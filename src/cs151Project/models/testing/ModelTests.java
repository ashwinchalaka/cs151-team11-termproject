package cs151Project.models.testing;

import cs151Project.models.DeeSpriteSheet;
import cs151Project.models.KirbySpriteSheet;
import cs151Project.models.Sprite;
import cs151Project.views.Game;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModelTests {
	@Test
	public void testWorld()
	{
		Game w = new Game();
		w.init();
		Sprite s1 = new Sprite(new DeeSpriteSheet());
		Sprite s2 = new Sprite(new KirbySpriteSheet());
		BufferedImage []m1 = w.wd;
		BufferedImage []m2 = w.ks;
		BufferedImage []t1 = s1.getWaddleDeeImage();
		BufferedImage []t2 = s2.getKirbyImage();
		int count = 0;
		for(BufferedImage i : m1)
		{
			BufferedImage j = t1[count];
				assert(compareImages(i, j));
			count++;
		}
		int count1 = 0;
		for(BufferedImage i : m2)
		{
			BufferedImage j = t2[count1];
				assert(compareImages(i, j));
			count1++;
		}
	}

	@Test
	public void testSprite()
	{
		DeeSpriteSheet d = new DeeSpriteSheet();
		KirbySpriteSheet k = new KirbySpriteSheet();
		File backgroundFile = new File("resources/LevelBackground.GIF");
		File platformFile = new File("resources/Platform.GIF");
		BufferedImage b = null;
		try {
			b = ImageIO.read(backgroundFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedImage p = null;
		try {
			p = ImageIO.read(platformFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sprite s1 = new Sprite(k);
		Sprite s2 = new Sprite(d);
		Sprite s3 = new Sprite(1);
		Sprite s4 = new Sprite(2);
		//Test that constructors accept both DeeSpriteSheet and KirbySpriteSheet and ensures they are properly assigned
		assertEquals(s1.kirbySheet, k);
		assertEquals(s2.waddleDeeSheet, d);
		//Makes sure that choice parameter through the constructor successfully creates the correct buffered image
		assert(compareImages(b, s3.background));
		assert(compareImages(p, s4.platform));
	}

	@Test
	public void tesDeeSpriteSheet()
	{
		Game w = new Game();
		w.init();
		DeeSpriteSheet tmp1 = w.waddleDeeSheet;
		File [] tmp =  tmp1.waddleDee;
		File[] wd = {new File("resources/WaddleDee1.PNG"), new File("resources/WaddleDee2.PNG"),
				new File("resources/WaddleDee3.PNG"), new File("resources/WaddleDee4.PNG")};
		int j = 0;
		for(File i : wd)
		{
			assertEquals(i, tmp[j]);
			j++;
		}
	}

	@Test
	public void testKirbySpriteSheet()
	{
		Game w = new Game();
		w.init();
		KirbySpriteSheet tmp1 = w.kirbySheet;
		File [] tmp =  tmp1.kirby;
		File[] kirby = {new File("resources/KirbyStand1.PNG"), new File("resources/KirbyStand2.PNG"),
				new File("resources/KirbyStand3.PNG"), new File("resources/KirbyStand4.PNG"),
				new File("resources/KirbyWalk1.PNG"), new File("resources/KirbyWalk2.PNG"),
				new File("resources/KirbyWalk3.PNG"), new File("resources/KirbyWalk4.PNG"),
				new File("resources/KirbyWalk5.PNG"), new File("resources/KirbyWalk6.PNG"),
				new File("resources/KirbyWalk7.PNG"), new File("resources/KirbyWalk8.PNG"),
				new File("resources/KirbyJump1.PNG"), new File("resources/KirbyJump5.PNG"),
				new File("resources/KirbyJump6.PNG"), new File("resources/KirbyJump10.PNG"),
				new File("resources/KirbyWin.PNG")};
		int j = 0;
		for(File i : kirby)
		{
			assertEquals(i, tmp[j]);
			j++;
		}
	}

	//Helper method to compare buffered images
	public static boolean compareImages(BufferedImage imgA, BufferedImage imgB) {
		  if (imgA.getWidth() != imgB.getWidth() || imgA.getHeight() != imgB.getHeight()) {
		    return false;
		  }
		  int width  = imgA.getWidth();
		  int height = imgA.getHeight();
		  for (int y = 0; y < height; y++) {
		    for (int x = 0; x < width; x++) {


		      if (imgA.getRGB(x, y) != imgB.getRGB(x, y)) {
		        return false;
		      }
		    }
		  }
		  return true;
	}
}
