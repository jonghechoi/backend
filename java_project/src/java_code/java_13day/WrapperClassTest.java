package java_code.java_13day;
import java.util.Scanner;

public class WrapperClassTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 기본형 데이터 타입 --> 클래스
		int number1 = 100;
		Integer number2 = new Integer(100);
		Integer number3 = new Integer("100");

//		System.out.println(number1);
//		System.out.println(System.identityHashCode(number1)); // 스택에 있는 메모리 주소 (별 의미 없음)
//		System.out.println(System.identityHashCode(number2));
//		System.out.println(System.identityHashCode(number3));
		
//		String num1 = scan.next();
//		String num2 = scan.next();
		
//		int num1 = Integer.parseInt(scan.next());
//		int num2 = Integer.parseInt(scan.next());
		
//		System.out.println("sum = " + (num1 + num2));
//		System.out.println("sum = " + (Integer.parseInt(num1) + Integer.parseInt(num2)));
		
		System.out.println("aaabbb".contains(("bbb")));
		System.out.println("aaabbb".contains(("ccc")));
		
	}

}
