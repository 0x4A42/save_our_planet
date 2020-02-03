/**
 * 
 */
package save.our.planet.game;

/**
 * This class will represent a die. It will have a roll count which will move
 * the player along the board.
 * 
 * @author Jordan
 *
 */
public class Die {

	private int rollCount;

	/**
	 * Default constructor
	 */
	public Die() {

	} // end of Die(Default constructor)

	/**
	 * @param rollCount
	 */
	public Die(int rollCount) {
		this.rollCount = rollCount;
	}

	/**
	 * @return the rollCount
	 */
	public int getRollCount() {
		return rollCount;
	}

	/**
	 * @param rollCount the rollCount to set
	 */
	public void setRollCount(int rollCount) {
		switch (rollCount) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			this.rollCount = rollCount;
			break;
		default:
			this.rollCount = 0;
		}

	} // end of setRollCount

}
