package hello.repository;

import hello.model.Exam;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by nadia on 13.05.17.
 */
public interface ExamRepository extends CrudRepository<Exam, Long> {
    List<Exam> findByexamName(String examName);
}
