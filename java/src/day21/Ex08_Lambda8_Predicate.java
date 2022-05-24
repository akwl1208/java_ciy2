package day21;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Ex08_Lambda8_Predicate {

	public static void main(String[] args) {
		// <람다식> Predicate
		List<Student> list = new ArrayList<Student>();

		list.add(new Student(1, 1, 1, 100, 90, 80, "홍길동"));
		list.add(new Student(1, 1, 2, 80, 90, 100, "임꺽정"));
		list.add(new Student(1, 2, 3, 20, 30, 40, "둘리"));
		list.add(new Student(1, 2, 4, 40, 40, 100, "고길동"));
			
		System.out.println("1학년 학생들의 평균 : " + avg(list, s->s.getGrade()==1)); //67.5
		System.out.println("1학년 1반 학생들의 평균 : " + avg(list, s->s.getGrade()==1 && s.getClazz()==1)); //90
		System.out.println("1학년 2반 학생들의 평균 : " + avg(list, s->s.getGrade()==1 && s.getClazz()==2)); //45
		System.out.println("1학년 1반 1번 학생의 평균 : " + avg(list, s->s.getGrade()==1 && s.getClazz()==1 && s.getNum()==1));
	}
	
	public static double avg(List<Student>list, Predicate<Student> function) {
		double sum = 0;
		int count = 0;
		for(int i = 0; i < list.size(); i++) {
			Student tmp = list.get(i);
			if(function.test(tmp)) {
				count++;
				sum += tmp.getEng() + tmp.getKor() + tmp.getMath();
			}
		}
		return sum/(double)(3*count);
	}

}