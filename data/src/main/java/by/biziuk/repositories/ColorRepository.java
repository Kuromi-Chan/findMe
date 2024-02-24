package by.biziuk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import by.biziuk.entities.СolorEntity;

@Repository
public interface ColorRepository extends JpaRepository<СolorEntity,Long> {
}
