package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.BookRepository;
import repositories.DepartmentRepository;
import repositories.PassengerRepository;
import repositories.SchoolRepository;

import java.util.Date;
import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class Application implements CommandLineRunner {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    SchoolRepository schoolRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        partA();
        partB();
        partC();
        partD();
    }
    void partA(){
        Department dept = new Department("CS");
        Employee emp1 = new Employee("Payman");
        Employee emp2 = new Employee("Samuel");
        dept.addEmployee(emp1);
        dept.addEmployee(emp2);
        emp1.setDepartment(dept);
        emp2.setDepartment(dept);
        departmentRepository.save(dept);


        Optional<Department> department = departmentRepository.findById(1L);
        System.out.println(department.get());
    }
    void partB(){
        Book book = new Book("123", "Head First Java", "Bert Bates");
        Publisher publisher = new Publisher("O'Reilly Media, Inc.");
        book.setPublisher(publisher);
        bookRepository.save(book);


        Optional<Book> bk = bookRepository.findById(4L);
        System.out.println(bk.get());
    }
    void partC(){
        Flight flight1 = new Flight("Texas", "Iowa", new Date());
        Flight flight2 = new Flight("Iowa", "Texas", new Date());
        Flight flight3 = new Flight("Iowa", "NY", new Date());
        Flight flight4 = new Flight("NY", "Iowa", new Date());
        Passenger passenger = new Passenger("Sujit Kumar Chanda");
        passenger.addFlight(flight1);
        passenger.addFlight(flight2);
        passenger.addFlight(flight3);
        passenger.addFlight(flight4);
        passengerRepository.save(passenger);


        Optional<Passenger> ps = passengerRepository.findById(6L);
        System.out.println(ps.get());
    }
    void partD(){
        Student student1 = new Student( "Sujit Kumar","Chanda");
        School school = new School("Maharishi International University");
        school.addStudent(student1);
        schoolRepository.save(school);

        Optional<School> sc = schoolRepository.findById(11L);
        System.out.println(sc.get());

    }


}