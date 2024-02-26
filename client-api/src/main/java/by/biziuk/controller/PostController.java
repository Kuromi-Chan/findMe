package by.biziuk.controller;

import by.biziuk.dictionaries.LocationData;
import by.biziuk.entities.PetEntity;
import by.biziuk.entities.PostEntity;
import by.biziuk.repositories.BreedRepository;
import by.biziuk.repositories.PetRepository;
import by.biziuk.repositories.ColorRepository;
import by.biziuk.repositories.PetTypeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/post")
public class PostController {
    @Autowired
    private BreedRepository breedRepository;
    @Autowired
    private PetTypeRepository petTypeRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private PetRepository petRepository;
    private static final String POST_FORM = "postForm";
  
    @GetMapping("/post/create")
    public String post(Model model)
        throws JsonProcessingException {
        model.addAttribute("pet", new PetEntity());
        model.addAttribute("petTypes", petTypeRepository.findAll());
        model.addAttribute("breeds", breedRepository.findAll());
        model.addAttribute("post", new PostEntity());
        model.addAttribute("colors", colorRepository.findAll());;
        return POST_FORM;
    }
}
