package cs151Project.models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * An object of DeeSpriteSheet has access to the image files that all correspond to the WaddleDee
 * enemy character (entity). Once an object of this class is initialized, the image files will be
 * converted into BufferedImage objects and stored in an array.
 */
public class DeeSpriteSheet {

	/**
	 * BufferredImage array that holds the images in the format that is compatible with the game.
	 */
	private BufferedImage[] waddleDeeSheet;

	/**
	 * File array containing original image files for WaddleDee's character.
	 */
	public File[] waddleDee = {new File("resources/WaddleDee1.PNG"), new File("resources/WaddleDee2.PNG"),
						new File("resources/WaddleDee3.PNG"), new File("resources/WaddleDee4.PNG")};

	/**
	 * Once initialized the BufferedImage array is populated with converted image files.
	 */
	public DeeSpriteSheet() {	
		waddleDeeSheet = new BufferedImage[4];
		try {
				for(int i=0; i<waddleDeeSheet.length; i++) {
					waddleDeeSheet[i] = ImageIO.read(waddleDee[i]);					
				}
			}
		catch(IOException e){
		
		}
	}

	/**
	 * Acceess method for BufferedImage array.
	 *
	 * @return returns a BufferedImage array containing the BufferedImage files for WaddleDee.
	 */
	public BufferedImage[] getWaddleDeeSprite() {			
			return waddleDeeSheet;
	}
}