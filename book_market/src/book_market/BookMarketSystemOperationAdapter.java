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
		// ��ٱ��Ͽ� item�� �ϳ��� �ִ� ��쿡�� ������ ���
		if(BookMarketSystem.cm.getSize() != 0) {
			System.out.print("��۹��� ���� �������� �����ϱ�? Y|N > ");
			String userConfirm = BookMarketSystem.scan.next().toUpperCase();
			BookMarketSystem.scan.nextLine();
			OrderUserVo orderUser = new OrderUserVo();
			if(userConfirm.equals("Y")) {
				/*
				 * user -> orderUser ����
				 */
				orderUser = (OrderUserVo)BookMarketSystem.user;
				
				System.out.print("������� �Է����ּ��� > ");
				String addr = BookMarketSystem.scan.nextLine();
				orderUser.setAddress(addr);
				
				System.out.println("-------------- ��� ���� �� ���� --------------");
				System.out.print("���� : " + orderUser.getName() + "\t"); 
				System.out.print("����ó : " + orderUser.getPhoneNumber() + "\n");
				System.out.print("����� : " + orderUser.getAddress() + "\t");
				System.out.print("�߼��� : " + orderUser.getDate() + "\n");
				System.out.print("��ٱ��� ��ǰ ��� : \n");
				BookMarketSystem.cm.showList("�ֹ� �ѱݾ� : ");
			}else {
				// orderUser ���� �Է� -> �̸�, ����ó, �����
				System.out.print("�̸��� �Է����ּ��� > ");
				orderUser.setName(BookMarketSystem.scan.next());
				System.out.print("����ó�� �Է����ּ��� > ");
				orderUser.setPhoneNumber(BookMarketSystem.scan.next());
				BookMarketSystem.scan.nextLine();
				System.out.print("������� �Է����ּ��� > ");
				orderUser.setAddress(BookMarketSystem.scan.nextLine());
				
				System.out.println("-------------- ��� ���� �� ���� --------------");
				System.out.print("���� : " + orderUser.getName() + "\t"); 
				System.out.print("����ó : " + orderUser.getPhoneNumber() + "\n");
				System.out.print("����� : " + orderUser.getAddress() + "\t");
				System.out.print("�߼��� : " + orderUser.getDate() + "\n");
				System.out.print("��ٱ��� ��ǰ ��� : \n");
				BookMarketSystem.cm.showList("�ֹ� �ѱݾ� : ");
			}
		}else {
			System.out.println("--- ��ٱ��ϰ� ����ֽ��ϴ� ---");
		}
		
		
		
//		BookMarketSystem.om.insert();
//		BookMarketSystem.om.showOrderInfo();
		
	}			
	public void menuExit() {System.out.println("�޴� ����");}	
}
 