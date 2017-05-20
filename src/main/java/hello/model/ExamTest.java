package hello.model;

import javax.persistence.*;

/**
 * Created by jskonst on 13.05.17.
 */
//вступительные испытания

@Entity
@Table(name="ExamTestDemo")
public class ExamTest {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Integer id;

        @Column(name="type")
        private String examName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }
}
