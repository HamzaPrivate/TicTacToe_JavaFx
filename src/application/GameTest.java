package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GameTest {

	
	@Test
	void testGeneral() {
		TTTModel game = new TTTModel();
		//Players turn
		game.playersTurn(0, 0);
		assertEquals('X', game.getCell(0, 0));
		//Computers turn
		String x = game.computersTurn();
		int row = Integer.parseInt(String.valueOf(x.charAt(0)));
		int column = Integer.parseInt(String.valueOf(x.charAt(2)));
		assertEquals('O',game.getCell(row, column));
		assertEquals(7, game.getEmptyCells());
		//Game not finished yet
		assertTrue(!game.gameFinished);
		assertEquals(' ',game.getWinner());
		
	}
	
	@Test
	void testWinnerHorizontal1() {
		TTTModel game = new TTTModel();
		//horizontal row -> player wins
		game.playersTurn(0, 0);
		game.playersTurn(0, 1);
		game.playersTurn(0, 2);
		assertEquals('X',game.getWinner());
	}
	
	@Test
	void testWinnerHorizontal2() {
		TTTModel game = new TTTModel();
		//horizontal row -> player wins
		game.playersTurn(1, 0);
		game.playersTurn(1, 1);
		game.playersTurn(1, 2);
		assertEquals('X',game.getWinner());
	}
	
	@Test
	void testWinnerHorizontal3() {
		TTTModel game = new TTTModel();
		//horizontal row -> player wins
		game.playersTurn(2, 0);
		game.playersTurn(2, 1);
		game.playersTurn(2, 2);
		assertEquals('X',game.getWinner());
	}
	
	@Test
	void testWinnerVert1() {
		TTTModel game = new TTTModel();
		//horizontal row -> player wins
		game.playersTurn(0, 0);
		game.playersTurn(1, 0);
		game.playersTurn(2, 0);
		assertEquals('X',game.getWinner());
	}

	@Test
	void testWinnerVert2() {
		TTTModel game = new TTTModel();
		//horizontal row -> player wins
		game.playersTurn(0, 1);
		game.playersTurn(1, 1);
		game.playersTurn(2, 1);
		assertEquals('X',game.getWinner());
	}
	
	@Test
	void testWinnerVert3() {
		TTTModel game = new TTTModel();
		//horizontal row -> player wins
		game.playersTurn(0, 2);
		game.playersTurn(1, 2);
		game.playersTurn(2, 2);
		assertEquals('X',game.getWinner());
	}
	
	@Test
	void testWinnerDia1() {
		TTTModel game = new TTTModel();
		//horizontal row -> player wins
		game.playersTurn(0, 0);
		game.playersTurn(1, 1);
		game.playersTurn(2, 2);
		assertEquals('X',game.getWinner());
	}

	@Test
	void testWinnerDia2() {
		TTTModel game = new TTTModel();
		//horizontal row -> player wins
		game.playersTurn(0, 2);
		game.playersTurn(1, 1);
		game.playersTurn(2, 0);
		assertEquals('X',game.getWinner());
	}



}
