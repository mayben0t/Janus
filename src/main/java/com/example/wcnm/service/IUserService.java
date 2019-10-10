package com.example.wcnm.service;

import com.example.wcnm.model.User;
import org.springframework.stereotype.Service;

public interface IUserService {
    User getUserByUserName(String userName);

    void insert(User user);
}
