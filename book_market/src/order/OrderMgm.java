package order;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Calendar;

import book_market.BookMarketSystem;
import book_market.CartItemVo;
import book_market.CartMgm;

/*
 * ������ ��� Ŭ����
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
	// �ֹ� �� ���� ���� - �����, userInfo
	// �ֹ� ������ ���� ���� - cartItem
	public void insert() {
		System.out.print("������� �Է����ּ��� > ");
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
	
	// �ֹ� ��/��� ���� ǥ��
	public void showOrderInfo() {
		int total = 0;
		System.out.println("-------------- ��� ���� �� ���� --------------");
		System.out.println("���� : " + BookMarketSystem.user.getName() + "\t" + "����ó : " + BookMarketSystem.user.getPhoneNumber());
		System.out.println("����� : " + this.address + "\t" + "�߼��� : " + cal.get(cal.MONTH) + "/" 
																		    + cal.get(cal.DATE) + "/"
																		    + cal.get(cal.YEAR));
		System.out.println(" ��ٱ��� ��ǰ ��� : ");
		System.out.println("-------------------------------------------");
		System.out.println("\t����ISBN\t|\t����\t|\t�հ�");
		System.out.println("-------------------------------------------");
		for(OrderVo item : orderList) {
			System.out.print("\t" + item.getIsbn() + " | ");
			System.out.print("\t" + item.getQty() + "\t | ");
			System.out.print("\t" + item.getTotalPrice() + "\t \n");
			
			total += item.getTotalPrice();
		}
//		}
		
		System.out.println("-------------------------------------------");
		System.out.println("\t\t\t\t�ֹ� �Ѿ� : " + total);
		System.out.println("-------------------------------------------");
		
	}
	

	
}
