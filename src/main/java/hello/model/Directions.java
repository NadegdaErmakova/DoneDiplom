package hello.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nadia on 20.05.17.
 */
//табличка направлений и связь с экзаменами
@Entity
@Table(name="DirectionsAll")
public class Directions {

    private Long id;
    private Long cod;
    private String nameDirections;
    private String profiles;

    private Set<Exam> exams = new HashSet<>(0);

    public Directions(){
    }

    public Directions(Long cod, String nameDirections, String profiles, Set<Exam> exams) {
        super();
        this.cod = cod;
        this.nameDirections = nameDirections;
        this.profiles = profiles;
        this.exams = exams;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "cod")
    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    @Column(name = "nameDirections")
    public String getNameDirections() {
        return nameDirections;
    }

    public void setNameDirections(String nameDirections) {
        this.nameDirections = nameDirections;
    }

    @Column(name = "profiles")
    public String getProfiles() {
        return profiles;
    }

    public void setProfiles(String profiles) {
        this.profiles = profiles;
    }

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "direction_exam",
            joinColumns = { @JoinColumn(name = "id") },
            inverseJoinColumns = { @JoinColumn(name = "exam_id") })
    public Set<Exam> getExams() {
        return this.exams;
    }

    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }

    public boolean hasExam(Exam exam) {
        for (Exam directionsExam: getExams()) {
            if (directionsExam.getExams() == exam.getExams()) {
                return true;
            }
        }
        return false;
    }
}
