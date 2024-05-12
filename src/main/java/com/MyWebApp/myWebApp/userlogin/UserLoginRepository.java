package com.MyWebApp.myWebApp.userlogin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {

    @Query("SELECT u FROM UserLogin u WHERE u.email_id = ?1")
    public UserLogin findByEmail_id(String email_id);
}
