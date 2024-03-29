package domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private long id;
	private String firstname;
	private String lastname;
	@ManyToOne(cascade={CascadeType.PERSIST})
	private Address address;
	@OneToMany (cascade={CascadeType.PERSIST},  mappedBy="customer")
	private Collection<Order> theOrders = new ArrayList<Order>();

	public Customer() {
	}

	public Customer(String firstname, String lastname, String street,
			String city, String zip,String country) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = new Address(street, city, zip,country);
	}


	public long getId() {
		return id;
	}
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Collection<Order> getTheOrders() {
		return Collections.unmodifiableCollection(theOrders);
	}

	
	public boolean addOrder(Order order) {
		boolean added = theOrders.add(order); 
		if (added) {
			order.setCustomer(this);
		}
		return added;
	}

	public boolean removeOrder(Order order) {
		boolean removed = theOrders.remove(order);
		if (removed) {
			theOrders.remove(order);
		}
		return removed;
	}
}
