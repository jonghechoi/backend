package java_code.java_9day;

public class SMSystem {

	public static void main(String[] args) {
		System.out.println("더조은 고등학교의 성적관리 시스템");
		
		// 홍길동 학생정보 : test, 10, 10, 10 --> Student 클래스를 이용해 객체 생성
		StudentVo hong = new StudentVo(); // 학생정보는 Student 클래스에 있는데 이 클래스의 객체는 heap에 저장되어 있음
		hong.name = "hong";
		hong.kor = 10;
		hong.eng = 10;
		hong.math = 10; 
		// setter
		hong.setName(hong.name);
		hong.setKor(hong.kor);
		hong.setEng(100);
		hong.setMath(100);
		// getter
		System.out.println(hong.getName());
		System.out.println(hong.getKor());
		System.out.println(hong.getEng());
		System.out.println(hong.getMath());
		
		
		// test 학생정보 : test, 20, 20, 20
		StudentVo test = new StudentVo();
		test.name = "test";
		test.kor = 20;
		test.eng = 20;
		test.math = 20;

		
		// 학생 정보 출력
//		System.out.println("학생명\t국어\t영어\t수학\n");
//		System.out.println("-----------------------------------");
//		System.out.print(hong.name+"\t");
//		System.out.print(hong.kor+"\t");
//		System.out.print(hong.eng+"\t");
//		System.out.print(hong.math+"\n");
//
//		System.out.print(test.name+"\t");
//		System.out.print(test.kor+"\t");
//		System.out.print(test.eng+"\t");
//		System.out.print(test.math);
	}//main
}//lass
