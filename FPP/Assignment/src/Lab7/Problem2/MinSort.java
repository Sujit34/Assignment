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
	
	/*
	 public String sort(String str){
		if(str == null || str.length() <= 0) return "";		
		
		int len = str.length();
		char[] strArr = str.toCharArray();
		
		//Swapping the 1st character with the minimum one
		swap(strArr, 0, minpos(strArr, 0,len-1));
		
		//Calling the method recursively for rest of the characters
		String result = strArr[0] + this.sort(String.copyValueOf(strArr, 1, len-1));
		
		return result;
	}
	
	void swap(char[] strArray, int i, int j){
		char temp = strArray[i];
		strArray[i] = strArray[j];
		strArray[j] = temp;
		
	}
	//find minimum of arr between the indices bottom and top
	public int minpos(char[] strArr, int bottom, int top){		
		int m = strArr[bottom];
		int index = bottom;
		for(int i = bottom+1; i <= top; ++i){
			if(strArr[i] < m){ 
				m = strArr[i];
				index = i;
			}
		}
		//return location of min, not the min itself
		return index;
	}

	public static void main(String[] args) {
		MinSort ms = new MinSort();
		String result = ms.sort("zwxuabfkafutbbbb");
		System.out.println(result);
	}
	 */


}
