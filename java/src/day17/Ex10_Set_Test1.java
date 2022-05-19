package day17;

import java.util.*;

public class Ex10_Set_Test1 {

	public static void main(String[] args) {
		// <set> 중복불가
		
		Set<Integer> set = new HashSet<Integer>(); 
		/* 
		//중복 제거함
		set.add(1);
		set.add(2);
		set.add(1); //중복
		set.add(1); //중복
		System.out.println(set); //{1,2}
		*/
		
		//범위가 작으면 자동으로 정렬이 된다
		for(int i = 0; i < 10; i++) {
			//set.add((int)(Math.random()*(9 - 1 + 1) + 1));
			int r = (int)(Math.random()*(9 - 1 + 1) + 1);
			System.out.println(r + " : " + set.add(r));
		}		
		System.out.println(set);
		System.out.println("-------------------------");
		
		//1 지우기
		System.out.println("1 삭제? : " + set.remove(1));
		System.out.println(set);
		System.out.println("-------------------------");
		
		//iterator를 통해 삭제
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			Integer tmp = it.next();
			System.out.println(tmp + " ");
		}
		System.out.println();
	}

}
