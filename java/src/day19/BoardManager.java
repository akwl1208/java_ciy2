package day19;

import java.util.*;

import day18.ConsolProgram;

public class BoardManager implements ConsolProgram {
	Scanner scan = new Scanner(System.in);
	private int exitmenu = 4;
	List<Board> boards = new ArrayList<Board>(); //게시판..
	
	//생성자
	public BoardManager(Scanner scan) {
		this.scan = scan;
		//테스트용
		Board board1 = new Board("공지", "안녕하세요", "안녕하세요", "아지짱짱");
		boards.add(board1);
		Board board2 = new Board("일반", "안녕", "안녕", "짱짱아지");
		boards.add(board2);
	}
	
	@Override
	public int selectMenu(Scanner scan) {
		System.out.println("=========메뉴=========");
		System.out.println("1. 게시글 등록(공지/일반)");
		System.out.println("2. 게시글 확인");
		System.out.println("3. 게시글 수정");
		System.out.println("4. 프로그램 종료");
		System.out.println("=====================");
		System.out.print("메뉴 입력 : ");
		int menu = scan.nextInt();
		System.out.println("=====================");

		return menu;
	}

	@Override
	public void excute(int menu) {
		switch(menu) {
		case 1: //게시글 등록
			/*사용자가 게시글을 등록
			* 게시글 타입에는 공지와 일반이 있다
			* 게시글 정보는 게시글 타입, 제목, 내용, 작성자를 입력하여 등록
			* 게시글 타입, 작성자는 공백이 없는 단어(scan.next())를 입력하고,
			  제목, 내용은 공백이 포함된 문자열(scan.nextLine())을 입력
			  -> nextLine 사용 모르겠어서 일단..next로...
			 */
			//게시글 작성 후, 게시글 저장
			Board board = writeBoard(); //기능2
			
			//게시글을 게시판에 올리기
			postBoard(board); //기능3

			break;
			
		case 2: //게시글 확인
			/* 등록된 전체 게시글을 게시글 번호, 타입, 제목, 작성자, 작성일, 조회수 순으로 보여준다.
			* 출력된 전체 게시글 중 보고 싶은 게시글 번호를 선택하면 상세 게시글을 확인한다
			* 게시글 상세를 확인하지 않고 나가려면 -1을 선택하면 나가도록 한다
			* 게시글 번호를 선택하면 게시글 제목, 작성자, 작성일, 조회수, 내용 순으로 상세 내용을 출력
			* 게시글 번호를 선택해서 게시글을 조회하면 해당 게시글 조회수가 1 증가 -> 모름!
			  */
			//출력된 전체 게시글 중 보고 싶은 게시글 번호를 선택하면 상세 게시글을 확인
			showDetailBoard(); //기능5
		
			break;
			
		case 3: //게시글 수정
			/* 전체 게시글을 출력한 후, 수정할 게시글을 선택한다
			* 게시글이 선택되면 제목, 내용을 수정한다
			* 수정하지 않고 나가려면 -1을 선택하면 나가도록 한다
			* */
			//수정할 게시글 선택하면 수정할 내용 입력
			modifyBoard();
			
			break;
			
		case 4: break;
		default: printMessage("잘못된 메뉴를 입력했습니다");
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
				menu = -1;
				scan.nextLine();
			}		
		}while(menu != exitmenu);
		printMessage("프로그램을 종료합니다");
		
	}

	//기능1) 메세지 출력
	private void printMessage(String str) {
		System.out.println("=====================");
		System.out.println(str);
		System.out.println("=====================");
	}//printMessage
	
	//기능2) 게시글 작성
	private Board writeBoard() {
		try {
			System.out.println("게시글을 작성합니다");
			System.out.print("게시글 타입[공지/일반] : ");
			String type = scan.next();
			scan.nextLine();
			System.out.print("게시글 제목 : ");
			String title = scan.nextLine();
			System.out.print("내용 : ");
			String content = scan.nextLine();
			System.out.print("작성자 : ");
			String writer = scan.next();	
			//게시글에 저장
			return new Board(type, title, content, writer);
		} catch (Exception e) {
			printMessage("잘못 입력했습니다. 메뉴로 돌아갑니다");
			//문자열을 비워줌
			scan.nextLine();
			return null;
		}
	}//writeBoard
	
	//기능3) 게시글을 게시판 등록
	private void postBoard(Board board) {
		//예외 처리 -> 작성한 게시글이 없을 때?
		if(board == null) {
			printMessage("작성된 게시글이 없습니다");
			return;
		}
		//게시글을 게시판에 등록
		boards.add(board);
	}//postBoard
	
	//기능4) 등록된 전체 게시글 출력
	private void printBoards() {
		//예외처리 -> 게시판에 등록된 게시글이 없을 때
		if(boards.size() == 0) {
			printMessage("등록된 게시글이 없습니다");
		}
		//게시글 출력
		System.out.println("=======게시글 목록=======");
		System.out.println("[번호]\t[구분]\t[제목]\t[작성자]\t[작성날짜]\t\t\t[조회수]");
		System.out.println("------------------------------------------------------------");
		for(int i = 0; i < boards.size(); i++) {
			System.out.println(boards.get(i));
		}
		System.out.println("=====================");
	}//printBoards
	
	//기능5) 게시글을 선택하면 상세 내용 확인
	private void showDetailBoard() {
		//등록된 전체 게시글 출력
		printBoards(); //기능4	
		
		try {
			//출력된 전체 게시글 중 보고 싶은 게시글 번호를 선택
			System.out.print("게시글 선택[메뉴로 돌아가기: -1] : ");
			int num = scan.nextInt();	
			//상세 게시글을 확인
			if(num >= 1) {
				//조회수 증가
				boards.get(num-1).setView(boards.get(num-1).getView() + 1);
				//상세 내용 출력
				boards.get(num-1).detailPrint();
				return;
			}	
			//입력한 값이 -1이면 메뉴로 돌아가기
			if(num == -1){
				printMessage("메뉴로 돌아갑니다");
				return;
			}
			//예외 처리: 입력값이 0보다 작거나 같은 경우
			if(num <= 0) {
				throw new Exception();
			}
		} catch (Exception e) {
			printMessage("잘못 입력했습니다. 메뉴로 돌아갑니다");
			scan.nextLine();
			return;
		}
		

	}//showDetailBoard
	
	//기능6) 수정하고 싶은 게시글을 선택하면 제목, 내용 수정
	private void modifyBoard() {
		//등록된 전체 게시글 출력
		printBoards(); //기능4
		
		try {
			//수정할 게시글 선택
			System.out.print("수정할 게시글 선택[메뉴로 돌아가기: -1] : ");
			int num = scan.nextInt();	
			//수정할 내용 입력
			if(num >= 1) {
				if(num == boards.get(num-1).getNum()) {
					System.out.print("수정할 제목 입력 : ");
					String title = scan.next();
					System.out.println("수정할 내용 입력 : ");
					String content = scan.next();
					//게시글 수정
					boards.get(num-1).modify(title, content);
					return;
				}
			}
			//입력한 값이 -1이면 메뉴로 돌아가기
			if(num == -1){
				printMessage("메뉴로 돌아갑니다");
				return;
			}
			//예외 처리: 입력값이 0보다 작거나 같은 경우
			if(num <= 0) {
				throw new Exception();
			}
		}catch (Exception e) {
			printMessage("잘못 입력했습니다. 메뉴로 돌아갑니다");
			scan.nextLine();
			return;
		}

	}//modifyBoard
}
