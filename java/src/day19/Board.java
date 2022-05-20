package day19;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	//필드
	private String type, title, content, writer;
	private int num, view;
	private Date registerDate;
	
	private static int count = 0;//등록된 게시글 수
	
	//생성자
	public Board(String type, String title, String content, String writer) {
		this.type = type;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.num = ++count;
		this.registerDate = new Date();
	}//
	
	//기본생성자 ->위에 생성자를 사용하지 않고...하기 위해 count가 올라가면 안되니까
	public Board(){}//

	//getter
	public String getRegisterDate() {
		if(registerDate == null) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(registerDate);
	}
	
	public int getNum() {
		return num;
	}
	
	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}//

	//수정
	public void modify(String title, String content) {
		this.title = title;
		this.content = content;
	}//

	//toString
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("000");
		return df.format(num)+ "\t" + type + "\t" + title + "\t" + writer + "\t"
				+ getRegisterDate() + "\t" + view;
	}
	
	//상세 내용 출력
	public void detailPrint() {
		System.out.println("=====================");
		System.out.println("번호 : " + num);
		System.out.println("제목 : " + title);
		System.out.println("작성자 : " + writer);
		System.out.println("작성일 : " + getRegisterDate());
		System.out.println("조회수 : " + view);
		System.out.println("내용 : " + content);
		System.out.println("=====================");
	}//

	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (num != other.num)
			return false;
		return true;
	}
	
	
}
