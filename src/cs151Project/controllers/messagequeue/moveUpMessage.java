package cs151Project.controllers.messagequeue;

/**
 * This class holds message data tracking Kirby's jumping movement when the user presses
 * the 'W' key.
 */
public class moveUpMessage extends Message {
	/**
	 * A universal version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Storage for Kirby's current y-position.
	 */
	int Yposition;

	/**
	 * Saves Kirby's current y-position to the moveUpMessage object.
	 *
	 * @param Yposition is the position of kirby on y-coordinate
	 */
	public moveUpMessage(int Yposition) {
		this.Yposition = Yposition;
	}

	/**
	 * Accessor method for Kirby's current y position.
	 *
	 * @return the position of Kirby jumps in the air now
	 */
	public int getYposition() {
		return Yposition;
	}
}
