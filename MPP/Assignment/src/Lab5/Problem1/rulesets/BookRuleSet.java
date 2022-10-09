package Lab5.Problem1.rulesets;

import java.awt.Component;

import Lab5.Problem1.gui.*;


/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Isbn must be numeric and consist of either 10 or 13 characters
 * 3. If Isbn has length 10, the first digit must be 0 or 1
 * 4. If Isbn has length 13, the first 3 digits must be either 978 or 979
 * 5. Price must be a floating point number with two decimal places 
 * 6. Price must be a number greater than 0.49.
 *
 */
public class BookRuleSet implements RuleSet {
	private BookWindow BookWin;
	@Override
	public void applyRules(Component ob) throws RuleException {
		BookWin = (BookWindow)ob;
		nonemptyRule();
		floatingPriceRule();
		isbnNumericRule();
		
	}
	
	private void nonemptyRule() throws RuleException {
		
		if(	 BookWin.getIsbnValue().trim().isEmpty() ||
				BookWin.getTitleValue().trim().isEmpty() ||
				BookWin.getPriceValue().trim().isEmpty()) {
			   throw new RuleException("All fields must be nonempty");
		}
	}

	private void floatingPriceRule() throws RuleException {
	
		if(BookWin.getPriceValue() == null) throw new RuleException("Price must be a floating point number");
		
		String[] str = BookWin.getPriceValue().split("\\.");
		if(str.length<=1 || str[1].length() != 2)  throw new RuleException("Price must be a floating point number with two decimal places");
		
		
		double priceValue =  BookWin.getPriceValue().isEmpty() ? 0 : Double.valueOf(BookWin.getPriceValue());
		
		if(	 priceValue <= .49) {
			   throw new RuleException("Price must be a number greater than 0.49");
		}
		
	}
	
	private void isbnNumericRule() throws RuleException {
		String val = BookWin.getIsbnValue().trim();
		try {
			Long.parseLong(val);
			if(val.length() == 10 ||  val.length() == 13) {
				if(val.length()==10) {
					if(!(val.charAt(0) == '0' || val.charAt(0) == '1')) 
						throw new RuleException("If Isbn has length 10, the first digit must be 0 or 1");
				}
				if(val.length()==13) {
					if(!(val.substring(0,3).equals("978") || val.substring(0,3).equals("979")))
						throw new RuleException("If Isbn has length 13, the first 3 digits must be either 978 or 979");
				}
				
			}
			else
			{
				throw new RuleException("Isbn consist of either 10 or 13 characters");
			}
			
		} catch(NumberFormatException e) {
			throw new RuleException("Isbn must be numeric");
		}		
	}

}
