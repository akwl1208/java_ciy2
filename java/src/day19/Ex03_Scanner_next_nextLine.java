package day19;

import java.util.Scanner;

public class Ex03_Scanner_next_nextLine {

	public static void main(String[] args) {
		// <Next와 NextLine 차이>
		//next는 공백을 제거하고 다음 단어를 찾아 str2를 넣음
		Scanner scan = new Scanner(System.in);
		String str1 = scan.next();
		String str2 = scan.next();
		//입력 버퍼를 비워서 nextline이 입력될 수 있도록 함 
		scan.nextLine();
		String str3 = scan.nextLine();
		System.out.println();

	}

}
