package java_code.java_09day;
import java.util.Scanner;

public class ��������б� {

	public static void main(String[] args) {
		// �������� �ý��� ����
		Scanner scan = new Scanner(System.in);
		SMOSystem gsmo = new SMOSystem();
		
		// �̷��� ����� SMSystem Ŭ�������� main�� �ֱ� ������ �ȵ� (��Ȯ�� main�� ����?)
		// SMSystem gsmo = new SMSystem();
		
		gsmo.showMenu("���� ����б�");
//		System.out.println("�� ���� �л��� �Է� �Ͻðڽ��ϱ�?");
//		int size = scan.nextInt();
		boolean result = true;
		while(result) {
			result = gsmo.choiceMenu();
		}
	}

}
