package cs151Project.models.testing;

import cs151Project.controllers.Handler;
import cs151Project.models.Id;
import cs151Project.models.Kirby;
import cs151Project.views.Camera;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class testCamera {

	@Test
	//test the position of the camera
	void test() {
		Handler handler = new Handler();
		handler.createLevel();

		Kirby player = new Kirby(300, 440, 64, 64, true, Id.player, handler);
		
		Camera cam = new Camera();
		cam.update(player);
		
		assertTrue(cam.getX() ==0);
	}

}
