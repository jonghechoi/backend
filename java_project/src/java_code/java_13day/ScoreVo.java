package java_code.java_13day;

public class ScoreVo {
	// Field
	private String name;
	private int kor, eng, math;
	private double tot, avg;
	
	// Constructor
	public ScoreVo(String name , int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public ScoreVo(String name) {
		this(name,0,0,0);
	}
	
	// Method
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public double getTot() {
		this.tot = kor+eng+math; // 묵시적 형변환
		return tot;
	}
	public void setTot(double tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return Math.floor(getTot()/3.0);
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	

}
