package java_code.java_9day;

public class StudentVo {
	// Field (����/�۷ι�����)
	// �л���, ����, ����, ����
	String name; // ���������� JVM�� �˾Ƽ� �ʱ�ȭ ���ֱ� ������ = ""; �̰� ��� ��
	int kor, eng, math;
	
	//Constructor
	public StudentVo() {} // �⺻������ 
	
	// Method - ������ ��ü�� �޼ҵ�� setter(�޴� �޼ҵ� �϶��� �տ� set ����)/getter(�����ϴ� �޼ҵ� �϶��� �տ� get ����) �޼ҵ�� ����
	public void setName(String name) { // name ������ �ٸ��� �� name(�Ķ�)�� ��������, name(���)�� �������� setName �޼ҵ� �������� ��� 
		this.name = name; // this => Ŭ���� �ڱ��ڽ��� self ������ �� ���
	}
	public String getName() {
		return name;
	}
	// ����
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getKor() {
		return kor;
	}
	// ����
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getEng() {
		return eng;
	}
	// ����
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
