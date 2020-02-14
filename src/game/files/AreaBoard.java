package game.files;

/**
 * This class represents 'squares' on the board, which players will 'land on' to
 * do various activities such as purchasing or upgrading or passing the start to
 * collect resources.
 * 
 * @author v1.0 Jordan (Set up initial class)
 * @author v2.0 - 2.2 Bekah, Cathrine, Ricards (Refactored & updated code)
 * @author v2.3 - Jordan (updating of documentation)
 */

public class AreaBoard extends FieldBoard implements IBought {

	private final int LOWER_PLAYER_ID = 1;
	private final int UPPER_PLAYER_ID = 4;
	private int fieldId;
	private int cost;
	private boolean owned;
	private int ownerId;

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
	 * Sets the ID of the field.
	 * 
	 * @param fieldId
	 */
	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
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
	 * 
	 * @param cost, the cost of the property to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * Checks if a property has been bought by checking first the property square is
	 * ownable, and secondly that it has not been purchased by another player. Then
	 * sets the owner to the player who purchased it.
	 */
	public void bought(int playerId) {
		if (isOwnable() && owned == false) {
			owned = true;
			setOwnerId(playerId);
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
			throw new IllegalArgumentException(
					"Owner ID must be between 1 - 4 (inclusive). You have entered: " + ownerId);
		}

	}
}
