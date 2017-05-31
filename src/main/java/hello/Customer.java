package hello;

import hello.model.ScoresExams;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nadia on  05.04.17.
 */
@Entity
public class Customer {

    private Long customer_id;

    private String firstName;
    private String lastName;
    private Set<ScoresExams> scoresExamses = new HashSet<>(0);

    //а почему именно protected
    protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[customer_id=%d, firstName='%s', lastName='%s']",
                customer_id, firstName, lastName);
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //связь с баллами и экзаменами
    @OneToMany(mappedBy = "Customer",cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ScoresExams>   getScoresExamses() {
        return scoresExamses;
    }

    public void setScoresExamses(Set<ScoresExams> scoresExamses) {
        this.scoresExamses = scoresExamses;
    }

  }
