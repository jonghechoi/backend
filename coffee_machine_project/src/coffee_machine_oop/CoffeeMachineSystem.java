package coffee_machine_oop;
import java.util.Scanner;

public class CoffeeMachineSystem {
	// Field
	MenuVo[] menuList; // 메뉴리스트. // 선언만 함. 주소값은 null인 상태
	int coin = 0;		// 동전
	int change = 0;
	MenuVo choice_menu; // 주문메뉴
	Scanner scan = new Scanner(System.in);
	
	// Constructor
	public CoffeeMachineSystem() {
		init();     // 메뉴 생성 
		showMenu(); // 메뉴 출력
		coinCheck(); // 도전입력 & 체크
		showOrderMenu(); // 주문가능 메뉴 출력
		orderMenu(); // 메뉴 주문
		getMenu(calChange());
		
	}
	
	// Method
	public void getMenu(int change) {
		System.out.println("주문하신 메뉴 "+ choice_menu.getName() + "입니다");
		System.out.println("잔돈은 " + change + "입니다");
		
		if(change>=200) {
			System.out.print("더 주문하겠습니까?? (주문:아무키, 종료:n)");
			String con = scan.next();
			if(con.equals("n")) {
				System.exit(0);
			}else {
				coin = change;
				showOrderMenu();
			}
		}
	}
	
	public int calChange() {
		System.out.println("=== 잔돈 계산 중입니다 ===");
		if(coin>choice_menu.getPrice()) {
			change = coin - choice_menu.getPrice();
		}
		return change;
	}
	
	public void orderMenu() {
		System.out.print("메뉴를 선택해주세요(번호) >> ");
		int menu = scan.nextInt();
		
		switch(menu) {
		case 1:
			choice_menu = menuList[menu-1]; // menuList[???]
			break;
		case 2:
			choice_menu = menuList[menu-1];
			break;
		case 3:
			choice_menu = menuList[menu-1];
			break;
		case 4:
			choice_menu = menuList[menu-1];
			break;
		case 0:
			System.out.println("=== 프로그램을 종료합니다 ===");
			System.exit(0);
		default:
			System.out.println("잘못입력하셨습니다. 다시 메뉴를 선택해주세요(숫자)");
		}
		System.out.print("선택하신 메뉴는 " + choice_menu.getName() + "이고 ,");
		System.out.println("가격은 " + choice_menu.getPrice() + "원 입니다");
	}
	
	public void showOrderMenu() {
		System.out.println("남은 coin >> " + coin);
		if(coin>=200) {
			// 주문 금액별 메뉴 출력
			if(coin>=400) {
				// 모든 메뉴 출력
				System.out.println("주문가능 메뉴: \n아메리카노(1) \n밀크커피(2) \n유자차(3) \n우유(4)");
			}else if(coin>=300) {
				System.out.println("주문가능 메뉴: \n밀크커피(2) \n유자차(3) \n우유(4)");
			}else {
				System.out.println("주문가능 메뉴: \n우유(4)");
			}
		}else {
			System.out.println("\n금액이 부족합니다. 동전을 더 입력해주세요");
			coinCheck();
		}
		orderMenu();
		
	}
	
	
	
	public void coinCheck() {
		System.out.print("동전 입력(숫자) >> ");
		coin += scan.nextInt();
		System.out.println("coin-------> " + coin);
		
		// 동전을 더 넣을 것인지 물어봐야 함
		System.out.print("동전을 더 넣으시겠습니까? (주문:n, 계속:아무키나 누르세요)");
		String con = scan.next();
		if(!con.equals("n")) {
			coinCheck(); // 재귀
		}else {
			if(coin<200) {
				System.out.println("현재 입금액은 " + coin + "입니다. 동전을 더 넣어주세요!!!");
				coinCheck();
			}
		}
	}
	
	public void showMenu() {
		int num = 1;
		System.out.println("========== 음료 자판기 ==========");
		for(MenuVo menu : menuList) {
			System.out.print(num+". "+menu.getName()+"\t");
			System.out.print(menu.getPrice()+"\n");
			num++;
		}
		System.out.println("0. 프로그램 종료");
		System.out.println("=============================");
	}
	
	public void init() {
		// 1. 자판기 메뉴리스트 출력
		String[] nameList = {"아메리카노", "밀크커피", "유자차", "우유"};
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
