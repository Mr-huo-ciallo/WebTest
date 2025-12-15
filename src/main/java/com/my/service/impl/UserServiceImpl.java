package com.my.service.impl;

import com.my.dao.UserMapper;
import com.my.domain.User;
import com.my.domain.UserRole;
import com.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user == null) {
            return null;
        }
        if (!password.equals(user.getPassword())) {
            return null;
        }
        return user;
    }

    @Override
    public List<User> listByRole(UserRole role) {
        return userMapper.findByRole(role.name());
    }

    @Override
    public void createUser(User user) {
        if (user.getRole() == null) {
            user.setRole(UserRole.STUDENT);
        }
        userMapper.insertUser(user);
    }
}
