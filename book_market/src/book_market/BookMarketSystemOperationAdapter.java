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
		BookMarketSystem.cm.remove();
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
					System.out.println(BookMarketSystem.cm.getSize());
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
	
	// ��ٱ��� ���� ���̱�
	public void menuCartRemoveItem() {
		if(BookMarketSystem.cm.getSize() != 0) {
			BookMarketSystem.cm.showList();
			System.out.print("������ ������ ������ ISBN�� �Է����ּ��� : ");
			String isbn = BookMarketSystem.scan.next().toUpperCase();
			System.out.print("������ �Է����ּ��� : ");
			int qty = BookMarketSystem.scan.nextInt();
			
			BookMarketSystem.cm.updateQty(isbn, qty);
			
		}else {
			System.out.println("--- ��ٱ��ϰ� ����ֽ��ϴ� ---");
		}
		
	}	
	
	// ��ٱ��� �׸� ����
	public void menuCartRemove() {
		if(BookMarketSystem.cm.getSize() != 0) {
			BookMarketSystem.cm.showList();
			System.out.print("��ٱ��Ͽ��� ������ ������ isbn�� �Է��ϼ��� > ");
			String isbn = BookMarketSystem.scan.next().toUpperCase();
			
			boolean result = BookMarketSystem.cm.remove(isbn);;
			if(result) {
				System.out.println("--- �ش� ��ٱ��� �׸� ���� �Ϸ� ---");
			}else {
				System.out.println("--- ��ٱ��� �׸� ���� ���� ---");
			}
		}else {
			System.out.println("--- ������ �����Ͱ� �������� �ʽ��ϴ� ---");
		}
	}		
	
	public void menuCartBill() {
		System.out.println("������ ǥ��");
		
		BookMarketSystem.om.insert();
		BookMarketSystem.om.showOrderInfo();
		
	}			
	public void menuExit() {System.out.println("�޴� ����");}	
}
 