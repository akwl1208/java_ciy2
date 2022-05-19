package day17;

import java.util.*;

public class Ex12_Set_Lotto {

	public static void main(String[] args) {
		// 예제)set을 이용하여 1~45 사이의 중복되지 않는 숫자 6개를 저장하고, 출력하는 코드 작성
		/*
		//<내가 푼거1> 중복을 생각못함..만약 중복때문에 6자리 숫자가 안나올수도 있음
		//Set 객체 생성 -> 숫자니까..Integer
		Set<Integer> lotto = new HashSet<Integer>();
		
		//랜덤 수 6자리 생성
		int max = 45, min = 1;
		//6자리 수니까 6번 반복..
		for(int i = 0; i < 6; i++) {
			//랜덤 수 생성
			int r = (int)(Math.random()*(max - min + 1) + min);
			//숫자 저장
			lotto.add(r);
			}
		}
		
		//로또 출력
		System.out.print(lotto + " ");
		*/
		
		//<내가 푼거2>
		Set<Integer> lotto = new HashSet<Integer>();
		
		int max = 45, min = 1;
		for(int i = 0;; i++) { //while문 사용 시 while(lotto.size() < 6)
			//lotto.add((int)(Math.random()*(max - min + 1) + min)); 요렇게 작성 가능
			int r = (int)(Math.random()*(max - min + 1) + min);			
			lotto.add(r);
			//6자리 수면..반복문 나옴?
			if(lotto.size() == 6) {
				break;
			}
		}
		
		//로또 출력
		System.out.print(lotto + " ");
		System.out.println();
		/* 1) 항상된 for문으로 출력 가능
		 for(Integer tmp : lotto){
		 	System.out.print(tmp + " ");
		 }	
		 */
		/* 2) interator 사용
		 Interator<Integer> it = lotto.iterator();
		 while(it.hasNext()){
		 	Integer tmp = it.next();
		 	System.out.print(tmp + " ");
	 	 }
		 */
		
		
		//예제2) 스캐너를 이용하여 정수 6개 입력받고, 중복되지 않은 숫자 6개를 입력할 때까지. 범위는 로또와 같음
		//구매한 로또
		Set<Integer> user = new HashSet<Integer>();
		Scanner scan = new Scanner(System.in);
		
		//중복되지 않은 숫자 6개를 입력할 때까지..니까 반복문 사용
		System.out.print("6개의 숫자 입력(1~45): ");
		while(user.size() < 6) {		
			//숫자 입력		
			int num = scan.nextInt();		
			if(num >= min && num <= max) {
				//user에 저장
				user.add((Integer)num);	
			}
		}
		
		//user 출력
		System.out.print(user + " ");
		System.out.println();
		
		
		//예제3) lotto와 user에서 일치하는 숫자의 개수를 세서 출력
		int count = 0;		
		/*
		//반복문 조건식을 모르겠당
		while() {
			//user와 lotto에서 일치하는 숫자
			if(user.equals(lotto)) {
				//count 증가
				count++;
			}
		}
		*/
		
		//<선생님 풀이>
		for(Integer tmp : lotto) {
			if(user.contains(tmp)) {
				count++;
			}
		}
		System.out.println(count + "개");
	}

}
