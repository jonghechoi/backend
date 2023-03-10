package book_market;
import java.util.ArrayList;
import java.util.Scanner;

// ��� �ý����� �����ϴ� Ŭ����
public class BookMarketSystem extends BookMarketSystemOperationAdapter implements BookMarketSystemOperation {
	// Field
	static UserVo user;
	static Scanner scan;
	static BookMgm bm; // ���� ��Ű���ȿ� �����Ƿ�
	static CartMgm cm;
	
	public static final int USER_INFO= 1;
	public static final int CART_LIST= 2;
	public static final int CART_CLEAR = 3;
	public static final int CART_ADD = 4;
	public static final int CART_ITEM_REMOVE = 5;
	public static final int CART_REMOVE = 6;
	public static final int CART_BILL = 7;
	public static final int EXIT = 8;
	
	// Constructor
	public BookMarketSystem()  {
		user = new UserVo();
		scan = new Scanner(System.in);
		bm = new BookMgm();
		cm = new CartMgm();
		
		userInsert();
		showMenu();
		choiceMenu();
	}
	
	// �޼ҵ� �������̵� -> BookMarketSystemOperationAdapter Ŭ������ �佺
//	public void menuUserInfo() {System.out.println("�� ���� Ȯ��");}			
//	public void menuCartList() {System.out.println("��ٱ��� ��ǰ ��� ���");}			
//	public void menuCartClear() {System.out.println("��ٱ��� ����");}		
//	public void menuCartAdd() {System.out.println("��ٱ��� �׸� �߰�");}			
//	public void menuCartRemoveItem() {System.out.println("��ٱ��� �׸� ����");}	
//	public void menuCartRemove() {System.out.println("��ٱ��� ����");}		
//	public void menuCartBill() {System.out.println("������ ǥ��");}			
//	public void menuExit() {System.out.println("�޴� ����");}				
	
	// Method
	public void menuUserInfo() {
		System.out.println("���� �� ���� : " + user.getName());
		System.out.println("���� �� ����ó : " + user.getPhoneNumber());
	}
	
	public void choiceMenu() {
		Scanner scan = new Scanner(System.in);
		// try�� �����ϱ�
		try {
			System.out.print("�޴� ��ȣ�� �������ּ��� : ");
			int menu = scan.nextInt();
			switch(menu) {
			case USER_INFO:
				menuUserInfo();
				choiceMenu();
				break;
			case CART_LIST:
				menuCartList();
				choiceMenu();
				break;
			case CART_CLEAR:
				menuCartClear();
				choiceMenu();
				break;
			case CART_ADD:
				menuCartAdd();
				choiceMenu();
				break;
			case CART_ITEM_REMOVE:
				menuCartRemoveItem();
				choiceMenu();
				break;
			case CART_REMOVE:
				menuCartRemove();
				choiceMenu();
				break;
			case CART_BILL:
				menuCartBill();
				choiceMenu();
				break;
			case EXIT:
				menuExit();
				choiceMenu();
				break;
			default:
				System.out.println("��ȣ�� �߸� �Է��߽��ϴ�. ���Է����ּ���");
				choiceMenu();
			}
		}catch (Exception e) {
			System.out.println("�߸� �Է��߽��ϴ�. ���Է� ���ּ���");
			System.out.println(e);
			choiceMenu();
		}

	}
	
	/**�޴� ���**/
	public void showMenu() {
		System.out.println("*********************************************");
		System.out.println("\tWelcome to Shopping Mall");
		System.out.println("\tWelcome to Book market!!");
		System.out.println("*********************************************");
		System.out.println("1. �� ���� Ȯ���ϱ� \t\t2. ��ٱ��� ��ǰ ��� ����");
		System.out.println("3. ��ٱ��� ����  \t\t4. ��ٱ��� �׸� �߰��ϱ�");
		System.out.println("5. ��ٱ��� �׸� �����ϱ�\t6. ��ٱ��� �����ϱ�");
		System.out.println("7. ������ ǥ���ϱ� \t\t8. ����");
		System.out.println("*********************************************");
	}
	
	/**����� ���**/
	public void userInsert() {
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		user.setName(scan.next());
		System.out.print("����ó�� �Է��ϼ��� : ");
		user.setPhoneNumber(scan.next());

		
	}
}
