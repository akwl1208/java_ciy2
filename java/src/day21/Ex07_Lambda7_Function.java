package day21;

import java.util.*;
import java.util.function.*;

public class Ex07_Lambda7_Function {

	public static void main(String[] args) {
		// <Lambda> Function
		//람다식을 이용하여 메소드를 각각 만들지 않고 성적 합계를 구함..필터링을 통해
		List<Student> list = new ArrayList<Student>();

		list.add(new Student(1, 1, 1, 100, 90, 80, "홍길동"));
		list.add(new Student(1, 1, 2, 80, 90, 100, "임꺽정"));
		list.add(new Student(1, 1, 3, 20, 30, 40, "둘리"));
		list.add(new Student(1, 1, 4, 40, 40, 100, "고길동"));
		
		BiFunction<Student, String, Integer> f = (Student std, String subject)->{
			if(subject.equals("국어")) return std.getKor();
			if(subject.equals("영어")) return std.getEng();
			if(subject.equals("수학")) return std.getMath();
			return 0;
		};
		
		System.out.println("학생들의 국어 총점 : " + sum(list, "국어", f));
		System.out.println("학생들의 영어 총점 : " + sum(list, "영어", f));
		System.out.println("학생들의 수학 총점 : " + sum(list, "수학", f));
	}
	
	public static int sum(List<Student>list, String subject, BiFunction<Student, String, Integer> function) {
		int sum = 0;
		for(int i = 0; i < list.size(); i++) {
			sum += function.apply(list.get(i), subject);
		}
		return sum;
	}
}

class Student{
	private int grade, clazz, num, kor, eng, math;
	private String name;
		
	//생성자
	public Student(int grade, int clazz, int num, int kor, int eng, int math, String name) {
		super();
		this.grade = grade;
		this.clazz = clazz;
		this.num = num;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.name = name;
	}//

	//toString
	@Override
	public String toString() {
		return "Student [grade=" + grade + ", clazz=" + clazz + ", num=" + num + ", kor=" + kor + ", eng=" + eng
				+ ", math=" + math + ", name=" + name + "]";
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
		Student other = (Student) obj;
		if (clazz != other.clazz)
			return false;
		if (eng != other.eng)
			return false;
		if (grade != other.grade)
			return false;
		if (kor != other.kor)
			return false;
		if (math != other.math)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num != other.num)
			return false;
		return true;
	}//

	//getter, setter
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
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}//
	
}