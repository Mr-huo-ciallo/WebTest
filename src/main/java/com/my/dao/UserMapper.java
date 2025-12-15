package com.my.dao;

import com.my.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User findByUsername(@Param("username") String username);

    List<User> findByRole(@Param("role") String role);

    int insertUser(User user);
}
