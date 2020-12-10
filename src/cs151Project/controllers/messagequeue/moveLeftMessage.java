package cs151Project.controllers.messagequeue;

/**
 * This class holds message data tracking Kirby's left movement when the user presses
 * the 'A' key.
 */
public class moveLeftMessage extends Message {
	/**
	 * A universal version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Storage for Kirby's current x-position.
	 */
	int Xposition;

	/**
	 * Saves Kirby's current x-position to the moveLeftMessage object.
	 *
	 * @param Xposition is the position of kirby on x-coordinate
	 */
	public moveLeftMessage(int Xposition) {
		this.Xposition = Xposition;
	}

	/**
	 * Accessor method for Kirby's current x position.
	 *
	 * @return the position of Kirby stands now
	 */
	public int getXposition() {
		return Xposition;
	}
}
