package java_code.java_4day;
import java.util.Scanner;

public class ControlFlow_for��2 {

	public static void main(String[] args) {
		// Scanner Ŭ���� �̿��Ͽ� �Է¹ޱ�
		Scanner scan = new Scanner(System.in);
		System.out.print("�ʱⰪ > ");
		int startNum = scan.nextInt();
		System.out.print("������ > ");
		int finalNum = scan.nextInt();
		
		// ������ �������� �ʱⰪ���� ū ��쿡�� �����ϵ��� �Ѵ�!!
		if(startNum>finalNum) {
			System.out.println("�������� �ʱⰪ���� ŭ");
		} else {
			int sum = 0;		
			for(int i=startNum; i<finalNum+1; i++) {
				sum += i;
			}
			System.out.println("i�� ���� = " + sum);
		}
	}

}
