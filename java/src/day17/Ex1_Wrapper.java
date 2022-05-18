package day17;

import java.util.ArrayList;
import java.util.List;

public class Ex1_Wrapper {

	public static void main(String[] args) {
		//<wrapper 클래스>
		/* 제네릭 클래스에서 기본 타입으로 제네릭을 만들고 싶지만
		   제네릭은 기본 타입이 올 수 없고 클래스가 필요
		   그래서 기본 타입으로 만든 Wrapper 클래스 이용
		 * Wrapper 클래스와 기본 타입의 차이
		   Wrapper 클래스의 객체는 기본 타입값과 null을 가짐
		   -> 언박싱할 때, 조심해야 함. null 일 수 있기 때문
		   기본 타입은 기본 타입 값만 가짐
		 * 두 기본타입 변수는 ==로 비교 가능
		 * 기본타입 변수와 Wrapper클래스 객체를 ==로 비교할 수 있음
		   -> Wrapper 클래스 객체가 자동 언박싱이 되어서 ==로 비교 
		 * 두 Wrapper 클래스 객체는 ==로 비교 불가  
		 */
		//wrapper를 사용하는 이유
		//List<Integer> list = new ArrayList<Integer>();
		
		//1)
		Integer num1 = 1; //자동 박싱
		int num2 = num1; //자동 언박싱

		//2)
		Integer num3 = null;
		//int num4 = num3; //예외 발생 -> null을 기본 타입으로 바꿀 수 없음(nullpointException)
		
		//3)두 기본타입 변수를 ==로 비교 -> 같다
		int num5 = 1, num6 = 1;
		if(num5 == num6) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		//4)
		Integer num7 = 1, num8 = new Integer(1);
		//두 wrapper 객체를 ==로 비교 -> 다르다
		if(num7 == num8) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		//강제 타입 변환 -> wrapper 객체와 기본 타입을 ==로 비교 -> 같다
		if(num7 == (int)num8) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		//5) 문자열을 정수로 바꿈
		String str = "1000"; //a가 들어가면 타입변환 못함
		int num9 = Integer.parseInt(str);
		System.out.println(num9);
		
		String str2 = "1.23";
		double num10 = Double.parseDouble(str2);
		System.out.println(num10);
	}

}
