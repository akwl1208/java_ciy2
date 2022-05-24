package day21;

public class Ex09_Debug {

	public static void main(String[] args) {
		//<디버깅>
		//보고 싶은 줄 더블 클릭 -> 줄 번호 옆에 파란색 원 생긴
		//-> F11 누르거나 'run - debug' 클릭
		int sum = 0, i;
		for(i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println();
	}

}
