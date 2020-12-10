package cs151Project.controllers.messagequeue;

/**
 * This class holds message data tracking Kirby's right movement when the user presses
 * the 'D' key.
 */
public class moveRightMessage extends Message{

	/**
	 * A universal version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Storage for Kirby's current x-position.
	 */
	int Xposition;

	/**
	 * Saves Kirby's current x-position to the moveRightMessage object.
	 *
	 * @param Xposition is the position of kirby on x-coordinate
	 */
	public moveRightMessage(int Xposition) {
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
