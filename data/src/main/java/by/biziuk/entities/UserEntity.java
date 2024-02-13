package by.biziuk.entities;

//import by.biziuk.enums.Role;
import jakarta.persistence.*;
import lombok.*;


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
    
    private String firstName;
    
    private String lastName;
    
//    @Enumerated(value = EnumType.STRING)
//    @Column(name = "role")
//    private Role role;

}
