package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.AddressRepository;
import repositories.CDRepository;
import repositories.CustomerRepository;
import repositories.OrderRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class OrderApplication implements CommandLineRunner{
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CDRepository cdRepository;
	@Autowired
	AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book = new Book();
		book.setName("Head First Java");
		book.setDescription("Java Book For Beginner");
		book.setPrice(20.00);
		book.setIsbn("123456");
		OrderLine ol1 = new OrderLine(2, book);

		CD cd = new CD();
		cd.setName("Head First Java Audio Book");
		cd.setDescription("Audio Book");
		cd.setPrice(9.00);
		cd.setArtist("Sujit");
		OrderLine ol2 = new OrderLine(3, cd);

		DVD dvd = new DVD();
		dvd.setName("Head First Java Audio Book");
		dvd.setDescription("Audio Book");
		dvd.setPrice(20.00);
		dvd.setGenre("Coding Book");
		OrderLine ol3 = new OrderLine(4, dvd);

		Order o1 = new Order("234743", "12/10/06", "closed");
		o1.addOrderLine(ol1);
		o1.addOrderLine(ol2);
		o1.addOrderLine(ol3);

		Customer c1 = new Customer("Frank", "Brown", "Mainstreet 1",
				"New york", "43221","USA");
		c1.addOrder(o1);
		o1.setCustomer(c1);


		System.out.println("--------------Save--------------");
		orderRepository.save(o1);
		printOrder(o1);

		System.out.println("--------------Fetch--------------");
		Optional<Order> orderOpt = orderRepository.findById(1L);
		Order order = orderOpt.get();
		printOrder(order);

		System.out.println("------All Customers -------------------");
		List<Customer> customers = customerRepository.findAll();
		customers.stream().forEach(c->System.out.println(c));

		System.out.println("------All CDs from Sujit with price < 10 -------------------");
		List<CD> cds=cdRepository.findByArtistAndPriceLessThan("Sujit",9.0);
		cds.stream().forEach(c->System.out.println(c));

		System.out.println("------Find By Country -------------------");
		List<Customer> customersByCountry = customerRepository.findByCountry("USA");
		customersByCountry.stream().forEach(c->System.out.println(c));

		System.out.println("------Find CD by certain Artist -------------------");
		List<CD> cdsByArtist=cdRepository.findByArtist("Sujit");
		cdsByArtist.stream().forEach(c->System.out.println(c));

		System.out.println("------All Order numbers from orders with status closed  -------------------");
		List<String> orderNumbers = orderRepository.findOrderNumbersFromOrdersWithStatus("closed");
		orderNumbers.stream().forEach(c->System.out.println(c));

		System.out.println("------Find By City -------------------");
		List<Customer> customersByCity = customerRepository.findByCity("New york");
		customersByCity.stream().forEach(c->System.out.println("First name = " +c.getFirstname()+ "  Last Name = "+c.getLastname()));

		System.out.println("------All Order numbers of customers from New York  -------------------");
		List<String> orderNumbersFromCertainCity = orderRepository.findOrderNumbersFromOrdersFromCity("New york");
		orderNumbersFromCertainCity.stream().forEach(c->System.out.println(c));

		System.out.println("------All CDs from certain Artist with price greater than certain amount -------------------");
		List<CD> cdsFromCertainArtistAndCertainPrice=cdRepository.findAllCDsFromArtistAndPriceBiggerThan("Sujit",5.00);
		cdsFromCertainArtistAndCertainPrice.stream().forEach(c->System.out.println(c));

		System.out.println("------All addresses from certain City  -------------------");
		List<Address> addresses = addressRepository.findAllAddressesFromCity("New york");
		addresses.stream().forEach(c->System.out.println(c));

		System.out.println("------All CDs from certain artist  -------------------");
		List<CD> cdByArtist = cdRepository.findByCertainArtist("Sujit");
		cdByArtist.stream().forEach(c->System.out.println(c));
	}

	public static void printOrder(Order order) {
		System.out.println("Order with orderNumber: " + order.getOrdernr());
		System.out.println("Order date: " + order.getDate());
		System.out.println("Order status: " + order.getStatus());
		Customer cust = order.getCustomer();
		System.out.println("Customer: " + cust.getFirstname() + " "
				+ cust.getLastname());
		for (OrderLine orderline : order.getOrderlines()) {
			System.out.println("Order line: quantity= "
					+ orderline.getQuantity());
			Product product = orderline.getProduct();
			System.out.println("Product: " + product.getName() + " "
					+ product.getDescription() + " " + product.getPrice() );

		}

	}
}
