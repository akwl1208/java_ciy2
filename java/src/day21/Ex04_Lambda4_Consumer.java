package day21;

import java.util.function.Consumer;

public class Ex04_Lambda4_Consumer {

	public static void main(String[] args) {
		//<Lambda> consumer
		Consumer<String> consumer = (String str)->System.out.println(str);
		consumer.accept("안녕");
		
		Point pt = new Point();
		Consumer<Point> ptconsumer = (Point pt1)->System.out.println(pt1.x + ", " + pt1.y);
		ptconsumer.accept(pt);
		
		//요런식으로 toString으로 할 수 있기 때문에 굳이 위처럼 할 필요가 없다
		System.out.println(pt);
	}
	
	
}

class Point{
	int x,y;
	
	@Override
	public String toString() {
		return x + ", " + y;
	}
}