package com.example.wcnm.security;

import com.example.wcnm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.wcnm.model.User user = userService.getUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.getUserName(), user.getPassword(), emptyList());
    }
}