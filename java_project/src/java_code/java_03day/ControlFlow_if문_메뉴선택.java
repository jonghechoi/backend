package java_code.java_03day;
import java.util.Scanner;

public class ControlFlow_if��_�޴����� {
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
		
		if(menu==1) {
			System.out.println("������� �����߽��ϴ�");
		} else if(menu==2) {
			System.out.println("��ġ��� �����߽��ϴ�");
		} else if(menu==3) {
			System.out.println("����� �����߽��ϴ�");
		} else if(menu==4) {
			System.out.println("¥��� �����߽��ϴ�");
		} else {
			System.out.println("���� �޴��Դϴ�. �ٽ� �������ּ���");
		}
		
		scan.close(); // ���� ���ص� main �޼ҵ尡 ������ �� ��ü�� �����.
		
	}

}
