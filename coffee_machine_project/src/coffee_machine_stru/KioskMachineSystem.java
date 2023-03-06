package coffee_machine_stru;
import java.util.Scanner;

public class KioskMachineSystem {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// [주문하시겠습니까?(y/n)] 창 생성
		System.out.println("주문하시겠습니까?(y/n)");
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
				System.out.println("========== 메뉴 리스트 ==========");
				System.out.println("1. 아메리카노(400원)");
				System.out.println("2. 밀크커피(300원)");
				System.out.println("3. 유자차(300원)");
				System.out.println("4. 우유(200원)");
				System.out.println("0. 종료");
				System.out.println("=============================");
				
				System.out.println("주문하실 음료의 번호를 선택하세요.");
				order = scan.nextInt();
				switch(order) {
				case 1:
					System.out.println("아메리카노를 선택하였습니다.");
					menu = "아메리카노";
					break;
				case 2:
					System.out.println("밀크커피를 선택하였습니다.");
					menu = "밀크커피";
					break;
				case 3:
					System.out.println("유자차를 선택하였습니다.");
					menu = "유자차";
					break;
				case 4:
					System.out.println("우유를 선택하였습니다.");
					menu = "우유";
					break;
				default:
					while(firstFlag) {
						System.out.println("종료하시겠습니까?(y/n)");
						exitCon = scan.next();
						if(exitCon.equals("y")) {
							// 여기에 전체 종료 flag 하나 들어가야 할듯??
							firstFlag = false;
							allFlag = false;
						}else if(exitCon.equals("n")) {
							firstFlag = false;
						}else {
							System.out.println("잘못 입력하였습니다. 재입력바랍니다.(y/n)");
						}
					}
				}//switch
				
				// [현금/카드/삼성페이] 선택창 표시
				while(paymentFalg) {
					System.out.println("========== 결제수단 선택 ==========");
					System.out.println("\t 1. 현금");
					System.out.println("\t 2. 카드");
					System.out.println("\t 3. 삼성페이");
					System.out.println("========== 결제수단 선택 ==========");
					System.out.print("결제수단을 선택하십시오.");
					int paymentMethod = scan.nextInt();
					
					/*
					 *  선택한 지불방식에 따라
					 *  [현금] - 모자르면 돈 더 입력
					 *  [카드/삼성페이] - 잔고(300원)가 없으면 다시 지불수단 요구
					 *  두 지불방식 모두 결제 조건(가격)이 충족이 되면 결제 진행으로 이동
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

							System.out.printf("\n선택한 메뉴의 가격은 %d원 입니다. 현금을 넣어주세요 > ",ChoosenMenuPrice);
							cash += scan.nextInt();
							if(cash>=order) {
								System.out.printf("지불한 금액은 %d원 입니다. 결제가 진행됩니다.",cash);
								change = cash-ChoosenMenuPrice;
								System.out.printf("[%s]가 준비중입니다. 잔돈은 %d원 입니다.",menu,change);
								coinCon = false;
								paymentFalg = false;
								allFlag = false;
							}else {
								System.out.printf("금액이 부족합니다. 모자란 현금은 %d원 입니다.",(order-cash));
							}
						}else if(paymentMethod==2 || paymentMethod==3) {
							System.out.println("\n카드를 선택하였으면 카드를 꽂아주시고, 삼성페이를 선택하였다면 핸드폰을 단말기에 대주세요.");
							System.out.println("ChoosenMenuPrice의 가격 >>> " + ChoosenMenuPrice + "\n");
							if(card>=ChoosenMenuPrice) {
								System.out.printf("카드 잔고는 %d원 입니다. 결제가 진행됩니다.",card);
								System.out.printf("[%s]가 준비중입니다.",menu);
								coinCon = false;
								paymentFalg = false;
								allFlag = false;
							}else {
								System.out.printf("카드 잔고는 %d원 입니다. 다른 지불 수단을 선택하거나 다른 메뉴를 선택해주세요. \n",card);
								coinCon = false;
							}
							
	
						}else {
							System.out.println("잘못 입력하였습니다. 재입력 바랍니다.");
							coinCon = false;
						}
					}
				}
	
			}else {
				System.out.println("========== 키오스크를 종료합니다 ==========");
			}//if
		}
		

	}

}
