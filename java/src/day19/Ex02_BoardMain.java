package day19;

import java.util.Scanner;

public class Ex02_BoardMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		BoardManager board = new BoardManager(scan);
		board.run();
		
		scan.close();

	}

}
