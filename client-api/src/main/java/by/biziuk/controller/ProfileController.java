package by.biziuk.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    
    private static final String PROFILE_PAGE = "profilePage";
    
   
    
    @GetMapping("/profile")
    public String profile(Model model) {
//        model.addAttribute("user",userSessionInfo.getCurrentUser());
        return PROFILE_PAGE;
    }
    
}
