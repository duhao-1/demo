package com.baizhi.service;


import com.baizhi.entity.User;

import java.util.Map;

public interface UserService {
    Map<String, Object> login(String username, String password);

    void regist(User user);
}
