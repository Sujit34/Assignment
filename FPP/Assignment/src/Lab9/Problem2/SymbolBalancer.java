package Lab9.Problem2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class SymbolBalancer {
	String ODD_DELIMITER = ""+(char)0;
	String filename;
	String text;
	char[] left;
	char[] right;
	
	Stack<Character> stack = new Stack<>();
	
	public SymbolBalancer(String filename) {
		this.filename = filename;
		readFile();		
	}
	public void setText(String text) {
		this.text = text;
	}
	
	boolean symbolsBalanced(String delimiters){
		left = new char[delimiters.length()/2];
		right = new char[delimiters.length()/2];
		
		int index=0;
		for(int i=0;i<delimiters.length();i=i+2) {left[index++]=delimiters.charAt(i);}
		
		index=0;
		for(int i=1;i<delimiters.length();i=i+2) {right[index++]=delimiters.charAt(i);}
		
		
		for(int i=0;i<text.length();i++) {			
			if(contains(text.charAt(i),left)) {				
				stack.push(text.charAt(i));
			}
			else if(contains(text.charAt(i),right)) {			
				char ch = stack.pop();				
				int indLeft = getIndexOf(ch,left);
				int indRight = getIndexOf(text.charAt(i),right);
				if(indLeft!=indRight)return false;
			}
		}	
					
		return stack.empty() ? true : false;
		
	}
	
	public static void main(String[] args) {
		SymbolBalancer sb = new SymbolBalancer("Lab9\\Problem2\\Employee.java");
		System.out.println(sb.symbolsBalanced("[]{}<>()"));
	}
	void readFile() {
		String prefix = System.getProperty("user.dir") + "\\src\\";
		try {
			Scanner sc = new Scanner(new File(prefix + filename));
			sc.useDelimiter(ODD_DELIMITER);
			text = sc.next();
			System.out.println(text);
			sc.close();
		}
		catch(FileNotFoundException ex) {
			System.err.println("File Not Found Exception " + ex.getMessage());
		}
	}
	
	boolean contains(char c, char[] array) {
	    for (char x : array) {
	        if (x == c) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public int getIndexOf( char toSearch, char[] charArray )
	{
	  for( int i=0; i< charArray.length ; i ++ )
	    if( charArray[ i ] == toSearch)
	     return i;

	  return -1;
	}
	
}
