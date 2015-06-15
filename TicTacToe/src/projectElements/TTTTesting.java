package projectElements;

import static org.junit.Assert.*;

import org.junit.Test;

public class TTTTesting {

	@Test
	//Testing toString
	public void test() {
		TicTacToe test = new TicTacToe();
		System.out.println(test.toString());
		
		
		//System.out.println("");
		
		test.setGrid(0, 0, Piece.X);
		test.setGrid(2, 2, Piece.X);
		test.setGrid(222, 0, Piece.X);
		//System.out.println(test.toString());
	}
	
	@Test
	//Testing toString
	public void testCheckLines() {
		TicTacToe test = new TicTacToe();
		
		test.setGrid(0, 0, Piece.X);
		test.setGrid(1, 0, Piece.O);
		test.setGrid(2, 0, Piece.X);
		
		assertFalse(test.checkLines());
		test.reset();
		
		test.setGrid(0, 0, Piece.X);
		test.setGrid(0, 1, Piece.X);
		test.setGrid(0, 2, Piece.X);
		
		assertTrue(test.checkLines());
		test.reset();
		
		
	}
	@Test 
	public void diagonalDown() {
		TicTacToe test = new TicTacToe();
		
		test.setGrid(0, 2, Piece.X);
		test.setGrid(1, 1, Piece.X);
		test.setGrid(2, 0, Piece.X);
		
		assertTrue(test.checkLines());
	}
	@Test
	public void changeTurns() {
		TicTacToe test = new TicTacToe();
		test.setPermGrid(0, 2);
		System.out.println(test);
		
		test.setPermGrid(1, 2);
		System.out.println(test);
	}

	@Test
	//Testing toString
	public void testCheckLines2() {
		TicTacToe test = new TicTacToe();
		
		test.setGrid(0, 2, Piece.X);
		test.setGrid(1, 2, Piece.O);
		test.setGrid(2, 2, Piece.X);
		
		test.setGrid(0, 1, Piece.O);
		test.setGrid(1, 1, Piece.X);
		test.setGrid(2, 1, Piece.O);
		
		System.out.println(test.toString());
		assertFalse(test.checkLines());
		
	}
}
