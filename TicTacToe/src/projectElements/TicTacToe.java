package projectElements;


/**
 * 
 * @author Bryan Dang
 * @date June 8, 2015
 * 
 */

//Class runs all the background computations for Tic-Tac-Toe
public class TicTacToe {


	Piece[][] grid = new Piece[3][3]; //3 by 3 grid for Tic-Tac Toe
	//Please note, 2D arrays have 0,0 at the top left
	//This programs thinks of the grid as in a typpically x vs y graph
	//with 0,0 at bottom left.

	Piece whoseTurn; //Variable for whose turn it is

	//Constructor for TicTacToe
	public TicTacToe() {
		reset();
	}

	//Sets a certain part of the grid to a certain
	//Only accepts values between 0-2
	//Used for debugging
	public void setGrid(int xaxis, int yaxis, Piece piece) {
		if (0 <= xaxis && xaxis <= 2 && 
				0 <= yaxis && yaxis <= 2) {
			grid[yaxis][xaxis] = piece;
		}
	}

	//Sets permanently sets the grid piece to current term
	public void setPermGrid(int xaxis, int yaxis) {
		if (0 <= xaxis && xaxis <= 2 && 
				0 <= yaxis && yaxis <= 2 &&
				grid[yaxis][xaxis] == Piece.NONE) {
			grid[yaxis][xaxis] = whoseTurn;
		}
	}

	//Returns the value in the grid postiion (x, y)
	public Piece getGrid(int xaxis, int yaxis) {
		if (0 <= xaxis && xaxis <= 2 && 
				0 <= yaxis && yaxis <= 2) {
			return grid[yaxis][xaxis];
		}
		return Piece.NONE;
	}

	//Sets whoseTurn it is
	public void setWhoseTurn(Piece piece) {
		whoseTurn = piece;
	}

	//Get whoseTurn it is
	public Piece getWhoseTurn() {
		return whoseTurn;
	}

	//Changes whose turn it is
	public void changeWhoseTurn() {
		if (whoseTurn == Piece.X)
			whoseTurn = Piece.O;
		else 
			whoseTurn = Piece.X;
	}

	//Resets the grid to nothing and whoseTurn to X
	public void reset() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				grid[row][col] = Piece.NONE;
			}
		}
		whoseTurn = Piece.X; //First player is X
	}

	//Checks all possible directions that could give a tic-tac-toe
	public boolean checkLines() {

		int tally = 0;
		//Checking horizontal lines
		for (int row = 0; row < 3; row++) {
			tally = 0;
			for (int col = 0; col < 3; col++) {
				if (grid[row][col] == whoseTurn) {
					tally++;
				}
			}
			if (tally == 3)
				return true;
		}

		//Checking Vertical lines
		for (int col = 0; col < 3; col++) {
			tally = 0;
			for (int row = 0; row < 3; row++) {
				if (grid[row][col] == whoseTurn) {
					tally++;
				}
			}
			if (tally == 3)
				return true;
		}

		//Diagonal up
		tally = 0;
		for (int row = 0; row < 3; row++) {
			if (grid[row][row] == whoseTurn) {
				tally++;
			}
		}
		if (tally == 3)
			return true;

		//Diagonal down
		tally = 0;
		int col = 0;
		for (int row = 2; row >= 0 ; row--) {
			
			if (grid[row][col] == whoseTurn) {
				tally++;
			}
			col++;

		}
		if (tally == 3)
			return true;



		return false;
	}

	//Returns a string of the Tic-Tac-Toe grid
	public String toString() {
		String retVal = "";
		//Notice how it prints bottom row first
		for (int row = 2; row >= 0; row--) { 
			for (int col = 0; col < 3; col++) {
				if (grid[row][col] == Piece.X)
					retVal += Piece.X;

				else if (grid[row][col] == Piece.O)
					retVal += Piece.O;
				else
					retVal += Piece.NONE;
			}
			retVal += "\n";
		}
		retVal += "Turn is: " + whoseTurn;
		return retVal;
	}
}
