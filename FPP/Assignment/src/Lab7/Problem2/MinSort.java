package Lab7.Problem2;

public class MinSort {	
	
	char[] ch; 	
	
	public String sort(String strArray){		
		ch = strArray.toCharArray();		
		rec(strArray,strArray.length());		
		return toString(ch);
	}
	
	void rec(String strArray,int len) {
		if(strArray.length()==0) return;	
		rec(strArray.substring(1),len);
		int subStringLen = strArray.length();
		int nextMinPos = minpos(subStringLen-1,len-1);
		swap(subStringLen-1,nextMinPos); 
				
	}
	
	void swap(int i, int j){		
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j]= temp;		
	}
	
	
	public int minpos(int bottom, int top){			
		char m = ch[bottom];
		int index = bottom;
		for(int i = bottom+1; i <= top; ++i){
			if(ch[i]!='\0' &&  ch[i]< m){ 
				m = ch[i];
				index = i;
			}
		}		
		return index;		
	}
	
	
	public static String toString(char[] a)
    {        
        StringBuilder sb = new StringBuilder(); 
        
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
        }
 
        return sb.toString();
    }


}
