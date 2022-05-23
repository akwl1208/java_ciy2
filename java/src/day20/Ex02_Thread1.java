package day20;

public class Ex02_Thread1 {

	public static void main(String[] args) {
		// <thread>
		/*
		Test1 t1 = new Test1();
		Thread th1 = new Thread(t1);
		*/
		//위의 두 줄을 한 줄로.
		Thread th1 = new Thread(new Test1());
		
		th1.setPriority(Thread.MAX_PRIORITY); //스레드의 우선순위 제어가능
		
		//|와 -와 *와 @가 동시에 출력 됨
		th1.start();
		th1.setPriority(Thread.MIN_PRIORITY); //스레드의 우선순위
		Thread th2 = new Test2();
		
		th2.start();
		
		//익명클래스를 이용
		Thread th3 = new Thread(new Runnable() {		
			@Override
			public void run() {
				for(int i = 0; i < 10000; i++) {
					System.out.println("@");
				}				
			}
		});
		th3.start();
		
		for(int i = 0; i < 10000; i++) {
			System.out.println("|");
		}
		
		
	}

}
//runnable 인터페이스를 구현한 구현클래스를 이용
class Test1 implements Runnable{
	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			System.out.println("-");
		}		
	}
}

//Thread 클래스를 상속받은 자식 클래스를 이용
class Test2 extends Thread{
	@Override
	public void run() {
		for(int i = 0; i < 10000; i++) {
			System.out.println("*");
		}		
	}
}