package day18;
import java.util.Scanner;

public class Ex04_MainBaseballGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		BaseballGame baseballgame = new BaseballGame(scan);
		baseballgame.run();

		scan.close();

	}

}
