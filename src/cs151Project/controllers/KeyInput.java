package cs151Project.controllers;

import cs151Project.controllers.messagequeue.Message;
import cs151Project.models.Id;
import cs151Project.views.Game;
import cs151Project.models.Entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Handles the keyboard interactions between the user and the movements/animations of the
 * game character. An object of KeyInput has access to the responses when a key on the keyboard
 * is pressed or released.
 */
public class KeyInput implements KeyListener {

	/**
	 * Blocking queue implementation that holds messages.
	 */
	private static BlockingQueue<Message> queue = new LinkedBlockingQueue<Message>();

	/**
	 * Although not being used by this program, this function handles a response
	 * when an event key is typed.
	 *
	 * @param e The key that is typed.
	 */
	@Override
	public void keyTyped(KeyEvent e) {}

	/**
	 * This function handles the response when one of the movement keys is pressed. The
	 * function applies as long as the key is held until the moment the key is released.
	 * When a movement key is pressed, Kirby will start moving.
	 *
	 * @param e The key that is pressed.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		for(Entity en: Game.handler.entity) {
			if(en.getId() == Id.player) {
				if(e.getKeyCode() == KeyEvent.VK_D) {
					en.setVelX(5);
					en.facing = 0;
				}
				if(e.getKeyCode() == KeyEvent.VK_A) {
					en.setVelX(-5);
					en.facing = 1;
				}
				if(e.getKeyCode() == KeyEvent.VK_W) {
					if(!en.jumping ) {
						en.jumping = true;
						en.gravity = 5.0;
					}
					en.setVelY(-5);
				}
			}
		}	
	}

	/**
	 * This function handles the response when one of the movement keys is released. When
	 * a movement key is released, Kirby should stop moving.
	 *
	 * @param e The pressed key that is now released.
	 */
	@Override
	public void keyReleased(KeyEvent e) {	
		for(Entity en: Game.handler.entity) {
			if(en.getId() == Id.player) {
				if(e.getKeyCode() == KeyEvent.VK_D) {
					en.setVelX(0);
				}
				if(e.getKeyCode() == KeyEvent.VK_A) {
					en.setVelX(0);	
				}
				if(e.getKeyCode() == KeyEvent.VK_W) {
					en.setVelY(0);
				}
			}
		}
	}

}
