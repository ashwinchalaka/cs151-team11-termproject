package cs151Project.models.testing;

import cs151Project.views.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class testGame {

	@Test
	void testInit() {
		//if init function works, kirby will have his image on the view
		Game testWorld = new Game();
		
		testWorld.init();
		
		assertNotNull(testWorld.ks);
		
		
	}
	
	@Test
	//if function works, handler should not be null
	void testRender() {
		//test world render function 
		Game testWorld = new Game();
		
		testWorld.render();
		
		assertNotNull(testWorld.handler);
		
		
	}
	
	@Test
	//if function works, deathScreenTime should not be null
	void testUpdate() {
		//test world render function 
		Game testWorld = new Game();
					
		assertNotNull(testWorld.deathScreenTime);
		
		
	}

}
