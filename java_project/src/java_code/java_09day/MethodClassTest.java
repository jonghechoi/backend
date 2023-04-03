package java_code.java_09day;

public class MethodClassTest {

	public static void main(String[] args) {
		MethodClass mc = new MethodClass(); // 기본생성자(MethodClass())가 있는데 사실 아무것도 준게 없음. JVM이 컴파일 할때 만들기 때문 
		
		mc.method1();
		mc.method2("홍길동");
		mc.mehtod3(10, 20);
		System.out.println(mc.method4());
		System.out.println(mc.method5());
		mc.method2(mc.method5());
		System.out.println(mc.method6(100, 200));
		System.out.println(mc.method7(34));
	}

}
