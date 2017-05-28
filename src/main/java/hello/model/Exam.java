package hello.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jskonst on 13.05.17.
 */
//вступительные испытания

@Entity
@Table(name="ExamTestDemo")
public class Exam {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long examid;

    @Column(name="examName")
    private String examName;

    public Exam() {
    }

    public Exam(String examName) {
        this.examName = examName;
    }

    public long getExamid() {
        return examid;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    @ManyToMany(mappedBy = "exams")
    private Set<Directions> directionses;

    public Set<Directions> getDirectionses() {
        return directionses;
    }

    public void setDirectionses(Set<Directions> directionses) {
        this.directionses = directionses;
    }

}
