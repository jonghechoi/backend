package java_code.java_9day;

public class MethodClass {
	// Field
	// Constructor
	// Method : 리턴타입, 매개변수 테스트
	// (1) 리턴타입 X, 매개변수 X
	public void method1() {
		System.out.println("리턴타입 X, 매개변수 X");
	}
	
	// (2) 리턴타입 X, 매개변수 O
	public void method2(String name) {
		System.out.println(name);
	}
	public void mehtod3(int num1, int num2) {
		System.out.println("sum = "+(num1+num2));
	}
	
	// (3) 리턴타입 O, 매개변수 X
	public int method4() {
		return 100;
	}
	public String method5() {
		return "최치열";
	}
	
	// (4) 리턴타입 O, 매개변수 O
	public int method6(int x, int y) {
		return x+y;
	}
	public boolean method7(int value) {
		boolean result = false;
		if(value%2==0) {
			result = true;
		}
		return result;
	}
}
