package ro7.game.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

	List<Character> board;
	char winner;

	public Board() {
		board = new ArrayList<Character>(9);
		for (int i = 0; i < 9; i++) {
			board.add('_');
		}
		winner = '_';
	}

	/**
	 * Set an X on the board
	 * @param position square position to be setted
	 * @return true if the square was empty, false otherwise
	 */
	public boolean setX(int position) {
		if (isEmpty(position)) {
			board.set(position - 1, 'X');
			return true;
		}
		return false;
	}

	/**
	 * Set a O on the board
	 * @param position square position to be setted
	 * @return true if the square was empty, false otherwise
	 */
	public boolean setCircle(int position) {
		if (isEmpty(position)) {
			board.set(position - 1, 'O');
			return true;
		}
		return false;
	}
	
	/**
	 * Check if a square is empty
	 * @param position square position
	 * @return true if the square is empty, false otherwise
	 */
	public boolean isEmpty(int position) {
		char square = board.get(position - 1);
		return square=='_';
	}
	
	/**
	 * Check if there is a winner
	 * @return true if there is a winner, false otherwise
	 */
	public boolean isComplete() {
		boolean firstLine = board.get(0) == board.get(1) && board.get(0) == board.get(2) && !isEmpty(1) && !isEmpty(2) && !isEmpty(3);
		if (firstLine) {
			winner = board.get(0);
			return true;
		}
		boolean secondLine = board.get(3) == board.get(4) && board.get(3) == board.get(5) && !isEmpty(4) && !isEmpty(5) && !isEmpty(6);
		if (secondLine) {
			winner = board.get(3);
			return true;
		}
		boolean thirdLine = board.get(6) == board.get(7) && board.get(6) == board.get(8) && !isEmpty(7) && !isEmpty(8) && !isEmpty(9);
		if (thirdLine) {
			winner = board.get(6);
			return true;
		}
		boolean firstColumn = board.get(0) == board.get(3) && board.get(0) == board.get(6) && !isEmpty(1) && !isEmpty(4) && !isEmpty(7);
		if (firstColumn) {
			winner = board.get(0);
			return true;
		}
		boolean secondColumn = board.get(1) == board.get(4) && board.get(1) == board.get(7) && !isEmpty(2) && !isEmpty(5) && !isEmpty(8);
		if (secondColumn) {
			winner = board.get(1);
			return true;
		}
		boolean thirdColumn = board.get(2) == board.get(5) && board.get(2) == board.get(8) && !isEmpty(3) && !isEmpty(6) && !isEmpty(9);
		if (thirdColumn) {
			winner = board.get(2);
			return true;
		}
		boolean firstDiagonal = board.get(0) == board.get(4) && board.get(0) == board.get(8) && !isEmpty(1) && !isEmpty(5) && !isEmpty(9);
		if (firstDiagonal) {
			winner = board.get(0);
			return true;
		}
		boolean secondDiagonal = board.get(2) == board.get(4) && board.get(2) == board.get(6) && !isEmpty(3) && !isEmpty(5) && !isEmpty(7);
		if (secondDiagonal) {
			winner = board.get(2);
			return true;
		}
		return false;
	}
	
	/**
	 * Check if it was a draw
	 * @return true if it was a draw, false otherwise
	 */
	public boolean isDraw() {
		return !board.contains('_') && !isComplete();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * Return the board state as a String. Each character
	 * is X, O or _, with the last one representing an 
	 * empty square
	 */
	@Override
	public String toString() {
		String boardString = "";
		for (Character square : board) {
			boardString += square;
		}
		return boardString;
	}

	/**
	 * Get a string with the winner
	 * @return string with winner
	 */
	public String winner() {
		if (!isComplete()) {
			return "There is no winner";
		}
		return "Player " + winner +  " is the winner!";
	}

}
