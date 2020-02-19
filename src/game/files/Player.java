package game.files;

/**
 * This class will allow a player to be set up - setting their name, id, money
 * and board position.
 * 
 * @author v1.0 Jordan (Set up initial class)
 * @author v2.3 - Jordan, updating of documentation and validation
 *
 */
public class Player {

	private final int LOWER_PLAYER_ID = 1;
	private final int UPPER_PLAYER_ID = 4;
	private final int LOWER_MONEY_LIMIT = 0;
	private final int LOWER_NAME_LIMIT = 1;
	private final int UPPER_NAME_LIMIT = 15;
	private int playerId;
	private String playerName;
	private double money;
	private int boardPosition = 0; // default to 0 to represent start position

	public Player() {
	}

	/**
	 * Constructor with args, calls setters to ensure validation is adhered to
	 * 
	 * @param playerId,      the Id of the player (must be between 1 - 4 inclusive)
	 * @param playerName,    the name of the player ( 1 - 15 characters, inclusive)
	 * @param money,         the money of the player
	 * @param boardPosition, the position of the player on the board (must be
	 *                       between 0 - 11, defaults to 0)
	 */
	public Player(int playerId, String playerName, double money, int boardPosition) {
		this.setPlayerId(playerId);
		this.setPlayerName(playerName);
		this.setMoney(money);
		this.setBoardPosition(boardPosition);

	}

	/**
	 * 
	 * @return the player's name
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * Sets the player's name, if it is above 15 characters long the excess is
	 * truncated.
	 * 
	 * @param playerName
	 * @throws NullPointerException if the name is <1 character in length
	 */

	public void setPlayerName(String playerName) throws NullPointerException {
		if (playerName.length() >= LOWER_NAME_LIMIT && playerName.length() <= UPPER_NAME_LIMIT) {
			this.playerName = playerName;
		} else if (playerName.length() > UPPER_NAME_LIMIT) {
			this.playerName = playerName.substring(0, 15);
		} else if (playerName.length() < LOWER_NAME_LIMIT) {
			throw new NullPointerException("Name must be at least one character long.");
		}
	}

	/**
	 * 
	 * @return the amount of money the player has
	 */
	public double getMoney() {
		return money;
	}

	/**
	 * Sets the amount of money the player has
	 * 
	 * @param money
	 * @throws IllegalArgumentException, when value entered is <0
	 */

	public void setMoney(double money) throws IllegalArgumentException {
		if (money >= LOWER_MONEY_LIMIT) {
			this.money = money;
		} else {
			throw new IllegalArgumentException("Error. You cannot enter a money value below 0.");
		}

	}

	/**
	 * 
	 * @return the position of the player on the board
	 */
	public int getBoardPosition() {
		return boardPosition;
	}

	/**
	 * Sets the board position of the player - 0 represents start, 11 represents the
	 * current final square on the board
	 * 
	 * @param boardPosition, an int representing the player's position on the board
	 * @throws IllegalArgumentException, if the player's position is set to a value
	 *                                   above or below the min or max values
	 */
	public void setBoardPosition(int boardPosition) throws IllegalArgumentException {
		if (boardPosition >= 0 && boardPosition <= 11) {
			this.boardPosition = boardPosition;
		} else {
			throw new IllegalArgumentException(
					"Board position must be between 0 - 11 (inclusive). You have entered " + boardPosition +".");
		}
	}

	/**
	 * 
	 * @return the player's Id
	 */
	public int getPlayerId() {
		return playerId;
	}

	/**
	 * Sets the player's Id, must be between 1 - 4.
	 * 
	 * @param playerId
	 * @throws IllegalArgumentException if the Id is outside the range of 1 - 4.
	 */
	public void setPlayerId(int playerId) throws IllegalArgumentException {
		if (playerId >= LOWER_PLAYER_ID && playerId <= UPPER_PLAYER_ID) {
			this.playerId = playerId;
		} else {
			throw new IllegalArgumentException(
					"Player ID must be between 1 - 4 (inclusive). You have entered: " + playerId +".");
		}
	}

}
