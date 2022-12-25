package aed.knightTour;

import java.util.HashSet;
import java.util.Set;

public class Tour {

	public static Integer[][] createBoard(int rows, int cols){
		Integer[][] board = new Integer[rows][cols];
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board.length; j++)
				board[i][j] = 0;
		return board;
	}

	public static void visualizeBoard(Integer[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				System.out.print(" | " + board[i][j] + " | ");
			}
			System.out.print("\n");
		}
	}

	public static boolean positionIsValid(Integer[][] board, Coord pos) {
		return pos.getX() >= 0 && pos.getX() < board.length && pos.getY() >= 0 && pos.getY() < board[0].length;
	}

	public static void tour(Integer[][] board, Coord startingPos){
		Set<Coord> visited = new HashSet<Coord>();
		board[startingPos.getX()][startingPos.getY()] = 1;
		visited.add(startingPos);
		tourRec(board, startingPos, visited, 2);
	}

	
	// NO ADMITE CICLOS: CORREGIR
	public static void tourRec(Integer[][] board, Coord pos, Set<Coord> visited, int counter) {
		// Obtenemos los  movimientos disponibles
		Integer xpos = pos.getX();
		Integer ypos = pos.getY();
		Integer[][] moves = {{xpos - 2, ypos - 1}, {xpos - 2, ypos + 1}, 
				{xpos - 1, ypos - 2}, {xpos - 1, ypos + 2}, 
				{xpos + 1, ypos - 2}, {xpos + 1, ypos + 2}, 
				{xpos + 2, ypos - 1}, {xpos + 2, ypos + 1}};

		//Hacemos la recursion
		for(int i = 0; i < moves.length; i++) {
			Coord newPos = new Coord(moves[i][0], moves[i][1]);
			if(positionIsValid(board, newPos) && !visited.contains(newPos)) {
				visited.add(newPos);
				board[newPos.getX()][newPos.getY()] = counter;
				tourRec(board, newPos, visited, counter + 1);
			}
		}
		//Caso base
		if(visited.size() == board.length*board[0].length) {
			return;
		}

		//Caso backtracking
		visited.remove(pos);
		board[pos.getX()][pos.getY()] = 0;
	}

	public static void main(String[] args) {
		int rows = 9;
		int cols = 9;

		Integer[][] board = createBoard(rows, cols);
		
		tour(board, new Coord(0,0));

		visualizeBoard(board);
	}

}
