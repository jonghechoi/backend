package java_code.java_2day;
import java.util.*;


public class DataTypeTest {

	public static void main(String[] args) {
		// ���� ����(�⺻��) : ������Ÿ�� ������ = ������ ��;
		int number = 100;
		float fnumber = (float)10.5;
		String str = "�ȳ�";
		
		int num1 = 100;
		int num2 = 200;
		int sum = num1 + num2;
		
		// ���� ����(������) : ������Ÿ��(Ŭ����) ������ = new Ŭ����������;
		String str2 = new String("�ȳ�2");
		Scanner scan = new Scanner(System.in);
		
		//���
		System.out.println("sum = " + (num1 + num2));
		System.out.println("sum = " + sum);
		System.out.println("number = " + number);
		System.out.println(fnumber);
		System.out.println(str);
		System.out.println(str2);
		System.out.println(scan);
		
	}

}