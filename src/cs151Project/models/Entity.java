package cs151Project.models;

import cs151Project.controllers.Handler;
import cs151Project.views.Game;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.Timer;

/**
 * This abstract class is the blueprint for all moving character objects in the game.
 */
public abstract class Entity {

	/**
	 * Entities must have an x and y coordinate position.
	 */
	public int x, y;

	/**
	 * Entities must have a width and height for the graphic representation.
	 */
	public int width, height;

	/**
	 * Entities will have a facing value to allow for moving animations.
	 */
	public int facing = 0;

	/**
	 * Entities that are solid will not be able to pass through other solid Entities and Tiles.
	 */
	public boolean solid;

	/**
	 * While an entity is jumping this variable will be true.
	 */
	public boolean jumping= false;

	/**
	 * While an entity is falling this variable will be true.
	 */
	public boolean falling = true;

	/**
	 * These variables control the speed of movement in the x and y directions.
	 */
	public int velX, velY;

	/**
	 * This variable corresponds the label prescribed in the Id (identifier) class.
	 */
	public Id id;

	/**
	 * Data to calculate the falling speed.
	 */
	public double gravity = 0.0;

	/**
	 * This handler object allows the Entity object to be assigned to a specific handler.
	 */
	public Handler handler;

	/**
	 * Keeps track of the number of frames required for an animation.
	 */
	public int frames = 0;

	/**
	 * Timer used to calculate the speed of the animation while an entity is standing.
	 */
	public Timer standTime = new Timer(200, e -> {
		frames++;
		if(frames >= 2)
			frames = 0;
	});

	/**
	 * Timer used to calculate the speed of the animation while Kirby is moving.
	 */
	public Timer walkTime = new Timer(150, e -> {
		if(frames >= 4) 
			frames = 0;
		frames++;
	});

	/**
	 * Timer used to calculate the speed of the animation while WaddleDee is moving.
	 */
	public Timer enemyWalk = new Timer(300, e -> {
		frames++;
		if(frames >= 2)
			frames = 0;
	});

	/**
	 * Assigns the following information to an Entity object.
	 *
	 * @param x x positional value for the image location
	 * @param y y positional value for the image location
	 * @param width width of the Entity's image as it appears in the game window
	 * @param height height of the Entity's image as it appears in the game window
	 * @param solid determines if other objects can pass through this object.
	 * @param id the object identifier (ie. player, platform, etc.)
	 * @param handler the handler object that contains the information about the level that
	 *                   the entity operates in.
	 */
	public Entity(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		this.x = x;
		this.y =y; 
		this.height = height;
		this.width = width;
		this.solid = solid;
		this.id = id;
		this.handler = handler;
	}

	/**
	 * This method is responsible for drawing the image graphics for the Entity object.
	 *
	 * @param g this object provides the necessary functions to paint the images to the
	 *             game window.
	 */
	public abstract void render(Graphics g);

	/**
	 * This function updates the positional values and speed of the Entity object. It also
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
	 * Accessor method for the y-coordinate position.
	 *
	 * @return the y-coordinate position
	 */
	public int getY() {
		return y;
	}

	/**
	 * Accessor method for the x-velocity (speed).
	 *
	 * @param velX the x-velocity (speed)
	 */
	public void setVelX(int velX) {
		this.velX = velX;
	}

	/**
	 * Accessor method for the y-velocity (speed).
	 *
	 * @param velY the y-velocity (speed)
	 */
	public void setVelY(int velY) {
		this.velY = velY;
	}

	/**
	 * Accessor method for the identifier.
	 *
	 * @return the identifier.
	 */
	public Id getId() {
		return id;
	}

	/**
	 * Operation to remove an entity object from the game once it is killed.
	 */
	public void die() {
		handler.removeEntity(this);
		Game.lives--;
		Game.showDeathScreen = true;
		
		if(Game.lives <= 0)
			Game.gameOver = true;
		if(Game.win == true)
			Game.lives = 0;
	}

	/**
	 * Accessor method for the game application window boundaries.
	 *
	 * @return the boundary rectangle representation
	 */
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), width, height);
	}

	/**
	 * Accessor method for the upper boundaries of Tile objects.
	 *
	 * @return the boundary rectangle representation
	 */
	public Rectangle getBoundsTop() {
		return new Rectangle(getX()+10, getY(), width-20, 5);
	}

	/**
	 * Accessor method for the lower boundaries of Tile objects.
	 *
	 * @return the boundary rectangle representation
	 */
	public Rectangle getBoundsBottom() {
		return new Rectangle(getX()+10, getY()+height-5, width-20, 5);
	}

	/**
	 * Accessor method for the left boundaries of Tile objects.
	 *
	 * @return the boundary rectangle representation
	 */
	public Rectangle getBoundsLeft() {
		return new Rectangle(getX(), getY()+10, 5, height-20);
	}

	/**
	 * Accessor method for the right boundaries of Tile objects.
	 *
	 * @return the boundary rectangle representation
	 */
	public Rectangle getBoundsRight() {
		return new Rectangle(getX()+width-5, getY()+10, 5, height-20);
	}
}
