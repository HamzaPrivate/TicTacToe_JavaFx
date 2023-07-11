package application;

import java.util.Random;

public class TTTModel {

	private char[][] playground;
	private static final char COMPUTER_O = 'O';
	private static final char PLAYER_X = 'X';
	public boolean gameFinished = false;
	private int emptyCells;

	public TTTModel() {
		playground = new char[3][3];
		for(int i = 0; i<playground.length;i++) {
			for(int j = 0; j<playground[i].length;j++) {
				playground[i][j] = ' ';
				emptyCells = 9;
			}
		}
	}
	
	/**
	 * RETURN IS FOR TESTING PURPOSES ONLY
	 * @return row | column as one string representing the position of the computers turn
	 */

	public String computersTurn() {
		if(gameFinished||emptyCells==0)return"";
		while(true) {
			Random random= new Random();
			int i = random.nextInt(3);
			int j = random.nextInt(3);
			if(cellIsEmpty(i,j)) {
				playground[i][j] = COMPUTER_O;
				emptyCells--;
				return "" + i + "|" + j;
			}
			else {
				continue;
			}

		}
	}


	public void playersTurn(int i, int j) {
		if(gameFinished)return;
		if(cellIsEmpty(i,j)) {
			playground[i][j] = PLAYER_X;
			emptyCells--;
		}
	}


	public boolean cellIsEmpty(int i,int j) {
		boolean boo = false;
		if(playground[i][j]==' ') {
			boo = true;
		}
		return boo;
	}

	public char getCell(int i, int j) {
		return playground[i][j];
	}

	public char getWinner() {
		char winner = ' ';
		String c1 = case1();
		String c2 = case2();
		String c3 = case3();
		String c4 = case4();
		if(c1.equals("O")||c2.equals("O")||c3.equals("O")||c4.equals("O")){
			winner = 'O';
			gameFinished = true;
		}

		else if(c1.equals("X")||c2.equals("X")||c3.equals("X")||c4.equals("X")){
			winner = 'X';
			gameFinished = true;
		}

		return winner;
	}

	/**
	 * check top right to bottom left
	 * @return winner or ""
	 */
	private String case4() {
		String result = "";
		result += playground[0][2] + "" + playground[1][1] +""+ playground[2][0];
		if(result.equals("OOO")){
			return ""+COMPUTER_O;
		}if(result.equals("XXX")) {
			return ""+PLAYER_X;
		}
		return "";
	}
	/**
	 * check top left to bottom right
	 * @return winner or ""
	 */
	private String case3() {
		String result = "";
		for(int i = 0; i<playground.length;i++) {
			result += playground[i][i];
			if(result.equals("OOO")){
				return ""+COMPUTER_O;
			}if(result.equals("XXX")) {
				return ""+PLAYER_X;
			}
		}

		return "";
	}
	/**
	 * check columns
	 * @return winner or ""
	 */
	private String case2() {
		String result = "";
		for(int i = 0; i<playground.length;i++) {
			result = "";
			for(int j =0;j<playground[i].length;j++) {
				result += playground[j][i];
				if(result.equals("OOO")){
					return ""+COMPUTER_O;
				}if(result.equals("XXX")) {
					return ""+PLAYER_X;
				}
			}
		}

		return "";
	}

	/**
	 * check rows
	 * @return winner or ""
	 */
	private String case1() {
		String result = "";
		for(int i = 0; i<playground.length;i++) {
			result = "";
			for(int j =0;j<playground[i].length;j++) {
				result += playground[i][j];
				if(result.equals("OOO")){
					return ""+COMPUTER_O;
				}if(result.equals("XXX")) {
					return ""+PLAYER_X;
				}
			}
		}

		return "";
	}

	public int getEmptyCells() {
		return emptyCells;
	}


}
