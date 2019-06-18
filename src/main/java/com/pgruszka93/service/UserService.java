package com.pgruszka93.service;


import com.pgruszka93.entity.Recipe;
import com.pgruszka93.entity.User;
import com.pgruszka93.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);

    Collection<Recipe> loadNewestRecipes(int pageNumber);

    Collection<User> findAllUsers();

}
