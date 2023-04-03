package java_code.java_03day;

public class AutomaticTest_논리연산자 {

	public static void main(String[] args) {
		/*
		(5>3) || (10<5) → true || false → true // shortcut
		(10<5) ||  (5>3) → false || true → true

		(5>3) && (10<5) → true && false → false
		(10<5) &&  (5>3) → false && true → false // shortcut	
		*/

		System.out.println((5>3) || (10<5));
		System.out.println((10<5) || (5>3));
		System.out.println((5>3) && (10<5));
		System.out.println((10<5) && (5>3));
		
	}

}
