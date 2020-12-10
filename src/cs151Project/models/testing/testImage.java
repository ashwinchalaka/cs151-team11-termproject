package cs151Project.models.testing;

import cs151Project.models.KirbySpriteSheet;
import cs151Project.models.Sprite;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class testImage {

	@Test
	//test background image
	void testBackgroundImage() throws IOException {
		
		Sprite backgroundSprite = new Sprite(1);
		BufferedImage BackgroundImage = backgroundSprite.getBackgroundImage();
		
		//BufferedImage background;
		File backgroundFile = new File("resources/LevelBackground.GIF");
		
		BufferedImage background = ImageIO.read(backgroundFile);

		assertSame(BackgroundImage, background);
		
		
	}
	
	@Test
	//test kirby image
	void testKirbyImage() throws IOException {
		KirbySpriteSheet kirbySheet = null;
		Sprite kirbySprite = new Sprite(kirbySheet);
				
		assertNotNull(kirbySprite.getKirbyImage());
	}
	
	

}
