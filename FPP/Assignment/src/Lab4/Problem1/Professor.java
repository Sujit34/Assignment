package Lab4.Problem1;

public class Professor extends DeptEmployee {

	private int numberOfPublications;
	
	Professor(String name, double salary,int year, int month, int day,int numberOfPublications){
		super( name,  salary,  year, month, day);
		this.numberOfPublications = numberOfPublications;
	}
	
	public int getNumberOfPublications(int numberOfPublications)
	{
		return this.numberOfPublications;
	}
	public void setNumberOfPublications(int numberOfPublications) {
		this.numberOfPublications = numberOfPublications;
	}
}
