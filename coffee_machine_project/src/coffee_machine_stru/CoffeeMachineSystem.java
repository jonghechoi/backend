package coffee_machine_stru;
import java.util.Scanner;

public class CoffeeMachineSystem {

	public static void main(String[] args) {
		// 1. 자판기 메뉴리스트 출력
		System.out.println("========== 음료 자판기 ==========");
		System.out.println("1. 아메리카노[400]");
		System.out.println("2. 밀크커피[300]");
		System.out.println("3. 유자차[300]");
		System.out.println("4. 우유[200]");
		System.out.println("0. 종료");
		System.out.println("========== 음료 자판기 ==========");
		
		// 동전을 넣는다(입력), 최소 주문금액 이상이 될때까지 반복한다
		Scanner scan = new Scanner(System.in);
		int coin = 0;
		int change = 0;
		String orderMenu = "";
		boolean flag = true;
		boolean orderFlag = true;
		
		while(flag) {
			System.out.print("동전입력> ");
			coin += scan.nextInt();
			System.out.println("coin-------> " + coin);
			
			// 동전을 더 넣을 것인지 물어봐야 함
			System.out.print("동전을 더 넣으시겠습니까?\n(주문:n, 계속:아무키나 누르세요)");
			String con = scan.next();
			if(con.equals("n")) {
				// 잔액 200원 이상일때 다시 반복되는 부분 ------------------------------------------------------------------------------------------------------------------------------------------
					// coin을 체크하여 최소 주문금액 확인
					// 최소 주문 금액 이상인 경우
					if(coin>=200) {
						while(orderFlag) {
							// 주문 금액별 메뉴 출력
							if(coin>=400) {
								// 모든 메뉴 출력
								System.out.println("주문가능 메뉴: \n아메리카노(1) \n밀크커피(2) \n유자차(3) \n우유(4)");
							}else if(coin<400 && coin>=300) {
								System.out.println("주문가능 메뉴: \n밀크커피(2) \n유자차(3) \n우유(4)");
							}else if(coin<300 && coin>=200) {
								System.out.println("주문가능 메뉴: \n우유(4)");
							}
							// 메뉴 선택
							System.out.println("메뉴선택(숫자)> ");
							int menu = scan.nextInt();
							switch(menu) {
								case 1:
									change = coin - 400;
									orderMenu = "아메리카노";
									break;
								case 2:
									change = coin - 300;
									orderMenu = "밀크커피";
									break;
								case 3:
									change = coin - 300;
									orderMenu = "유자차";
									break;
								case 4:
									change = coin - 200;
									orderMenu = "우유";
									break;
								default:
									System.out.println("잘못입력하셨습니다. 다시 메뉴를 선택해주세요(숫자)");
							}//switch
							// 메뉴와 잔돈 전달
							System.out.printf("주문하신 메뉴 [%s]가 준비되었습니다 :) \n",orderMenu);
							System.out.printf("잔돈은 %d원 입니다 \n",change);
							
							// 잔돈이 최소주문 금액 이상이면..
							if(change>=200) {
								System.out.println("계속 주문하시겠습니까?\n(주문종료:n, 계속:아무키나 누르세요)");
								String orderCon = scan.next();
								if(orderCon.equals("n")) {
									// 주문 종료
									System.out.println("잔액은 " + change + "원입니다. 좋은 하루 보내세요");
									orderFlag = false;
									flag = false;
								}else {
									coin = change;
								}
							}else {
								//잔돈이 200원 미만인 경우 --> 종료
								orderFlag = false;
								flag = false;
							}
						}//orderFlag
					}else {
						System.out.println("\n금액이 부족합니다. 동전을 더 입력해주세요");
					}
				// ------------------------------------------------------------------------------------------------------------------------------------------
			}
		}//while
		System.out.println("\n========== 프로그램 종료 ==========");
	}//main
}//class
