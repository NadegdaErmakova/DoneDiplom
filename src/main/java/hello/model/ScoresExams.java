package hello.model;

import hello.Customer;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by nadia on 29.05.17.
 */

//ПОЧЕМУУУУУУУУУУУУ?! ЗА ЧТОООО, ENTITY?
@Entity
//Table а ты то что?)
@Table( name="ScoresExams")
public class ScoresExams {
    private Customer customer;
    private Exam exam;
    private int score;

    @Id
    @ManyToOne
    @JoinColumn(name = "book_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "examid")
    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
    @Column(name = "score")

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
