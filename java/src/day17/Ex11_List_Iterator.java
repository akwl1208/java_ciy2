package day17;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex11_List_Iterator {

	public static void main(String[] args) {
		//<iterator>
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(2);
		
		//향상된 for문 : 배열과 리스트 가능
		for(Integer tmp : list) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		//iterator: while을 주로 사용
		Iterator<Integer> it = list.iterator();
		//다음 요소가 있으면
		while(it.hasNext()) {
			//다음 요소를 가져옴
			Integer tmp = it.next();
			System.out.print(tmp + " ");
		}
		System.out.println();
	}

}
