package cs151Project.models;

import cs151Project.controllers.Handler;
import cs151Project.models.Id;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * This abstract class is the blueprint for all static graphic objects in the game.
 */
public abstract class Tile {
	/**
	 * Tiles must have an x and y coordinate position.
	 */
	public int x, y;

	/**
	 * Tiles must have a width and height for the graphic representation.
	 */
	public int width, height;

	/**
	 * Tiles that are solid will not be able to pass through other solid Entities and Tiles.
	 */
	public boolean solid;

	/**
	 * This variable corresponds the label prescribed in the Id (identifier) class.
	 */
	public Id id;

	/**
	 * This handler object allows the Entity object to be assigned to a specific handler.
	 */
	public Handler handler;

	/**
	 * Assigns the following information to an Tile object.
	 *
	 * @param x x positional value for the image location
	 * @param y y positional value for the image location
	 * @param width width of the Tile's image as it appears in the game window
	 * @param height height of the Tile's image as it appears in the game window
	 * @param solid determines if other objects can pass through this object.
	 * @param id the object identifier (ie. player, platform, etc.)
	 * @param handler the handler object that contains the information about the level that
	 *                   the tile operates in.
	 */
	public Tile(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		this.x = x;
		this.y =y; 
		this.height = height;
		this.width = width;
		this.solid = solid;
		this.id = id;
		this.handler = handler;
	}

	/**
	 * This method is responsible for drawing the image graphics for the Tile object.
	 *
	 * @param g this object provides the necessary functions to paint the images to the
	 *             game window.
	 */
	public abstract void render(Graphics g);

	/**
	 * This function updates the positional values and speed of the Tile object. It also
	 * handles all collision detection.
	 */
	public abstract void update();

	/**
	 * Accessor method for the x-coordinate position.
	 *
	 * @return the x-coordinate position
	 */
	public int getX() {
		return x;
	}

	/**
	 * Setter method for the x-coordinate position.
	 *
	 * @param x the new x-coordinate position
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Accessor method for the y-coordinate position.
	 *
	 * @return the y-coordinate position
	 */
	public int getY() {
		return y;
	}

	/**
	 * Accessor method for solid (boolean) state.
	 *
	 * @return solid (boolean) state
	 */
	public boolean isSolid() {
		return solid;
	}

	/**
	 * Setter method for solid (boolean) state.
	 *
	 * @param solid solid (boolean) state
	 */
	public void setSolid(boolean solid) {
		this.solid = solid;
	}

	/**
	 * Getter method for object identifier.
	 *
	 * @return object identifier (ie. player, platform, etc.)
	 */
	public Id getId() {
		return id;
	}

	/**
	 * Getter method for rectangular representation of boundaries.
	 *
	 * @return rectangular boundary representation
	 */
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), width, height);
	}
}

