package day17;

public class Ex2_Math {

	public static void main(String[] args) {
		// <math>
		//예제) 주어진 정수를 소수점 둘째자리에서 반올림하는 코드 작성
		//<네기 푼거>
		double pi = 3.141592;
		/*
		double pi2 = Math.rint(pi*10); 
		pi = pi2/10;
		System.out.println(pi);
		*/
		
		//<선생님 풀이>	
		int num = 2;
		pi = 3.141592;
		//x를 곱해서 반올림
		double pi2 = pi * Math.pow(10, num-1);
		//반올림한 값에서 x로 나눔
		double pi3 = Math.round(pi2) / Math.pow(10, num-1);
		double pi4 = Math.round(pi * Math.pow(10, num-1))/Math.pow(10, num-1);
		System.out.println(pi3);
		System.out.println(pi4);
		
	}

}
