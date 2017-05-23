package hello.model;

import javax.persistence.*;

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

//    @ManyToOne
//    private ExamTest examsTest;

    public Directions() {
    }


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

//    public ExamTest getExamsTest() {
//        return examsTest;
//    }
//
//    public void setExamsTest(ExamTest examsTest) {
//        this.examsTest = examsTest;
//    }
}
