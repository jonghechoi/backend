package java_code.java_6day;
import java.util.Scanner;

public class ArrayTest3 {

	public static void main(String[] args) {
		// Scanner Ŭ������ 3�� �����Ͽ� �迭�� ����
		Scanner[] scanList = new Scanner[3]; // heap�� Scanner ��ü�� 3�� ��������� ���� ���� �ƴ�!!! �켱�� �ּ�(�ʱⰪ null) �� �� 3���� ����
		
//		System.out.println(scanList[0]);
//		System.out.println(scanList[1]);
//		System.out.println(scanList[2]);
		
		scanList[0] = new Scanner(System.in);
		
		for(int i=0;i<scanList.length;i++) {
			System.out.println(scanList[i]);
		}

	}

}
