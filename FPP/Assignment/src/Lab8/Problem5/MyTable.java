package Lab8.Problem5;

public class MyTable {
	
	private Entry[] entries = new Entry[26];
	
	public static void main(String[] args) {
		MyTable t = new MyTable();
		t.add('a', "Andrew");
		t.add('b',"Billy");
		t.add('w',"Willie");
		System.out.println(t);
		System.out.println(t.get('b'));
	}
	
	//returns the String that is matched with char c in the table
	public String get(char c){
		for (Entry e : entries) {
			if (e != null && e.ch == c) {
				return e.toString();
			}
		}
		return null;
	}
	
	
	//adds to the table a pair (c, s) so that s can be looked up using c 
	public void add(char c, String s) {		
		Entry e = new Entry(s, c);
		entries[c-97] = e;
	}
	
	
	//returns a String consisting of nicely formatted display of the contents of the table
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Entry e : entries) {
			if (e != null)
				str.append(String.format("%s %n", e));
		}
		return str.toString();
		
	}
	
	
	private class Entry {
		private String str;
		private char ch;
		Entry(String str, char ch){			
			this.str= str;
			this.ch = ch;
		}

		//returns a String of the form "ch->str" 
		public String toString() {		
			String string = ch +"->"+str;
			return string;
		}
	}

}