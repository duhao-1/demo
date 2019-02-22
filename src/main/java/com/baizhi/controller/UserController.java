package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    //登录
    public Object login(String username, String password) {
        Map<String, Object> login = userService.login(username, password);
        if (login.get("code").equals("200")) {
            return "redirect:/employee/showAll";
        }
        return "redirect:/login.jsp";
    }

    //添加
    @RequestMapping("/regist")
    public String regist(User user, String number, HttpSession session) {
        Object code = session.getAttribute("code");
        if (number.equals(code)) {
            userService.regist(user);
            return "redirect:/login.jsp";
        }
        return "redirect:/regist.jsp";
    }
}
