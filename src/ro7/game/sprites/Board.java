package ro7.game.sprites;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

import ro7.engine.sprites.Circle;
import ro7.engine.sprites.Sprite;
import cs195n.Vec2f;

public class Board extends Sprite {

	private int size;
	private String board;

	public Board(Vec2f vec2f, int size, String board) {
		super(vec2f);
		this.size = size;
		this.board = board;
	}

	@Override
	public void drawSprite(Graphics2D g) {
		g.setColor(Color.WHITE);

		float space = size / 3.0f;

		drawBoardLine(g, new Vec2f(0.0f, space), new Vec2f(size, space));
		drawBoardLine(g, new Vec2f(0.0f, 2 * space), new Vec2f(size, 2 * space));
		drawBoardLine(g, new Vec2f(space, 0.0f), new Vec2f(space, size));
		drawBoardLine(g, new Vec2f(2 * space, 0.0f), new Vec2f(2 * space, size));

		for (int i = 0; i < 9; i++) {
			char square = board.charAt(i);
			drawSquare(g, square, i+1);
		}
	}
	
	/**
	 * Draw an X or a O in a board square
	 * @param g Graphics2D object to draw on the screen
	 * @param square symbol to draw (X or O)
	 * @param pos square position
	 */
	public void drawSquare(Graphics2D g, char square, int pos) {
		int xPosition = (pos - 1) % 3;
		int yPosition = (pos - 1) / 3;
		float space = size / 3.0f;
		
		switch (square) {
		case 'X':
			TicX x = new TicX(new Vec2f(space * xPosition, space
				* yPosition), space);
			x.draw(g);
			break;
		case 'O':
			Circle circle = new Circle(new Vec2f(space * xPosition, space
					* yPosition), space, Color.WHITE);
			circle.draw(g);
			break;
		}
	}

	/**
	 * Draw a line of the board
	 * @param g Graphics2D object to draw on the screen
	 * @param start start point of the line
	 * @param end end point of the line
	 */
	private void drawBoardLine(Graphics2D g, Vec2f start, Vec2f end) {
		Line2D boardLine;
		boardLine = new Line2D.Float(start.x, start.y, end.x, end.y);
		g.draw(boardLine);
	}
	
	public void setState(String board) {
		this.board = board;
	}

	/**
	 * Get the position of a clicked square
	 * @param point coordinates of the point clicked on the screen
	 * @return position of the square
	 */
	public int getClickedSquare(Point point) {
		int x = point.x;
		int y = point.y;
		float space = size / 3.0f;
		
		int column = (int)(x/space);
		int row = (int)(y/space);
		
		return (column+1) + (row*3);
	}

}
