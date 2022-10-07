package Lab4.PartC;

import java.time.LocalDate;
import java.util.*;

public class Commissioned extends Employee{
	private double commission;
	private double baseSalary;
	
	private List<Order> orders = new LinkedList<>();
	
	public Commissioned(int empId, double commission, double baseSalary) {
		super(empId);
		this.commission = commission;
		this.baseSalary = baseSalary;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public void addNewOrder(int orderNum, LocalDate orderDate, int orderAmount) {
		orders.add(new Order(orderNum,orderDate,orderAmount));
	}
	
	
	@Override
	public double calcGrossPay(int month, int year) {		
		double previousMonthOrder = 0.0;
		LocalDate current = LocalDate.of(year, month, 1);	
		
		for(Order o: orders) {
			LocalDate orderDate = o.getOrderDate();
			if((current.getMonthValue() - orderDate.getMonthValue() == 1 && current.getYear() == orderDate.getYear()) ||
					(current.getMonthValue() == 1 && orderDate.getMonthValue() == 12 && current.getYear() - orderDate.getYear() == 1)) {
				previousMonthOrder = previousMonthOrder +  o.getOrderAmount();
			}
		}
		return this.baseSalary + this.commission * previousMonthOrder;
	}	
}
