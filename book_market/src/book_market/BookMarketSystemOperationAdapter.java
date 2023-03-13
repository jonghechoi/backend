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
		System.out.println("영수증 표시");
		
		BookMarketSystem.om.insert();
		BookMarketSystem.om.showOrderInfo();
		
	}			
	public void menuExit() {System.out.println("메뉴 종료");}	
}
 