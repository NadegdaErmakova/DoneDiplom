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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long cod;

    private String nameDirections;

    private String profiles;

    @ManyToMany
    @JoinTable(name = "EXAMS_DIRECTION",
            joinColumns = { @JoinColumn(name = "DIRECTION_ID") },
            inverseJoinColumns = { @JoinColumn(name = "EXAM_ID") })
    private Set<Exam> exams = new HashSet<Exam>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public String getNameDirections() {
        return nameDirections;
    }

    public void setNameDirections(String nameDirections) {
        this.nameDirections = nameDirections;
    }

    public String getProfiles() {
        return profiles;
    }

    public void setProfiles(String profiles) {
        this.profiles = profiles;
    }

    public Set<Exam> getExams() {
        return exams;
    }

    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }
}
