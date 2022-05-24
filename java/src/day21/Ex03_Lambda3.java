package day21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex03_Lambda3 {

	public static void main(String[] args) {
		//<람다식> list의 정렬에서 활용
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(12);
		list.add(60);
		list.add(25);
		list.add(10);
		list.add(100);
		list.add(32);
		list.add(26);
		
		list.sort(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return a-b;
			}
		});
		
		//위의 식을 람다식을 활용하여 작성
		list.sort((Integer a, Integer b) -> a-b);
		
		System.out.println(list);
	}

}
