package day18;

import java.util.Scanner;

public class Ex03_StudentMain {

	public static void main(String[] args) {
		//<학생정보관리프로그램>
		/* 클론이 잘됬는지 테스트
		Student std1 = new Student(1,1,1,"홍길동",0,0,0);
		Student std2 = std1.clone(); //복제해서 사용
		//이름 수정
		std1.modify("임꺽정", 0, 0, 0);
		System.out.println(std1);
		System.out.println(std2); //수정해도 이름이 바꾸지 않음
		//주소도 다름..
		if(std1 == std2) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		*/
		
		Scanner scan = new Scanner(System.in);
		StudentManager sm = new StudentManager(scan);
		sm.run();
		scan.close();
	}

}
