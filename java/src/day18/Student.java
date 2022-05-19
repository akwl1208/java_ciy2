package day18;

import java.util.List;

public class Student implements Cloneable{
	//필드
	private int grade, clazz, num;
	private String name;
	private int kor, eng, math;
	
	//생성자
	public Student(int grade, int clazz, int num, String name, int kor, int eng, int math) {	
		this.grade = grade;
		this.clazz = clazz;
		this.num = num;
		modify(name, kor, eng, math);
	}
	
	//기본생성자
	public Student() {}
	
	//생성자2
	public Student(int grade, int clazz, int num) {	
		this.grade = grade;
		this.clazz = clazz;
		this.num = num;	
	}
	
	//기능1) 수정 -> 정보를 쉽게 수정하기 위해 만들어 놓음
	public void modify(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	//toString
	@Override
	public String toString() {
		return "[" + grade + "학년 " + clazz + "반 " + num + "번 " + name + "] [국어 : " + kor
				+ ", 영어 : " + eng + ", 수학 : " + math + "]";
	}

	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (clazz != other.clazz)
			return false;
		if (grade != other.grade)
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	
	//clone
	//런타입 예외가 아니기 때문에 꼭 예외 처리 해줘야 함 
	//throw 쓰면 메인에서 클론 쓸 때마다 예외 처리해줘야 함
	@Override
	public Student clone() {
		//기본생성자가 없으면 new Student에 오류 발생
		//Student std = new Student();
		try {
			Student std = (Student)super.clone();
			//이름 복사 -> 공유하지 않도록
			std.name = new String(name);
			return std;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
		//여기에 return하면 unreachable 오류 발생 -> 밖에 선언해주던가..
	}

	//getter setter
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClazz() {
		return clazz;
	}

	public void setClazz(int clazz) {
		this.clazz = clazz;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	

	


	
	
}
