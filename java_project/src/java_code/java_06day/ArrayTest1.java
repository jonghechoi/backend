package java_code.java_6day;
import java.util.Scanner;

public class ArrayTest1 {

	public static void main(String[] args) {
		// �迭 ����
		int[] numberList1 = new int[10]; // �迭 ���� default ���� ��� 0 
		int numberList2[] = new int[4];
		int[] numberList3 = new int[] {10,20,30}; // default: 10,20,30
		int[] numberList4 = {100,200,300};
		int[] numberList5 = null; // heap�� ������ ��ü�� �ּҰ� ��� �����̴�!
		Scanner scan = null; // ���߿� ������ Scanner ��ü�� �ּҰ� ��� ����
		
		// numberList1�� 7��° �ڸ��� 100�� �Է�
		numberList1[6] = 100;
		
		// numberList1 ��ü�� ������ ���(�ε��� ����)
		for(int i=0;i<numberList1.length;i++) {
			System.out.println(i + " = " + numberList1[i]);
		}
		
		// numberList1 ��ü�� ������ ���(�ε��� ����)
		for(int i:numberList1) {
			System.out.println(i);
		}
	}

}
