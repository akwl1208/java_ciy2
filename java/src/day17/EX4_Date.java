package day17;

import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date; //이렇게 불러도 되지만
import java.util.*; //모든걸 불러도 됨

public class EX4_Date {

	public static void main(String[] args) {
		// <Date 클래스>
		//1) new Date();는 실행 시간을 기준으로 날짜 객체 생성
		Date date = new Date();
		System.out.println(date);
		
		//2) new Date(num);는 1970년 1월 1일 00:00:00을 기준으로 num 밀리세컨드가 흐른 날짜 객체 생성
		Date date2 = new Date(0);
		System.out.println(date2); //출력은 한국시간이라서 9시로 출력됨
		
		//3)yyyy-MM-dd hh:mm:ss E요일
		//Date 클래스의 객체를 원하는 포멧의 문자열로 바꾸는 예제
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss E요일");
		String strDate = format.format(date);
		System.out.println(strDate);
		
		
		//4) 문자열을 Date 클래스의 객체로 바꾸는 객체
		//예외처리를 해줘야함..
		try {
			format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date3 = format.parse("2022-05-18 10:58:00");
			System.out.println(date3);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
