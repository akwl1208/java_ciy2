package day20;

public class Ex04_Thread3 {

	public static void main(String[] args) {
		//<동기화 메소드와 동기화 블록>
		//예제)한 계좌에 동시에 2명이 접근해서 천원을 빼갈 때 생길 수 있는 문제점
		//두 개 이상의 스레드가 하나의 자원을 같이 이용하는 경우 생길 수 있는 문제점
		/*user1 start -> 만원에서 천원 빼감 -> sleep(일시정지)
		 -> user2 start -> 9천원에서 천원 빼감 -> sleep(일시정지)
		 -> 1초 후 user1 대기 -> 진행 중인 스레드가 없으면 user1 다시 시작
		 -> user1 잔액 8천원 출력.. -> 1초 후 user2 대기 -> 진행 중인 스레드가 없으면 user2 다시 시작
		 -> user2 잔액 8천원 출력.. 
		 -> 해결방법이 출금 메소드에 synchronized(동기화)-> 그럼 9000원, 8000원 출력됨*/
		BankBook book = new BankBook(10000);
		User user1 = new User(book);
		user1.start(); //8000
		
		User user2 = new User(book);
		user2.start(); //8000
	}

}
class User extends Thread{
	BankBook book;
	
	public User(BankBook book) {
		this.book = book;
	}
	
	@Override
	public void run() {
		book.withdraw2(1000);
	}
}
class BankBook{
	private int money; //잔액

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	//출금
	/*메소드를 synchronized(동기화)하면 어떤 스레드가 동기화 메소드를 실행하고 있으면
	  다른 스레드에서 해당 메소드를 접근할 때, 실행이 다 끝날 때까지 일시정지했다가(Blocked)
	  다 끝나면 사용할 수 있음1
	*/
	//동기화 메소드
	public synchronized void withdraw(int money) {
		this.money -= money;
		try {
			Thread.sleep(1000);//1초 지연시간
			System.out.println("남은 잔액 : " + this.money);
		} catch (InterruptedException e) {} 
	}
	
	//동기화 블록
	public void withdraw2(int money) {
		synchronized (this) {
			this.money -= money;
			try {
				Thread.sleep(1000);//1초 지연시간
				System.out.println("남은 잔액 : " + this.money);
			} catch (InterruptedException e) {} 
		}
	}
	public BankBook(int money) {
		this.money = money;
	}
}