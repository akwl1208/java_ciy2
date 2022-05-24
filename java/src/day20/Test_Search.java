package day20;

import java.util.*;

public class Test_Search {

	public static void main(String[] args) {
		//변수 선언
		Scanner scan = new Scanner(System.in);
		int menu;
		List<String> files = new ArrayList<String>();

		do {
			//메뉴 출력 및 선택
			System.out.println("메뉴");
			System.out.println("1. 파일 저장");
			System.out.println("2. 파일 확인");
			System.out.println("3. 파일 검색");
			System.out.println("4. 프로그램 종료");
			System.out.print("메뉴를 선택하세요 : ");
			menu = scan.nextInt();
			
			//기능 구현
			switch(menu) {
			case 1: //파일 저장
				//파일명 입력
				System.out.print("파일명 : ");
				String file = scan.next();
				//파일 저장
				files.add(file);
				System.out.println("파일 저장이 완료되었습니다");
				break;
				
			case 2: //파일 확인 
				for(String tmp : files) {
					System.out.println(tmp);
				}
				break;
				
			case 3: //파일 검색
				//검색할 확장자 선택
				System.out.print("검색어 : ");
				String search = scan.next();
				/*
				//단어 찾고 출력
				for(int i = 0; i < files.size(); i++) {
					//파일에 검색어가 있는지 확인
					int index = files.get(i).indexOf(search);
					//index가 0보다 크다는건 검색어가 있다는 뜻
					if(index >= 0) {
						//해당 파일명 출력
						System.out.println(files.get(i));
					}
				}
				*/
				for(String tmp : files) {
					//index가 0보다 크다는건 검색어가 있다는 뜻
					if(tmp.indexOf(search) >= 0) {
						//해당 파일명 출력
						System.out.println(tmp);
					}
					/* contains 사용해서 푸는 방법
					if(tmp.contains(search)) {
						System.out.println(tmp);
					}
					*/
				}
				
				
				break;
			case 4:
				System.out.println("프로그램을 종료합니다");
				break;
			default:
			}
		}while(menu != 4);
		scan.close();
	}

}
