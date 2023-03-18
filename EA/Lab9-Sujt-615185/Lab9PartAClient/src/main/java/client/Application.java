package client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {

	RestTemplate restTemplate = new RestTemplate();
	private String serverUrl = "http://localhost:8080/books";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// add Book
		restTemplate.postForLocation(serverUrl, new Book("1324","Doe", "Java Book", 15));

		// get book by isbn
		Book book= restTemplate.getForObject(serverUrl+"/{isbn}", Book.class, "1324");
		System.out.println(book);

		// update book
		book.setAuthor("Sujit");
		restTemplate.put(serverUrl+"/{isbn}" , book, "1324");

		// delete book
		restTemplate.delete(serverUrl+"/{isbn}", "1324");

        // get all books
		Books books = restTemplate.getForObject(serverUrl, Books.class);
		System.out.println(books);
	}
}
