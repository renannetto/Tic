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
import ro7.game.sprites.Board;
import ro7.game.sprites.TicUI;
import cs195n.Vec2f;
import cs195n.Vec2i;

public class GameScreen extends Screen {

	private final int TIME_LIMIT = 3000;

	private TicUI ui;
	private ro7.game.models.Board boardModel;
	private Board boardSprite;
	private int currentPlayer;
	private int remainingTime;

	protected GameScreen(Application app) {
		super(app);
		boardModel = new ro7.game.models.Board();
		currentPlayer = 1;
		remainingTime = TIME_LIMIT;
	}

	/* (non-Javadoc)
	 * @see ro7.engine.Screen#onTick(long)
	 * Update the remaining time and change the current player, 
	 * if necessary
	 */
	@Override
	public void onTick(long nanosSincePreviousTick) {
		int millisTime = (int) (nanosSincePreviousTick / 1000000);
		remainingTime -= millisTime;
		if (remainingTime <= 0) {
			switchPlayer();
		}
		ui.setTime(remainingTime);
	}

	/**
	 * Change the current player and restart the timer 
	 */
	private void switchPlayer() {
		if (currentPlayer == 1) {
			currentPlayer = 2;
		} else {
			currentPlayer = 1;
		}
		remainingTime = TIME_LIMIT;
		ui.setPlayer(currentPlayer);
	}

	@Override
	public void onDraw(Graphics2D g) {
		Rectangle2D background = new Rectangle(0, 0, windowSize.x, windowSize.y);
		g.setColor(Color.BLACK);
		g.draw(background);
		g.fill(background);

		boardSprite.draw(g);

		ui.draw(g);

		if (boardModel.isComplete()) {
			app.popScreen();
			app.pushScreen(new EndScreen(app, boardModel.winner()));
		} else if (boardModel.isDraw()) {
			app.popScreen();
			app.pushScreen(new EndScreen(app, "It was a draw!"));
		}
	}

	@Override
	public void onKeyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see ro7.engine.Screen#onKeyPressed(java.awt.event.KeyEvent)
	 * If Esc is pressed, go back to the Title Screen, if r
	 * is pressed, start a new game
	 */
	@Override
	public void onKeyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case 27:
			app.popScreen();
			break;
		case 82:
			app.popScreen();
			app.pushScreen(new GameScreen(app));
			break;
		}
	}

	/**
	 * Set a new square with an X or O on the board
	 * @param position position of the square
	 */
	private void setSquare(int position) {
		if (currentPlayer == 1) {
			boardModel.setX(position);
			switchPlayer();
		} else {
			boardModel.setCircle(position);
			switchPlayer();
		}
		boardSprite.setState(boardModel.toString());
	}

	@Override
	public void onKeyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see ro7.engine.Screen#onMouseClicked(java.awt.event.MouseEvent)
	 * Get the clicked square and set it
	 */
	@Override
	public void onMouseClicked(MouseEvent e) {
		int square = boardSprite.getClickedSquare(e.getPoint());
		setSquare(square);
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

	public void onResize(Vec2i newSize) {
		super.onResize(newSize);

		int boardSize = 0;
		if (windowSize.x < windowSize.y) {
			boardSize = windowSize.x;
			ui = new TicUI(new Vec2f(0.0f, boardSize), new Vec2i(boardSize,
					windowSize.y - boardSize), currentPlayer, remainingTime);
		} else {
			boardSize = windowSize.y;
			ui = new TicUI(new Vec2f(boardSize, 0.0f), new Vec2i(windowSize.x
					- boardSize, boardSize), currentPlayer, remainingTime);
		}
		boardSprite = new Board(new Vec2f(0.0f, 0.0f), boardSize,
				boardModel.toString());
	}

}
