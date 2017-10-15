package ua.accouting_of_cats.repository;

import org.springframework.data.repository.CrudRepository;
import ua.accouting_of_cats.model.Cat;

import java.util.List;

public interface CatsRepository extends CrudRepository<Cat, Long> {
    List<Cat> findByOwner_OwnerId(Long ownerId);
}
