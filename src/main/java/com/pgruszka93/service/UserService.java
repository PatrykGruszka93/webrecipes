package com.pgruszka93.service;


import com.pgruszka93.entity.User;
import com.pgruszka93.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);


}
