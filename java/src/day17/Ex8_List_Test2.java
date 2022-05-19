package day17;

import java.util.*;

public class Ex8_List_Test2 {

	public static void main(String[] args) {
		//<list>
		List<Student> list = new ArrayList<Student>();
		//리스트에 바로 저장
		Student std = new Student(1, 1, 1, "홍길동");
		list.add(std);
		//위의 두 줄을 한줄로 줄인거임
		//그러나 이 코드는 list에서는 사용가능하나 하지만 외부에서 사용할 수 없음 이름이 없기 때문
		//list.add(new Student(1,1,1,"홍길동"));
		
		System.out.println(list);
		System.out.println("------------------");
		
		//Student 클래스에 equals를 오버라이딩하지 않으면 indexOf, contains, remove메소드가 원하는대로 동작하지 않음
		//indexOf
		int index = list.indexOf(new Student(1,1,1,"홍길동"));
		System.out.println(index);
		
		//contains
		System.out.println(list.contains(new Student(1,1,1,"홍길동")));
		
		//remove
		//밑의 코드는 삭제가 안됨 -> equals 안해서...그럼 object를 -> 주소가 달라서 삭제 안됨
		//class에 equals 만들어주니까 삭제됨..
		System.out.println(list.remove(new Student(1, 1, 1, "홍길동")));
		//list.remove(std); -> 요거는 홍길동 삭제됨	
		
		System.out.println(list);
	}

}

class Student{
	private int grade, clazz, num;
	private String name;
	
	//생성자
	public Student(int grade, int clazz, int num, String name) {
		this.grade = grade;
		this.clazz = clazz;
		this.num = num;
		this.name = name;
	}
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//toString
	@Override
	public String toString() {
		return "student [grade=" + grade + ", clazz=" + clazz + ", num=" + num + ", name=" + name + "]";
	}
	
	//hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clazz;
		result = prime * result + grade;
		result = prime * result + num;
		return result;
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
	//복사생성자 -> 공유하지 않도록 막음
	public Student(Student std) {
		this.num = std.num;
		this.clazz = std.clazz;
		this.grade = std.grade;
		this.name = new String(std.name); //깊은 복사
	}

	
	
}

