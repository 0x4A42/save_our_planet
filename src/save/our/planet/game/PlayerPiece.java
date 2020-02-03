/**
 * 
 */
package save.our.planet.game;

/**
 * This class will represent a player piece.
 * 
 * @author Jordan
 *
 */
public class PlayerPiece extends BoardPiece {

	private String playerName;
	private String character;
	private double money;

	/**
	 * Default constructor
	 */
	public PlayerPiece() {

	} // end of PlayerPiece(Default Constructor)

	/**
	 * 
	 * @param playerName
	 * @param character
	 */
	public PlayerPiece(String playerName, String character, double money) {
		this.setPlayerName(playerName);
		this.character = character;
		this.money = money;
		// TODO Auto-generated constructor stub
	} // end of PlayerPiece(Constructor with args)

	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	} // end of getPlayerName

	/**
	 * Sets the player's name. If the player's name is above 15 characters, the
	 * excess is truncated.
	 * 
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		if (playerName.length() <= 15) {
			this.playerName = playerName;
		} else {
			this.playerName = playerName.substring(0, 14);
		}
	} // end of setPlayerName

	/**
	 * @return the character
	 */
	public String getCharacter() {
		return character;
	} // end of getCharacter

	/**
	 * This method sets the name of the character's player piece. If the param
	 * matches one of the pre-defined pieces, it is set. Otherwise, it is set to
	 * null.
	 * 
	 * @param character the character to set
	 */
	public void setCharacter(String character) {
		if (character.equalsIgnoreCase("Tree")) {
			this.character = character;
		} else if (character.equalsIgnoreCase("Fish")) {
			this.character = character;
		} else if (character.equalsIgnoreCase("Leaf")) {
			this.character = character;
		} else if (character.equalsIgnoreCase("Turtle")) {
			this.character = character;
		} else if (character.equalsIgnoreCase("Penguin")) {
			this.character = character;
		} else if (character.equalsIgnoreCase("Bicycle")) {
			this.character = character;
		} else {
			System.err.println("Error setting character piece for " + this.playerName + ". Defaulting to null.");
			this.character = "null";
		}
	} // end of setCharacter

	/**
	 * @return the money
	 */
	public double getMoney() {
		return money;
	} // end of getMoney

	/**
	 * @param money the money to set
	 */
	public void setMoney(double money) {
		this.money = money;
	} // end of setMoney

} // end of class
