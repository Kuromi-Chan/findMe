package by.biziuk.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String email;
    
    private String password;
    
    private String telephone;
    
    private String fio;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PostEntity> posts;
    
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getFio(){return fio;}
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setFio(String fio) {
        this.fio = fio;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
}
