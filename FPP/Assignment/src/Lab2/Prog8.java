package Lab2;

public class Prog8 {
	public static void main(String[] args){
		int[] input = {2, -21, 3, 45, 0, 12, 18, 6, 3, 1, 0, -22};
		System.out.println(minValue(input));
	}
	public static int minValue(int[] array)
	{
		int min= Integer.MAX_VALUE;
		for(int i=0;i<array.length;i++)
		{
			if(array[i]<min) min= array[i];
		}
		return min;
	}

}
