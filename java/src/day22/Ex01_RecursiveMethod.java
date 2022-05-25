package day22;

public class Ex01_RecursiveMethod {

	public static void main(String[] args) {
		// <재귀메소드> 팩토리얼 메소드 구현
		try {
			System.out.println(factorial1(4));
			System.out.println(factorial2(4));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	//반복문으로
	public static int factorial1(int n) {
		int res = 1;
		for(int i = 1; i <= n; i++) {
			res *= i;
		}
		return res;
	}
	
	//재귀메소드로 -> 종료 조건이 있어야 함
	public static int factorial2(int n) {
		//예외 처리
		if(n < 0) {
			throw new RuntimeException("음수 팩토리얼은 구할 수 없습니다");
		}
		//종료 조건이 없으면 stack overflow 발생
		if(n == 1 || n == 0) {
			return 1;
		}
		return n * factorial2(n-1);
	}
}
