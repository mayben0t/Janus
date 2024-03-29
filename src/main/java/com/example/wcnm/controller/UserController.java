package com.example.wcnm.controller;

import com.example.wcnm.DTO.ResultDTO;
import com.example.wcnm.model.User;
import com.example.wcnm.service.IUserService;
import io.swagger.annotations.Api;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/users")
@Api(value = "用户注册")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signup")
    public ResultDTO signUp(@RequestBody User user) {
        if(validateUser(user.getUserName()) == 1){
            ResultDTO<Object> resultDTO = ResultDTO.builder()
                    .code(202)
                    .msg("对不起，该用户名已被注册，请使用其他用户名!")
                    .build();

            return resultDTO;
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.insert(user);
        ResultDTO<Object> result = ResultDTO.builder().msg("恭喜你，注册成功!").build();
        return result;
    }


    public int validateUser(String userName){
        if(StringUtils.isEmpty(userName)){
            return 1;
        }
        User user = userService.getUserByUserName(userName);
        if(Objects.nonNull(user)){
            return 1;
        }
        return 0;
    }
}