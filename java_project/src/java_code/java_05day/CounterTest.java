package java_code.java_5day;
import java.util.Scanner;

public class CounterTest {

	public static void main(String[] args) {
		// ������ ���ڸ� �Է¹޾� Ȧ��, ¦���� ������ ���
		// ��) 7, 1, 10, 5, 33, 65, 0[����]
		// ���) Ȧ��:5, ¦��:1
		
		// 1. ������ ���ڸ� �Է¹޴´�. ��, 0�� �Է½� ����
		
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		int odd = 0; // Ȧ�� ����
		int even = 0; // ¦�� ����
		System.out.println("���� �Է½� 0�� �ԷµǸ� ����!!");
		while(flag) {
			System.out.print("���� �Է��ϼ��� >> ");
			int number = scan.nextInt();
			
			if(number!=0) {
				// ����
				if(number%2==0) {
					System.out.println("¦��");
					even++;
				}else {
					System.out.println("Ȧ��");
					odd++;
				}
			}else {
				// ����
				flag = false;
			}
		}//while
		
		System.out.printf("Ȧ��: %d, ¦��: %d %n",odd,even);
		System.out.println(" ====== ���α׷� ���� ======");
		
	}//main

}//class
