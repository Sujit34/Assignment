package Lab8.Problem4;

import java.util.*;
import java.util.stream.Collectors;



public class Main {
	public static void main(String[] args) {		
		List<String> words = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Nora", "Scott");		
		System.out.println(countWords(words, 'N', 'X', 4));
	}
	
	public static int countWords(List<String> words, char c, char d, int len) {
		return
			     words.stream()   
	         	     .filter(name -> name.contains("" + c)) 
	         	     .filter(name -> !name.contains("" + d))
	         	     .filter(name -> name.length() == len)
	         	     .collect(Collectors.toList())
	         	     .size();
	}
}
