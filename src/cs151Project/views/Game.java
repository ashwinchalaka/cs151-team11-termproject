package cs151Project.views;

import cs151Project.controllers.KeyInput;
import cs151Project.models.*;
import cs151Project.controllers.Handler;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * An object of the Game class will create the game application window combining all the information
 * about characters (entities) and level constructs (tiles). This class contains the information to
 * start (run) the game.
 */
public class Game extends Canvas implements Runnable {

	/**
	 * A universal version identifier for a Serializable class
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The width of the application window (pixels).
	 */
	public static final int WIDTH = 300;

	/**
	 * The height of the application window (pixels).
	 */
	public static final int HEIGHT = WIDTH/15*10;

	/**
	 * The multiplier that increases the size of the application window proportionately.
	 */
	public static final int SCALE = 4;

	/**
	 * The game window title, which will appear on the application frame.
	 */
	public static final String TITLE = "Kirby Game";

	/**
	 * A necessary object to successfully run the application and keep track of the overall game
	 * status.
	 */
	private Thread thread;

	/**
	 * If running is true then the application has started and is playable, when false the
	 * application stops.
	 */
	private boolean running = false;

	/**
	 * The number of lives assigned to Kirby.
	 */
	public static int lives = 2;

	/**
	 * The number of seconds that that the dying animation appears before game over. In our case,
	 * this is zero because the number of lives screen or the game over screen will appear
	 * immediately after Kirby dies.
	 */
	public static int deathScreenTime = 0;

	/**
	 * When the showDeathScreen variable is true, the game screen will change to the death screen.
	 */
	public static boolean showDeathScreen = true;

	/**
	 * When the gameOver variable is true, the game screen will change to the game over screen.
	 */
	public static boolean gameOver = false;

	/**
	 * When the win variable is true, the game screen will change to the win screen.
	 */
	public static boolean win = false;

	/**
	 * The handler object keeps all the information about Entities and Tiles and the level that
	 * is created with them.
	 */
	public static Handler handler;

	/**
	 * The camera object keeps track of the current viewable game area and moves when Kirby moves
	 * left and right.
	 */
	public static Camera cam;

	/**
	 * This object carries the image information for Kirby.
	 */
	public static KirbySpriteSheet kirbySheet;

	/**
	 * This object carries the image information for WaddleDee.
	 */
	public static DeeSpriteSheet waddleDeeSheet;

	/**
	 * This Sprite object is initialized with the background information.
	 */
	public static Sprite back;

	/**
	 * This Sprite object is initialized with the platform information.
	 */
	public static Sprite block;

	/**
	 * This Sprite object is initialized with the Kirby information.
	 */
	public static Sprite kirby;

	/**
	 * This Sprite object is initialized with the WaddleDee information.
	 */
	public static Sprite waddleDee;

	/**
	 * This array contains all the BufferedImages for Kirby.
	 */
	public static BufferedImage[] ks;

	/**
	 * This array contains all the BufferedImages for WaddleDee.
	 */
	public static BufferedImage[] wd;

	/**
	 * This array contains all the BufferedImages for platforms.
	 */
	public static BufferedImage platform;

	/**
	 * This array contains all the BufferedImages for the background.
	 */
	public static BufferedImage background;

	/**
	 * The constructor sets the size of the game application window.
	 */
	public Game() {
		Dimension size = new Dimension(WIDTH*SCALE, HEIGHT*SCALE);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);		
	}

	/**
	 * This function allows the program to remain running until the user closes the window,
	 * loses all lives, or completes the level.
	 */
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this, "Thread");
		thread.start();
	}

	/**
	 * This function discontinues all game sprites and functionality.
	 */
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		}catch(InterruptedException ex) {
			
		}
		
	}

	/**
	 * When the game starts, all of these actions will be performed.
	 */
	public void init() {
		handler = new Handler();
		
		cam = new Camera();
		
		back = new Sprite(1);
		background = back.getBackgroundImage();
		
		block = new Sprite(2);
		platform = block.getPlatImage();
		
		kirbySheet = new KirbySpriteSheet();
		kirby = new Sprite(kirbySheet);
		ks = kirby.getKirbyImage();
		
		waddleDeeSheet = new DeeSpriteSheet();
		waddleDee = new Sprite(waddleDeeSheet);
		wd = waddleDee.getWaddleDeeImage();
				
		addKeyListener(new KeyInput());
		
	}

	/**
	 * While the game is running, all of these actions will be performed.
	 */
	public void run() {
		init();
		requestFocus();

		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double delta = 0.0;
		double ns = 1000000000.0/60.0;
		
		while(running) {
			long now = System.nanoTime();			
			delta +=(now -lastTime)/ns;
			lastTime=now;
			while(delta >=1) {
				update();
				delta--;
			}
			render();
			if(System.currentTimeMillis()-timer>1000) {
				timer+=1000;
			}
			
		}
		stop();
	}

	/**
	 * This function is called to load all of the game graphics.
	 */
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs ==null) {
			createBufferStrategy(3);
		return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        
		if(showDeathScreen) {
			if(win) {
				g.setColor(Color.WHITE);
				g.setFont(new Font("Courier", Font.BOLD, 50));
				g.drawImage(Game.ks[16], 570, 370, 160, 200, null);
				g.drawString("YOU WIN!", 520, 220);
			}
			else if(!gameOver) {
				g.setColor(Color.WHITE);
				g.setFont(new Font("Courier", Font.BOLD, 50));
				g.drawImage(Game.ks[0], 550, 300, 100, 100, null);
				g.drawString("x" + lives, 660, 370);
			}
			else {
				g.setColor(Color.WHITE);
				g.setFont(new Font("Courier", Font.BOLD, 50));
				g.drawString("GAME OVER!", 490, 370);
			}
		}
		else {		
			g.translate(cam.getX(), cam.getY());
			handler.render(g);
		}

		g.dispose();
		bs.show();
		
	}

	/**
	 * This function handles all the responses when the user interacts with Kirby and
	 * when Kirby interacts with other Entities and Tiles.
	 */
	public void update() {
		handler.update();
		
		for(Entity en: handler.entity) {
			if (en.getId() == Id.player)
				cam.update(en);
		}
		
		if(showDeathScreen && !gameOver && !win)
			deathScreenTime++;
		if(deathScreenTime >= 180) {
			showDeathScreen = false;
			deathScreenTime = 0;
			handler.clearLevel();
			handler.createLevel();
		}
	}

	/**
	 * Accessor method that returns the game application window width.
	 *
	 * @return the game application window width.
	 */
	public static int getFrameWidth() {
		return WIDTH * SCALE;
	}
}


