package com.ibarra.service.impl;

import com.google.common.collect.Lists;
import com.ibarra.dao.UserRepository;
import com.ibarra.model.User;
import com.ibarra.service.UserService;
import com.ibarra.view.UserCreateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by paoloibarra on 22/8/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(UserCreateForm userCreateForm) {
        User user = new User();
        user.setEmail(userCreateForm.getEmail());
        user.setEncryptedPassword(new BCryptPasswordEncoder().encode(userCreateForm.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getUsers() {
        return Lists.newArrayList(userRepository.findAll());
    }
}