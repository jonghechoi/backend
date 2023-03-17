package order;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Calendar;

import book_market.BookMarketSystem;
import book_market.CartItemVo;
import book_market.CartMgm;

/*
 * 영수증 출력 클래스
 */
public class OrderMgm {
	// Field
	Calendar cal; 
	String address;
	ArrayList<OrderVo> orderList;
	OrderVo order;
	
	
	// Constructor
	public OrderMgm() {
		cal = Calendar.getInstance();
		orderList = new ArrayList<OrderVo>();
	}
	
	
	// Method
	// 주문 고객 정보 저장 - 배송지, userInfo
	// 주문 아이템 정보 저장 - cartItem
	public void insert() {
		System.out.print("배송지를 입력해주세요 > ");
		String address = BookMarketSystem.scan.next();
//		order.setAddress(address);
//		order.setUserInfo(BookMarketSystem.user);
//		order.setCartItem(BookMarketSystem.cm.cartItemList);
		
		for(int i=0; i<CartMgm.getSize2(); i++) {
			order = new OrderVo();
			order.setIsbn(CartMgm.sendIsbn(i));
			order.setQty(CartMgm.sendQty(i));
			order.setTotalPrice(CartMgm.sendTotalPrice(i));
			
			orderList.add(order);
		}
	}
	
	// 주문 고객/목록 정보 표시
	public void showOrderInfo() {
		int total = 0;
		System.out.println("-------------- 배송 받을 고객 정보 --------------");
		System.out.println("고객명 : " + BookMarketSystem.user.getName() + "\t" + "연락처 : " + BookMarketSystem.user.getPhoneNumber());
		System.out.println("배송지 : " + this.address + "\t" + "발송일 : " + cal.get(cal.MONTH) + "/" 
																		    + cal.get(cal.DATE) + "/"
																		    + cal.get(cal.YEAR));
		System.out.println(" 장바구니 상품 목록 : ");
		System.out.println("-------------------------------------------");
		System.out.println("\t도서ISBN\t|\t수량\t|\t합계");
		System.out.println("-------------------------------------------");
		for(OrderVo item : orderList) {
			System.out.print("\t" + item.getIsbn() + " | ");
			System.out.print("\t" + item.getQty() + "\t | ");
			System.out.print("\t" + item.getTotalPrice() + "\t \n");
			
			total += item.getTotalPrice();
		}
//		}
		
		System.out.println("-------------------------------------------");
		System.out.println("\t\t\t\t주문 총액 : " + total);
		System.out.println("-------------------------------------------");
		
	}
	

	
}
