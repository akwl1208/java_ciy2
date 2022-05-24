package day21;

import java.util.function.Consumer;

import day21.Outer.Inner;

public class Ex06_Lambda6 {
	
	public static void main(String[] args) {
		Outer o = new Outer();
		Inner i = o.new Inner();
		i.method();
	}
}
//람다식에서 클래스 필드에 다 접근 가능
class Outer{
	public int outerField = 10;
	
	class Inner{
		int innerField = 20;
		
		void method() {
			int localField = 10;
			//람다식에서 localField를 사용 중이기 때문에, localField를 바꾸면 
			//final이 성립하지 않아 람다식에서 오류 발생
			//localField = 20;
			Consumer<Integer> co = (Integer a)->{
				System.out.println("outerfield : " + outerField);
				//바깥 클래스의 필드에 접근하는 경우 : 바깥클래스명.this.필드명
				System.out.println("outerfield : " + Outer.this.outerField);
				
				System.out.println("innerfield : " + innerField);
				//내부 클래스의 필드에 접근하는 경우: this.필드명
				System.out.println("innerfield : " + this.innerField);
				
				System.out.println("localfield : " + localField);
			};
			co.accept(1);
		}
	}
}