package book_market;

/*
 * 인터페이스를 오버라이딩 할 클래스라는 느낌 먼저 받고
 * BookMarketSystem에서 BookMarketSystemOperation 인터페이스로 오버라이딩 된 코드를 작성하려면
 * 너무 길어지기 때문에 따로 뺌
 */
public class BookMarketSystemOperationAdapter implements BookMarketSystemOperation {
	public void menuUserInfo() {
		System.out.println("고객 이름 : " + BookMarketSystem.user.getName());
	}			
	
	public void menuCartList() {
		BookMarketSystem.cm.showList();
	}			
	
	public void menuCartClear() {
		BookMarketSystem.cm.remove();
	}	
	
	public void menuCartAdd() {
		System.out.println("장바구니 항목 추가");
		BookMarketSystem.bm.showList();
		 
		System.out.print("장바구니에 추가할 도서의 ISBN을 입력하세요 : ");
		String orderIsbn = BookMarketSystem.scan.next().toUpperCase();
		BookVo book = BookMarketSystem.bm.search(orderIsbn);
		if(book != null) {
			// 장바구니에 추가
			System.out.print("장바구니에 추가 하시겠습니까? Y | N > ");
			String cartAdd = BookMarketSystem.scan.next().toUpperCase();

			if(cartAdd.equals("Y")) {
				if(BookMarketSystem.cm.insert(book)) {
					System.out.println("장바구니 추가 완료");
					System.out.println(BookMarketSystem.cm.getSize());
				}else {
					System.out.println("장바구니 추가 실패");
				}
			}else {
				System.out.println("장바구니에 추가하지 않습니다.");
			}
		}else {
			System.out.println("도서가 존재하지 않습니다.");
		}
		
	}			
	
	// 장바구니 수량 줄이기
	public void menuCartRemoveItem() {
		if(BookMarketSystem.cm.getSize() != 0) {
			BookMarketSystem.cm.showList();
			System.out.print("수량을 차감할 도서의 ISBN을 입력해주세요 : ");
			String isbn = BookMarketSystem.scan.next().toUpperCase();
			System.out.print("수량을 입력해주세요 : ");
			int qty = BookMarketSystem.scan.nextInt();
			
			BookMarketSystem.cm.updateQty(isbn, qty);
			
		}else {
			System.out.println("--- 장바구니가 비어있습니다 ---");
		}
		
	}	
	
	// 장바구니 항목 삭제
	public void menuCartRemove() {
		if(BookMarketSystem.cm.getSize() != 0) {
			BookMarketSystem.cm.showList();
			System.out.print("장바구니에서 삭제할 도서의 isbn을 입력하세요 > ");
			String isbn = BookMarketSystem.scan.next().toUpperCase();
			
			boolean result = BookMarketSystem.cm.remove(isbn);;
			if(result) {
				System.out.println("--- 해당 장바구니 항목 삭제 완료 ---");
			}else {
				System.out.println("--- 장바구니 항목 삭제 실패 ---");
			}
		}else {
			System.out.println("--- 삭제할 데이터가 존재하지 않습니다 ---");
		}
	}		
	
	public void menuCartBill() {
		// 장바구니에 item이 하나라도 있는 경우에만 영수증 출력
		if(BookMarketSystem.cm.getSize() != 0) {
			System.out.print("배송받을 분의 고객정보와 같습니까? Y|N > ");
			String userConfirm = BookMarketSystem.scan.next().toUpperCase();
			BookMarketSystem.scan.nextLine();
			OrderUserVo orderUser = new OrderUserVo();
			if(userConfirm.equals("Y")) {
				/*
				 * user -> orderUser 변경
				 */
				orderUser = (OrderUserVo)BookMarketSystem.user;
				
				System.out.print("배송지를 입력해주세요 > ");
				String addr = BookMarketSystem.scan.nextLine();
				orderUser.setAddress(addr);
				
				System.out.println("-------------- 배송 받을 고객 정보 --------------");
				System.out.print("고객명 : " + orderUser.getName() + "\t"); 
				System.out.print("연락처 : " + orderUser.getPhoneNumber() + "\n");
				System.out.print("배송지 : " + orderUser.getAddress() + "\t");
				System.out.print("발송일 : " + orderUser.getDate() + "\n");
				System.out.print("장바구니 상품 목록 : \n");
				BookMarketSystem.cm.showList("주문 총금액 : ");
			}else {
				// orderUser 정보 입력 -> 이름, 연락처, 배송지
				System.out.print("이름을 입력해주세요 > ");
				orderUser.setName(BookMarketSystem.scan.next());
				System.out.print("연락처를 입력해주세요 > ");
				orderUser.setPhoneNumber(BookMarketSystem.scan.next());
				BookMarketSystem.scan.nextLine();
				System.out.print("배송지를 입력해주세요 > ");
				orderUser.setAddress(BookMarketSystem.scan.nextLine());
				
				System.out.println("-------------- 배송 받을 고객 정보 --------------");
				System.out.print("고객명 : " + orderUser.getName() + "\t"); 
				System.out.print("연락처 : " + orderUser.getPhoneNumber() + "\n");
				System.out.print("배송지 : " + orderUser.getAddress() + "\t");
				System.out.print("발송일 : " + orderUser.getDate() + "\n");
				System.out.print("장바구니 상품 목록 : \n");
				BookMarketSystem.cm.showList("주문 총금액 : ");
			}
		}else {
			System.out.println("--- 장바구니가 비어있습니다 ---");
		}
		
		
		
//		BookMarketSystem.om.insert();
//		BookMarketSystem.om.showOrderInfo();
		
	}			
	public void menuExit() {System.out.println("메뉴 종료");}	
}
 