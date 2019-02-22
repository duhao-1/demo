package com.baizhi.service.impl;

import com.baizhi.dao.UserMapper;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        User user = userMapper.selectByName(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                map.put("code", "200");
                map.put("msg", "登录成功");
            } else {
                map.put("code", "400");
                map.put("msg", "密码错误");
            }
        } else {
            map.put("code", "400");
            map.put("msg", "用户名不存在");
        }
        return map;
    }

    @Override
    public void regist(User user) {
        userMapper.insert(user);
    }
}
