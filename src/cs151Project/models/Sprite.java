package cs151Project.models;

import cs151Project.models.DeeSpriteSheet;
import cs151Project.models.KirbySpriteSheet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * An object of the Sprite class will have access to ALL the BuffereedImage files that pertain
 * to the Kirby game. It is from this class that other classes will access these files.
 */
public class Sprite {

	/**
	 * Holds the BufferedImage of the game background image file.
	 */
	public BufferedImage background;

	/**
	 * The original image file for the game background.
	 */
	File backgroundFile = new File("resources/LevelBackground.GIF");

	/**
	 * Holds the BufferedImage of platform image file.
	 */
	public BufferedImage platform;

	/**
	 * The original image file for the platforms that the characters stand on.
	 */
	File platformFile = new File("resources/Platform.GIF");

	/**
	 * This object is populated with all the Kirby image files that have already been
	 * converted to BufferedImage files.
	 */
	public KirbySpriteSheet kirbySheet;

	/**
	 * Temporary holder of kirby sprite sheet buffered image files.
	 */
	BufferedImage[] ks;

	/**
	 * A public version of the Kirby Sprite sheet so that it is accessible to other classes.
	 */
	BufferedImage[] kirbyImage;

	/**
	 * This object is populated with all the Waddle Dee image files that have already been
	 * converted to BufferedImage files.
	 */
	public DeeSpriteSheet waddleDeeSheet;

	/**
	 * Temporary holder of waddle dee sprite sheet buffered image files.
	 */
	BufferedImage[] wd;

	/**
	 * A public version of the WaddleDee Sprite sheet so that it is accessible to other classes.
	 */
	public BufferedImage[] waddleDeeImage;

	/**
	 * Constructor that initializes the background and platform buffered image files.
	 *
	 * @param choice allows the user to choose access to the background or platform image file.
	 */
	public Sprite(int choice) {
		if(choice == 1) {
			try {
				background = ImageIO.read(backgroundFile);
			}
			catch(IOException e){
			
			}
		}
		if(choice == 2) {
			try {
				platform = ImageIO.read(platformFile);
			}
			catch(IOException e){
			
			}
		}
	}

	/**
	 * Constructor that initializes the objects with access to the Kirby Buffered Images.
	 *
	 * @param kirbySheet original image files for Kirby
	 */
	public Sprite(KirbySpriteSheet kirbySheet) {
		this.kirbySheet = kirbySheet;
		ks = new BufferedImage[17];
		kirbyImage = new BufferedImage[17];
		ks = kirbySheet.getKirbySprite();
		for(int i=0; i< ks.length; i++)
			kirbyImage[i]= ks[i];
	}

	/**
	 * Constructor that initializes the objects with access to the WaddleDee Buffered Images.
	 *
	 * @param waddleDeeSheet original image files for WaddleDee
	 */
	public Sprite(DeeSpriteSheet waddleDeeSheet) {
		this.waddleDeeSheet = waddleDeeSheet;
		wd = new BufferedImage[4];
		waddleDeeImage = new BufferedImage[4];
		wd = waddleDeeSheet.getWaddleDeeSprite();
		for(int i=0; i< wd.length; i++)
			waddleDeeImage[i]= wd[i];
	}

	/**
	 * Accessor method for platform image.
	 *
	 * @return
	 */
	public BufferedImage getPlatImage() {
		return platform;
	}

	/**
	 * Accessor method for backgorund image.
	 *
	 * @return
	 */
	public BufferedImage getBackgroundImage() {
		return background;
	}

	/**
	 * Accessor method for Kirby images.
	 *
	 * @return
	 */
	public BufferedImage[] getKirbyImage() {
		return kirbyImage;
	}

	/**
	 * Accessor method for WaddleDee images.
	 *
	 * @return
	 */
	public BufferedImage[] getWaddleDeeImage() {
		return waddleDeeImage;
	}
	
}