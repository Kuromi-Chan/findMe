package by.biziuk.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.Collectors;

@Controller
public class helloController {
    
    @GetMapping("/")
    public String books(Model model) {
        return "mainForm";
    }
}
