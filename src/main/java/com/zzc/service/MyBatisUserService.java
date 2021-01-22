package com.zzc.service;

import com.zzc.pojo.User;

public interface MyBatisUserService {
         String getUsernameByUsername(String username);
        void insertUser(User user);
        boolean register(User user);
}
