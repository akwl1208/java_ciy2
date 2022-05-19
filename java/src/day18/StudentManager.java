package day18;

import java.util.*;

//학생관리프로그램 기능 구현
public class StudentManager implements ConsolProgram {
	//변수 선언
	private Scanner scan;
	private List<Student> list; //학생정보 저장
	private int exitMenu = 5;
	
	//생성자1
	public StudentManager() {
		//자체적으로 스캐너, 리스트 만듬
		scan = new Scanner(System.in);
		list = new ArrayList<Student>();
		//linkedList는 가운데에서 삽입,삭제가 자주 일어날 때
	}
	//생성자2
	public StudentManager(Scanner scan) {
		this.scan = scan;
		list = new ArrayList<Student>();
	}
	//생성자3
	public StudentManager(Scanner scan, int size) {
		this.scan = scan;
		list = new ArrayList<Student>(size);
	}
	
	
	@Override
	public int selectMenu(Scanner scan) {
		System.out.println("------------메뉴-----------");
		System.out.println("1. 학생정보 입력");
		System.out.println("2. 학생정보 출력");
		System.out.println("3. 학생정보 수정");
		System.out.println("4. 학생정보 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴를 선택하세요 : ");
		
		int menu = scan.nextInt();
		System.out.println("-----------------------");
		
		return menu;
	}

	@Override
	public void excute(int menu) {
		switch(menu) {
		case 1: 
			//학생정보를 입력받아 학생 객체를 받아옴
			Student std = inputStudent(); //기능1

			//학생 정보 추가
			insertStudent(std); //기능2
			break;
		case 2: 
			//학생 정보 출력
			printStudent(); //기능3
			break;
		case 3: 
			//학년 반 번호 입력 -> 학생 객체 생성
			Student modStd = inputsearchStudent(); //기능4
			//학생 객체가 리스트에 있으면 
			int index = list.indexOf(modStd);
			if(index >= 0) {
				//수정할 이름, 국어, 수학, 수학을 입력받아 학생객체 수정
				inputAdditionInformation(modStd); //기능5
				//리스트에서 학생 객체 A로 수정
				list.set(index, modStd);
				//수정됬다고 알려줌
				printMessage("학생 정보가 수정되었습니다");
			}
			//없으면 학생이 없다고 알려줌
			else {
				printMessage("등록되지 않은 학생 정보입니다. 학생 정보를 입력하세요");
			}
			break;
		case 4: 
			//학년 반 번호 입력 -> 삭제할 학생 객체 생성
			Student delStd = inputsearchStudent(); //기능4
			/*<내가 푼거>
			//학생 객체가 리스트에 있으면
			index = list.indexOf(delStd);
			if(index >= 0) {
				//list에서 삭제
				list.remove(index);
				//삭제되었다고 알려줌
				printMessage("학생 정보가 삭제되었습니다");
			}
			//없으면 학생이 없다고 알려줌
			else {
				printMessage("등록되지 않은 학생 정보입니다. 학생 정보를 입력하세요");
			}
			*/
			//<선생님 풀이>
			if(list.remove(delStd)) {
				printMessage("학생 정보가 삭제되었습니다");
			}else {
				printMessage("등록되지 않은 학생 정보입니다. 학생 정보를 입력하세요");
			}
			break;
		case 5: 
			break;
		default:
			printMessage("잘못된 메뉴를 선택했습니다");
		}
		
	}

	@Override
	public void run() {
		int menu;
		do {
			try {
				menu = selectMenu(scan);
				excute(menu);
			} catch (Exception e) {
				menu = 0;
				printMessage("잘못된 메뉴를 입력했습니다");
				scan.nextLine();
			}
			
		}while(menu != exitMenu);
	}

	/*기능1) 학생정보를 입력받아 학생 객체를 받아옴
	 * 매개변수: 없음
	 * 리턴타입: 학생클래스에서 객체를 받아와야 하니까 -> 학생클래스...?
	 */
	private Student inputStudent() {
		try {
			//학생정보 입력
			System.out.println("학생 정보를 입력하세요");
			System.out.print("학년 반 번호 입력[예: 1 1 1 홍길동] : ");
			int grade = scan.nextInt();
			int clazz = scan.nextInt();
			int num = scan.nextInt();
			String name = scan.next();
			System.out.print("국어 영어 수학 성적 입력[예: 0 0 0] : ");
			int kor = scan.nextInt();
			int eng = scan.nextInt();
			int math = scan.nextInt();			
			//학생 객체 받아서 돌려줌
			return new Student(grade, clazz, num, name, kor, eng, math);
		}catch (Exception e) {
			printMessage("잘못된 값을 입력했습니다. 입력이 취소됩니다");
		
			//입력을 잘못했을 때 입력 버퍼에 있는 내용들을 문자열로 가져옴(입력 버퍼를 비우는 역할)
			scan.nextLine();
			return null;
		}
	}//inputStudent
	
	//기능2) 학생정보 추가
	private void insertStudent(Student std) {
		if(std == null) {
			printMessage("저장된 학생 정보가 없습니다");
			return;
		}
		//학년 반 번호가 같은 학생이 있을 때 처리..
		if(list.contains(std)) {
			printMessage("이미 존재하는 학생 정보입니다. 학생 정보를 수정하세요");
		}
		//list에 추가
		list.add(std);
		//정렬
		list.sort(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.getGrade() != o2.getGrade()) {
					return o1.getGrade() - o2.getGrade();
				}
				if(o1.getClazz() != o2.getClazz()) {
					return o1.getClazz() - o2.getClazz();
				}
				if(o1.getNum() != o2.getNum()) {
					return o1.getNum() - o2.getNum();
				}
				return 0;
			}
			
		});
		printMessage("학생 정보 추가가 완료되었습니다");	
	}//insertStudent
	
	//기능3) 학생정보 출력
	private void printStudent() {
		if(list.size() == 0) {
			printMessage("저장된 학생 정보가 없습니다");
			return;
		}
		System.out.println("-----------------------");
		for(Student tmp : list) {
			System.out.println(tmp);
		}
		System.out.println("-----------------------");
	}//printStudent
	
	//기능4) 학년 반 번호를 입력받아 학생 객체 생성
	private Student inputsearchStudent() {
		try {
			//학생정보 입력
			System.out.println("검색할 학생 정보를 입력하세요");
			System.out.print("학년 반 번호 입력[예: 1 1 1] : ");
			int grade = scan.nextInt();
			int clazz = scan.nextInt();
			int num = scan.nextInt();		
				
			//학생 객체 받아서 돌려줌
			return new Student(grade, clazz, num);
		}catch (Exception e) {
			printMessage("잘못된 값을 입력했습니다. 입력이 취소됩니다");
			
			scan.nextLine();
			return null;
		}
	}//inputsearchStudent
	
	/*기능5) 학년 반 번호가 있는 객체가 주어지면 해당 객체에 이름 국어 영어 수학을 입력받아 수정
	 * 매개변수: 객체
	 * 리턴타입: void
	 */
	private void inputAdditionInformation(Student std) {
		if(std == null) {
			printMessage("학생 정보가 없습니다");
			return;
		}
		
		try {
			System.out.println("수정할 정보를 입력하세요 ");
			System.out.println("이름 국어 영어 수학 입력 :");
			String name = scan.next();
			int kor = scan.nextInt();
			int eng = scan.nextInt();
			int math = scan.nextInt();
			std.modify(name, kor, eng, math);		
		}catch (Exception e) {
			printMessage("잘못된 값을 입력했습니다. 입력이 취소됩니다");
			
			scan.nextLine();
			return;
		}		
	}//inputAdditionInformation
	
	//기능6)
	private void printMessage(String message) {
		System.out.println("-----------------------");
		System.out.println(message);
		System.out.println("-----------------------");
	}//printMessage
	
}
