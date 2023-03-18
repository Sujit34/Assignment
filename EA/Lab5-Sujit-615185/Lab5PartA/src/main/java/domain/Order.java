package domain;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="Orders")
public class Order {
	@Id
	@GeneratedValue
	private long id;
	private String ordernr;
	private String date;
	private String status;
	@ManyToOne (cascade={CascadeType.PERSIST})
	private Customer customer;
	@OneToMany (cascade={CascadeType.PERSIST}, fetch = FetchType.EAGER)
	private Collection<OrderLine> orderlines = new ArrayList<OrderLine>();

	public Order() {
	}

	public Order(String ordernr, String date, String status) {
		this.ordernr = ordernr;
		this.date = date;
		this.status = status;
	}

	public long getId() {
		return id;
	}
	public String getOrdernr() {
		return ordernr;
	}

	public void setOrdernr(String ordernr) {
		this.ordernr = ordernr;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<OrderLine> getOrderlines() {
		return Collections.unmodifiableCollection(orderlines);
	}

	public boolean addOrderLine(OrderLine ol) {
		return orderlines.add(ol);
	}

}
