package day17;

import java.util.*;

public class Ex7_List {

	public static void main(String[] args) {
		// <컬렉션 프레임워크: list>
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		Vector<Integer> list2 = new Vector<Integer>();
		LinkedList<Integer> list3 = new LinkedList<Integer>();
		List<Integer> list4 = new ArrayList<Integer>(); //인터페이스를 이용하여 부름
		
		list1.add(10); //정수 10이 자동 박싱으로 Integer로 변한 후 리스트에 추가
		list1.add(20);
		//0번지에 30을 추가 -> 이전 0번지 값은 뒤로 자동으로 밀림
		list1.add(0,30);
		//list는 중복 가능
		list1.add(20);
		System.out.println("list1 : " + list1);
		//list1에 있는 값은 전체 다 복사
		list4.addAll(list1);
		System.out.println("list4 : " + list4);
		System.out.println("-----------------");
		//값 변경
		list1.set(0,3);
		System.out.println("list1 : " + list1);
		//0번지의 값을 가져옴
		System.out.println("list1의 0번지 값 : " + list1.get(0)); //3
		//contains ->boolean
		System.out.println("list1에 30이 있는가? : " + list1.contains(30)); //false
		//indexOf
		System.out.println("list1에 10이 몇 번지에 있는가? : " + list1.indexOf(10) + "번지"); //1번지
		//size
		System.out.println("list1에 있는 원소 개소 : " + list1.size() + "개"); //4개
		System.out.println("-------------------");
		
		Integer num = list4.remove(0);
		System.out.println("list4에서 제거한 0번지의 값 : " + num); //30
		
		System.out.println("list4에서 제거한 20을 제거했는가? : " + list4.remove((Integer)20)); //true
		System.out.println("list4 : " + list4); //{10,20}
		//list값 제거
		list4.clear(); 
		System.out.println("list4 : " + list4); //[] 비어있음
		
		
	}

}
