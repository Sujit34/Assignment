package Lab10.Problem2;

import java.util.Objects;

public class Rational {
	
	private int p;
	private int q;
	
	public Rational(int p, int q) {
		this.p = p;
		this.q = q;
		
		if(this.q < 0) {
			throw new RuntimeException("Not a valid rational number");
		}
	}
	
	
    public Rational add(Rational rat) {
    	return new Rational((this.q * rat.q) + (this.q * rat.p), (this.q * rat.q));
    }
    
    
    public Rational multiply(Rational rat) {
    	return new Rational(this.p * rat.p, this.q * rat.q);
    }
    
  
    public int compareTo(Rational rat) {
    	int multi1 = this.p * rat.q;
    	int multi2 = this.q * rat.p;
    	
    	if (multi1 < multi2) {
    		return -1;
    	} else if (multi1 > multi2) {
    		return 1;
    	}
    	
    	return 0;
    }
	
	public int getP() {
		return p;
	}
	public void setP(int p) {
		this.p = p;
	}
	public int getQ() {
		return q;
	}
	public void setQ(int q) {
		this.q = q;
	}
	
	@Override
	public String toString() {
		return p + "/" + q;
	}
	@Override
	public int hashCode() {
		return Objects.hash(p, q);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rational other = (Rational) obj;
		return p == other.p && q == other.q;
	}
	
	public static void main(String[] args) {
		Rational rat1 = new Rational(2, 3);
		Rational rat2 = new Rational(-17, 5);
		Rational rat3 = new Rational(1, 3);
		
		Rational res1 = rat1.multiply(rat2).add(rat3);
		Rational res2 = rat2.add(rat3).multiply(rat1);
		
		if (res1.equals(res2)) {
			System.out.println("(" + rat1.toString() + " * " + rat2.toString() + ") + " + rat3.toString() + " is equal to " 
					+ rat1.toString() + " * (" + rat2.toString() + " + " + rat3.toString() + ")");
		} else if (res1.compareTo(res2) < 0) {
			System.out.println("(" + rat1.toString() + " * " + rat2.toString() + ") + " + rat3.toString() + " is less than " 
								+ rat1.toString() + " * (" + rat2.toString() + " + " + rat3.toString() + ")");
		} else {
			System.out.println("(" + rat1.toString() + " * " + rat2.toString() + ") + " + rat3.toString() + " is greater than " 
					+ rat1.toString() + " * (" + rat2.toString() + " + " + rat3.toString() + ")");
		}
	}

}
