package day22;

import java.util.*;

import day18.ConsolProgram;
//학생 1명의 성적을 관리하는 프로그램
public class MarkManager implements ConsolProgram {
	Scanner scan = new Scanner(System.in);
	private int exitMenu = 4;
	List<Mark> marks = new ArrayList<Mark>();

	public MarkManager(Scanner scan) {
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		//테스트용
		marks.add(new Mark(2, 1, "영어", 40, 50, 60));
		marks.add(new Mark(1, 1, "국어", 100, 90, 80));
		marks.add(new Mark(2, 1, "수학", 10, 20, 30));
		marks.add(new Mark(1, 1, "수학", 70, 60, 60));
		marks.add(new Mark(2, 1, "국어", 20, 10, 0));
		marks.add(new Mark(1, 1, "영어", 50, 40, 30));
	
	}
	
	@Override
	public int selectMenu(Scanner scan) {
		System.out.println("======메뉴======");
		System.out.println("1. 성적 추가");
		System.out.println("2. 성적 확인");
		System.out.println("3. 성적 수정");
		System.out.println("4. 프로그램 종료");
		System.out.println("==============");
		System.out.print("메뉴 입력 : ");
		int menu = scan.nextInt();
		return menu;
	}

	@Override
	public void excute(int menu) {
		switch(menu) {
		case 1:/* 성적 추가
		* 학년, 학기, 과목, 중간, 기말, 수행평가 점수 입력
		* 학년은 1~3학년까지, 학기는 1학기 2학기가 있음
		* 점수는 0~100 사이의 정수
		* 학년 학기 과목이 중복될 수 없다
		* 아무렇게 입력해도 학년과 학기로 오름차순 정렬된다 -> 잘안됨..
		*/
			if(addMark()) { //기능1
				System.out.println("성적이 추가됬습니다");
			}else {
				System.out.println("이미 등록된 점수입니다. 성적 확인하세요");
			}
			
			//정렬 -> 기능 구현이 안됨..
			marks.sort(new Comparator<Mark>() {
				@Override
				public int compare(Mark o1, Mark o2) {
					return o1.getGrade() - o2.getGrade();
				}
			});	
			break;
			
		case 2:/*성적 확인
		1. 전체 성적 확인 : 저장된 성적을 모두 출력
		2. 학기별 성적 확인 : 학년 학기를 입력하면 해당되는 모든 성적 출력
						총점과 평균 출력 -> 중간 40% 기말 40% 수행 20%
		3. 시험별 성적 확인 : 학년 학기를 입력하고 점수가 있으면 성적을 보고 싶은 시험을 입력
		 				해당 시험의 과목과 점수그리고 시험들의 총점과 평균 출력
		*/
			printMark(); //기능2
			break;
			
		case 3:/*성적 수정
		* 학기 학년 과목을 입력하면 해당되는 성적이 있으면 중간 기말 수행평가 성적을 수정하고
		* 없으면 수정할 수 없음
		*/
			modifyMark(); //기능6
			break;
		default: System.out.println("잘못 입력했습니다. 다시 입력하세요");
		}
		
	}

	@Override
	public void run() {
		int menu = 1;
		do {
			try {
				menu = selectMenu(scan);
				excute(menu);
			}catch (Exception e) {
				System.out.println("잘못 입력했습니다. 다시 입력하세요");
				scan.nextLine();
			}
		}while(menu != exitMenu);
		System.out.println("프로그램을 종료합니다");
		
	}

	//기능1) 성적을 입력받고 리스트에 성적 추가
	public boolean addMark() {
		System.out.println("=성적을 추가합니다=");
		System.out.print("학년 학기 과목 : ");
		int grade = scan.nextInt();
		int semester = scan.nextInt();
		String subject = scan.next();
		
		if(marks.contains(new Mark(grade, semester, subject))) {
			return false;
		}
		System.out.print("중간 기말 수행평가 :");
		int midterm = scan.nextInt();
		int finals = scan.nextInt();
		int pA = scan.nextInt();
		
		marks.add(new Mark(grade, semester, subject, midterm, finals, pA));
		return true;	
	}//addMark
	
	//기능2) 성적 출력
	public void printMark() {
		System.out.println("======메뉴======");
		System.out.println("1. 전체 성적 확인");
		System.out.println("2. 학기별 성적 확인");
		System.out.println("3. 시험별 성적 확인");
		System.out.println("==============");
		System.out.print("메뉴 입력 : ");
		int menu = scan.nextInt();
		
		switch(menu) {
		case 1: //전체 성적
			printAllMarks(); //기능3
			break;
		case 2: //학기별 성적
			printSemesterMarks(); //기능4
			break;	
		case 3: //시험별 성적
			printTestMarks(); //기능5
			break;
		default: System.out.println("잘못 입력했습니다");
		}
	}//printMark
	
	//기능3) 전체 성적 출력
	public void printAllMarks() {
		if(marks == null) {
			return;
		}
		
		for(Mark tmp : marks) {
			System.out.println(tmp);
		}
	}//printAllMarks
	
	//기능4) 학기별 성적 출력
	public void printSemesterMarks() {
		System.out.print("학년 학기 입력 : ");
		int grade = scan.nextInt();
		int semester = scan.nextInt();
		int sum = 0; //총점
		double count = 0; //평균을 구하기 위해 등록된 개수..?
		for(int i = 0; i < marks.size(); i++) {	
			//입력한 학년과 학기가 있으면
			if(marks.get(i).getGrade() == grade && marks.get(i).getSemester() == semester ) {
				//해당 성적을 출력하고
				System.out.println(marks.get(i));
				//총점에 더하고 -> 중간 40 기말 40 수행평가 20
				sum += marks.get(i).getMidterm()*0.4 + marks.get(i).getFinals()*0.4 + marks.get(i).getPA()*0.2;
				//개수 증가
				count++;
			}else {
				System.out.println("해당되는 성적이 없습니다");
				return;
			}
		}
		System.out.println("==============");
		System.out.println(grade + "학년 " + semester + "학기 총점 : " + sum +"점, 평균 : " + (sum/count) + "점");
		System.out.println("==============");
	}//printSemesterMarks
	
	//기능5) 학년과 학기를 입력하고 일치하몀 성적을 보고 싶은 시험을 입력받아 출력
	public void printTestMarks() {
		System.out.print("학년 학기 입력 : ");
		int grade = scan.nextInt();
		int semester = scan.nextInt();
		//시험별로 보기 위해 학년과 학기가 일치하는 성적들을 임시로 리스트에 담아둠
		List<Mark> tmp = new ArrayList<Mark>(); 
		double count = 0; //개수
		for(int i = 0; i < marks.size(); i++) {	
			if(marks.get(i).getGrade() == grade && marks.get(i).getSemester() == semester ) {
				tmp.add(marks.get(i)); //일치하면 tmp에 추가
				count++; //개수 증가
			}else {
				System.out.println("해당되는 성적이 없습니다");
				return;
			}
		}
		//성적을 보고 싶은 시험 입력				
		System.out.print("시험 입력[중간/기말/수행평가]: ");
		String test = scan.next();
		int sum = 0; //총점
		switch(test) {
		case "중간":
			for(int i = 0; i < tmp.size(); i++) {
				//중간고사에서 본 과목들과 점수들 출력
				System.out.println(tmp.get(i).getSubject() + " | " + tmp.get(i).getMidterm() + "점" );
				sum += tmp.get(i).getMidterm(); //중간고사의 총점
			}
			System.out.println(grade + "학년 " + semester + "학기 중간고사 총점 : " + sum +"점, 평균 : " + (sum/count) + "점");
			break;
		case "기말":
			for(int i = 0; i < tmp.size(); i++) {
				//기말고사에서 본 과목들과 점수들 출력
				System.out.println(tmp.get(i).getSubject() + " | " + tmp.get(i).getFinals() + "점");
				sum += tmp.get(i).getFinals(); //기말고사의 총점
			}
			System.out.println(grade + "학년 " + semester + "학기 기말고사 총점 : " + sum +"점, 평균 : " + (sum/count) + "점");
			break;
		case "수행평가" :
			for(int i = 0; i < tmp.size(); i++) {
				//수행평가에서 과목들과 점수들 출력
				System.out.println(tmp.get(i).getSubject() + " | " + tmp.get(i).getPA() + "점");
				sum += tmp.get(i).getPA(); //수행평가 총점
			}
			System.out.println(grade + "학년 " + semester + "학기 수행평가 총점 : " + sum +"점, 평균 : " + (sum/count) + "점");
			break;
		default: System.out.println("잘못 입력했습니다. 중간/기말/수행평가 중에 입력하세요");	
		}	
	}//printTestMarks
	
	//기능6)
	public void modifyMark() {
		System.out.print("학년 학기 과목 : ");
		int grade = scan.nextInt();
		int semester = scan.nextInt();
		String subject = scan.next();
		//학년 학기 과목이 일치하는 성적이 있으면
		if(marks.contains(new Mark(grade, semester, subject))) {
			//학년 학기 과목에 맞는 번지 저장 -> 수정하기 위해
			int index = marks.indexOf(new Mark(grade, semester, subject));
			//성적 입력
			System.out.print("중간 기말 수행평가 :");
			int midterm = scan.nextInt();
			int finals = scan.nextInt();
			int pA = scan.nextInt();
			//과목 수정...
			marks.get(index).modify(midterm, finals, pA);
		}else {
			System.out.println("등록된 점수가 없습니다. 수정할 수 없습니다");
		}	
	}//modifyMark
}

