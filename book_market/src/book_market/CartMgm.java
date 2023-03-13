package book_market;
import java.util.ArrayList;

/*
 * īƮ���� ó���Ǵ� ��� �۾����� CartMgm Ŭ�������� ����
 */
public class CartMgm implements CartMgmOperation {
	// Field
	private ArrayList<CartItemVo> cartItemList;
	private Object CopyCartItemList;
	
	public CartMgm() {
		cartItemList = new ArrayList<CartItemVo>();
	}
	
	// ������ ó���� ���� private���� ������ cartItemList ������ �����ؼ� �װ��� ��������
	public Object CopyCartItemList() {
		CopyCartItemList = cartItemList.clone();
		return CopyCartItemList;
	}
	
	public void updateQty(String isbn, int qty) {
		// isbn üũ
		int idx = -1;
		for(int i=0; i<cartItemList.size(); i++) {
			if(cartItemList.get(i).getIsbn().equals(isbn)) {
				System.out.println("--- ������ ������ ������ ISBN Ȯ�� �Ϸ� ---");
				idx = i;
			}
		}
		
		// ���� ����
		if(idx != -1) {
			// ���� üũ
			int originQty = cartItemList.get(idx).getQty();
			if(originQty>qty) {
				cartItemList.get(idx).setQty(originQty - qty);
			}else if(originQty==qty) {
				cartItemList.remove(idx);
			}else {
				System.out.println("--- ������ ������ �����մϴ� ---");
			}
			
		}else {
			System.out.println("--- �ش� ������ �����ϴ� ---");
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

	// ��ٱ��� ��ü ����
	public boolean remove() {
		boolean result = false;
		if(cartItemList.size() != 0) {
			System.out.print("��ٱ��Ͽ� ��� �׸��� �����Ͻðڽ��ϱ�? (Y|N) >");
			String yesno = BookMarketSystem.scan.next().toUpperCase();
			if(yesno.equals("Y")) {
//				cartList.clear();
				cartItemList.clear();
				result = true;
				System.out.println("--- ��ٱ��� ���� �Ϸ� ---");
			}else {
				System.out.println("--- ��ٱ��� ����  ��� ---");
			}
		}else {
			System.out.println("--- ������ �����Ͱ� �����ϴ� ---");
		}
		
		return result;
	}
	
	public void showList() {
		System.out.println("***********************************************");
		System.out.println("\t����ISBN\t|\t����\t|\t�հ�");
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
		
//		return result;
		return check;
	}
}		
			

