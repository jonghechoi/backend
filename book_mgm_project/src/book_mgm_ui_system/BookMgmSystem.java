package book_mgm_ui_system;

import java.util.ArrayList;
import java.util.List;

public class BookMgmSystem {
	// Field
	private ArrayList<BookVo> bookList;
	
	// Constructor
	public BookMgmSystem() {
		bookList = new ArrayList<BookVo>();
		System.out.println("size ----> " + bookList.size());
	}
	
	// Method
	public boolean delete(BookVo dbook) {
		boolean result = false;
		int idx = -1;
		idx = findIndex(dbook.getIsbn());
		if(idx != -1) {
			bookList.remove(idx);
			result = true;
		}
		
		return result;
	}
	
	public boolean update(BookVo ubook) {
		boolean result = false;
//		int idx = -1;
//		
//		int i = 0;
//		for(BookVo book : bookList) {
//			if(book.getIsbn().equals(ubook.getIsbn())) {
//				idx = i; 
//			}
//			i++;
//		}
//		
//		if(idx != -1) {
//			bookList.get(idx).setTitle(ubook.getTitle());
//			bookList.get(idx).setAuthor(ubook.getAuthor());
//			bookList.get(idx).setPrice(ubook.getPrice());
//			result = true;
//		}
		
		int idx = -1;
		idx = findIndex(ubook.getIsbn());
		if(idx != -1) {
			bookList.set(idx,  ubook);
			result = true;
		}
		
		return result;
	}
	
	public int findIndex(String isbn) {
		int idx = -1;
		
		int i = 0;
		for(BookVo book : bookList) {
			if(book.getIsbn().equals(isbn)) {
				idx = i;
			}
			i++;
		}
		return idx;
	}
	
	public BookVo search(String isbn) {
		BookVo book = null;
		// findIndex 같은 함수를 만들어 놓으면 나중에 인덱스 관련 작업할때는 아주 편해짐
		int idx = findIndex(isbn);
		if(idx != -1) book = bookList.get(idx); 
		
		return book;
	}
	
	// 부모타입으로 return하기 때문에 메모리 절약
	// 이렇게 메소드로 return 할 때는 부모타입으로 보낼 수 있어서 좋음
	public  List<BookVo> select() { 
		return bookList;
	}
	
	public boolean insert(BookVo book) {
		boolean result = bookList.add(book);
		return result;
	}
//	파라미터로 받아올때 insert() 메소드 오버로딩
//	public boolean insert(String isbn, String title, String author, int price) {}
}
