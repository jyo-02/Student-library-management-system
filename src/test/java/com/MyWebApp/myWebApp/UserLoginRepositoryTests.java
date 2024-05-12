package com.MyWebApp.myWebApp;


import static org.assertj.core.api.Assertions.assertThat;

import com.MyWebApp.myWebApp.userlogin.UserLogin;
import com.MyWebApp.myWebApp.userlogin.UserLoginRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserLoginRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserLoginRepository repo;
    @Test
    public void testCreateUser() {
        UserLogin userLogin = new UserLogin();
        userLogin.setEmail_id("ravis@gmail.com");
        userLogin.setPassword("ravi2023");
        userLogin.setFirstName("Ravis");
        userLogin.setLastName("Saha");

        UserLogin savedUser;
        savedUser = repo.save(userLogin);

        UserLogin existUser = entityManager.find(UserLogin.class, savedUser.getId());

        assertThat(userLogin.getEmail_id()).isEqualTo(existUser.getEmail_id());

    }
}
