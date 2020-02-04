/**
 * 
 */
package save.our.planet.game;

/**
 * This class will represent a property piece.
 * 
 * @author Jordan
 *
 */
public class Property extends BoardSquare {

	private int price;
	private String colour;
	private boolean firstMinorImprovement;
	private boolean secondMinorImprovement;
	private boolean thirdMinorImprovement;
	private boolean majorImprovement;
	private String owner = "bank";
	private int field;

	/**
	 * 
	 */
	public Property() {
		// TODO Auto-generated constructor stub
	} // end of Property(default constructor)

	/**
	 * 
	 * @param name,                   the name of the property square
	 * @param price,                  the price of the property square
	 * @param colour,                 the colour corresponding to the area of the
	 *                                board the property square is on
	 * @param firstMinorImprovement,  boolean to indicate if the property has its
	 *                                first minor improvement
	 * @param secondMinorImprovement, boolean to indicate if the property has its
	 *                                second minor improvement
	 * @param thirdMinorImprovement,  boolean to indicate if the property has its
	 *                                third minor improvement
	 * @param majorImprovement,       boolean to indicate if the property has its
	 *                                major improvement (requires
	 *                                thirdMinorImprovement to be true)
	 */
	public Property(String name, int boardPosition, int price, String colour, boolean firstMinorImprovement,
			boolean secondMinorImprovement, boolean thirdMinorImprovement, boolean majorImprovement, String owner, int field) {
		super(name, boardPosition);
		this.price = price;
		this.setColour(colour);
		this.firstMinorImprovement = firstMinorImprovement;
		this.setSecondMinorImprovement(secondMinorImprovement);
		this.setThirdMinorImprovement(thirdMinorImprovement);
		this.setMajorImprovement(majorImprovement);
		this.owner = owner;
		this.setField(field);

	} // end of Property(constructor with args)

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	} // end of getPrice

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	} // end of setPrice

	/**
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	} // end of getColour

	/**
	 * This method sets the colour of the property square. The parameter must
	 * conform to one of the four pre-set colours, representing the four fields of
	 * play on the board, otherwise the colour will be rejected and set to null with
	 * an error message being displayed to the user.
	 * 
	 * @param colour the colour to set
	 * @throws IllegalArgumentException
	 */
	public void setColour(String colour) throws IllegalArgumentException{
		if (colour.equalsIgnoreCase("Oak")) {
			this.colour = colour;
		} else if (colour.equalsIgnoreCase("Pine")) {
			this.colour = colour;
		} else if (colour.equalsIgnoreCase("Cedar")) {
			this.colour = colour;
		} else if (colour.equalsIgnoreCase("Sky Blue")) {
			this.colour = colour;
		}  else if (colour.equalsIgnoreCase("Cerulean")) {
			this.colour = colour;
		} else if (colour.equalsIgnoreCase("Lemon")) {
			this.colour = colour;
		} else if (colour.equalsIgnoreCase("Honey")) {
			this.colour = colour;
		} else if (colour.equalsIgnoreCase("Dandelion")) {
			this.colour = colour;
		} else if (colour.equalsIgnoreCase("Graphite")) {
			this.colour = colour;
		}else if (colour.equalsIgnoreCase("Pewter")) {
			this.colour = colour;
		} else {
			throw new IllegalArgumentException("Colour defined for " +this.getName() +" is invalid. Refer to manual for acceptable colours.");
		}
	} // end of setColour

	/**
	 * @return the firstMinorImprovement
	 */
	public boolean isFirstMinorImprovement() {
		return firstMinorImprovement;
	} // end of isFirstMinorImprovement

	/**
	 * @param firstMinorImprovement the firstMinorImprovement to set
	 */
	public void setFirstMinorImprovement(boolean firstMinorImprovement) {
		this.firstMinorImprovement = firstMinorImprovement;
	} // end of setFirstMinorImprovement

	/**
	 * @return the secondMinorImprovement
	 */
	public boolean isSecondMinorImprovement() {
		return secondMinorImprovement;
	} // end of isSecondMinorImprovement

	/**
	 * This method will set the secondMinorImprovement to be true if the property
	 * has its first minor improvement and the parameter being passed through is
	 * true. If either of these are false, the secondMinorImprovement will be set to
	 * false.
	 * 
	 * @param secondMinorImprovement the secondMinorImprovement to set
	 */
	public void setSecondMinorImprovement(boolean secondMinorImprovement) {
		if (this.firstMinorImprovement == true && secondMinorImprovement == true) {
			this.secondMinorImprovement = secondMinorImprovement;
		} else {
			this.secondMinorImprovement = false;
		}
	} // end of setSecondMinorImprovement

	/**
	 * @return the thirdMinorImprovement
	 */
	public boolean isThirdMinorImprovement() {
		return thirdMinorImprovement;
	} // end of isThirdMinorImprovement

	/**
	 * This method will set the thirdMinorImprovement to be true if the property has
	 * its first and second minor improvement and the parameter being passed through
	 * is true. If any of these are false, the secondMinorImprovement will be set to
	 * false.
	 * 
	 * @param thirdMinorImprovement the thirdMinorImprovement to set
	 */
	public void setThirdMinorImprovement(boolean thirdMinorImprovement) {
		if (this.firstMinorImprovement == true && this.secondMinorImprovement == true
				&& thirdMinorImprovement == true) {
			this.thirdMinorImprovement = thirdMinorImprovement;
		} else {
			this.thirdMinorImprovement = false;
		}
	} // end of setThirdMinorImprovement

	/**
	 * @return the majorImprovement
	 */
	public boolean isMajorImprovement() {
		return majorImprovement;
	}

	/**
	 * This will set the major improvement to be true if the property square has all
	 * three minor improvements and the param is true. If any of these are false
	 * (either missing a minor improvement, or the parameter is false),
	 * majorImprovement will be set to false.
	 * 
	 * @param majorImprovement
	 */
	public void setMajorImprovement(boolean majorImprovement) {
		if (this.isFirstMinorImprovement() == true && this.isSecondMinorImprovement() == true
				&& this.isThirdMinorImprovement() == true && majorImprovement == true) {
			this.majorImprovement = majorImprovement;
		} else {
			this.majorImprovement = false;
		}

	} // end of setMajorImprovement

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the field
	 */
	public int getField() {
		return field;
	}

	/**
	 * This method will set the field of the board square, with validation ensuring it is between 1 - 4. 
	 * @param field
	 * @throws IllegalArgumentException
	 */
	public void setField(int field) throws IllegalArgumentException {
		if (field >= 1 && field <= 4) {
			this.field = field;
		} else {
			throw new IllegalArgumentException("Fields must be within the range of 1 - 4 (inclusive). You have entered " +field);
		}
	}

	
	
	
}
