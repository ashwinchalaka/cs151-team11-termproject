package cs151Project.models.testing;

import cs151Project.controllers.Handler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class testHandle {

	@Test
	void testEntity() {
		Handler handler = new Handler();
		handler.createLevel();
		
		assertNotNull(handler.entity);
		
	}
	
	
	@Test
	void testTile() {
		Handler handler = new Handler();
		handler.createLevel();
		
		assertNotNull(handler.tile);
		
	}
	

}
