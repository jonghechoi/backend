package coffee_machine_stru;
import java.util.Scanner;

public class KioskMachineSystem {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// [�ֹ��Ͻðڽ��ϱ�?(y/n)] â ����
		System.out.println("�ֹ��Ͻðڽ��ϱ�?(y/n)");
		String orderCon = scan.next();
		int order = 0; 
		int cash = 0;
		int card = 300;
		int change = 0;
		int ChoosenMenuPrice = 0;
		String menu = "";
		String exitCon = "";
		boolean allFlag = true;
		boolean firstFlag = true;
		boolean paymentFalg = true;
		boolean coinCon = true;
		
		while(allFlag) {
			if (orderCon.equals("y")) {
				System.out.println("========== �޴� ����Ʈ ==========");
				System.out.println("1. �Ƹ޸�ī��(400��)");
				System.out.println("2. ��ũĿ��(300��)");
				System.out.println("3. ������(300��)");
				System.out.println("4. ����(200��)");
				System.out.println("0. ����");
				System.out.println("=============================");
				
				System.out.println("�ֹ��Ͻ� ������ ��ȣ�� �����ϼ���.");
				order = scan.nextInt();
				switch(order) {
				case 1:
					System.out.println("�Ƹ޸�ī�븦 �����Ͽ����ϴ�.");
					menu = "�Ƹ޸�ī��";
					break;
				case 2:
					System.out.println("��ũĿ�Ǹ� �����Ͽ����ϴ�.");
					menu = "��ũĿ��";
					break;
				case 3:
					System.out.println("�������� �����Ͽ����ϴ�.");
					menu = "������";
					break;
				case 4:
					System.out.println("������ �����Ͽ����ϴ�.");
					menu = "����";
					break;
				default:
					while(firstFlag) {
						System.out.println("�����Ͻðڽ��ϱ�?(y/n)");
						exitCon = scan.next();
						if(exitCon.equals("y")) {
							// ���⿡ ��ü ���� flag �ϳ� ���� �ҵ�??
							firstFlag = false;
							allFlag = false;
						}else if(exitCon.equals("n")) {
							firstFlag = false;
						}else {
							System.out.println("�߸� �Է��Ͽ����ϴ�. ���Է¹ٶ��ϴ�.(y/n)");
						}
					}
				}//switch
				
				// [����/ī��/�Ｚ����] ����â ǥ��
				while(paymentFalg) {
					System.out.println("========== �������� ���� ==========");
					System.out.println("\t 1. ����");
					System.out.println("\t 2. ī��");
					System.out.println("\t 3. �Ｚ����");
					System.out.println("========== �������� ���� ==========");
					System.out.print("���������� �����Ͻʽÿ�.");
					int paymentMethod = scan.nextInt();
					
					/*
					 *  ������ ���ҹ�Ŀ� ����
					 *  [����] - ���ڸ��� �� �� �Է�
					 *  [ī��/�Ｚ����] - �ܰ�(300��)�� ������ �ٽ� ���Ҽ��� �䱸
					 *  �� ���ҹ�� ��� ���� ����(����)�� ������ �Ǹ� ���� �������� �̵�
					 */
					coinCon = true;
					while(coinCon) {
						switch(order) {
							case 1:
								ChoosenMenuPrice = 400;
								break;
							case 2:
								ChoosenMenuPrice = 300;
								break;
							case 3:
								ChoosenMenuPrice = 300;
								break;
							case 4:
								ChoosenMenuPrice = 200;
								break;
						}	
						if(paymentMethod==1) {

							System.out.printf("\n������ �޴��� ������ %d�� �Դϴ�. ������ �־��ּ��� > ",ChoosenMenuPrice);
							cash += scan.nextInt();
							if(cash>=order) {
								System.out.printf("������ �ݾ��� %d�� �Դϴ�. ������ ����˴ϴ�.",cash);
								change = cash-ChoosenMenuPrice;
								System.out.printf("[%s]�� �غ����Դϴ�. �ܵ��� %d�� �Դϴ�.",menu,change);
								coinCon = false;
								paymentFalg = false;
								allFlag = false;
							}else {
								System.out.printf("�ݾ��� �����մϴ�. ���ڶ� ������ %d�� �Դϴ�.",(order-cash));
							}
						}else if(paymentMethod==2 || paymentMethod==3) {
							System.out.println("\nī�带 �����Ͽ����� ī�带 �Ⱦ��ֽð�, �Ｚ���̸� �����Ͽ��ٸ� �ڵ����� �ܸ��⿡ ���ּ���.");
							System.out.println("ChoosenMenuPrice�� ���� >>> " + ChoosenMenuPrice + "\n");
							if(card>=ChoosenMenuPrice) {
								System.out.printf("ī�� �ܰ�� %d�� �Դϴ�. ������ ����˴ϴ�.",card);
								System.out.printf("[%s]�� �غ����Դϴ�.",menu);
								coinCon = false;
								paymentFalg = false;
								allFlag = false;
							}else {
								System.out.printf("ī�� �ܰ�� %d�� �Դϴ�. �ٸ� ���� ������ �����ϰų� �ٸ� �޴��� �������ּ���. \n",card);
								coinCon = false;
							}
							
	
						}else {
							System.out.println("�߸� �Է��Ͽ����ϴ�. ���Է� �ٶ��ϴ�.");
							coinCon = false;
						}
					}
				}
	
			}else {
				System.out.println("========== Ű����ũ�� �����մϴ� ==========");
			}//if
		}
		

	}

}
