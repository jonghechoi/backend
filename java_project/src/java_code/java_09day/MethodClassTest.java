package java_code.java_09day;

public class MethodClassTest {

	public static void main(String[] args) {
		MethodClass mc = new MethodClass(); // �⺻������(MethodClass())�� �ִµ� ��� �ƹ��͵� �ذ� ����. JVM�� ������ �Ҷ� ����� ���� 
		
		mc.method1();
		mc.method2("ȫ�浿");
		mc.mehtod3(10, 20);
		System.out.println(mc.method4());
		System.out.println(mc.method5());
		mc.method2(mc.method5());
		System.out.println(mc.method6(100, 200));
		System.out.println(mc.method7(34));
	}

}
