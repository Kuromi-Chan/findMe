package by.biziuk.security;

import by.biziuk.entities.UserEntity;
import by.biziuk.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

import static by.biziuk.enums.Role.USER;

public class SecurityUser implements UserDetails {
    
    private final String username;
    private final String password;
    private final List<SimpleGrantedAuthority> authorities;
    private final boolean isActive;
    
    public SecurityUser(String username, String password, List<SimpleGrantedAuthority> authorities, boolean isActive) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.isActive = isActive;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
    
    @Override
    public String getPassword() {
        return password;
    }
    
    @Override
    public String getUsername() {
        return username;
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }
    
    @Override
    public boolean isEnabled() {
        return isActive;
    }
    
    public static UserDetails fromUser(UserEntity user) {
        Role role = USER;
        return new org.springframework.security.core.userdetails.User(
            user.getEmail(), user.getPassword(),
            role.getAuthorities()
        );
    }
    
}
