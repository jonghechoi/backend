package score_mgm_stru;

import java.util.Scanner;

public class ScoreMgmSystem {

	public static void main(String[] args) {
		//1. �޴� ���
		System.out.println("==============================");
		System.out.println("\t���� ���� �ý���");
		System.out.println("------------------------------");
		System.out.println("  1. ���� ���");
		System.out.println("  2. ���� ��ȸ(��ü)");
		System.out.println("  3. ���� �˻�");
		System.out.println("  4. ���� ����");
		System.out.println("  5. ���� ����");
		System.out.println("  0. ���α׷� ����");
		System.out.println("==============================");
		
		//2. �޴� ����
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.print("�޴�����(����)> ");
			int menu = scan.nextInt();
			
			switch(menu) {
				case 1 : //���
					System.out.println("���");
					break;
				case 2: //��ȸ(��ü)
					System.out.println("��ȸ");
					break;
				case 3: //�˻�
					System.out.println("�˻�");
					break;
				case 4: //����
					System.out.println("����");
					break;
				case 5: //����
					System.out.println("����");
					break;
				case 0: //���α׷� ����
					System.out.println("���α׷��� �����մϴ�.");
					flag = false;
					//System.exit(0);
					break;
				default: //�޴� �̿��� �ٸ� ���� �Է� ��
					System.out.println("�ٸ� �޴��� �������ּ���");
			}//switch
		}//while
		
		System.out.println("-- ���μ��� ���� --");
	}//main

}//class










