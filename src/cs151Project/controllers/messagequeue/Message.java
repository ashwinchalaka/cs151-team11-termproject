package cs151Project.controllers.messagequeue;
import java.io.Serializable;

/**
 * An object of this class will hold messages that track user action and can be used for Valves.
 */
public abstract class Message implements Serializable {
	/**
	 * A universal version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;
}
