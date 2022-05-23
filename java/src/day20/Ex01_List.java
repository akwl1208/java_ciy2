package day20;

import java.util.ArrayList;
import java.util.List;

public class Ex01_List {

	public static void main(String[] args) {
		// <list>
		//1)<>를 안쓰면 <Object>를 적은 것과 동일
		List list = new ArrayList<Object>();
		//object에 속한 클래스를 사용가능
		list.add(new Point());
		list.add("123");
		
		Point pt = new Point();
		//참조변수를 직접 넣어줬기 때문에 리스트에 있는 객체와 pt가 같은 객체를 공유. 그래서 equals를 오버라이딩 안해도 가능
		//	-> 하지만 이렇게 하면 list를 안 건들여도 pt 수정 시 list도 수정되기 때문에 이 방법은 비추천
		list.indexOf(pt);
		
		//반복문 사용 시 주의 -> 조건문과 instanceOf로 형변환이 가능한지 확인
		for(Object tmp : list) {
			if(tmp instanceof Point) {
				Point p = (Point)tmp;
				System.out.println(p.x + ", " + p.y);
			}
		}
		
		/*2) indexOf, containts, containsAll, remove 등을 이용할 때 오버라이딩이 필요한 메스드
				-> point 클래스에 equals 필요
			equals를 오버라이딩 안하면 object의 equals가 호출됨 -> 이 때, equals는 주소를 비교함
				-> 같은 객체를 두 참조 변수가 공유하는지 확인
			*/
		list.indexOf(list);
	}

}

class Point{
	int x,y;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
}