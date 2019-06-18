package com.pgruszka93.dao;


import com.pgruszka93.entity.Recipe;
import com.pgruszka93.entity.User;

import java.util.Collection;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);

    Collection<User> findAllUsers();


}
