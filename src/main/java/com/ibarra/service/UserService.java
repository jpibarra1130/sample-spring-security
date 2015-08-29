package com.ibarra.service;

import com.ibarra.model.User;
import com.ibarra.view.UserCreateForm;

import java.util.List;

/**
 * Created by paoloibarra on 22/8/15.
 */
public interface UserService {

    User create(UserCreateForm userCreateForm);

    User findByEmail(String email);

    List<User> getUsers();
}
