package coffee_machine_oop;
import java.util.Scanner;

public class CoffeeMachineSystem {
	// Field
	MenuVo[] menuList; // �޴�����Ʈ. // ���� ��. �ּҰ��� null�� ����
	int coin = 0;		// ����
	int change = 0;
	MenuVo choice_menu; // �ֹ��޴�
	Scanner scan = new Scanner(System.in);
	
	// Constructor
	public CoffeeMachineSystem() {
		init();     // �޴� ���� 
		showMenu(); // �޴� ���
		coinCheck(); // �����Է� & üũ
		showOrderMenu(); // �ֹ����� �޴� ���
//		orderMenu(); // �޴� �ֹ�
//		getMenu(calChange());
		
	}
	
	// Method
	public void getMenu(int change) {
		System.out.println("�ֹ��Ͻ� �޴� "+ choice_menu.getName() + "�Դϴ�");
		System.out.println("�ܵ��� " + change + "�Դϴ�");
		
		System.out.print("�� �ֹ��ϰڽ��ϱ�?? (�ֹ�:�ƹ�Ű, ����:n)");
		String con = scan.next();
		if(!con.equals("n")) {
			coin = change;
			showOrderMenu();
		}else {
			System.out.println("=== ���α׷� ���� ===");
			System.exit(0);
		}
	}
	
	public int calChange() {
		System.out.println("=== �ܵ� ��� ���Դϴ� ===");
		if(coin>=choice_menu.getPrice()) {
			change = coin - choice_menu.getPrice();
		}
		return change;
	}
	
	public void orderMenu() {
		showMenu();
		System.out.print("�޴��� �������ּ���(��ȣ) >> ");
		int menu = scan.nextInt();
		
		if(coin>=400 && menu==1) {
			choice_menu = menuList[menu-1];
		}else if(coin>=300 && menu==2) {
			choice_menu = menuList[menu-1];
		}else if(coin>=300 && menu==3) {
			choice_menu = menuList[menu-1];
		}else if(coin>=200 && menu==4) {
			choice_menu = menuList[menu-1];
		}else {
			System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �޴��� �������ּ���(����)");
			orderMenu();
		}
		getMenu(calChange());
		
//		switch(menu) {
//		case 1:
//			choice_menu = menuList[menu-1]; // menuList[???]
//			break;
//		case 2:
//			choice_menu = menuList[menu-1];
//			break;
//		case 3:
//			choice_menu = menuList[menu-1];
//			break;
//		case 4:
//			choice_menu = menuList[menu-1];
//			break;
//		case 0:
//			System.out.println("=== ���α׷��� �����մϴ� ===");
//			System.exit(0);
//		default:
//			System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �޴��� �������ּ���(����)");
//		}
//		System.out.print("�����Ͻ� �޴��� " + choice_menu.getName() + "�̰� ,");
//		System.out.println("������ " + choice_menu.getPrice() + "�� �Դϴ�");
//		
//		getMenu(calChange());
	}
	
	public void showOrderMenu() {
		System.out.println("���� coin >> " + coin);
		if(coin>=200) {
			// �ֹ� �ݾ׺� �޴� ���
			if(coin>=400) {
				// ��� �޴� ���
				System.out.println("�ֹ����� �޴�: \n�Ƹ޸�ī��(1) \n��ũĿ��(2) \n������(3) \n����(4)");
			}else if(coin>=300) {
				System.out.println("�ֹ����� �޴�: \n��ũĿ��(2) \n������(3) \n����(4)");
			}else {
				System.out.println("�ֹ����� �޴�: \n����(4)");
			}
		}else {
			System.out.println("\n�ݾ��� �����մϴ�. ������ �� �Է����ּ���");
			coinCheck();
		}
		orderMenu();
		
	}
	
	
	
	public void coinCheck() {
		System.out.print("���� �Է�(����) >> ");
		coin += scan.nextInt();
		System.out.println("coin-------> " + coin);
		
		// ������ �� ���� ������ ������� ��
		System.out.print("������ �� �����ðڽ��ϱ�? (�ֹ�:n, ���:�ƹ�Ű�� ��������)");
		String con = scan.next();
		if(!con.equals("n")) {
			coinCheck(); // ���
		}else {
			if(coin<200) {
				System.out.println("���� �Աݾ��� " + coin + "�Դϴ�. ������ �� �־��ּ���!!!");
				coinCheck();
			}
		}
	}
	
	public void showMenu() {
		int num = 1;
		System.out.println("========== ���� ���Ǳ� ==========");
		for(MenuVo menu : menuList) {
			System.out.print(num+". "+menu.getName()+"\t");
			System.out.print(menu.getPrice()+"\n");
			num++;
		}
		System.out.println("0. ���α׷� ����");
		System.out.println("=============================");
		
	}
	
	public void init() {
		// 1. ���Ǳ� �޴�����Ʈ ���
		String[] nameList = {"�Ƹ޸�ī��", "��ũĿ��", "������", "����"};
		int[] priceList = {400,300,300,200};
		menuList = new MenuVo[nameList.length];
		
		for(int i=0; i<menuList.length; i++) {
			MenuVo menu = new MenuVo();
			menu.setName(nameList[i]);
			menu.setPrice(priceList[i]);
			
			menuList[i] = menu;
		}
				
	}
}
