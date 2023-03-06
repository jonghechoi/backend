package java_code.java_2day;
import java.util.*;


public class DataTypeTest {

	public static void main(String[] args) {
		// 변수 정의(기본형) : 데이터타입 변수명 = 데이터 값;
		int number = 100;
		float fnumber = (float)10.5;
		String str = "안녕";
		
		int num1 = 100;
		int num2 = 200;
		int sum = num1 + num2;
		
		// 변수 정의(참조형) : 데이터타입(클래스) 변수명 = new 클래스생성자;
		String str2 = new String("안녕2");
		Scanner scan = new Scanner(System.in);
		
		//출력
		System.out.println("sum = " + (num1 + num2));
		System.out.println("sum = " + sum);
		System.out.println("number = " + number);
		System.out.println(fnumber);
		System.out.println(str);
		System.out.println(str2);
		System.out.println(scan);
		
	}

}