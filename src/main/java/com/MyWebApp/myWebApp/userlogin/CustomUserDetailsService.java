package com.MyWebApp.myWebApp.userlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserLoginRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin userLogin = userRepo.findByEmail_id(username);
        if (userLogin == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(userLogin);
    }

}