package cs151Project.models;

import cs151Project.controllers.Handler;
import cs151Project.views.Game;

import java.awt.Graphics;

/**
 * An object of the Kirby class declares and stores the information needed to program a
 * Kirby playable character into the game. This class keeps track of the state of Kirby
 * as well (ie. standing, walking) to supply the proper animations and other program
 * responses.
 */
public class Kirby extends Entity {

	/**
	 * Boolean value that is true if Kirby's velocity is equal to zero, and false if it is not
	 * equal to zero.
	 */
	public boolean standing = true;

	/**
	 * Boolean value that is true if Kirby's velocity is not equal to zero, and false if it is
	 * equal to zero.
	 */
	public boolean walking = false;

	/**
	 * An object of the Kirby class contains several attributes that correspond to the character's
	 * current status.
	 *
	 * @param x x positional value for the image location relative to the game window
	 * @param y y positional value for the image location relative to the game window
	 * @param width width of the Kirby image as it appears in the game window
	 * @param height height of the Kirby image as it appears in the game window
	 * @param solid determines if character can pass through other characters or is solid
	 *                 and thus has collision detection code.
	 * @param id the type of character (ie. player, platform, etc.)
	 * @param handler the handler object that contains the information about the level that
	 *                   the character operates in.
	 */
	public Kirby(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		setVelX(0);
	}

	/**
	 * This method is responsible for drawing the image graphics for Kirby.
	 *
	 * @param g this object provides the necessary functions to paint the images to the game
	 *             window.
	 */
	@Override
	public void render(Graphics g) {
		if(facing == 0) {
			if (velY > 0)
				g.drawImage(Game.ks[13], x, y, width, height, null);
			else if (velY < 0)
				g.drawImage(Game.ks[12], x, y, width, height, null);
			else if (standing)
				g.drawImage(Game.ks[frames], x, y, width, height, null);
			else if (walking)
				g.drawImage(Game.ks[frames + 3], x, y, width, height, null);
		}
		else if(facing == 1) {
			if(velY > 0)
				g.drawImage(Game.ks[15], x, y, width, height, null);
			else if(velY < 0)
				g.drawImage(Game.ks[14], x, y, width, height, null);
			else if(standing)
				g.drawImage(Game.ks[frames + 2], x, y, width, height, null);
			else if(walking)
				g.drawImage(Game.ks[frames + 7], x, y, width, height, null);
		}

	}

	/**
	 * This function updates the positional values and speed of Kirby. It also handles all
	 * collision detection between a Player type object and a Tile type object or between
	 * Kirby and another Entity type object.
	 */
	@Override
	public void update() {
		x += velX;
		y += velY;
		if(x <= 0)
			x = 0;
		if(x + width >= 5200)
			x = 5200 - width;
		if(y + height > 800)
			y = 800 - height;
		if(x >= 4900) {
			Game.win = true;
			die();
		}
		if(y >= 720)
			die();
		if(velX != 0 && velY == 0) {
			standing = false;
			walking = true;
			standTime.stop();
		}
		if(velX == 0 && velY == 0) {
			standing = true;
			walking = false;
			walkTime.stop();
		}
		for(Tile t:handler.tile) {
			if(!t.solid)break;
			if(t.getId() == Id.platform) {
				if(getBoundsTop().intersects(t.getBounds())) {
					setVelY(0);
					if(jumping) {
						jumping = false;
						gravity = 0.0;
						falling = true;
					}
				}
				if(getBoundsBottom().intersects(t.getBounds())) {
					setVelY(0);
					if(falling) {
						falling = false;
					}
				}
				else if(!falling && !jumping) {
					gravity = 0.0;
					falling = true;
				}
			}
				if(getBoundsLeft().intersects(t.getBounds())) {
					setVelX(0);
					x = t.getX() + t.width;
				}
				
				if(getBoundsRight().intersects(t.getBounds())) {
					setVelX(0);
					x = t.getX() - t.width;
				}
		}
		for(int i = 0; i < handler.entity.size(); i++) {
			Entity e = handler.entity.get(i);
			if(e.getId() == Id.waddleDee) {
				if(getBounds().intersects(e.getBounds())) {
					die();
				}
			}
			if(e.getId() == Id.waddleDoo) {
				if(getBounds().intersects(e.getBounds())) {
					die();
				}
			}
		}
		if(jumping) {
			gravity -= 0.1;
			setVelY((int) -gravity);
			if(gravity <= 0.0) {
				jumping = false;
				falling = true;
			}
		}
		if(falling) {
			gravity += 0.1;
			setVelY((int) gravity);
		}
		if(standing) {
			standTime.start();
		}
		if(walking) {
			walkTime.start();
		}
	}
	
}
