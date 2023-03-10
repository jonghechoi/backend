package book_market;
import java.util.ArrayList;

public class CartMgm {
	// Field
	ArrayList<BookVo> cartList;
	ArrayList<CartItemVo> cartItemList;
	
	public CartMgm() {
		cartList = new ArrayList<BookVo>();
		cartItemList = new ArrayList<CartItemVo>();
	}
	
	public boolean removeCartItem(String removeIsbn) {
		boolean result = false;
		for(BookVo book : cartList) {
			if(book.getIsbn().equals(removeIsbn)) {
				result = cartList.remove(book);
			}
		}
		return result;
	}
	
	public void clearCart() {
		cartList.clear();
		System.out.println("--- 장바구니 비우기 완료 ---");
	}
	
	public void showList() {
		System.out.println("*****************************************");
		System.out.println("\t도서ISBN\t|\t수량\t|\t합계");
		System.out.println("*****************************************");
		for(CartItemVo item : cartItemList) {
			System.out.print("\t" + item.getIsbn() + " | ");
			System.out.print("\t" + item.getQty() + "\t | ");
			System.out.print("\t" + item.getTotalPrice() + "\t \n");
		}
		System.out.println("*****************************************");
	}
	
	public boolean insert(BookVo book) {
		boolean result = false;
		result = cartList.add(book);
		
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
		
		return result;
	}
}		
			

