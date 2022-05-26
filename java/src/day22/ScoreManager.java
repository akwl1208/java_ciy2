package day22;

import java.util.*;
import java.util.function.Predicate;

import day18.ConsolProgram;

public class ScoreManager implements ConsolProgram {
	Scanner scan = new Scanner(System.in);
	private int exitMenu = 4;
	private List<Score> list = new ArrayList<Score>();
	
	public ScoreManager(Scanner scan) {
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		
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
		return scan.nextInt();
	}

	@Override
	public void excute(int menu) {
		switch(menu) {
		case 1:
			if(addScore()) {
				printMessage("성적을 추가했습니다");
			}else {
				printMessage("이미 등록된 과목 성적입니다");
			}
			break;
		case 2:
			printScore();
			break;
		case 3:
			modifyScore();
			break;
		case 4:
			break;
		default:	
		}
		
	}

	@Override
	public void run() {
		//테스트용
		list.add(new Score(1, 1, "국어", 100, 90, 80));
		list.add(new Score(1, 1, "수학", 70, 60, 60));
		list.add(new Score(1, 1, "영어", 50, 40, 30));
		list.add(new Score(1, 2, "국어", 20, 10, 0));
		list.add(new Score(1, 2, "수학", 10, 20, 30));
		list.add(new Score(1, 2, "영어", 40, 50, 60));	
		
		int menu = -1;
			do {
				try {
					menu = selectMenu(scan);
					excute(menu);	
				}catch (InputMismatchException e) {
					printMessage("올바른 값을 입력하세요");
					scan.nextLine();
				}catch (RuntimeException e){
					printMessage(e.getMessage());
				}catch (Exception e) {
					printMessage("예외 발생 : " + e.getMessage());
				}
			}while(menu != exitMenu);
	
		System.out.println("프로그램을 종료합니다");	
	}

	//기능1)
	private void printMessage(String str) {
		System.out.println("==============");
		System.out.println(str);
		System.out.println("==============");
	}//printMessage
	
	//기능2)
	private boolean addScore() {
		System.out.println("==============");
		System.out.println("추가할 성적을 입력하세요");
		System.out.println("학년 학기 과목 : ");
		int grade = scan.nextInt();
		int semester = scan.nextInt();
		String subject = scan.next();
		
		Score tmp = new Score(grade, semester, subject);
		if(list.contains(tmp)) {
			return false;
		}
		System.out.print("중간 기말 수행평가 :");
		int midterm = scan.nextInt();
		int finals = scan.nextInt();
		int pA = scan.nextInt();
		
		tmp = new Score(grade, semester, subject, midterm, finals, pA);
		list.add(tmp);
		return true;
	}//addScore
	
	//기능3)
	private void printScore() {
		sort();
		System.out.println("======메뉴======");
		System.out.println("1. 전체 성적 확인");
		System.out.println("2. 학기별 성적 확인");
		System.out.println("3. 과목별 성적 확인");
		System.out.println("==============");
		System.out.print("메뉴 입력 : ");
		int menu = scan.nextInt();
		
		switch(menu) {
		case 1:
			printScoreList(s->true);
			break;
		case 2:
			System.out.print("학년 학기 : ");
			int grade = scan.nextInt();
			int semester = scan.nextInt();
			
			printScoreList(s->s.getGrade() == grade && s.getSemester() == semester);
			break;
		case 3:
			System.out.print("과목 : ");
			String subject = scan.next();
			
			printScoreList(s->s.getSubject().equals(subject));
			break;
		default: printMessage("잘못된 메뉴 입력했습니다");
		}
	}//printScore
	
	//기능5
	private void printScoreList(Predicate<Score> p) {
		List<Score> tmpList = new ArrayList<Score>();
		
		for(Score tmp : list) {
			if(p.test(tmp)) {
				tmpList.add(tmp);
			}
		}
		
		if(tmpList.size() == 0) {
			printMessage("출력할 성적이 없습니다");
		}else {
			System.out.println("==============");
			for(Score tmp : tmpList) {
				System.out.println(tmp);
			}
			System.out.println("==============");
		}
	}//printScoreList
	
	//기능6
	private void sort() {
		list.sort((Score s1, Score s2)->{
			if(s1.getGrade() != s2.getGrade()) {
				return s1.getGrade() - s1.getGrade();
			}
			if(s1.getSemester() != s2.getSemester()) {
				return s1.getGrade() - s1.getGrade();
			}
			return s1.getSubject().compareTo(s2.getSubject());
		});
	}//sort
	
	//기능7
	private boolean modifyScore() {
		System.out.println("==============");
		System.out.println("수정할 성적을 입력하세요");
		System.out.println("학년 학기 과목 : ");
		int grade = scan.nextInt();
		int semester = scan.nextInt();
		String subject = scan.next();
		
		Score tmp = new Score(grade, semester, subject);
		int index = list.indexOf(tmp);
		if(index < 0) {
			return false;
		}
		
		System.out.print("중간 기말 수행평가 :");
		int midterm = scan.nextInt();
		int finals = scan.nextInt();
		int pA = scan.nextInt();
		
		//리스트에서 학년, 학기, 과목이 같은 성적 정보를 가져옴
		tmp = list.get(index);
		//수정 방법 1)
		tmp.setMidterm(midterm);
		tmp.setFinals(finals);
		tmp.setPerformance(pA);
		
		//방법2)
		tmp = new Score(grade, semester, subject, midterm, finals, pA);
		list.remove(tmp); //기존에 있던 학생 정보 삭제
		list.add(tmp); //수정한 학생 정보 추가
		return true;
		
		/* 100 91 120으로 수정한다면...
		 * 방법1: 중간과 기말은 저장되고 pA만 저장 안됨 -> 잘못 입력하기 전까지만 수정됨
		 * 방벙2: 객체 생성에서 오류나서 수정이 안됨 -> 잘못 입력하면 정보 자체가 수정되지 않음
		 * */
	}//modifyScore
	
}
