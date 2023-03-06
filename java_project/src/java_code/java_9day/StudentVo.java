package java_code.java_9day;

public class StudentVo {
	// Field (전역/글로벌변수)
	// 학생명, 국어, 영어, 수학
	String name; // 전역변수는 JVM이 알아서 초기화 해주기 때문에 = ""; 이거 없어도 됨
	int kor, eng, math;
	
	//Constructor
	public StudentVo() {} // 기본생성자 
	
	// Method - 데이터 객체의 메소드는 setter(받는 메소드 일때는 앞에 set 붙임)/getter(전달하는 메소드 일때는 앞에 get 붙임) 메소드로 구현
	public void setName(String name) { // name 색깔이 다른데 위 name(파랑)은 전역변수, name(노랑)은 지역변수 setName 메소드 내에서만 사용 
		this.name = name; // this => 클래스 자기자신을 self 참조할 때 사용
	}
	public String getName() {
		return name;
	}
	// 국어
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getKor() {
		return kor;
	}
	// 영어
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getEng() {
		return eng;
	}
	// 수학
	public void setMath(int math) {
		this.math = math;
	}
	public int getMath() {
		return math;
	}
	public int getTot() {
		return getKor()+getEng()+getMath();
//		tot = kor+eng+math;
//		return tot;
	}
	public double getAvg() {
		return getTot()/3.0;
	}
}
