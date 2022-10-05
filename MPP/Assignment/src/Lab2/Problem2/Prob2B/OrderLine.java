package Lab2.Problem2.Prob2B;

public class OrderLine {
	
	private Order order;	
	private int id;

	OrderLine(int id, Order order) {
		this.order = order;
		this.id = id;
	}

	@Override
	public String toString() {		
		return "orderLine id " + id;
	}
}
