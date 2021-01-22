package com.zzc.controller;

import com.zzc.auth.MyUserDetails;
import com.zzc.dao.MyBatisUserDao;
import com.zzc.pojo.Result;
import com.zzc.pojo.User;
import com.zzc.service.impl.MyBatisUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller

public class MyBatisUserController {
    @Resource
    PasswordEncoder passwordEncoder;

    @Autowired
    MyBatisUserDao myBatisUserDao;
    @Autowired
    MyBatisUserServiceImpl myBatisUserService;


    /**
     * 接受user数据后,需先判断该user的username是否存在,
     * 如果存在则返回400,否则继续将user的密码进行加密,
     * 然后将用户信息插入数据库,再将用户的角色添加进数据库,
     * 最后返回200.
     * @param user
     * @return
     */
    @ResponseBody
    @PostMapping("/registe")
    public Result registe(@RequestBody User user){
    if(myBatisUserService.register(user)){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        myBatisUserService.insertUser(user);
        myBatisUserDao.insertUserRole(myBatisUserDao.getId(user.getUsername()));
            return new Result(200,"注册成功");
    }
    return new Result(400,"该用户名已存在!");
    }

    /**
     * 本接口配合spring security使用,当spring security验证通过后调用此接口,
     * 不对外开放,开放接口:login
     * @return
     */
    @ResponseBody
    @PostMapping("/login02")
    public Result login02(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MyUserDetails myUserDetails=(MyUserDetails)principal;
        if(myUserDetails.toString().contains("ROLE_admin"))
            return new Result(200,"是VIP");   //200是VIP
        return new Result(400,"不是VIP");
    }

    /**
     * 配合spring security使用的接口
     * 登录失败跳转,不对外开放
     * @return
     */
    @ResponseBody
    @PostMapping("/login03")
    public Result login03(){
        return new Result(404,"登录失败");
    }


}
