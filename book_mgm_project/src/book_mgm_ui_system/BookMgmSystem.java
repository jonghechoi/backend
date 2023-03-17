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
		// findIndex ���� �Լ��� ����� ������ ���߿� �ε��� ���� �۾��Ҷ��� ���� ������
		int idx = findIndex(isbn);
		if(idx != -1) book = bookList.get(idx); 
		
		return book;
	}
	
	// �θ�Ÿ������ return�ϱ� ������ �޸� ����
	// �̷��� �޼ҵ�� return �� ���� �θ�Ÿ������ ���� �� �־ ����
	public  List<BookVo> select() { 
		return bookList;
	}
	
	public boolean insert(BookVo book) {
		boolean result = bookList.add(book);
		return result;
	}
//	�Ķ���ͷ� �޾ƿö� insert() �޼ҵ� �����ε�
//	public boolean insert(String isbn, String title, String author, int price) {}
}
