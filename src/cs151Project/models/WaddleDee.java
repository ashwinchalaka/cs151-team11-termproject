package cs151Project.models;

import cs151Project.controllers.Handler;
import cs151Project.views.Game;

import java.awt.Graphics;

/**
 * An object of the WaddleDee class declares and stores the information needed to program a
 * WaddleDee character into the game. This class keeps track of the state of WaddleDee as
 * well (ie. standing, walking) to supply the proper animations and other program responses.
 */
public class WaddleDee extends Entity {

	/**
	 * The left-most coordinate limit that the WaddleDee enemy character can walk to.
	 */
	private int walkBounds1;

	/**
	 * The right-most coordinate limit that the WaddleDee enemy character can walk to.
	 */
	private int walkBounds2;

	/**
	 * Initializes 1 WaddleDee object with all necessary information.
	 *
	 * @param x x positional value for the image location relative to the game window
	 * @param y y positional value for the image location relative to the game window
	 * @param width width of the WaddleDee image as it appears in the game window
	 * @param height height of the WaddleDee image as it appears in the game window
	 * @param walkBounds1 left-most coordinate limit that the WaddleDee enemy character
	 *                       can walk to
	 * @param walkBounds2 right-most coordinate limit that the WaddleDee enemy character
	 *                       can walk to
	 * @param solid determines if character can pass through other characters or is solid
	 *                 and thus has collision detection code.
	 * @param id the type of character (ie. player, platform, etc.)
	 * @param handler the handler object that contains the information about the level that
	 *                   the character operates in.
	 */
	public WaddleDee(int x, int y, int width, int height, int walkBounds1, int walkBounds2, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		this.walkBounds1 = walkBounds1;
		this.walkBounds2 = walkBounds2;
		setVelX(-2);
	}

	/**
	 * This method is responsible for drawing the image graphics for WaddleDee.
	 *
	 * @param g this object provides the necessary functions to paint the images to the
	 *             game window.
	 */
	@Override
	public void render(Graphics g) {
		if(facing == 0)
			g.drawImage(Game.wd[frames], x, y, width, height, null);
		else if(facing == 1)
			g.drawImage(Game.wd[frames + 2], x, y, width, height, null);
	}

	/**
	 * This function updates the positional values and speed of WaddleDee. It also handles
	 * all collision detection between WaddleDee and a Tile type object or between WaddleDee
	 * and another Entity type object.
	 */
	@Override
	public void update() {
		enemyWalk.start();
		x += velX;
		y += velY;

		for(Tile t:handler.tile) {
			if(!t.solid)break;
			if(t.getId() == Id.platform) {
				if(getBoundsBottom().intersects(t.getBounds())) {
					setVelY(0);
					if(falling) {
						falling = false;
					}
				}
				else if(!falling) {
					gravity = 0.0;
					falling = true;
				}
			}
				if(getBoundsLeft().intersects(t.getBounds()) || x == walkBounds1) {
					facing = 1;
					setVelX(2);
				}

				if(getBoundsRight().intersects(t.getBounds()) || x == walkBounds2) {
					facing = 0;
					setVelX(-2);
				}
		}
		if(falling) {
			gravity += 0.1;
			setVelY((int) gravity);
		}
	}
}