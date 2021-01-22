package com.zzc.dao;

import com.zzc.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBatisUserDao {
     String getUsernameByUsername(String username);
     void insertUser(User user);
     int getId(String username);
     void insertUserRole(int id);
}
