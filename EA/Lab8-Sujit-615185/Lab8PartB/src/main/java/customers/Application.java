package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        // create customer
		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		customer = new Customer(109,"John Jones", "jones@acme.com", "0624321234");
		creditCard = new CreditCard("657483342", "Visa", "09/23");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		//get customers
		System.out.println(customerRepository.findById(66).get());
		System.out.println(customerRepository.findById(101).get());
		System.out.println("-----------All customers ----------------");
		System.out.println(customerRepository.findAll());
		//update customer
		customer = customerRepository.findById(101).get();
		customer.setEmail("jd@gmail.com");
		customerRepository.save(customer);
		System.out.println("-----------find by phone ----------------");
		System.out.println(customerRepository.findByPhone("0622341678"));
		System.out.println("-----------find by email ----------------");
		System.out.println(customerRepository.findCustomerWithEmail("jj123@acme.com"));
		System.out.println("-----------find customers with a certain type of creditcard ----------------");
		List<Customer> customers = customerRepository.findCustomerWithCreditCardType("Visa");
		for (Customer cust : customers){
			System.out.println(cust);
		}



		// create student
		Student student = new Student(101,"Sujit Kumar Chanda",  "1234");
		Address address = new Address("1000 N 4th St.", "FairField", "52557");
		student.setAddress(address);
		Grade grade1 = new Grade("EA","A+");
		Grade grade2 = new Grade("WAA","A+");
		List<Grade> grade = new ArrayList<Grade>();
		grade.add(grade1);
		grade.add(grade2);
		student.setGrade(grade);
		studentRepository.save(student);

		student = new Student(102,"Shuvra Dey",  "123456");
		address = new Address("1000 N 5th St.", "FairField", "52557");
		student.setAddress(address);
		grade1 = new Grade("EA","A+");
		grade2 = new Grade("WAA","A+");
		grade = new ArrayList<Grade>();
		grade.add(grade1);
		grade.add(grade2);
		student.setGrade(grade);
		studentRepository.save(student);

		student = new Student(103,"Fahim Uddin",  "123");
		address = new Address("1000 N 6th St.", "FairField", "52557");
		student.setAddress(address);
		grade1 = new Grade("EA","A+");
		grade2 = new Grade("SA","A+");
		grade = new ArrayList<Grade>();
		grade.add(grade1);
		grade.add(grade2);
		student.setGrade(grade);
		studentRepository.save(student);


		System.out.println("-----------find by name ----------------");
		System.out.println(studentRepository.findByName("Sujit Kumar Chanda"));

		System.out.println("-----------find by phone ----------------");
		System.out.println(studentRepository.findByPhone("123456"));

		System.out.println("-----------find Student From Certain City ----------------");
		List<Student> students = studentRepository.findStudentFromCertainCity("FairField");
		for (Student st : students){
			System.out.println(st);
		}

		System.out.println("-----------find Student From Certain Course ----------------");
		List<Student> studentsFromCertainCourse = studentRepository.findStudentFromCertainCourse("SA");
		for (Student st : studentsFromCertainCourse){
			System.out.println(st);
		}

		System.out.println("-----------find Student From Certain Course with certain grade ----------------");
		List<Student> studentsFromCertainCourseWithCertainGrade = studentRepository.findStudentFromCertainCourseWithACertainGrade("EA","A+");
		for (Student st : studentsFromCertainCourseWithCertainGrade){
			System.out.println(st);
		}


	}

}
