package by.biziuk.controller;

import by.biziuk.entities.BreedEntity;
import by.biziuk.repositories.BreedRepository;
import by.biziuk.repositories.ColorRepository;
import by.biziuk.repositories.PetTypeRepository;
import by.biziuk.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.*;

import java.util.List;

@Controller
public class HomeController {
    
    private static final String MAIN_PAGE = "mainPage";
    @Autowired
    private BreedRepository breedRepository;
    @Autowired
    private PetTypeRepository petTypeRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private PostRepository postRepository;
    @GetMapping("/")
    public String books(Model model) {
        model.addAttribute("authenticated", isAuthenticated());
        model.addAttribute("breeds", breedRepository.findAll());
        model.addAttribute("colors", colorRepository.findAll());
        model.addAttribute("petTypes", petTypeRepository.findAll());
        model.addAttribute("posts",postRepository.findAll());
        return MAIN_PAGE;
    }
    
    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated()
            && !(authentication instanceof AnonymousAuthenticationToken);
    }
    
}
