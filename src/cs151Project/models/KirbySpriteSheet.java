package cs151Project.models;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * An object of KirbySprite has access to the image files that all correspond to the Kirby
 * character (entity). Once an object of this class is initialized, the image files will be
 * converted into BufferedImage objects and stored in an array.
 */
public class KirbySpriteSheet {

	/**
	 * BufferredImage array that holds the images in the format that is compatible with the game.
	 */
	private BufferedImage[] kirbySheet;

	/**
	 * File array containing original image files for Kirby's character.
	 */
	public File[] kirby = {new File("resources/KirbyStand1.PNG"), new File("resources/KirbyStand2.PNG"),
					new File("resources/KirbyStand3.PNG"), new File("resources/KirbyStand4.PNG"),
					new File("resources/KirbyWalk1.PNG"), new File("resources/KirbyWalk2.PNG"),
					new File("resources/KirbyWalk3.PNG"), new File("resources/KirbyWalk4.PNG"),
					new File("resources/KirbyWalk5.PNG"), new File("resources/KirbyWalk6.PNG"),
					new File("resources/KirbyWalk7.PNG"), new File("resources/KirbyWalk8.PNG"),
					new File("resources/KirbyJump1.PNG"), new File("resources/KirbyJump5.PNG"),
					new File("resources/KirbyJump6.PNG"), new File("resources/KirbyJump10.PNG"),
					new File("resources/KirbyWin.PNG")};

	/**
	 * Once initialized the BufferedImage array is populated with converted image files.
	 */
	public KirbySpriteSheet() {
			kirbySheet = new BufferedImage[17];
		
		try {
			for(int i = 0; i < kirby.length; i++) {
				kirbySheet[i] = ImageIO.read(kirby[i]);
			}
		}
		catch(IOException e){
		
		}	
	}

	/**
	 * Acceess method for BufferedImage array.
	 *
	 * @return returns a BufferedImage array containing the BufferedImage files for Kirby.
	 */
	public BufferedImage[] getKirbySprite() {
		return kirbySheet;
	}
}

