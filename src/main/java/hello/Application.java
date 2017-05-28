package hello;

import hello.model.Directions;
import hello.model.Exam;
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

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jskonst on 14.03.17.
 */
@ComponentScan
@EnableAutoConfiguration

public class Application {
    @Autowired
    private UserRepository userRepository;

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
            User n = new User();
            n.setName("TestUsr");
            n.setEmail("Email");
            userRepository.save(n);
            spec.setUser(n);
            repository.save(spec);
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
     * @param repository
     * @return
     */
    @Bean
    public CommandLineRunner demo(DirectionsRepository directionsRepository, ExamRepository examRepository) {
        return (args) -> {
            // save directions
            //не понимаю в чем ошибка?
            Directions directions1 = new Directions("04.03.01", "Химия", "Теоретическая и экспериментальная химия");
            directionsRepository.save(new Directions("18.03.01", "Химическая технология", "Профили"));
            directionsRepository.save(new Directions("19.03.02", "Продукты питания из растительного сырья", "Профили"));
            directionsRepository.save(new Directions("19.03.01", "Биотехнология", "Пищевая биотехнология"));
            directionsRepository.save(new Directions("29.03.04", "Технология художественной обработки материалов", "Технология художественной обработки материалов"));
            directionsRepository.save(new Directions("11.03.04", "Электроника и наноэлектроника", "Микроэлектроника и твердотельная электроника"));
            directionsRepository.save(new Directions("18.03.02", "Энерго- и ресурсосберегающие процессы в химической технологии, нефтехимии и биотехнологии", "Профили"));
            directionsRepository.save(new Directions("22.03.01", "Материаловедение и технологии материалов", "Материаловедение и технология новых материалов "));
            directionsRepository.save(new Directions("15.03.04", "Автоматизация технологических процессов и производств", "Автоматизация технологических процессов и производств"));
            directionsRepository.save(new Directions("15.03.02", "Технологические машины и оборудование", "Профили"));
            directionsRepository.save(new Directions("20.03.01", "Техносферная безопасность", "Инженерная защита окружающей среды"));
            directionsRepository.save(new Directions("09.03.02", "Информационные системы и технологии", "Информационные системы и технологии"));
            directionsRepository.save(new Directions("27.03.04", "Управление в технических системах", "Системы и средства автоматизации технологических процессов"));
            directionsRepository.save(new Directions("38.03.01", "Экономика", "Профили"));
            directionsRepository.save(new Directions("38.03.02", "Менеджмент", "Профили"));
            directionsRepository.save(new Directions("38.03.05", "Бизнес-информатика", "Электронный бизнес "));
            directionsRepository.save(new Directions("51.03.01", "Культурология", "Социокультурное проектирование "));

            Exam exam1 = new Exam("Химия");
            Exam exam2 = new Exam("Русский язык");
            //Почему они не объявляются как экзамены выше?
            examRepository.save(new Exam("Математика"));
            examRepository.save(new Exam("Физика"));
            examRepository.save(new Exam("Информатика"));
            examRepository.save(new Exam("Обществознание"));
            examRepository.save(new Exam("История"));
            //Тут тож не оч понятна.. рационально ли?
            examRepository.save(exam1);
            examRepository.save(exam2);

            Set<Exam> exams = new HashSet<Exam>();
            exams.add(exam1);
            exams.add(exam2);

            directions1.setExams(exams);
            directionsRepository.save(directions1);
        };
    }
//файл связанный с безопасностью пока не создавала

}
