package cs151Project.models;

import cs151Project.controllers.Handler;
import cs151Project.views.Game;

import java.awt.Graphics;

/**
 * A background object is a type of tile that appears in the game application window. It
 * contains the information for the background picture.
 */
public class Background extends Tile {

	/**
	 * Initializes a background object with the following data.
	 *
	 * @param x x-position of the background image
	 * @param y y-position of the background image
	 * @param width width of the background image
	 * @param height height of the background image
	 * @param solid determines if character can pass through other characters or is solid
	 *                 and thus has collision detection code.
	 * @param id the type of character (ie. player, platform, etc.)
	 * @param handler the handler object that contains the information about the level that
	 *                   the character operates in.
	 */
	public Background(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
	}

	/**
	 * This method is responsible for drawing the image graphics for the background image.
	 *
	 * @param g
	 */
	@Override
	public void render(Graphics g) {
		g.drawImage(Game.background, 0, 0, 5200, 700, null);
	}

	/**
	 * This function updates the background image data as needed.
	 */
	@Override
	public void update() {}
}
