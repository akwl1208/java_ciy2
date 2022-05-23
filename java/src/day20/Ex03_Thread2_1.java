package day20;

import java.awt.Toolkit;

public class Ex03_Thread2_1 {

	public static void main(String[] args) {
		//tread 없는 예제 -> 소리가 다 출력된 후, 띵이 출력
		Toolkit tk = Toolkit.getDefaultToolkit();
		
		for(int i = 0; i < 5; i++) {
			tk.beep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}			
		}
		
		for(int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}			
		}
	}
}
