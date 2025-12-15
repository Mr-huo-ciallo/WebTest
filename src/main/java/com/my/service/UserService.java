package com.my.service;

import com.my.domain.User;
import com.my.domain.UserRole;

import java.util.List;

public interface UserService {
    User login(String username, String password);

    List<User> listByRole(UserRole role);

    void createUser(User user);
}
