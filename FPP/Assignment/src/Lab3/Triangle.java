package Lab3;

import java.util.Arrays;

public final class Triangle {
	
	private double base;
	private double height;
	private double first;
	private double second;
	private double third;
	private double x;
	
	Triangle(double bs, double high){
		if(bs>high)
		{
			this.base = bs;
			this.height = high;
		}
		else
		{
			this.base = high;
			this.height = bs;
		}
		this.third = Math.sqrt(base*base + height*height); 
	}
	
	Triangle(double first, double second, double third){
		
		double[] a = new double[3];
		a[0]=first; a[1]= second; a[2]= third;
		Arrays.sort(a);
		first=a[0];  second =a[1];  third = a[2];
		
		this.first = first;
		this.second = second;
		this.base  = third;		
		this.x =(first*first+second*second-third*third)/(2*third);		
		this.height =  (second*second - x*x); 
		
	}
	
	public double getBase(){
		 return base;
	} 
	
	public double getHeight(){
		 return height;
	} 
	
	public double computeArea(){
		return .5 * this.base * this.height;
	}

}
