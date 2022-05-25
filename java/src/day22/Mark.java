package day22;

public class Mark {
	//필드
	private int grade; //학년
	private int semester; //학기
	private String subject; //과목
	private int midterm, finals, pA; //점수
	
	//생성자
	public Mark(int grade, int semester, String subject, int midterm, int finals, int pA) {
		setGrade(grade);
		setSemester(semester);
		this.subject = subject;
		setMidterm(midterm);
		setFinals(finals);
		setPA(pA);
	}
	
	//생성자
	public Mark(int grade, int semester, String subject) {
		setGrade(grade);
		setSemester(semester);
		this.subject = subject;
	}//
	
	//수정
	public void modify(int midterm, int finals, int pA) {
		setMidterm(midterm);
		setFinals(finals);
		setPA(pA);
	}

	//toString
	@Override
	public String toString() {
		return  grade + "학년 " + semester + "학기 | " + subject + "\n[중간 : " + midterm
				+ "점, 기말 : " + finals + "점, 수행평가 : " + pA+ "점]";
	}

	//getter setter
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
	public int getPA() {
		return pA;
	}
	public void setPA(int pA) {
		if(pA < 0 || pA > 100) {
			throw new RuntimeException("0~100 사이의 정수를 입력하세요");
		}
		this.pA = pA;
	}//
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mark other = (Mark) obj;
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
	}
	
	



	
	
	
	
	
	
	
	
}
