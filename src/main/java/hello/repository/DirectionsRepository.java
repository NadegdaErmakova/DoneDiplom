package hello.repository;

import hello.model.Directions;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by nadia on 20.05.17.
 */
public interface DirectionsRepository extends CrudRepository<Directions,Long> {
    List<Directions> findBynameDirections(String nameDirections);

}
