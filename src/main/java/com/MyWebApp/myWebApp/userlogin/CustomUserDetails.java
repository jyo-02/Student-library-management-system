package com.MyWebApp.myWebApp.userlogin;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

    private UserLogin userLogin;

    public CustomUserDetails(UserLogin userLogin) {
        this.userLogin = userLogin;
    }

    // Methods overridden from UserDetails interface

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Implement logic to return authorities
        return null;
    }

    @Override
    public String getPassword() {
        return userLogin.getPassword();
    }

    @Override
    public String getUsername() {
        return userLogin.getEmail_id();
    }

    @Override
    public boolean isAccountNonExpired() {
        // Implement logic to check if account is non-expired
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Implement logic to check if account is non-locked
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Implement logic to check if credentials are non-expired
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Implement logic to check if account is enabled
        return true;
    }

    // Additional method to get user's full name

    public String getFullName() {
        return userLogin.getFirstName() + " " + userLogin.getLastName();
    }
}

