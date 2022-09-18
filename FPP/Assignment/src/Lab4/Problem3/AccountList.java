package Lab4.Problem3;

public class AccountList {
	
	private final int INITIAL_LENGTH = 2;
	private Account[] accArray; 
	private int size;
	
	public AccountList() {
		accArray = new Account[INITIAL_LENGTH];
		size = 0;
	}
	
	public void add(Account acc){
		if(this.size < size())
		{
			accArray[this.size] = acc;
			this.size ++;
		}
		else
		{
			resize();
			accArray[this.size] = acc;
			this.size ++;
		}
	}
	
	public Account get(int i){
		if(i<=accArray.length-1)
		{
			return accArray[i];
		}
		return null;
	}
	
	public boolean find(Account acc){
		
        int len = accArray.length;
        int i = 0;  
        
        while (i < len) {  
            
            if (accArray[i] == acc) {
                return true;
            }
            else {
                i = i + 1;
            }
        }
        return false;
    }		
	
	
	public void insert(Account acc, int pos){
		if(accArray.length <= pos) resize();
		
		Account[] tempArray = new Account[accArray.length];
		
 		for(int i=0;i<pos;i++)
		{
			if(accArray[i]!=null)tempArray[i]=accArray[i];
		}
		tempArray[pos] = acc;
		for(int i=pos;i<accArray.length-1;i++)
		{
			tempArray[i+1]= accArray[i];
		}
		size =size+1;
		System.arraycopy(tempArray, 0, accArray, 0, tempArray.length);	
	}
	
	public boolean remove(Account acc){
		
		boolean removed = false;
        Account[] tempArray = new Account[accArray.length]; 
        int k=0;
        for (int i = 0; i < accArray.length; i++) {
            if (accArray[i]!=null && accArray[i].equals(acc)) {
            	removed  = true;
            	size=size-1;
                continue;
            }
            
            if(accArray[i]!=null) 
            	tempArray[k++] = accArray[i];
        }
        this.accArray = new Account[tempArray.length];
        System.arraycopy(tempArray, 0, accArray, 0, k);
        
		
		return removed == true? true: false;
	}
	
	
	private void resize(){	
		System.out.println("Resizing...");
		String[] newArray = new String[accArray.length];
		System.arraycopy(accArray, 0, newArray, 0, accArray.length);
		this.accArray = new Account[size*2];
		System.arraycopy(newArray, 0, accArray, 0, newArray.length);
		
		
	}
	public String toString(){
		String retValue="[";
		for(int i=0;i<accArray.length;i++)
		{
			if(i!=0 && accArray[i]!=null)retValue  += ","+accArray[i]+"";
			if(i==0 && accArray[i]!=null) retValue  += ""+accArray[i]+"";
		}
		retValue +="]";
		return retValue;
	}
	public int size() {
		return accArray.length;
	}

	/*public static void main(String[] args){
		MyStringList l = new MyStringList();
		l.add("Bob");
		l.add("Steve");
		l.add("Susan");
		l.add("Mark");
		l.add("Dave");
		System.out.println("The list of size "+l.size()+" is "+l.toString());
		l.remove("Mark");
		l.remove("Bob");
		System.out.println("The list of size "+l.size()+" is "+l.toString());
		l.insert("Richard",3);
		System.out.println("The list of size "+l.size()+" after inserting Richard into pos 3 is "+l);
		l.insert("Tonya",0);
		System.out.println("The list of size "+l.size()+" after inserting Tonya into pos 0 is "+l);
		
	    MyStringList l = new MyStringList();
		l.add("Bob");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
		l.add("Steve");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
		l.add("Susan");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
		l.add("Mark");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
		l.add("Dave");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
		l.remove("Mark");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
		l.remove("Bob");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
		
	}*/


}
