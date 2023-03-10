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
		System.out.println("--- ��ٱ��� ���� �Ϸ� ---");
	}
	
	public void showList() {
		System.out.println("*****************************************");
		System.out.println("\t����ISBN\t|\t����\t|\t�հ�");
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
		
		// isbn�� ó���Է� or ������ ���� isbn
		// vs
		// �̹� cartItemList�� ����ִ� isbn
		boolean check = false;
		int num = 0;
		if(cartItemList.size() != 0) { // ������ �ִ� isbn�� ������ ���� check = true;
			for(int i=0; i<cartItemList.size(); i++) {
				if(cartItemList.get(i).getIsbn().equals(book.getIsbn())) {
					check = true;
					num = i;
				}
			}
		}
				
		if(check) { // ������ �ִ� isbn�� ������
			CartItemVo item = cartItemList.get(num);
			item.setQty(cartItemList.get(num).getQty()+1);
			item.setTotalPrice(book.getPrice()*cartItemList.get(num).getQty());
		}else { // ó�� �Է� or ������ ���� isbn �Է� 
			CartItemVo item = new CartItemVo();
			item.setIsbn(book.getIsbn());
			item.setQty(1);
			item.setTotalPrice(book.getPrice());
			
			cartItemList.add(item);
		}
		
		return result;
	}
}		
			

