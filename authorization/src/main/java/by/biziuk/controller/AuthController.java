package by.biziuk.controller;


import by.biziuk.entities.UserEntity;
import by.biziuk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private static final String REGISTRATION_FORM = "registrationForm";
    private static final String LOGIN_FORM = "loginForm";
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new UserEntity());
        return REGISTRATION_FORM;
    }

    @GetMapping("/login")
    public String login() {
        return LOGIN_FORM;
    }

    @GetMapping("/logout")
    public String logout(){
        return "/";
    }

    @PostMapping("/registration")
    public String newUser(@ModelAttribute("user") UserEntity user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return LOGIN_FORM;
    }
}
