package day23;

import java.util.Scanner;

public class Ex01_UpDown {
		//예제) 1~100 사이의 랜덤한 수를 맞추는 up down 게임 프로그램 작성
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		UpdownManager um = new UpdownManager(scan);
		um.run();
	
		scan.close();

	}


}
