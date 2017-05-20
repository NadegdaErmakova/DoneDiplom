package hello.repository;

import hello.model.Directions;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nadia on 20.05.17.
 */
public interface DirectionsRepository extends CrudRepository<Directions,Long> {

}
