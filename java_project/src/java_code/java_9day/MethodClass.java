package java_code.java_9day;

public class MethodClass {
	// Field
	// Constructor
	// Method : ����Ÿ��, �Ű����� �׽�Ʈ
	// (1) ����Ÿ�� X, �Ű����� X
	public void method1() {
		System.out.println("����Ÿ�� X, �Ű����� X");
	}
	
	// (2) ����Ÿ�� X, �Ű����� O
	public void method2(String name) {
		System.out.println(name);
	}
	public void mehtod3(int num1, int num2) {
		System.out.println("sum = "+(num1+num2));
	}
	
	// (3) ����Ÿ�� O, �Ű����� X
	public int method4() {
		return 100;
	}
	public String method5() {
		return "��ġ��";
	}
	
	// (4) ����Ÿ�� O, �Ű����� O
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
