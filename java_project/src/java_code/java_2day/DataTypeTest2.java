package java_code.java_2day;

public class DataTypeTest2 {

	public static void main(String[] args) {
		// 로컬(지역,멤버) 변수 정의
		// 4바이트 정수형 변수  num에 100을 저장
		int num = 100;
		// 8바이트 실수형 변수 fnum에 3.14를 저장
		double fnum = 3.14;
		// 1바이트 문자형 변수 s1에 '홍'을 저장
		char s1 = '홍';
		// 기본 문자형 변수에 s2에 "홍길동"을 저장
		String s2 = "홍길동";
		// 객체 타입 문자형 변수 s3에 "홍길동"을 저장
		String s3 = new String("홍길동");

		//출력
		System.out.println("num = " + num);
		System.out.println("fnum = " + fnum);
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		System.out.println("s3 = " + s3);
		System.out.println("s2==s3 --> " + (s2==s3));
		// 왜 false 나오나?? 스택에 있는 s3의 값은 "홍길동"의 주소값
		System.out.println(s3.hashCode());
		// 따라서 문자데이터 비교는 equals를 써라. equals 메소드는 힙에 있는 데이터까지 가져옴
		System.out.println("s2.equals(s3) -- > " + (s2.equals(s3)));
	}

}
