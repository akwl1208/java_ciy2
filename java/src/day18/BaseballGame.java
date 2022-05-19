package day18;
import java.text.MessageFormat;
import java.util.*;

import day18.ConsolProgram;

public class BaseballGame implements ConsolProgram{
	Scanner scan;
	private final int exitMenu = 3;
	private List<Integer> com = new ArrayList<Integer>();
	private List<Integer> user = new ArrayList<Integer>();
	private List<Integer> records = new ArrayList<Integer>();
	
	private int min = 1;
	private int max = 9;
	
	@Override
	public int selectMenu(Scanner scan) {
		System.out.println("=======메뉴======");
		System.out.println("1. 플레이");
		System.out.println("2. 기록 확인");
		System.out.println("3. 프로그램 종료");
		System.out.println("=================");
		System.out.print("메뉴 선택 : ");
		int menu = scan.nextInt();
		System.out.println("=================");
		return menu;
	}

	@Override
	public void excute(int menu) {
		switch(menu) {
		case 1:
			//< 컴퓨터 랜덤수 생성 > -> 1~9 사이의 정수
			createComRandom(); //기능1
			System.out.println();
			
			//게임 플레이
			int count = play();
			
			//기록 저장
			recordResult(count, 5);
			break;
		case 2: //기록 출력
			printRecord();
			
			break;
		case 3:
			
			break;
		default:
			System.out.println("잘못된 메뉴를 선택했습니다");
			System.out.println("=================");
		}
	}

	@Override
	public void run() {
		int menu;
		do {
			menu = selectMenu(scan);
			excute(menu);
		}while(menu != exitMenu);
		System.out.println("게임을 종료합니다");
		System.out.println("==============");
	}
	
	//생성자
	public BaseballGame(Scanner scan) {
		this.scan = scan;
	}
	
	//기능1) 컴퓨터의 랜덤한 수 만들기
	public void createComRandom() {
		com.clear(); //이전 플레이에서 사용한 숫자들을 지워줌
		while(com.size() < 3) {
			//랜덤수 생성
			int r = random(min, max);
			//중복체크
			//중복이 아니면 저장 후, count 증가
			if(com.indexOf(r) == -1) {
				com.add(r);
				System.out.print(r + " ");
			}
		}
		System.out.println();
	} //createComRandom()
	
	//기능2) 랜덤 수 생성
	public static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random()*(max-min+1) + min);
	} //random
	
	//기능3) 사용자가 숫자 입력
	private void inputNumber(int count) {
		user.clear();
		//숫자 입력
		String str = "중복되지 않게 {0}~{1}사이의 {2}의 정수를 입력하세요";
		String formatStr = MessageFormat.format(str, min, max, count);
		System.out.println(formatStr);
		System.out.print("숫자 입력 : ");
		
		//나는 조건문을 잘못 입력함(그냥 user.size로..) -> 그니까 입력을 안하고 넘어가징!!
		while(user.size() < count) {
			try {
				int num = scan.nextInt();
				//범위를 벗어난 경우 예외 발생
				if(num < min || num > max) {
					throw new ArithmeticException();
				}
				//중복된 경우 예외 발생
				if(user.contains(num)) {
					throw new ArithmeticException();
				}
				user.add(num);
			}catch (ArithmeticException e) {
				//범위가 아닌 숫자를 입력했을 경우, 중복될 경우
				System.out.println("중복되거나 범위를 벗어난 숫자를 입력했습니다. 다시 입력하세요");
				if(scan.hasNext()) {
					scan.nextLine();
				}
				System.out.println(formatStr);
				System.out.print("숫자 입력 : ");
				user.clear();
			} 
			catch (Exception e) {
				//숫자가 아닌 문자를 입력했을 경우 
				System.out.println("잘못 입력했습니다. 다시 숫자만 입력하세요");
				scan.nextLine();
				System.out.println(formatStr);
				System.out.print("숫자 입력 : ");
				user.clear();
				}
			}
	}//inputNumber
		
	//기능4) 결과 출력
	private boolean printResult() {
		//스트라이크 개수
		int strike = 0;
		for(int i = 0; i < com.size(); i++) {
			//여기서 그냥 contains랑 indexOf 씀...equals를 생각 못함..
			if(com.get(i).equals(user.get(i))) {
				strike++;
			}
		}
		//볼 개수
		int ball = 0;
		for(Integer tmp : com) {
			if(user.contains(tmp)) {
				ball++;
			}
		}
		ball = ball - strike;
		
		if(strike != 0) {
			System.out.println(strike + "S");
		}
		if(ball != 0) {
			System.out.println(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.println("O");
		}
		System.out.println();
		
		if(strike == 3) {
			return true;
		}
		
		return false;
	}//printResult
	
	//기능5) 결과 기록
	private void recordResult(int count, int max) {
		//기록저장
		records.add(count);
		//기록 정렬
		records.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		//max개 이상이면 마지막 기록 지움
		if(records.size() >= max) {
			records.remove(max);
		}
	}//recordResult
	
	//기능6) 숫자야구게임플레이
	private int play() {
		int count = 0;
		while(true) {
			
			//숫자 3개 입력
			inputNumber(3);
			
			//횟수 1 증가
			count++;
			
			//스트라이크, 볼 결과를 출력 후, 게임 종료 여부 알려줌
			if(printResult()) {
				break;
			}
		}
			
		return count;
	}//play

	//기능7) 
	private void printRecord(){
		if(records.size() == 0) {
			System.out.println("기록이 없습니다. 플레이하세요");
			return;
		}
		for(int i = 0; i < records.size(); i++) {
			System.out.println(i+1 + "등. " + records.get(i) + "회");
		}
	}
}
