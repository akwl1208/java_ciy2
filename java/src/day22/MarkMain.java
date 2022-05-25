package day22;

import java.util.Scanner;

public class MarkMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		MarkManager mm = new MarkManager(scan);
		mm.run();
		
		scan.close();

	}

}
