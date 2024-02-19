package by.biziuk.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.*;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String books(Model model) {
        model.addAttribute("authenticated", isAuthenticated());
        return "mainPage";
    }
    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated()
            && !(authentication instanceof AnonymousAuthenticationToken);
    }
}
