package projectElements;

import static org.junit.Assert.*;

import org.junit.Test;

public class TTTTesting {

	@Test
	//Testing toString
	public void test() {
		TicTacToe test = new TicTacToe();
		System.out.println(test.toString());
		
		
		System.out.println("");
		
		test.setGrid(0, 0, Piece.X);
		test.setGrid(2, 2, Piece.X);
		test.setGrid(222, 0, Piece.X);
		System.out.println(test.toString());
	}

}
