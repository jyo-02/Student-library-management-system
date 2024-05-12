package com.MyWebApp.myWebApp;

import com.MyWebApp.myWebApp.userlogin.UserLogin;
import com.MyWebApp.myWebApp.userlogin.UserLoginRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private UserLoginRepository userLoginRepo;

    @GetMapping("/")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/home")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userLogin", new UserLogin());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(@ModelAttribute("userLogin") UserLogin userLogin) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(userLogin.getPassword());
        userLogin.setPassword(encodedPassword);

        userLoginRepo.save(userLogin);

        return "register_success";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidates the session
        return "redirect:/login"; // Redirect to the login page or any other desired page
    }
}
