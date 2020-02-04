/**
 * 
 */
package save.our.planet.game;

/**
 * This is a class that other subclasses will build upon. This class, and any
 * subclasses, represent a board square such as a property piece.
 * 
 * @author Jordan
 *
 */
public class BoardSquare {

	private String name;
	private int boardPosition;

	/**
	 * Default constructor
	 */
	public BoardSquare() {

	} // end of BoardSquare(Default constructor)

	/**
	 * @param name, the name of the board square
	 */
	public BoardSquare(String name, int boardPosition) {
		this.setName(name);
		this.setBoardPosition(boardPosition);
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

	/**
	 * @return the boardPosition
	 */
	public int getBoardPosition() {
		return boardPosition;
	}

	/**
	 * This method sets the position of the board square within the game board.
	 * Validation ensures that the value can only be within the current confines of
	 * the game board. 
	 * 
	 * @param boardPosition the boardPosition to set
	 * @throws IllegalArgumentException
	 */
	public void setBoardPosition(int boardPosition) throws IllegalArgumentException {
		if (boardPosition >= 0 && boardPosition <= 37) {
			this.boardPosition = boardPosition;
		} else {
			throw new IllegalArgumentException(
					"Sorry, you must enter a board position 0-40 (inclusive). You have entered " + boardPosition
							+ "for " + this.name);
		}

	} // end of setBoardPosition

} // end of class
