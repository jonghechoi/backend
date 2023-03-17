package book_mgm_stru;
import java.util.Scanner;

public class BookMgmSystemArray1 {

	public static void main(String[] args) {
		// 1. �޴� ����
		System.out.println("********************");
		System.out.println("���� ���� �ý���");
		System.out.println("a. ���� ���");
		System.out.println("b. ���� ��ȸ(��ü)");
		System.out.println("c. ���� �˻�");
		System.out.println("d. ���� ����");
		System.out.println("e. ���� ����");
		System.out.println("z. ���α׷� ����");
		System.out.println("********************");

		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		
		// �������� ���� ����(����=����=��� ����: �ݵ�� �ʱ�ȭ �۾��� �Ѵ�)
//		String bookTitle = "", bookAuthor = "", bookIsbn = "";
//		int bookPrice = 0, bookCount =0;
		
		System.out.print("����� å�� ���� �Է� >> ");
		int size = scan.nextInt();
		
		String[] bookTitleList = new String[size];
		String[] bookAuthorList = new String[size];
		int[] bookIsbnList = new int[size];
		int[] bookPriceList = new int[size];
		
		int bookCount = 0;
		
		while(flag) {
			System.out.print("�޴� �˹��� �Է� > ");
			String menu = scan.next();
			
			// a. ���� ���
			if(menu.equals("a")) { 
				// 2. �޴� �Է�
				if(bookCount<size) {
					boolean regflag = true;
					while(regflag) {
						for(int i=0; i<size; i++) {
							System.out.print("å ������ �Է����ּ��� >> ");
							bookTitleList[i] = scan.next();
							
							System.out.print("å ���ڸ� �Է����ּ��� >> ");
							bookAuthorList[i] = scan.next();
							
							System.out.print("å ISBN�� �Է����ּ��� >> ");
							bookIsbnList[i] = scan.nextInt();
							
							System.out.print("å ������ �Է����ּ��� >> ");
							bookPriceList[i] = scan.nextInt();
							
							System.out.println("====== ��� �Ϸ� ======");
							bookCount++;
							
							System.out.println("��� ����Ͻðڽ��ϱ�? (��� ��Ͻ�(y), �����(n) >>");
							String con = scan.next();
							if(con.equals("n")) {
								regflag = false;
								i = size;
							}
						}
					}
				}else {
					System.out.println("------- ��� ���� ������ �����ϴ� -------");
				}
				
			// b. ���� ��ȸ
			} else if(menu.equals("b")) { 
				System.out.println("=========== ��� ���� ���� ===========");
				System.out.println("������\t���ڸ�\t����\tISBN");
				System.out.println("=================================");
				for(int i=0; i<bookCount; i++) {
					System.out.print(bookTitleList[i]+"\t");
					System.out.print(bookAuthorList[i]+"\t");
					System.out.print(bookPriceList[i]+"\t");
					System.out.print(bookIsbnList[i]+"\t");
					System.out.println();
				}
				System.out.println("=================================");
				System.out.println("��  " + bookCount + "��");
				
				
			// c. ���� �˻�
			} else if(menu.equals("c")) { 
				boolean search = true;
				while(search) {
					if(bookCount!=0) {
						System.out.print("�˻��� �������� �Է��ϼ��� >> ");
						String searchName = scan.next();
						
						// �ش� ������ �ִ��� Ȯ��
						boolean bookCheck = true;
						int bookNum = 0;
						for(int i=0; i<bookCount; i++) {
							if(searchName.equals(bookTitleList[i])) {
								bookCheck = false;
								bookNum = i;
							}
						}
						
						String research = "";
						if(!bookCheck) {
							System.out.println("�����Ͻ� ������ ["+ bookTitleList[bookNum] +"]�Դϴ�");
							System.out.print(bookAuthorList[bookNum]+"\t");
							System.out.print(bookPriceList[bookNum]+"\t");
							System.out.print(bookIsbnList[bookNum]+"\t");
							System.out.println();
							System.out.println("�ٸ� ������ �˻��Ͻðڽ��ϱ�? [��˻�:(y), ����(n)]");
							research = scan.next();
						}else {
							System.out.println("�Է��Ͻ� ������ �����ϴ�. ��˻��Ͻðڽ��ϱ�? [��˻�:(y), ����(n)]");
							research = scan.next();
						}
						
						if(research.equals("n")) {
							search = false;
						}
					}else {
						System.out.println("\n------- ��������� ���� ���ּ���. -------");
					}//if
				}//while
				
				
				
				
				
				
				
			// d. ���� ����
			} else if(menu.equals("d")) {
				System.out.println("���� ����");
				/*
				 * 1. ������ ���� �̸� �Է�
				 * 2. �ش� ������ ���� idx ����
				 * 3. idx ����Ͽ� �󼼿� ���� ����
				 * 4. �߰� ������ ���� Ȯ��(while)
				 */
				
				System.out.print("������ ������ �̸� �Է� >> ");
				String modifyBook = scan.next();

				
//				for(int i=0; i<bookTitleList.length; i++) {
//					bookTitleList
//				}
//				if(modifyBook)
//				
//				
//				System.out.print("å ������ �Է����ּ��� >> ");
//				bookTitleList[i] = scan.next();
//				
//				System.out.print("å ���ڸ� �Է����ּ��� >> ");
//				bookAuthorList[i] = scan.next();
//				
//				System.out.print("å ISBN�� �Է����ּ��� >> ");
//				bookIsbnList[i] = scan.nextInt();
//				
//				System.out.print("å ������ �Է����ּ��� >> ");
//				bookPriceList[i] = scan.nextInt();
//				
				
				
			// e. ���� ����
			} else if(menu.equals("e")) {
				System.out.println("���� ����");
				
				
				
				
				
				
				
				
			} else if(menu.equals("z")) {
				System.out.println("\n====== ���α׷� ���� ======");
				flag = false;
				// System.exit(0);
			} else {
				System.out.println("�̻��Ѱ� ����");
			}
		}
		
	}

}
