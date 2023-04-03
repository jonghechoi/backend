package score_mgm_oop_arrayList;

public class ScoreVo {
	//Field
	String sid, name, sdate;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	int rno, kor, eng, math;
	double tot, avg;
	
	
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public void setTot(double tot) {
		this.tot = tot;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public double getTot() {
		return kor + eng + math;
	}
	public double getAvg() {
		return getTot()/3.0;
	}
	
	
	
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
}
