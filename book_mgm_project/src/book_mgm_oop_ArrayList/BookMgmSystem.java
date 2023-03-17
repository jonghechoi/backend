package book_mgm_oop_ArrayList;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BookMgmSystem {
	// field
	Scanner scan = new Scanner(System.in);
	ArrayList<BookVo> bookList = new ArrayList<BookVo>();
	Random rd = new Random();
	int search_idx = -1;
	
	public static final int INSERT = 1;
	public static final int SELECT = 2;
	public static final int SEARCH = 3;
	public static final int UPDATE = 4;
	public static final int DELETE = 5;
	public static final int EXIT = 6;
	
	// constructor
	public BookMgmSystem() {
		this("", "", 0, 0);
	}
	
	public BookMgmSystem(String title, String author, int isbn, int price) {
		showMenu();
		selectMenu();
	}
	
	// method
	public void delete() {
		
	}
	public void update() {
		System.out.println("--------------");
		for(int i=0; i<bookList.size(); i++) {
			System.out.println((i+1) + ". " + bookList.get(i).getTitle());
		}
		System.out.println("--------------");
		System.out.println("������ ������Ʈ�ϰ��� �ϴ� å�� ��ȣ�� �Է��ϼ���");
		int book_num = scan.nextInt();
		
		BookVo book = new BookVo();
		System.out.print("�������� �Է��ϼ��� >> ");
		book.setTitle(scan.next());
		
		System.out.print("���ڸ� �Է��ϼ��� >> ");
		book.setAuthor(scan.next());
		
		System.out.print("������ �Է��ϼ��� >> ");
		book.setPrice(scan.nextInt());

		book.setIsbn(rd.nextInt(10000));
		
		bookList.set(book_num-1, book);
		System.out.println("=== ������Ʈ �Ϸ� ===");
		
		
	}
	public void search() {
		System.out.println("--------------");
		for(int i=0; i<bookList.size(); i++) {
			System.out.println((i+1) + ". " + bookList.get(i).getTitle());
		}
		System.out.println("--------------");
		System.out.print("������ �˰��� �ϴ� å�� ��ȣ�� �Է��ϼ��� >>");
		search_idx = scan.nextInt() - 1;
		select();
		search_idx = -1; // search_idx �ʱ�ȭ
	}
	
	
	public void select() {
		if(bookList.size()>0) {
			int start_num = 0;
			int end_num = bookList.size(); 

			if(search_idx != -1) { // �޴����� 3���� �˻��� ���۵�
				start_num = search_idx;
				end_num = search_idx + 1;
			}
			
			System.out.println("---------------------------------------");
			System.out.println("������ \t ���� \t ISBN \t ����");
			System.out.println("---------------------------------------");
			for(int i=start_num; i<end_num; i++) {
				System.out.print(bookList.get(i).getTitle()+"\t");
				System.out.print(bookList.get(i).getAuthor()+"\t");
				System.out.print(bookList.get(i).getIsbn()+"\t");
				System.out.print(bookList.get(i).getPrice()+"\n");
			}
			System.out.println("---------------------------------------");
				
		}else {
			System.out.println("�Էµ� �����Ͱ� �����ϴ�. ���� ������ּ���.");
		}
	}
	
	public void insert() {
		System.out.println("���� ������ �Է��ϼ���. (ISBN�� �ڵ��Էµ˴ϴ�.)");
		
		BookVo book = new BookVo();
		System.out.print("�������� �Է��ϼ��� >> ");
		book.setTitle(scan.next());
		
		System.out.print("���ڸ� �Է��ϼ��� >> ");
		book.setAuthor(scan.next());
		
		System.out.print("������ �Է��ϼ��� >> ");
		book.setPrice(scan.nextInt());
		
		book.setIsbn(rd.nextInt(10000));
		
		bookList.add(book);
		
	}
	
	public void selectMenu() {
		System.out.print("�޴��� ������ �ּ��� >> ");
		int idx = scan.nextInt();
		
		switch(idx) {
		case INSERT:
			insert();
			selectMenu();
			break;
		case SELECT:
			select();
			selectMenu();
			break;
		case SEARCH:
			search();
			selectMenu();
			break;
		case UPDATE:
			update();
			selectMenu();
			break;
		case DELETE:
			delete();
			selectMenu();
			break;
		case EXIT:
			System.out.println("=== ���α׷� ���� ===");
			System.exit(0);
		}
	}
	
	public void showMenu() {
		System.out.println("---------------------------------------");
		System.out.println("\t ���� ���� �ý��� \t");
		System.out.println("---------------------------------------");
		System.out.println("1. ���� ���");
		System.out.println("2. ���� ��ȸ(��ü)");
		System.out.println("3. ���� �˻�");
		System.out.println("4. ���� ����");
		System.out.println("5. ���� ����");
		System.out.println("6. ���α׷� ����");
		System.out.println("---------------------------------------");
	}
	
}
