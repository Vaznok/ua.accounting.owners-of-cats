package ua.accouting_of_cats.repository;


import org.springframework.data.repository.CrudRepository;
import ua.accouting_of_cats.model.Owner;

import java.util.List;

public interface OwnersRepository extends CrudRepository<Owner, Long> {
    /*List<Owner> findByLastName(String lastName);*/
}
