package by.biziuk.repositories;

import by.biziuk.entities.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import by.biziuk.entities.ColorEntity;

@Repository
public interface ColorRepository extends JpaRepository<ColorEntity,Long> {
}
