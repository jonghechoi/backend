package book_mgm_stru;
import java.util.Scanner;

public class BookMgmSystem {

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
		String bookTitle = "", bookAuthor = "", bookIsbn = "";
		int bookPrice = 0, bookCount =0;
		
		while(flag) {
			System.out.print("�޴� �˹��� �Է� > ");
			String menu = scan.next();
				
			if(menu.equals("a")) {
				// 2. �޴� �Է�
				System.out.print("å ������ �Է����ּ��� >> ");
				bookTitle = scan.next();
				System.out.print("å ���ڸ� �Է����ּ��� >> ");
				bookAuthor = scan.next();
				System.out.print("å ISBN�� �Է����ּ��� >> ");
				bookIsbn = scan.next();
				System.out.print("å ������ �Է����ּ��� >> ");
				bookPrice = scan.nextInt();
				System.out.println("====== ��� �Ϸ� ======");
				bookCount++;
			} else if(menu.equals("b")) {
				System.out.println("=========== ��� ���� ���� ===========");
				System.out.println("���\t������\t���ڸ�\t����\tISBN");
				System.out.println("=================================");
				System.out.print("1\t");
				System.out.print(bookTitle + "\t");
				System.out.print(bookAuthor + "\t");
				System.out.print(bookPrice + "\t");
				System.out.print(bookIsbn + "\n");
				System.out.println("=================================");
				System.out.println("��  " + bookCount + "��");
				
			} else if(menu.equals("c")) {
				System.out.println("���� �˻�");
			} else if(menu.equals("d")) {
				System.out.println("���� ����");
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
