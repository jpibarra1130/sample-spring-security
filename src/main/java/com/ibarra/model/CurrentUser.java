package com.ibarra.model;

import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by paoloibarra on 22/8/15.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {
    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getEncryptedPassword(), AuthorityUtils.NO_AUTHORITIES);
    }

    public User getUser() {
        return user;
    }
}
