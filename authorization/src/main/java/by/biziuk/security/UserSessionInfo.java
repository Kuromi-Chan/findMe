package by.biziuk.security;

import by.biziuk.entities.UserEntity;
import by.biziuk.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserSessionInfo {
    
    private Optional<UserEntity> user;
    
    @Autowired
    private UserRepository userRepository;
    
    public UserEntity getCurrentUser() {
        if (user == null) {
            user = userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        }
        return user.get();
    }
    
}
