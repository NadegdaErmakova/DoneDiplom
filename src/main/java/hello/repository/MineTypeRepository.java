package hello.repository;

/**
 * Created by jskonst on 05.04.17.
 */

import hello.User;
import hello.model.MineTypes;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MineTypeRepository extends CrudRepository<MineTypes, Long> {




}