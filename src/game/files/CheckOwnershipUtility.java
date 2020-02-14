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
 *
 *
 */
public class CheckOwnershipUtility {

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

	public static boolean ownsFieldOne(ArrayList<AreaBoard> theBoard, int ownerId, int fieldId) {
		boolean playerOwnsAll = false;
		ArrayList<AreaBoard> results = new ArrayList<AreaBoard>();
		ArrayList<AreaBoard> compareSize = new ArrayList<AreaBoard>();

		for (int loop = 0; loop < theBoard.size(); loop++) {
			if (theBoard.get(loop).getFieldId() == fieldId) {
				compareSize.add(theBoard.get(loop));
			}

			if (theBoard.get(loop).getFieldId() == fieldId && theBoard.get(loop).getOwnerId() == ownerId) {
				results.add(theBoard.get(loop));
			}
		}

		if (results.size() == compareSize.size()) {
			playerOwnsAll = true;
		}

		return playerOwnsAll;
	}
}
