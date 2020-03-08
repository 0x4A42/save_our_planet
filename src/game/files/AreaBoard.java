package game.files;

import java.util.ArrayList;

/**
 * CSC7053-1920-G2: Jordan Brown (40282125), Ricards Estemirovs (40126945),
 * Rebekah Logan (40059637), Catherine McGuckin (40105486)
 * 
 * This class represents 'squares' on the board, which players will 'land on' to
 * do various activities such as purchasing or upgrading or passing the start to
 * collect resources.
 *
 * 
 * @author v1.0 Jordan (Set up initial class)
 * @author v2.0 - 2.2 Bekah, Catherine, Ricards (Refactored & updated code)
 * @author v2.3 - Jordan (updating of documentation)
 * @author v4 - Catherine (buyMinorUpgrade/buyMajorUpgrade use
 *         removeMoney/gainMoney functions rather than directly setting money)
 * @author v4.1 Jordan (added constants to make code more readable)
 * @author v4.3 Catherine (add messages to make it clear what the player pays to
 *         upgrade)
 * @author v4.4 Jordan (ensure all instances of messages to user uses constant
 *         values where applicable, to ensure easy maintainability of code)
 */

public class AreaBoard extends FieldBoard implements IBought {

	public static final int UPPER_MINOR_UPGRADE_LIMIT = 3;
	private final int MAJOR_UPGRADE_LIMIT = 1;
	private final int LOWER_PLAYER_ID = 1;
	private final int UPPER_PLAYER_ID = 4;
	private final int LOWER_FIELD_ID = 0;
	private final int UPPER_FIELD_ID = 4;
	private final int LOWER_COST_LIMIT = 50;
	private final int UPPER_COST_LIMIT = 80;
	private int fieldId;
	private int cost;
	private boolean owned;
	private int ownerId;
	private int minorUpgrades = 0; // default to 0 as not owned, therefore cannot have upgrades
	private int majorUpgrades = 0; // default to 0 as not owned, therefore cannot have upgrades

	/**
	 * Default constructor
	 */
	public AreaBoard() {

	}

	/**
	 * Constructor with args. Calls the setters to ensure validation is adhered to
	 * 
	 * @param spaceName the name of the square.
	 * @param ownable,  determines of the square is ownable.
	 * @param fieldId,  the Id of the field.
	 * @param cost,     the cost of the property
	 */

	public AreaBoard(String spaceName, boolean ownable, int fieldId, int cost) {
		super(spaceName, ownable);
		this.setFieldId(fieldId);
		this.setCost(cost);
		this.owned = false;
	}

	/**
	 * 
	 * @return the fieldId
	 */
	public int getFieldId() {
		return fieldId;
	}

	/**
	 * Sets the ID of the field. 0 = 'board' squares such as 'start' or blank
	 * squares 1 = property squares related to biomass 2 = property squares related
	 * to wind farms 3 = property squares related to solar power 4 = property
	 * squares related to hydroelectricity
	 * 
	 * @param fieldId
	 * @throws IllegalArgumentException if ID is outside of range
	 */
	public void setFieldId(int fieldId) throws IllegalArgumentException {
		if (fieldId >= LOWER_FIELD_ID && fieldId <= UPPER_FIELD_ID) {
			this.fieldId = fieldId;
		} else {
			throw new IllegalArgumentException("Field ID must be between " + LOWER_FIELD_ID + " - " + UPPER_FIELD_ID
					+ " (inclusive). You have entered: " + fieldId + ".");
		}

	}

	/**
	 * Checks if property is Owned
	 * 
	 * @return boolean, true = owned, false = not owned.
	 */
	public boolean isOwned() {
		return owned;
	}

	/**
	 * 
	 * @return the cost of the property
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * Sets the cost of the property. If the field ID is 0, sets to 0 no matter the
	 * arg.
	 * 
	 * @param cost, the cost of the property to set
	 * @throws IllegalArgumentException, if ID is not 0 and cost is outside of
	 *                                   range.
	 */
	public void setCost(int cost) throws IllegalArgumentException {
		if (cost >= LOWER_COST_LIMIT && cost <= UPPER_COST_LIMIT && this.fieldId != 0) {
			this.cost = cost;
		} else if (this.fieldId == 0) {
			this.cost = 0;
		} else if (cost < LOWER_COST_LIMIT || cost > UPPER_COST_LIMIT && this.fieldId != 0) {
			throw new IllegalArgumentException("Cost must be between " + LOWER_COST_LIMIT + " - " + UPPER_COST_LIMIT
					+ " (inclusive). You have entered: " + cost + ".");
		}
	}

	
	/**
	 * 
	 * @return the ID of the owner
	 */
	public int getOwnerId() {
		return ownerId;
	}

	/**
	 * Sets the ID of the owner of the property.
	 * 
	 * @param ownerId, the Id of the owner.
	 * @throws IllegalArgumentException if the ID is < 1 or > 4.
	 */
	public void setOwnerId(int ownerId) throws IllegalArgumentException {
		if (ownerId >= LOWER_PLAYER_ID && ownerId <= UPPER_PLAYER_ID) {
			this.ownerId = ownerId;
		} else {
			throw new IllegalArgumentException("Owner ID must be between " + LOWER_PLAYER_ID + " - " + UPPER_PLAYER_ID
					+ "(inclusive). You have entered: " + ownerId);
		}

	}

	/**
	 * 
	 * @return the amount of minor upgrades a property has
	 */
	public int getMinorUpgrades() {
		return minorUpgrades;
	}

	/**
	 * 
	 * @return the amount of major upgrades a property has
	 */
	public int getMajorUpgrades() {
		return majorUpgrades;
	}

	/**
	 * Checks if a property has been bought by checking first the property square is
	 * ownable, and secondly that it has not been purchased by another player. Then
	 * sets the owner to the player who purchased it.
	 */

	@Override
	public void bought(int currentPlayer, ArrayList<Player> playerArray) {

		if (isOwnable() && owned == false) {

			if (playerArray.get(currentPlayer).getMoney() > cost) {
				owned = true;
				setOwnerId(playerArray.get(currentPlayer).getPlayerId());
				playerArray.get(currentPlayer).removeMoney(cost);

				System.out.println("You have bought: " + getSpaceName() + " for " + cost);
				System.out.println("You now have " + playerArray.get(currentPlayer).getMoney());

			}
		}

	}
	
	
	/**
	 * Allows the player to buy minor upgrades
	 * 
	 * @param p (input player object)
	 */
	public void buyMinorUpgrade(Player p) {

		if (minorUpgrades <= UPPER_MINOR_UPGRADE_LIMIT && p.getMoney() > 20) {

			minorUpgrades++;
			p.removeMoney(CheckOwnershipUtility.MINOR_UPGRADE_CHARGE);
			System.out.println(p.getPlayerName() + " pays " + CheckOwnershipUtility.MINOR_UPGRADE_CHARGE
					+ " to add a minor upgrade.");
			System.out.println("Congratulations! You have added a minor upgrade to the selected property.");
		} else {
			System.out.println("Sorry - you can't upgrade!");
		}
	}

	/**
	 * Allows the player to buy a major upgrade
	 * 
	 * @param p (input player object)
	 */
	public void buyMajorUpgrade(Player p) {
		if (minorUpgrades == UPPER_MINOR_UPGRADE_LIMIT && majorUpgrades < MAJOR_UPGRADE_LIMIT & p.getMoney() > 50) {

			majorUpgrades++;
			p.removeMoney(CheckOwnershipUtility.MAJOR_UPGRADE_CHARGE);
			System.out.println(p.getPlayerName() + " pays " + CheckOwnershipUtility.MAJOR_UPGRADE_CHARGE
					+ " to add a major upgrade.");
			System.out.println("Congratulations! You have added a major upgrade to the selected property.");
		} else {
			System.out.println("Sorry - you cant upgrade!");
		}
	}
	


}
