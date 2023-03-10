package book_market;
import java.util.ArrayList;
import java.util.Scanner;

// 모든 시스템을 관리하는 클래스
public class BookMarketSystem extends BookMarketSystemOperationAdapter implements BookMarketSystemOperation {
	// Field
	static UserVo user;
	static Scanner scan;
	static BookMgm bm; // 같은 패키지안에 있으므로
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
	
	// 메소드 오버라이딩 -> BookMarketSystemOperationAdapter 클래스로 토스
//	public void menuUserInfo() {System.out.println("고객 정보 확인");}			
//	public void menuCartList() {System.out.println("장바구니 상품 목록 출력");}			
//	public void menuCartClear() {System.out.println("장바구니 비우기");}		
//	public void menuCartAdd() {System.out.println("장바구니 항목 추가");}			
//	public void menuCartRemoveItem() {System.out.println("장바구니 항목 삭제");}	
//	public void menuCartRemove() {System.out.println("장바구니 삭제");}		
//	public void menuCartBill() {System.out.println("영수증 표시");}			
//	public void menuExit() {System.out.println("메뉴 종료");}				
	
	// Method
	public void menuUserInfo() {
		System.out.println("현재 고객 정보 : " + user.getName());
		System.out.println("현재 고객 연락처 : " + user.getPhoneNumber());
	}
	
	public void choiceMenu() {
		Scanner scan = new Scanner(System.in);
		// try문 적용하기
		try {
			System.out.print("메뉴 번호를 선택해주세요 : ");
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
				System.out.println("번호를 잘못 입력했습니다. 재입력해주세요");
				choiceMenu();
			}
		}catch (Exception e) {
			System.out.println("잘못 입력했습니다. 재입력 해주세요");
			System.out.println(e);
			choiceMenu();
		}

	}
	
	/**메뉴 출력**/
	public void showMenu() {
		System.out.println("*********************************************");
		System.out.println("\tWelcome to Shopping Mall");
		System.out.println("\tWelcome to Book market!!");
		System.out.println("*********************************************");
		System.out.println("1. 고객 정보 확인하기 \t\t2. 장바구니 상품 목록 보기");
		System.out.println("3. 장바구니 비우기  \t\t4. 장바구니 항목 추가하기");
		System.out.println("5. 장바구니 항목 삭제하기\t6. 장바구니 삭제하기");
		System.out.println("7. 영수증 표시하기 \t\t8. 종료");
		System.out.println("*********************************************");
	}
	
	/**사용자 등록**/
	public void userInsert() {
		
		System.out.print("이름을 입력하세요 : ");
		user.setName(scan.next());
		System.out.print("연락처를 입력하세요 : ");
		user.setPhoneNumber(scan.next());

		
	}
}
