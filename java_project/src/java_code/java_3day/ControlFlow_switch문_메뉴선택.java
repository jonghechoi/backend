package java_code.java_3day;
import java.util.Scanner;

public class ControlFlow_switch��_�޴����� {
	/*
	 * ���� �޴� ����
	 * 1: �����, 2: ��ġ�, 3: ���, 4: ¥���
	 */
	public static void main(String[] args) {
		// 1. �޴��� ���
		System.out.println("-------- ���� �޴� ����Ʈ -------");
		System.out.println("1. �����");
		System.out.println("2. ��ġ�");
		System.out.println("3. ���");
		System.out.println("4. ¥���");
		System.out.println("** �޴������� ���ڷ� ���ּ��� **");
		System.out.println("---------------------------");
		
		//2. �޴� �Է��� ���� Scanner ��ü ����
		Scanner scan = new Scanner(System.in);
		System.out.print("�޴�����(����)> ");
		int menu = scan.nextInt();
			
		switch(menu) {
			case 1: System.out.println("������� �����߽��ϴ�");
				break;
			case 2: System.out.println("��ġ��� �����߽��ϴ�");
				break;
			case 3: System.out.println("����� �����߽��ϴ�");
				break;
			case 4: System.out.println("¥��� �����߽��ϴ�");
				break;
			default: System.out.println("���� �޴��Դϴ�. �ٽ� �������ּ���");
		}
		
		scan.close();
		
	}

}
