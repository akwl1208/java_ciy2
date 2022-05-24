package day21;

import java.util.function.Supplier;

public class Ex05_Lambda5_Supplier {

	public static void main(String[] args) {
		// <Lambda> supplier
		//랜덤 수 생성할 땐 쓸만 함
		//Supplier<Integer> su = ()->(int)(Math.random()*10+1);
		//외부에 있는 지역변수 사용 가능 -> but 값을 바꾸면 안됨
		int min = 1, max =10;
		Supplier<Integer> su = ()->(int)(Math.random()*(max-min+1)+min);
		
		for(int i = 0; i < 10; i++) {
			System.out.println(su.get());
		}
		
	
	}
	//원래는 요렇게 메소드 만들어줘야 함
	public static int random(int min, int max) {
		return (int)(Math.random()*(max-min+1)+min);
	}
}
