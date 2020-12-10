package cs151Project.models;

import cs151Project.controllers.Handler;
import cs151Project.views.Game;

import java.awt.Graphics;

/**
 * Platform object is a type of Tile class that specifies the data specifically for a platform.
 */
public class Platform extends Tile {

	/**
	 * Assigns the following information to an Platform object.
	 *
	 * @param x x positional value for the image location
	 * @param y y positional value for the image location
	 * @param width width of the Platform's image as it appears in the game window
	 * @param height height of the Platform's image as it appears in the game window
	 * @param solid provides logic for collision detection code.
	 * @param id the type of character (ie. player, platform, etc.)
	 * @param handler the handler object that contains the information about the level that
	 *                   the platform operates in.
	 */
	public Platform(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
	}

	/**
	 * This method is responsible for drawing the image graphics for the Platform object.
	 *
	 * @param g this object provides the necessary functions to paint the images to the
	 *             game window.
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(Game.platform, x, y, width, height, null);
	}

	/**
	 * This function updates the positional values and speed of the Platform object. It also
	 * handles all collision detection.
	 */
	@Override
	public void update() {}
}
