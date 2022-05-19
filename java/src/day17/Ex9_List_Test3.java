package day17;

import java.util.ArrayList;
import java.util.List;

public class Ex9_List_Test3 {

	public static void main(String[] args) {
		// <list>
		List<Student> list = new ArrayList<Student>();
		Student std = new Student(1,1,1,"홍길동");
		list.add(new Student(std));
		
		System.out.println(list);
		//std에서 이름을 홍길동에서 임꺽정으로 바꿈
		/* 학생 객체 std를 생성하여 리스트에 추가한 후, 학생 객체를 수정하면 문제가 생길 수 있음
			-> 복사 생성자를 이용하여 객체에 복사하여 리스트에 추가해야 한다.
			-> 또는, 학생 클래스에 클론 메소드를 오버라이딩해서 복제해서 리스트에 추가
			*/
		std.setName("임꺽정");
		//list는 안건들였는데 list에서 이름이 바뀜 -> bad...
		System.out.println(list);
	}

}
