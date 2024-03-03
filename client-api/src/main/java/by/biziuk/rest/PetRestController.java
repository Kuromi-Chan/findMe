package by.biziuk.rest;

import by.biziuk.entities.PetEntity;
import by.biziuk.entities.PostEntity;
import by.biziuk.entities.UserEntity;
import by.biziuk.repositories.PetRepository;
import by.biziuk.repositories.PostRepository;
import by.biziuk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PetRestController {
    @Autowired
    private final PostRepository postRepository;
    @Autowired
    private final UserRepository userRepository;
    
    public PetRestController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }
    
    @GetMapping("/pet/{id}")
    @ResponseBody
    public String getPetUser(@PathVariable Long id) {
        Optional<PostEntity> postOptional = postRepository.findAll().stream()
            .filter(post -> post.getPet().getId().equals(id))
            .findFirst();
        
        if (postOptional.isPresent()) {
            PostEntity post = postOptional.get();
            return post.getUser().getTelephone();
        } else {
            throw new RuntimeException("Post not found for pet with ID: " + id);
        }
    }
    
    
}
