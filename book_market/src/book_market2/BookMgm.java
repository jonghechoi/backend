package book_market;
import java.util.ArrayList;


/*
 * 도서 등록/삭제/업데이트 등 도서와 관련된 모든 작업은 BookMgm 클래스에서 구현
 * 
 */
public class BookMgm {
	// Field
	ArrayList<BookVo> bookList;
	
	// Constructor
	public BookMgm() {
		bookList = new ArrayList<BookVo>();
		createList();
	}
	
	/*
	 * orderIsbn로 들어온 데이터가 실제 장바구니에 있는지 검색
	 * 메소드는 항상 그 데이터가 있는 곳에서 실행되어야 함
	 */
	public BookVo search(String isbn) {
		BookVo book = new BookVo();
		for(BookVo sbook : bookList) {
			if(sbook.getIsbn().equals(isbn)) {
				book = sbook;
				break;
			}else {
				book = null;
			}
		}
		return book; // 없으면 null 값 반환 
	}
	
	
	/*
	 * 도서 리스트 출력
	 */
	public void showList() {
		System.out.println("*****************************************");
		System.out.println("\t구매 가능 도서 리스트");
		System.out.println("*****************************************");
		for(BookVo book : bookList) {
			System.out.print(book.getIsbn() + " | ");
			System.out.print(book.getTitle() + "\t | ");
			System.out.print(book.getAuthor() + " | ");
			System.out.print(book.getPrice() + " | \n");
		}
		System.out.println("*****************************************");
	}
	
	
	/*
	 * 도서 추가
	 */
	public void createList() {
		String[] titleList = {"Just Java", "오라클 SQL 기술", "JSP 프로그래밍", "스프링 퀵 스타트"};
		String[] authorList = {"황희정", "홍형경", "최범균", "홍길동"};
		String[] isbnList = {"ISBN1234", "ISBN5678", "ISBN8901", "ISBN2345"};
		int[] priceList = {10000,20000,30000,40000};
		
		// bookList에 도서 정보 추가
		for(int i=0; i<titleList.length; i++) {
			BookVo bookvo = new BookVo();
			
			bookvo.setTitle(titleList[i]);
			bookvo.setAuthor(authorList[i]);
			bookvo.setIsbn(isbnList[i]);
			bookvo.setPrice(priceList[i]);
			bookList.add(bookvo);
		}
		
		System.out.println("상품목록 추가 완료");
	}
	
}
