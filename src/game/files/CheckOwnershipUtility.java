package game.files;

import java.util.ArrayList;

/**
 * 
 * This class contains methods which will check if a player owns all relevant
 * properties within a field on the board, thus allowing them to upgrade the
 * property located there.
 * 
 * @author v2.0 - 2.2 Ricards (Initial class creation)
 * @author v2.3 - Jordan (updating of documentation, bug fix)
 * @author v2.4 - Ricards & Bekah (Print out upgradeable methods & charge
 *         methods created)
 * @author v4 - Catherine (rewrite and rename doesPlayerOwnField, extracted
 *         charge values to constants, charge can not take player to negative
 *         money)
 *
 */
public class CheckOwnershipUtility {

	private static final int MAJOR_UPGRADE_CHARGE = 50;
	private static final int MINOR_UPGRADE_CHARGE = 10;
	private static final int BASE_CHARGE = 5;

	/**
	 * compares specified field on board with player id and if player owns all
	 * returns as true
	 * 
	 * @param theBoard, the gameboard
	 * @param ownerId,  the id of the owner
	 * @param fieldId,  the id of the field
	 * @return boolean, if true the player has the right to make upgrades within the
	 *         field
	 */

	public static boolean doesPlayerOwnField(ArrayList<AreaBoard> theBoard, int ownerId, int fieldId) {
		boolean playerOwnsAll = true;
		for (int loop = 0; loop < theBoard.size(); loop++) {
			if (theBoard.get(loop).getFieldId() == fieldId && theBoard.get(loop).getOwnerId() != ownerId) {
				playerOwnsAll = false;
				break;
			}
		}
		return playerOwnsAll;
	}

	public static void returnOwned(ArrayList<AreaBoard> theBoard, int ownerId) {
		// ArrayList<AreaBoard> results = new ArrayList<AreaBoard>();

		for (int loopIn = 0; loopIn < theBoard.size(); loopIn++) {

			if (theBoard.get(loopIn).getOwnerId() == ownerId) {

				System.out.println(loopIn + " : " + theBoard.get(loopIn).getSpaceName());

			}

		}
	}

	/**
	 * A method that calculates the charge for landing on an owned property thats
	 * not yours
	 * 
	 * @param theBoard      Input the board game ArrayList
	 * @param player        Input the player ArrayList
	 * @param currentPlayer Input the current player loop
	 */
	public static void chargePlayer(ArrayList<AreaBoard> theBoard, ArrayList<Player> player, int currentPlayer) {
		int currentPlayerPosition = player.get(currentPlayer).getBoardPosition();
		int currentPlayerID = player.get(currentPlayer).getPlayerId();

		int areaId = theBoard.get(currentPlayerPosition).getFieldId();
		int minUpgrades = theBoard.get(currentPlayerPosition).getMinorUpgrades();
		int majUpgrades = theBoard.get(currentPlayerPosition).getMajorUpgrades();

		// As arrays start with 0 and our owned id is 1-4, must take away 1 from id
		int ownerOfPropertyArrayInput = theBoard.get(currentPlayerPosition).getOwnerId() - 1;

		// custom formula for coming up with charge
		if (theBoard.get(currentPlayerPosition).isOwned()
				&& theBoard.get(currentPlayerPosition).getOwnerId() != currentPlayerID) {
			int charge = (areaId * BASE_CHARGE) + (MINOR_UPGRADE_CHARGE * minUpgrades)
					+ (MAJOR_UPGRADE_CHARGE * majUpgrades);

			int amount = player.get(currentPlayer).removeMoney(charge);
			player.get(ownerOfPropertyArrayInput).gainMoney(amount);

			System.out.println(player.get(currentPlayer).getPlayerName() + " has lost " + charge + " Eco-Coins");
			System.out.println(
					player.get(ownerOfPropertyArrayInput).getPlayerName() + " has gained " + charge + " Eco-Coins");

		}
	}
}
