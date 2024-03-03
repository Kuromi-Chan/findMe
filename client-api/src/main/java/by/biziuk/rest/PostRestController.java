package by.biziuk.rest;

import by.biziuk.entities.BreedEntity;
import by.biziuk.entities.PetEntity;
import by.biziuk.entities.PostEntity;
import by.biziuk.repositories.BreedRepository;
import by.biziuk.repositories.PetRepository;
import by.biziuk.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PostRestController {
    
    @Autowired
    private final PostRepository postRepository;
    @Autowired
    private final PetRepository petRepository;
    
    public PostRestController(PostRepository postRepository, PetRepository petRepository) {
        this.postRepository = postRepository;
        this.petRepository = petRepository;
    }
    
    @GetMapping("/get-pets-data")
    @ResponseBody
    public List<PetEntity> getPetData() {
        List<PetEntity> posts = petRepository.findAll();
        return posts;
    }
    
}
