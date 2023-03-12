package book_market;

/*
 * �������̽��� �������̵� �� Ŭ������� ���� ���� �ް�
 * BookMarketSystem���� BookMarketSystemOperation �������̽��� �������̵� �� �ڵ带 �ۼ��Ϸ���
 * �ʹ� ������� ������ ���� ��
 */
public class BookMarketSystemOperationAdapter implements BookMarketSystemOperation {
	public void menuUserInfo() {
		System.out.println("�� �̸� : " + BookMarketSystem.user.getName());
	}			
	
	public void menuCartList() {
		BookMarketSystem.cm.showList();
	}			
	
	public void menuCartClear() {
		BookMarketSystem.cm.clearCart();
	}	
	
	public void menuCartAdd() {
		System.out.println("��ٱ��� �׸� �߰�");
		BookMarketSystem.bm.showList();
		 
		System.out.print("��ٱ��Ͽ� �߰��� ������ ISBN�� �Է��ϼ��� : ");
		String orderIsbn = BookMarketSystem.scan.next().toUpperCase();
		BookVo book = BookMarketSystem.bm.search(orderIsbn);
		if(book != null) {
			// ��ٱ��Ͽ� �߰�
			System.out.print("��ٱ��Ͽ� �߰� �Ͻðڽ��ϱ�? Y | N > ");
			String cartAdd = BookMarketSystem.scan.next().toUpperCase();

			if(cartAdd.equals("Y")) {
				if(BookMarketSystem.cm.insert(book)) {
					System.out.println("��ٱ��� �߰� �Ϸ�");
					System.out.println(BookMarketSystem.cm.cartList.size());
				}else {
					System.out.println("��ٱ��� �߰� ����");
				}
			}else {
				System.out.println("��ٱ��Ͽ� �߰����� �ʽ��ϴ�.");
			}
		}else {
			System.out.println("������ �������� �ʽ��ϴ�.");
		}
		
	}			

	public void menuCartRemoveItem() {
		System.out.println("��ٱ��� �׸� ����");
		menuCartList();
		System.out.print ("��ٱ��Ͽ��� ������ ������ ISBN�� �Է��ϼ��� : ");
		String removeIsbn = BookMarketSystem.scan.next().toUpperCase();
		System.out.println("+++++++++++++++++++++++++++ " + removeIsbn + " +++++++++++++++++++++++++++");
		if(BookMarketSystem.cm.removeCartItem(removeIsbn)) {
			System.out.println("--- �ش� ���� ���� �Ϸ� ---");
		}else {
			System.out.println("--- �ش� ���� ���� ���� ---");
		}
		
	}	
	
	public void menuCartRemove() {System.out.println("��ٱ��� ����");}		
	
	public void menuCartBill() {
		System.out.println("������ ǥ��");
		
		BookMarketSystem.om.insert();
		BookMarketSystem.om.showOrderInfo();
		
	}			
	public void menuExit() {System.out.println("�޴� ����");}	
}
 