package coffee_machine_stru;
import java.util.Scanner;

public class CoffeeMachineSystem {

	public static void main(String[] args) {
		// 1. ���Ǳ� �޴�����Ʈ ���
		System.out.println("========== ���� ���Ǳ� ==========");
		System.out.println("1. �Ƹ޸�ī��[400]");
		System.out.println("2. ��ũĿ��[300]");
		System.out.println("3. ������[300]");
		System.out.println("4. ����[200]");
		System.out.println("0. ����");
		System.out.println("========== ���� ���Ǳ� ==========");
		
		// ������ �ִ´�(�Է�), �ּ� �ֹ��ݾ� �̻��� �ɶ����� �ݺ��Ѵ�
		Scanner scan = new Scanner(System.in);
		int coin = 0;
		int change = 0;
		String orderMenu = "";
		boolean flag = true;
		boolean orderFlag = true;
		
		while(flag) {
			System.out.print("�����Է�> ");
			coin += scan.nextInt();
			System.out.println("coin-------> " + coin);
			
			// ������ �� ���� ������ ������� ��
			System.out.print("������ �� �����ðڽ��ϱ�?\n(�ֹ�:n, ���:�ƹ�Ű�� ��������)");
			String con = scan.next();
			if(con.equals("n")) {
				// �ܾ� 200�� �̻��϶� �ٽ� �ݺ��Ǵ� �κ� ------------------------------------------------------------------------------------------------------------------------------------------
					// coin�� üũ�Ͽ� �ּ� �ֹ��ݾ� Ȯ��
					// �ּ� �ֹ� �ݾ� �̻��� ���
					if(coin>=200) {
						while(orderFlag) {
							// �ֹ� �ݾ׺� �޴� ���
							if(coin>=400) {
								// ��� �޴� ���
								System.out.println("�ֹ����� �޴�: \n�Ƹ޸�ī��(1) \n��ũĿ��(2) \n������(3) \n����(4)");
							}else if(coin<400 && coin>=300) {
								System.out.println("�ֹ����� �޴�: \n��ũĿ��(2) \n������(3) \n����(4)");
							}else if(coin<300 && coin>=200) {
								System.out.println("�ֹ����� �޴�: \n����(4)");
							}
							// �޴� ����
							System.out.println("�޴�����(����)> ");
							int menu = scan.nextInt();
							switch(menu) {
								case 1:
									change = coin - 400;
									orderMenu = "�Ƹ޸�ī��";
									break;
								case 2:
									change = coin - 300;
									orderMenu = "��ũĿ��";
									break;
								case 3:
									change = coin - 300;
									orderMenu = "������";
									break;
								case 4:
									change = coin - 200;
									orderMenu = "����";
									break;
								default:
									System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �޴��� �������ּ���(����)");
							}//switch
							// �޴��� �ܵ� ����
							System.out.printf("�ֹ��Ͻ� �޴� [%s]�� �غ�Ǿ����ϴ� :) \n",orderMenu);
							System.out.printf("�ܵ��� %d�� �Դϴ� \n",change);
							
							// �ܵ��� �ּ��ֹ� �ݾ� �̻��̸�..
							if(change>=200) {
								System.out.println("��� �ֹ��Ͻðڽ��ϱ�?\n(�ֹ�����:n, ���:�ƹ�Ű�� ��������)");
								String orderCon = scan.next();
								if(orderCon.equals("n")) {
									// �ֹ� ����
									System.out.println("�ܾ��� " + change + "���Դϴ�. ���� �Ϸ� ��������");
									orderFlag = false;
									flag = false;
								}else {
									coin = change;
								}
							}else {
								//�ܵ��� 200�� �̸��� ��� --> ����
								orderFlag = false;
								flag = false;
							}
						}//orderFlag
					}else {
						System.out.println("\n�ݾ��� �����մϴ�. ������ �� �Է����ּ���");
					}
				// ------------------------------------------------------------------------------------------------------------------------------------------
			}
		}//while
		System.out.println("\n========== ���α׷� ���� ==========");
	}//main
}//class
