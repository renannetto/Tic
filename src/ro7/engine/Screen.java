package ro7.engine;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import cs195n.Vec2i;

public abstract class Screen {
	
	protected Application app;
	protected Vec2i windowSize;
	
	protected Screen(Application app) {
		this.app = app;
	}
	
	public abstract void onTick(long nanosSincePreviousTick);

	
	/**
	 * Draw the sprites initialized by the screen
	 * @param g Graphics2D object to draw on the screen
	 */
	public abstract void onDraw(Graphics2D g);

	
	public abstract void onKeyTyped(KeyEvent e);

	
	public abstract void onKeyPressed(KeyEvent e);

	
	public abstract void onKeyReleased(KeyEvent e);

	
	public abstract void onMouseClicked(MouseEvent e);

	
	public abstract void onMousePressed(MouseEvent e);

	
	public abstract void onMouseReleased(MouseEvent e);

	
	public abstract void onMouseDragged(MouseEvent e);

	
	public abstract void onMouseMoved(MouseEvent e);

	
	public abstract void onMouseWheelMoved(MouseWheelEvent e);

	
	/**
	 * Save the new window size and initialize sprite objects
	 * according to it
	 * @param newSize new window size
	 */
	public void onResize(Vec2i newSize) {
		windowSize = newSize;
	}

}
