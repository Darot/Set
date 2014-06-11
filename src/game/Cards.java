/**
 * 
 */
package game;

import java.util.Arrays;

/**
 * @author Daniel Roth
 *
 */
public class Cards {
	
	//Konstants
	public static final String [] colours = {"red", "green", "blue"};
	public static final String [] paddings = {"filled", "empty", "striped"};
	public static final String [] symbols = {"star", "square", "diamond"};	
	
	private boolean selected = false;
	private String colour = null;
	private String padding = null;
	private String symbol = null;
	
	public Cards(String colour,String padding,String symbol){
		this.colour = colour;
		this.padding = padding;
		this.symbol = symbol;
	}
	
	/**
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}
	
	/**
	 * @param selected the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * @param colour the colour to set
	 */
	public void setColour(String colour) {
		if (Arrays.asList(colours).contains(colour)){
			this.colour = colour;
		}
	}

	/**
	 * @return the padding
	 */
	public String getPadding() {
		return padding;
	}

	/**
	 * @param padding the padding to set
	 */
	public void setPadding(String padding) {
		if(Arrays.asList(paddings).contains(padding)){
			this.padding = padding;	
		}
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		if(Arrays.asList(symbols).contains(symbol)){
			this.symbol = symbol;			
		}
	}
	
	
}
