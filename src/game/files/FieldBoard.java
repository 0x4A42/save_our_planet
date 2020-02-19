package game.files;

/**
 * This is an abstract class that will be extended to create squares such as
 * property tiles and other relevant squares.
 * 
 * @author v2.0 - 2.2 Ricards (Initial class creation)
 * @author v2.3 - Jordan (updating of documentation)
 *
 */
public abstract class FieldBoard {

	private final int LOWER_SPACE_NAME_LIMIT = 1;
	private final int UPPER_SPACE_NAME_LIMIT = 25;
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
	 * Sets the name of the space. If it is above 25 characters in length, excess is
	 * truncated.
	 * 
	 * @param spaceName
	 * @throws NullPointerException if space name is < 1 in length
	 */
	public void setSpaceName(String spaceName) throws NullPointerException {
		if (spaceName.length() >= LOWER_SPACE_NAME_LIMIT && spaceName.length() <= UPPER_SPACE_NAME_LIMIT) {
			this.spaceName = spaceName;
		} else if (spaceName.length() > UPPER_SPACE_NAME_LIMIT) {
			this.spaceName = spaceName.substring(0, 25);
		} else if (spaceName.length() < LOWER_SPACE_NAME_LIMIT) {
			throw new NullPointerException("Error. Space name must be at least one character.");
		}
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
