package day22;

public class Score {
	private int grade, semester;
	private String subject;
	private int midterm, finals, performance;
	
	public Score(int grade, int semester, String subject, int midterm, int finals, int performance) {
		this(grade, semester, subject);
		setMidterm(midterm);
		setFinals(finals);
		setPerformance(performance);
	}
	
	public Score(int grade, int semester, String subject) {
		setGrade(grade);
		setSemester(semester);
		this.subject = subject;
	}

	@Override
	public String toString() {
		double total = midterm*0.4 + finals*0.5 + performance*0.1;
		return  grade + "학년 " + semester + "학기 | " + subject + "\n[중간 : " + midterm
				+ "점, 기말 : " + finals + "점, 수행평가 : " + performance + "점]\n총점 : " + total + "점";
	}

	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		if(grade < 1 || grade > 3) {
			throw new RuntimeException("1~3 사이의 정수를 입력하세요");
		}
		this.grade = grade;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		if(semester < 1 || semester > 2) {
			throw new RuntimeException("1~3 사이의 정수를 입력하세요");
		}
		this.semester = semester;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getMidterm() {
		return midterm;
	}
	public void setMidterm(int midterm) {
		if(midterm < 0 || midterm > 100) {
			throw new RuntimeException("0~100 사이의 정수를 입력하세요");
		}
		this.midterm = midterm;
	}
	public int getFinals() {
		return finals;
	}
	public void setFinals(int finals) {
		if(finals < 0 || finals > 100) {
			throw new RuntimeException("0~100 사이의 정수를 입력하세요");
		}
		this.finals = finals;
	}
	public int getPerformance() {
		return performance;
	}
	public void setPerformance(int performance) {
		if(performance < 0 || performance > 100) {
			throw new RuntimeException("0~100 사이의 정수를 입력하세요");
		}
		this.performance = performance;
	}
	
	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (grade != other.grade)
			return false;
		if (semester != other.semester)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}//
	
	
	
}
