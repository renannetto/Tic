package ro7.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Rectangle2D;

import ro7.engine.Application;
import ro7.engine.Screen;
import ro7.engine.sprites.Message;
import cs195n.Vec2f;
import cs195n.Vec2i;

public class EndScreen extends Screen {
	
	private String text;
	private Message endMessage;
	private Message restartMessage;

	public EndScreen(Application app, String text) {
		super(app);
		this.text = text;
	}
	
	@Override
	public void onDraw(Graphics2D g) {
		Rectangle2D background = new Rectangle(0, 0, windowSize.x, windowSize.y);
		g.setColor(Color.BLACK);
		g.draw(background);
		g.fill(background);
		
		endMessage.draw(g);
		
		restartMessage.draw(g);
	}
	
	@Override
	public void onKeyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == 82) {
			app.popScreen();
			app.pushScreen(new GameScreen(app));
		}
	}
	
	@Override
	public void onMouseClicked(MouseEvent e) {
		app.popScreen();
		app.pushScreen(new GameScreen(app));
	}
	
	public void onResize(Vec2i newSize) {
		super.onResize(newSize);
		
		float endX = windowSize.x / 4.0f;
		float endY = windowSize.y / 3.0f;
		int fontSize = windowSize.x / 24;
		endMessage = new Message(text, fontSize, Color.WHITE, new Vec2f(
				endX, endY));
		
		float restartMessageX = endX + 30;
		float restartMessageY = 2*endY;
		restartMessage = new Message("Click on the screen or press r to restart", fontSize/2,
				Color.WHITE, new Vec2f(restartMessageX, restartMessageY));
	}

	@Override
	public void onTick(long nanosSincePreviousTick) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
	}

}
