/**
 * 
 */
package save.our.planet.game;

/**
 * This class will represent a major building improvement.
 * 
 * @author Jordan
 *
 */
public class MajorImprovement extends BoardPiece {

	private double cost;

	/**
	* 
	*/
	public MajorImprovement() {
		// TODO Auto-generated constructor stub
	} // end of MajorImprovement(Default constructor)

	/**
	 * @param cost
	 */
	public MajorImprovement(double cost) {
		super();
		this.cost = cost;
	} // end of MajorImprovement(Constructor with args)

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

}// end of class
