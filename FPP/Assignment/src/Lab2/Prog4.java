package Lab2;


public class Prog4 {
	
	public static void main(String[] args) {
		 String myString = Data.records;	
		 String [] rows = myString.split(":");
		 String [] columns;
		 for(int i=0;i<rows.length;i++)
		 {
			 columns = rows[i].split(",");
			 System.out.println(columns[0]);
		 }
		}

}
