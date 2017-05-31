package hello;

import hello.model.Directions;
import hello.model.Exam;
import hello.model.ScoresExams;
import hello.repository.DirectionsRepository;
import hello.repository.ExamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nadia on 14.03.17.
 */
@ComponentScan
@EnableAutoConfiguration

public class Application {
//    @Autowired
//    private UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            Customer spec = new Customer("Michelle", "Dessler");
//            User n = new User();
//            n.setName("TestUsr");
//            n.setEmail("Email");
//            userRepository.save(n);
//            spec.setUser(n);
//            repository.save(spec);
            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Customer customer = repository.findOne(1L);
            log.info("Customer found with findOne(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            for (Customer bauer : repository.findByLastName("Bauer")) {
                log.info(bauer.toString());
            }
            log.info("");
        };
    }

    //All about direction and exam
     /**
     * Save students to H2 DB for testing
     * @param
     * @return
     */
    @Bean
    public CommandLineRunner demo(DirectionsRepository directionsRepository, ExamRepository examRepository) {
        return (args) -> {
            // save directions
            Directions directions1 = new Directions("04.03.01", "Химия", 21);
            directionsRepository.save(new Directions("18.03.01", "Химическая технология",188));
            directionsRepository.save(new Directions("19.03.02", "Продукты питания из растительного сырья", 27));
            directionsRepository.save(new Directions("19.03.01", "Биотехнология", 27));
            directionsRepository.save(new Directions("29.03.04", "Технология художественной обработки материалов",17));
            directionsRepository.save(new Directions("11.03.04", "Электроника и наноэлектроника",18));
            directionsRepository.save(new Directions("18.03.02", "Энерго- и ресурсосберегающие процессы в химической технологии, нефтехимии и биотехнологии", 32));
            directionsRepository.save(new Directions("22.03.01", "Материаловедение и технологии материалов", 17));
            directionsRepository.save(new Directions("15.03.04", "Автоматизация технологических процессов и производств",19));
            directionsRepository.save(new Directions("15.03.02", "Технологические машины и оборудование", 30));
            directionsRepository.save(new Directions("20.03.01", "Техносферная безопасность", 16));
            directionsRepository.save(new Directions("15.03.02", "Управление в технических системах", 35));
            directionsRepository.save(new Directions("09.03.02", "Информационные системы и технологии", 43));
            directionsRepository.save(new Directions("51.03.01", "Культурология", 6));
            directionsRepository.save(new Directions("38.03.01", "Экономика", 0));
            directionsRepository.save(new Directions("38.03.02", "Менеджмент", 0));
            directionsRepository.save(new Directions("38.03.05", "Бизнес-информатика", 0));


            Exam exam1 = new Exam("Химия");
            Exam exam2 = new Exam("Русский язык");
            examRepository.save(new Exam("Математика"));
            examRepository.save(new Exam("Физика"));
            examRepository.save(new Exam("Информатика"));
            examRepository.save(new Exam("Обществознание"));
            examRepository.save(new Exam("История"));
            examRepository.save(exam1);
            examRepository.save(exam2);

            Set<Exam> exams = new HashSet<Exam>();
            exams.add(exam1);
            exams.add(exam2);

            directions1.setExams(exams);
            directionsRepository.save(directions1);
        };
    }

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ExamRepository examRepository;

//    Это вообще надо? Мы не можем узнать кто придет! Тем более часть пользователей выше прописана... крч туту странности происходят
//    @Override
//    @Transactional
//    public void run(String... strings) throws Exception {
//        Customer customerA = new Customer();
//
//        Exam examA = new Exam();
//
//        ScoresExams scoresExams = new ScoresExams();
//        scoresExams.setCustomer(customerA);
//        scoresExams.setExam(examA);
//        scoresExams.setScore(();
//        customerA.getScoresExamses().add(scoresExams);
//
//        ExamRepository.save(examA);
//        customerRepository.save(customerA);
//
//        // test
//        System.out.println(customerA.getScoresExamses().size());
//
//        // update
//        customerA.getScoresExamses().remove(scoresExams);
//        customerRepository.save(customerA);
//
//        // test
//        System.out.println(customerA.getScoresExamses().size());
//    }
}

}
