package day18;

public class Ex02_Stack {

	public static void main(String[] args) {
		//<Stack>
		//메소드가 stack에 저장됨 보여주기 위해..
		//호출
		//호출순서 : main -> test -> test -> test......지정된 크기까지...계속 쌓임
		test(); //StackOverflowError 발생
		

	}
	//재귀메소드: 메소드 안에서 자기 자신을 호출하는 메소드
	public static void test() {
		test();
	}
}
