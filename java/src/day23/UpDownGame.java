package day23;

import java.util.*;

public class UpDownGame {
	//선생님 풀이
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int menu;
		int min = 1, max = 100;
		List<Score> list = new ArrayList<Score>();
		//테스트용
		list.add(new Score(9, "김철수"));
		list.add(new Score(5, "이철수"));
		list.add(new Score(7, "박철수"));
		list.add(new Score(3, "최철수"));
		list.add(new Score(1, "조철수"));
		do {
			System.out.println("1. 플레이");
			System.out.println("2. 기록 확인");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1://게임 플레이
				//랜덤 수 생성
				int r = (int)(Math.random()*(max - min + 1 ) + min);
				System.out.println(r);
				int count = 0; //시도 횟수
				//맞출 때까지 게임 반복
				while(true) {
					//숫자를 입력받아 비교
					System.out.print("정수 입력(1~100) : ");
					int num = scan.nextInt();
					count++;
					if(num > r)
						System.out.println("DOWN");
					else if(num < r)
						System.out.println("UP");
					else 
						break;	
				}
				System.out.println("정답입니다");
				
				//내 기록 확인			
				//새 기록이라면(5등 이내라면) 이름 입력하고 저장
				int i;
				//break가 동작하면 i는 list.size()보다 작고
				//break가 동작하지 않으면 i는 list.size()이다 -> 저장된 기록보다 안좋은거
				for(i = 0; i < list.size(); i++) {
					if(list.get(i).getCount() > count) {
						break;
					}
				}
				//저장된 기록이 5개 미만이거나 
				//저장된 기록이 5개 이상인 기록 중에 지금 플레이한 횟수가 등수에 포함될 때
				if(list.size() <= 5 || i < list.size()) {
					System.out.println("새로운 기록이 달성했습니다. 기록을 저장하세요");
					System.out.print("이름 : ");
					list.add(i, new Score(count, scan.next()));
					/*
					if(list.size() > 5) {
						list.remove(5);
					}
					*/
					//위의 코드 2줄를 sublist 사용해서
					list = list.subList(0, list.size()>5? 5: list.size());
				}
				break;
			case 2://기록 확인
				for(int j = 0; j < list.size(); j++) {
					System.out.println(j+1 + ". " + list.get(j));
				}
				break;
			case 3://프로그램 종료
				System.out.println("프로그램 종료");
				break;
			default:
			}
		}while(menu != 3);

		scan.close();
	}
}

class Score{
	private int count;
	private String name;
	
	public Score(int count, String name) {
		this.count = count;
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "[ " + name +" : " + count + "]";
	}
	
}