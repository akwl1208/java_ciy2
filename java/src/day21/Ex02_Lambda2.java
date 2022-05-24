package day21;

public class Ex02_Lambda2 {

	public static void main(String[] args) {
		//<람다식>
		//1)하나의 매개변수가 있는 경우 -> (int a)에서 괄호 생략 가능
		Test1 t1 = a ->{
			System.out.println("테스트 : " + a);
		};
		t1.test(10);
		
		//2)중괄호 안에 리턴만 있는 경우 중괄호와 리턴 생략 가능
		/*
		Test2 t2 = (int a, int b) ->{
			return a+b;
		};
		*/
		Test2 t2 = (int a, int b) ->a+b;
		
		System.out.println(t2.sum(10, 20));
	}

}

interface Test1{
	void test(int a);
	//추상메소드 2개는 안됨 1개만
	//void test2(); -> 오류
}

@FunctionalInterface
interface Test2{
	int sum(int a, int b);
}