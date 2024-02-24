package by.biziuk.repositories;

import by.biziuk.entities.BreedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BreedRepository extends JpaRepository<BreedEntity, Long> {

}
