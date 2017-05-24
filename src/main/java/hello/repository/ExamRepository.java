package hello.repository;

import hello.model.Exam;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jskonst on 13.05.17.
 */
public interface ExamRepository extends CrudRepository<Exam, Integer> {

}
