package by.biziuk.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pet")
@Entity
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String description;
    
    private String sex;
    
    private String location;
    
    private String  missingDate;
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] photo;
    
    
//    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<PetsColorEntity> petColors = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "color_id")
    private ColorEntity color;
    
    @ManyToOne
    @JoinColumn(name = "breed_id")
    private BreedEntity breed;
    
    @ManyToOne
    @JoinColumn(name = "petType_id")
    private PetTypeEntity petType;
    
    
}
