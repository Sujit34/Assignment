package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		for (int x = 1; x <= 10000; x++) {
			Person person = new Person(x,"Sujit Kumar", "Chanda");
			List<Pet> pets = new ArrayList<Pet>();
			for (int y = 0; y < 10; y++) {
				Pet pet = new Pet("Cat", 1);
				pets.add(pet);
			}
			person.setPets(pets);
			personRepository.save(person);
		}
		stopwatch.stop();
		System.out.println("Mongo DB took " + stopwatch.getTotalTimeMillis() + " milliseconds to save.");


		stopwatch = new StopWatch();
		stopwatch.start();
		List<Person> persons = personRepository.findAll();
		stopwatch.stop();
		System.out.println("Mongo DB took " + stopwatch.getTotalTimeMillis() + " milliseconds to fetch.");

	}
}