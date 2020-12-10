package cs151Project.views;

import cs151Project.models.Entity;

/**
 * The Camera class is responsible for controlling the viewable area while the Kirby character
 * is moving through the level.
 */
public class Camera {
	/**
	 * The x and y position of the current Camera viewable area.
	 */
	public int x, y;

	/**
	 * Adjusts the camera screen when the player moves left and right.
	 *
	 * @param player corresponding player object that camera is responding too.
	 */
	public void update(Entity player) {
		if(player.getX() <= 600)
			setX(-600 + Game.getFrameWidth()/2);
		else
			setX(-player.getX() + Game.getFrameWidth()/2);
	}

	/**
	 * Accessor method for camera x coordinate.
	 *
	 * @return x coordinate for camera object
	 */
	public int getX() {
		return x;
	}

	/**
	 * Setter method for camera x coordinate.
	 *
	 * @param x new x coordinate value
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Accessor method for camera y coordinate.
	 *
	 * @return y coordinate for camera object
	 */
	public int getY() {
		return y;
	}

	/**
	 * Setter method for camera y coordinate.
	 *
	 * @param y new y coordinate value
	 */
	public void setY(int y) {
		this.y = y;
	}
}
