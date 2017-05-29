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
    private String cod;
    private String nameDirections;
//    private String profiles;
    private int numOchn;

    private Set<Exam> exams = new HashSet<>(0);

    public Directions(){
    }

    public Directions(String cod, String nameDirections, int numOchn) {//}, String profiles, Set<Exam> exams) {
        super();
        this.cod = cod;
        this.nameDirections = nameDirections;
        this.numOchn = numOchn;

//        this.profiles = profiles;
//        this.exams = exams;
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
    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    @Column(name = "nameDirections")
    public String getNameDirections() {
        return nameDirections;
    }

    public void setNameDirections(String nameDirections) {
        this.nameDirections = nameDirections;
    }

    @Column(name = "numOchn")
    public int getNumOchn() {
        return numOchn;
    }

    public void setNumOchn(int numOchn) {
        this.numOchn = numOchn;
    }

    //    @Column(name = "profiles")
//    public String getProfiles() {
//        return profiles;
//    }
//
//    public void setProfiles(String profiles) {
//        this.profiles = profiles;
//    }



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
            if (directionsExam.getExamid() == exam.getExamid()) {
                return true;
            }
        }
        return false;
    }
}
