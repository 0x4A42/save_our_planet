package game.files;

/**
 * This class allows the creation of major and minor upgrades for property the
 * player owns the entire field for.
 * 
 * @author v2.0 - 2.2 Ricards (Initial class creation)
 * @author v2.3 - Jordan (updating of documentation)
 *
 */
public class Upgrades {
	private final int LOWER_MINOR_UPGRADE_LIMIT = 0;
	private final int UPPER_MINOR_UPGRADE_LIMIT = 3;

	private int minorUpgrades = 0; // default to 0 as not owned, therefore cannot have upgrades
	private int majorUpgrades = 0; // default to 0 as not owned, therefore cannot have upgrades

	/**
	 * Default constructor
	 */
	public Upgrades() {

	}

	/**
	 * Constructor with args
	 * 
	 * @param minorUpgrades, the amount of minor upgrades a property has
	 * @param majorUpgrades, the amount of major upgrades a property has
	 */
	public Upgrades(int minorUpgrades, int majorUpgrades) {
		this.minorUpgrades = minorUpgrades;
		this.majorUpgrades = majorUpgrades;
	}

	/**
	 * 
	 * @return the amount of minor upgrades a property has
	 */
	public int getMinorUpgrades() {
		return minorUpgrades;
	}

	/**
	 * /** Sets the amount of minor upgrades a property has
	 *
	 * @param minorUpgrades, the amount of upgrades to set.
	 * @throws IllegalArgumentException, if the amount of upgrades for a property is
	 *                                   < 0 or > 3.
	 */
	public void setMinorUpgrades(int minorUpgrades) throws IllegalArgumentException {
		if (minorUpgrades >= LOWER_MINOR_UPGRADE_LIMIT && minorUpgrades <= UPPER_MINOR_UPGRADE_LIMIT) {
			this.minorUpgrades = minorUpgrades;

		} else {
			throw new IllegalArgumentException(
					"A property can have between 0 - 3 (inclusive) minor upgrades. You have attempted to set: "
							+ minorUpgrades);
		}
	}

	/**
	 * 
	 * @return the amount of major upgrades a property has
	 */
	public int getMajorUpgrades() {
		return majorUpgrades;
	}

	/**
	 * Sets the amount of major upgrades a property has. The player must own 3 minor
	 * upgrades to access a major upgrade.
	 * 
	 * @param majorUpgrades, the amoutn of major upgrades to set
	 */
	public void setMajorUpgrades(int majorUpgrades) {
		if (this.minorUpgrades == UPPER_MINOR_UPGRADE_LIMIT) {
			this.majorUpgrades = majorUpgrades;
		} else {
			this.majorUpgrades = 0;
		}

	}

}
