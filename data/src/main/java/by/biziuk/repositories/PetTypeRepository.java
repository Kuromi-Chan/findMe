package by.biziuk.repositories;

import by.biziuk.entities.PetTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends JpaRepository<PetTypeEntity, Long> {
}
