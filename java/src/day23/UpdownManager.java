package day23;

import java.util.*;

import day18.ConsolProgram;

public class UpdownManager implements ConsolProgram {
	Scanner scan = new Scanner(System.in);
	private int exitMenu = 3;
	private int min = 1, max = 100;
	int score; //점수 -> 작을수록 높은 점수
	List<Record> records = new ArrayList<Record>(); //기록 저장용
	private int maxRecordCount = 5;
	
	//생성자
	public UpdownManager(Scanner scan) {
		this.scan = scan;
	}

	@Override
	public int selectMenu(Scanner scan) {
		System.out.println("=======메뉴======");
		System.out.println("1. 플레이");
		System.out.println("2. 기록 확인");
		System.out.println("3. 프로그램 종료");
		System.out.println("=================");
		System.out.print("메뉴 선택 : ");
		return scan.nextInt();
	}

	@Override
	public void excute(int menu) {
		switch(menu) {
		case 1:/*
		* 플레이 : 1~100 사이의 정수가 아니면 점수로 인정하지 않음
		* 기록저장
			- 기록에 저장된 개수가 5보다 작으면 그냥 저장됨
			- 기록에 저장된 개수가 5보다 크거나 같으면 마지막에 저장된 점수와 비교해서
				작으면 마지막 플레이를 삭제 후, 기록 저장, 크면 다시 플레이하라고 메세지 출력
			- 기록 저장할 때 이름을 물음 
				-> 기록에 저장된 같은 이름가 있으면 지금 플레이한 점수가 기록보다 작으면 덮어쓰기 크면 그냥 메뉴로
				-> 같은 이름이 없으면 그냥 저장
			- 5등에서 점수가 같은 경우, 오래된 기록을 지우고 새 기록을	저장
		*/
			//랜덤수 생성 -> 1~100 사이의 정수
			int r = creatRandomNumber(min, max); //기능1
			System.out.println("랜덤한 수 : " + r); //테스트를 위해
			//게임 플레이
			playGame(r); //기능4
			//기록 저장
			fullRecords(); //기능5
			break;
			
		case 2: //기록 출력
			printRecords(); //기능6
			break;
			
		case 3: break;
		default:
			printMessage("잘못 입력했습니다");
		}
	}

	@Override
	public void run() {
		//테스트용 
		records.add(new Record("홍길동", 1));
		records.add(new Record("임꺽정", 3));
		records.add(new Record("김철수", 2));
		records.add(new Record("김영희", 4));
		records.add(new Record("장금이", 5));

		int menu = 0;
		do {
			try {
				menu = selectMenu(scan);
				excute(menu);
			} catch (Exception e) {
				printMessage("잘못 입력했습니다");
			}
		}while(menu != exitMenu);
		printMessage("게임을 종료합니다");	
	}

	//기능1) 랜덤수 생성
	public int creatRandomNumber(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random()*(max-min+1) + min);
	}
	
	//기능2) 기록 저장하기
	public void saveRecord() {
		System.out.print("플레이어 이름 입력 : ");
		String name = scan.next();
		//기록에 같은 이름이 없으면
		if(!records.contains(new Record(name))) {
			//record 저장
			records.add(new Record(name, score));
			//정렬
			sortRecords(); //기능7
		}else { //기록에 이름이 있으면 
			//기존 기록이랑 비교해서 작으면
			int index = records.indexOf(new Record(name));
			if(score < records.get(index).getScore()) {
				//기록 수정
				records.get(index).setScore(score);
			}else { //크거나 같으면 그냥 메뉴로 돌아감
				printMessage("기존 점수를 넘어보세요! 다시 플레이하세요!");
				return;
			}
		}
	}//saveRecord
	
	//기능3) 메세지 출력
	public void printMessage(String str) {
		System.out.println("==============");
		System.out.println(str);
		System.out.println("==============");
	}//printMessage
	
	//기능4) 게임 플레이
	public void playGame(int r) {
		score = 0; //값 초기화 
		
		for( ; ; ) {
			System.out.print("1~100 사이 정수 입력 : ");
			int num = scan.nextInt();
			if(num < 1 || num > 100) {
				System.out.println("1~100 사이 정수를 입력하세요");
				continue;
			}
			score++;
			if(r == num) {	
				printMessage("정답입니다");
				break;
			}else if(r > num){
				System.out.println("UP");
			}else {
				System.out.println("DOWN");
			}
		}
	}//playGame
	
	//기능5) 기록이 꽉 찼을 때 어떻게 처리할지
	public void fullRecords() {
		//최대저장개수보다 record에 저장된 개수가 작으면
		if(records.size() < maxRecordCount) {
			saveRecord(); //기능2
		}else { //이미 기록이 꽉 찼으면
			//마지막 저장된 플레이어보다 점수가 작거나 같으면
			if(score <= records.get(maxRecordCount-1).getScore()) {
				//마지막 기록 삭제
				records.remove(maxRecordCount-1); 
				//기록 저장
				saveRecord();
			}else {
				printMessage("5등 안에 못 들었습니다. 다시 플레이하세요");
			}
		}
	}//fullRecords
	
	//기능6) 기록 출력
	public void printRecords() {
		if(records.size() == 0) {
			System.out.println("기록이 없습니다. 플레이하세요");
			return;
		}
		for(int i = 0; i < records.size(); i++) {
			System.out.println(i+1 + "등. " + records.get(i));
		}
	}//printRecords
	
	//기능7) 기록 정렬
	public void sortRecords() {
		records.sort(new Comparator<Record>() {
			@Override
			public int compare(Record o1, Record o2) {
				return o1.getScore() - o2.getScore();
			}
		});
	}
}

//업다운게임은 기록을 가지고 있다 -> has a 관계
class Record {
	private String name;
	private int score;
	//생성자
	public Record(String name, int score) {
		this.name = name;
		this.score = score;
	}
	//생성자
	public Record(String name) {
		this.name = name;
	}
	//getter, setter
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name + " - " + score + "점";
	}	
}