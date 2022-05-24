package day21;

public class Ex01_Lambda1 {

	public static void main(String[] args) {
		//<람다식>
		//람다식을 안쓰고 스레드 생성 후 테스트
		Thread th1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("안녕");	
			}
		});
		th1.start();
		
		//위의 식을 람다식 활용하여 작성 -> 코드 간결
		//함수적 인터페이스일 때 사용 가능
		Thread th2 = new Thread(()-> System.out.println("Hi"));
		th2.start();
		
		//위의 식의 원래 식 -> 하나의 실행문일 때 중괄호 생략 가능
		Thread th3 = new Thread(()-> {
			System.out.println("Hi");
		});
		th3.start();
	}
}