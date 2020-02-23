package game.files;

/**
 * CSC7053-1920-G2: Jordan Brown (40282125), Ricards Estemirovs (40126945),
 * Rebekah Logan (40059637), Catherine McGuckin (40105486)
 * 
 * This is an abstract class that will be extended to create squares such as
 * property tiles and other relevant squares.
 * 
 * @author v2.0 - 2.2 Ricards (Initial class creation)
 * @author v2.3 - Jordan (updating of documentation)
 *
 */
public abstract class FieldBoard {

	private String spaceName;
	private boolean ownable;

	/**
	 * Default constructor
	 */
	public FieldBoard() {
	}

	/**
	 * Constructor with args
	 * 
	 * @param spaceName, the name of the square
	 * @param ownable,   determines if the square is ownable or not.
	 */
	public FieldBoard(String spaceName, boolean ownable) {
		setSpaceName(spaceName);
		setOwnable(ownable);
	}

	/**
	 * 
	 * @return the name of the space
	 */
	public String getSpaceName() {
		return spaceName;
	}

	/**
	 * Sets the name of the space.
	 * 
	 * @param spaceName
	 */
	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}

	/**
	 * 
	 * @return boolean that determines if a square is ownable or not. True = yes,
	 *         false = no
	 */
	public boolean isOwnable() {
		return ownable;
	}

	/**
	 * Sets if the square can be ownable or not.
	 * 
	 * @param ownable
	 */
	public void setOwnable(boolean ownable) {
		this.ownable = ownable;
	}

}
