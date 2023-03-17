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
		System.out.println("정보를 업데이트하고자 하는 책의 번호를 입력하세요");
		int book_num = scan.nextInt();
		
		BookVo book = new BookVo();
		System.out.print("도서명을 입력하세요 >> ");
		book.setTitle(scan.next());
		
		System.out.print("저자를 입력하세요 >> ");
		book.setAuthor(scan.next());
		
		System.out.print("가격을 입력하세요 >> ");
		book.setPrice(scan.nextInt());

		book.setIsbn(rd.nextInt(10000));
		
		bookList.set(book_num-1, book);
		System.out.println("=== 업데이트 완료 ===");
		
		
	}
	public void search() {
		System.out.println("--------------");
		for(int i=0; i<bookList.size(); i++) {
			System.out.println((i+1) + ". " + bookList.get(i).getTitle());
		}
		System.out.println("--------------");
		System.out.print("정보를 알고자 하는 책의 번호를 입력하세요 >>");
		search_idx = scan.nextInt() - 1;
		select();
		search_idx = -1; // search_idx 초기화
	}
	
	
	public void select() {
		if(bookList.size()>0) {
			int start_num = 0;
			int end_num = bookList.size(); 

			if(search_idx != -1) { // 메뉴선택 3번의 검색이 시작됨
				start_num = search_idx;
				end_num = search_idx + 1;
			}
			
			System.out.println("---------------------------------------");
			System.out.println("도서명 \t 저자 \t ISBN \t 가격");
			System.out.println("---------------------------------------");
			for(int i=start_num; i<end_num; i++) {
				System.out.print(bookList.get(i).getTitle()+"\t");
				System.out.print(bookList.get(i).getAuthor()+"\t");
				System.out.print(bookList.get(i).getIsbn()+"\t");
				System.out.print(bookList.get(i).getPrice()+"\n");
			}
			System.out.println("---------------------------------------");
				
		}else {
			System.out.println("입력된 데이터가 없습니다. 먼저 등록해주세요.");
		}
	}
	
	public void insert() {
		System.out.println("도서 정보를 입력하세요. (ISBN은 자동입력됩니다.)");
		
		BookVo book = new BookVo();
		System.out.print("도서명을 입력하세요 >> ");
		book.setTitle(scan.next());
		
		System.out.print("저자를 입력하세요 >> ");
		book.setAuthor(scan.next());
		
		System.out.print("가격을 입력하세요 >> ");
		book.setPrice(scan.nextInt());
		
		book.setIsbn(rd.nextInt(10000));
		
		bookList.add(book);
		
	}
	
	public void selectMenu() {
		System.out.print("메뉴를 선택해 주세요 >> ");
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
			System.out.println("=== 프로그램 종료 ===");
			System.exit(0);
		}
	}
	
	public void showMenu() {
		System.out.println("---------------------------------------");
		System.out.println("\t 도서 관리 시스템 \t");
		System.out.println("---------------------------------------");
		System.out.println("1. 도서 등록");
		System.out.println("2. 도서 조회(전체)");
		System.out.println("3. 도서 검색");
		System.out.println("4. 도서 수정");
		System.out.println("5. 도서 삭제");
		System.out.println("6. 프로그램 종료");
		System.out.println("---------------------------------------");
	}
	
}
