package com.pgruszka93.dao;


import com.pgruszka93.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
