package java_code.java_09day;

public class 더조은고등학교 {

	public static void main(String[] args) {
		// 성적관리 시스템 생성
		// stack에 tsmo, heap에 SMOSystem 타입의 객체 생성, 그 안에는 StudentVo타입의 hong 존재, hong에는 name,kor,eng,math 변수가 있음
		SMOSystem tsmo = new SMOSystem();
		
		tsmo.showMenu("더조은 고등학교");
	}
}
