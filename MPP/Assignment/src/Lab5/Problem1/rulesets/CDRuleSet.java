package Lab5.Problem1.rulesets;

import java.awt.Component;

import Lab5.Problem1.gui.CDWindow;

/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. Price must be a floating point number with two decimal places 
 *  3. Price must be a number greater than 0.49. 
 */

public class CDRuleSet implements RuleSet {
	
	private CDWindow cdWin;
	
	@Override
	public void applyRules(Component ob) throws RuleException {		
		cdWin = (CDWindow)ob;
		nonemptyRule();
		floatingPriceRule();
		
	}
	
	private void nonemptyRule() throws RuleException {
			
			if(	 cdWin.getArtistValue().trim().isEmpty() ||
					cdWin.getTitleValue().trim().isEmpty() ||
					cdWin.getPriceValue().trim().isEmpty()) {
				   throw new RuleException("All fields must be nonempty");
			}
	}
	
	private void floatingPriceRule() throws RuleException {
		
			if(cdWin.getPriceValue() == null) throw new RuleException("Price must be a floating point number");
			
			String[] str = cdWin.getPriceValue().split("\\.");
			if(str.length<=1 || str[1].length() != 2)  throw new RuleException("Price must be a floating point number with two decimal places");
			
			
			double priceValue =  cdWin.getPriceValue().isEmpty() ? 0 : Double.valueOf(cdWin.getPriceValue());
			
			if(	 priceValue <= .49) {
				   throw new RuleException("Price must be a number greater than 0.49");
			}
	}
}
