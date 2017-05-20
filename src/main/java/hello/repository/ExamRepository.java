package hello.repository;

import hello.model.ExamTest;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jskonst on 13.05.17.
 */
public interface ExamRepository extends CrudRepository<ExamTest, Integer> {

}
