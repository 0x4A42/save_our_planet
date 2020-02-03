/**
 * 
 */
package save.our.planet.game;

/**
 * This is an abstract class that other subclasses will build upon. This class,
 * and any subclasses, represent a board square such as a property piece.
 * 
 * @author Jordan
 *
 */
public abstract class BoardSquare {

	private String name;

	/**
	 * Default constructor
	 */
	public BoardSquare() {

	} // end of BoardSquare(Default constructor)

	/**
	 * @param name, the name of the board square
	 */
	public BoardSquare(String name) {
		this.setName(name);
	} // end of BoardSquare(Constructor with args)

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}// end of getName

	/**
	 * Sets the board square's name. If the name is above 30 characters, the excess
	 * is truncated.
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		if (name.length() <= 30) {
			this.name = name;
		} else {
			this.name = name.substring(0, 29);
		}

	} // end of setName;

} // end of class
