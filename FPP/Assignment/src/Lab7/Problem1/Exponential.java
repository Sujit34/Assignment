package Lab7.Problem1;

public class Exponential {
	int result = 1;
	public int power(int x,int n) {		
		if(n==0) return 1;
		return x*power(x,n-1);			
	}
}
