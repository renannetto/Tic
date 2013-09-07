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
import ro7.game.sprites.Message;
import cs195n.Vec2f;

public class TitleScreen extends Screen {

	private Message title;
	private Message startMessage;

	protected TitleScreen(Application app) {
		super(app);
	}

	@Override
	public void onTick(long nanosSincePreviousTick) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDraw(Graphics2D g) {
		Rectangle2D background = new Rectangle(0, 0, windowSize.x, windowSize.y);
		g.setColor(Color.BLACK);
		g.draw(background);
		g.fill(background);

		float titleX = windowSize.x / 3.0f;
		float titleY = windowSize.y / 4.0f;
		title = new Message("Welcome to Tic!", 48, Color.WHITE, new Vec2f(
				titleX, titleY));
		title.draw(g);

		float startMessageX = windowSize.x / 3.0f - 100;
		float startMessageY = windowSize.y / 4.0f + 50;
		startMessage = new Message("Click on the screen or press Enter to start", 28,
				Color.WHITE, new Vec2f(startMessageX, startMessageY));
		startMessage.draw(g);
	}

	@Override
	public void onKeyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onKeyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		System.out.println("Key pressed on Title Screen: " + keyCode);
		if (keyCode == 10) {
			System.out.println("Enter pressed, changing to Game Screen");
			app.pushScreen(new GameScreen(app));
		}
	}

	@Override
	public void onKeyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMouseClicked(MouseEvent e) {
		app.pushScreen(new GameScreen(app));
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
