package book_market;
import java.util.ArrayList;

/*
 * 카트에서 처리되는 모든 작업들은 CartMgm 클래스에서 구현
 */
public class CartMgm implements CartMgmOperation {
	// Field
	private ArrayList<CartItemVo> cartItemList;
	private Object CopyCartItemList;
	
	public CartMgm() {
		cartItemList = new ArrayList<CartItemVo>();
	}
	
	// 영수증 처리를 위해 private으로 설정된 cartItemList 변수를 복제해서 그것을 돌려주자
	public Object CopyCartItemList() {
		CopyCartItemList = cartItemList.clone();
		return CopyCartItemList;
	}
	
	public void updateQty(String isbn, int qty) {
		// isbn 체크
		int idx = -1;
		for(int i=0; i<cartItemList.size(); i++) {
			if(cartItemList.get(i).getIsbn().equals(isbn)) {
				System.out.println("--- 수량을 차감을 도서의 ISBN 확인 완료 ---");
				idx = i;
			}
		}
		
		// 수량 차감
		if(idx != -1) {
			// 수량 체크
			int originQty = cartItemList.get(idx).getQty();
			if(originQty>qty) {
				cartItemList.get(idx).setQty(originQty - qty);
			}else if(originQty==qty) {
				cartItemList.remove(idx);
			}else {
				System.out.println("--- 차감할 수량이 부족합니다 ---");
			}
			
		}else {
			System.out.println("--- 해당 도서가 없습니다 ---");
		}
	}
	
	public int getSize() {
		return cartItemList.size();
	}
	
	public boolean remove(String isbn) {
		boolean result = false; 
		int idx = -1;
		for(int i=0; i<cartItemList.size(); i++) {
			CartItemVo item = cartItemList.get(i);
			if(item.getIsbn().equals(isbn)) {
				idx = i;
				result = true;
			}
		}
		
		if(idx != -1) {
			cartItemList.remove(cartItemList.get(idx));
		}
		
		return result;
	}

	// 장바구니 전체 삭제
	public boolean remove() {
		boolean result = false;
		if(cartItemList.size() != 0) {
			System.out.print("장바구니에 모든 항목을 삭제하시겠습니까? (Y|N) >");
			String yesno = BookMarketSystem.scan.next().toUpperCase();
			if(yesno.equals("Y")) {
//				cartList.clear();
				cartItemList.clear();
				result = true;
				System.out.println("--- 장바구니 비우기 완료 ---");
			}else {
				System.out.println("--- 장바구니 비우기  취소 ---");
			}
		}else {
			System.out.println("--- 삭제할 데이터가 없습니다 ---");
		}
		
		return result;
	}
	
	public void showList() {
		System.out.println("***********************************************");
		System.out.println("\t도서ISBN\t|\t수량\t|\t합계");
		System.out.println("***********************************************");
		for(CartItemVo item : cartItemList) {
			System.out.print("\t" + item.getIsbn() + " | ");
			System.out.print("\t" + item.getQty() + "\t | ");
			System.out.print("\t" + item.getTotalPrice() + "\t \n");
		}
		System.out.println("***********************************************");
	}
	
	public boolean insert(BookVo book) {
//		boolean result = false;
//		result = cartList.add(book);
		
		// isbn을 처음입력 or 기존에 없던 isbn
		// vs
		// 이미 cartItemList에 들어있는 isbn
		boolean check = false;
		int num = 0;
		if(cartItemList.size() != 0) { // 기존에 있던 isbn이 들어왔을 때만 check = true;
			for(int i=0; i<cartItemList.size(); i++) {
				if(cartItemList.get(i).getIsbn().equals(book.getIsbn())) {
					check = true;
					num = i;
				}
			}
		}
				
		if(check) { // 기존에 있는 isbn이 들어오면
			CartItemVo item = cartItemList.get(num);
			item.setQty(cartItemList.get(num).getQty()+1);
			item.setTotalPrice(book.getPrice()*cartItemList.get(num).getQty());
		}else { // 처음 입력 or 기존에 없던 isbn 입력 
			CartItemVo item = new CartItemVo();
			item.setIsbn(book.getIsbn());
			item.setQty(1);
			item.setTotalPrice(book.getPrice());
			
			cartItemList.add(item);
		}
		
//		return result;
		return check;
	}
}		
			

