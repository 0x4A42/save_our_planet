/**
 * 
 */
package save.our.planet.game;

/**
 * This class will represent a minor building improvement.
 * 
 * @author Jordan
 *
 */
public class MinorImprovement extends BoardPiece {

	private double cost;

	/**
	 * Default constructor
	 */
	public MinorImprovement() {
		// TODO Auto-generated constructor stub
	}// end of MinorImprovement(Default constructor)

	/**
	 * @param cost
	 */
	public MinorImprovement(double cost) {
		this.cost = cost;
	}// end of MinorImprovement(Constructor with args)

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}// end of getCost

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}// end of setCost

} // end of class
