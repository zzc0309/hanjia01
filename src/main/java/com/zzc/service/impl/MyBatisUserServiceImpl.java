package com.zzc.service.impl;

import com.zzc.dao.MyBatisUserDao;
import com.zzc.pojo.User;
import com.zzc.service.MyBatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBatisUserServiceImpl implements MyBatisUserService {
    @Autowired
    MyBatisUserDao myBatisUserDao;

    /**
     * 通过username参数来查询数据库中是否存在用户
     * @param username
     * @return
     */
    @Override
    public String getUsernameByUsername(String username) {
        if(myBatisUserDao.getUsernameByUsername(username)==null){
            return null;}
        return myBatisUserDao.getUsernameByUsername(username);
    }

    /**
     * 向数据库中插入用户
     * @param user
     */
    @Override
    public void insertUser(User user){
        myBatisUserDao.insertUser(user);
    }

    /**
     * 如果用户注册的名字已经存在了,就返回False,否则True
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {
        if(this.getUsernameByUsername(user.getUsername())==null){
            return true;
        }
        return false;
    }
}
