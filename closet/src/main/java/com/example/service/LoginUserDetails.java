package com.example.service;

import com.example.model.User;
import lombok.Data;
import org.springframework.security.core.authority.AuthorityUtils;


public class LoginUserDetails extends org.springframework.security.core.userdetails.User {
    private final User user;

    public LoginUserDetails(User user) {
        super(user.getUserId(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.user = user;
    }
}
