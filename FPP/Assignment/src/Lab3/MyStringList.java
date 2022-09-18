package Lab3;

public class MyStringList {
	private final int INITIAL_LENGTH = 2;
	private String[] strArray; 
	private int size;
	
	public MyStringList() {
		strArray = new String[INITIAL_LENGTH];
		size = 0;
	}
	
	public void add(String s){
		if(this.size < size())
		{
			strArray[this.size] = s;
			this.size ++;
		}
		else
		{
			resize();
			strArray[this.size] = s;
			this.size ++;
		}
	}
	
	public String get(int i){
		if(i<=strArray.length-1)
		{
			return strArray[i];
		}
		return null;
	}
	
	public boolean find(String s){
		
        int len = strArray.length;
        int i = 0;  
        
        while (i < len) {  
            
            if (strArray[i] == s) {
                return true;
            }
            else {
                i = i + 1;
            }
        }
        return false;
    }		
	
	
	public void insert(String s, int pos){
		if(strArray.length <= pos) resize();
		
		String[] tempArray = new String[strArray.length];
		
 		for(int i=0;i<pos;i++)
		{
			if(strArray[i]!=null)tempArray[i]=strArray[i];
		}
		tempArray[pos] = s;
		for(int i=pos;i<strArray.length-1;i++)
		{
			tempArray[i+1]= strArray[i];
		}
		size =size+1;
		System.arraycopy(tempArray, 0, strArray, 0, tempArray.length);	
	}
	
	public boolean remove(String s){
		
		boolean removed = false;
        String[] tempArray = new String[strArray.length]; 
        int k=0;
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i]!=null && strArray[i].equals(s)) {
            	removed  = true;
            	size=size-1;
                continue;
            }
            
            if(strArray[i]!=null) 
            	tempArray[k++] = strArray[i];
        }
        this.strArray = new String[tempArray.length];
        System.arraycopy(tempArray, 0, strArray, 0, k);
        
		
		return removed == true? true: false;
	}
	
	
	private void resize(){	
		System.out.println("Resizing...");
		String[] newArray = new String[strArray.length];
		System.arraycopy(strArray, 0, newArray, 0, strArray.length);
		this.strArray = new String[size*2];
		System.arraycopy(newArray, 0, strArray, 0, newArray.length);
		
		
	}
	public String toString(){
		String retValue="[";
		for(int i=0;i<strArray.length;i++)
		{
			if(i!=0 && strArray[i]!=null)retValue  += ","+strArray[i]+"";
			if(i==0 && strArray[i]!=null) retValue  += ""+strArray[i]+"";
		}
		retValue +="]";
		return retValue;
	}
	public int size() {
		return strArray.length;
	}

	public static void main(String[] args){
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
		
	   /* MyStringList l = new MyStringList();
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
		*/
	}

}

