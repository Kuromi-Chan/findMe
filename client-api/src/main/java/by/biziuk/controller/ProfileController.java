package by.biziuk.controller;


import by.biziuk.entities.PostEntity;
import by.biziuk.repositories.PostRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ProfileController {
    
    private static final String PROFILE_PAGE = "profilePage";
    @Autowired
    private PostRepository postRepository;
    
   
    
    @GetMapping("/profile")
    public String profile(Model model)
        throws UnsupportedEncodingException {
        List<PostEntity> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("authenticated", isAuthenticated());
        return PROFILE_PAGE;
    }
    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated()
            && !(authentication instanceof AnonymousAuthenticationToken);
    }
   
    
}
