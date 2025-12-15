package com.my.controller;

import com.my.domain.User;
import com.my.domain.UserRole;
import com.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView doLogin(@RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session) {
        User user = userService.login(username, password);
        if (user == null) {
            ModelAndView mv = new ModelAndView("login");
            mv.addObject("error", "用户名或密码错误");
            return mv;
        }
        session.setAttribute("currentUser", user);

        // 根据用户角色跳转到不同页面
        if (user.getRole() == UserRole.TEACHER || user.getRole() == UserRole.ADMIN) {
            // 教师和管理员跳转到教师后台
            return new ModelAndView("redirect:/exams/manage");
        } else {
            // 学生跳转到考试列表
            return new ModelAndView("redirect:/exams");
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }

    @GetMapping("/register")
    public ModelAndView registerPage() {
        ModelAndView mv = new ModelAndView("register");
        // 添加所有角色选项到视图
        mv.addObject("roles", UserRole.values());
        return mv;
    }

    @PostMapping("/register")
    public ModelAndView doRegister(@RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("fullName") String fullName,
            @RequestParam("role") String roleName) {
        try {
            // 创建用户对象
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setFullName(fullName);
            // 转换角色字符串为UserRole枚举
            user.setRole(UserRole.valueOf(roleName.toUpperCase()));

            // 调用服务层创建用户
            userService.createUser(user);

            // 注册成功，重定向到登录页面
            ModelAndView mv = new ModelAndView("redirect:/auth/login");
            mv.addObject("message", "注册成功，请登录");
            return mv;
        } catch (Exception e) {
            // 注册失败，返回注册页面并显示错误信息
            ModelAndView mv = new ModelAndView("register");
            mv.addObject("roles", UserRole.values());
            mv.addObject("error", "注册失败：" + e.getMessage());
            mv.addObject("username", username);
            mv.addObject("fullName", fullName);
            return mv;
        }
    }
}
