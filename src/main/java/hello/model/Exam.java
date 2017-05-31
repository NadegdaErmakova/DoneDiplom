package hello.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jskonst on 13.05.17.
 */
//вступительные испытания

@Entity
//@Table(name="ExamTestDemo")
public class Exam {

    private long examid;
    private String examName;

    private Set<ScoresExams> scoresExamses = new HashSet<>(0);;

    public Exam() {
    }

    public Exam(String examName) {
        this.examName = examName;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long getExamid() {
        return examid;
    }

    public void setExamid(long examid) {
        this.examid = examid;
    }

    @Column(name="examName")
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

    //связь с абитуриентом и его баллами
    @OneToMany(mappedBy = "exam")
    public Set<ScoresExams> getScoresExamses() {
        return scoresExamses;
    }

    public void setScoresExamses(Set<ScoresExams> scoresExamses) {
        this.scoresExamses = scoresExamses;
    }
}
