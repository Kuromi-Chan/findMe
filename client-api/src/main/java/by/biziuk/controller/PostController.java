package by.biziuk.controller;

import by.biziuk.entities.PetEntity;
import by.biziuk.entities.PostEntity;
import by.biziuk.utils.CompressionService;
import by.biziuk.repositories.BreedRepository;
import by.biziuk.repositories.ColorRepository;
import by.biziuk.repositories.PetRepository;
import by.biziuk.repositories.PetTypeRepository;
import by.biziuk.repositories.PostRepository;
import by.biziuk.security.UserSessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;

@Controller
//@RequestMapping("/post")
public class PostController {
    @Autowired
    private BreedRepository breedRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserSessionInfo userSessionInfo;
    @Autowired
    private PetTypeRepository petTypeRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private CompressionService compressionService;
    private static final String POST_FORM = "postForm";
    private static final String PROFILE_PAGE = "profilePage";
    @GetMapping("/post/create")
    public String post(Model model){
        model.addAttribute("pet", new PetEntity());
        model.addAttribute("petTypes", petTypeRepository.findAll());
        model.addAttribute("breeds", breedRepository.findAll());
        model.addAttribute("post", new PostEntity());
        model.addAttribute("colors", colorRepository.findAll());
        return POST_FORM;
    }
    @PostMapping("/post/create")
    public String createPost(
        @ModelAttribute("pet") PetEntity pet,
        @ModelAttribute("post") PostEntity post) {
        petRepository.save(pet);
        post.setCreatedAt(Instant.now());
        post.setPet(pet);
        post.setStatus("Active");
        post.setUser(userSessionInfo.getCurrentUser());
        postRepository.save(post);
        return PROFILE_PAGE;
    }
    @PostMapping("/files/upload")
    public void uploadFile(Model model, @ModelAttribute("pet") PetEntity pet, @RequestParam("file") MultipartFile file) {
        try {
            pet.setPhoto(file.getInputStream().readAllBytes());
            model.addAttribute("pet", pet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
    }
   
}

