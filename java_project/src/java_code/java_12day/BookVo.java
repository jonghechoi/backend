package java_code.java_12day;

public class BookVo {
	// Field
	String title, author, isbn;
	int price;
	
	public BookVo(String title) {
		this(title,"","",0);
//		this.title = title;
	}
	
	public BookVo(String title, String author) {
		this(title,author,"",0);
//		this.title = title;
//		this.author = author;
	}
	
	public BookVo(String title, String author, String isbn) {
		this(title,author,isbn,0);
//		this.title = title;
//		this.author = author;
//		this.isbn = isbn;
	}
	
	public BookVo(String title, String author, String isbn, int price) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
	}
	
	// Constructor
	public BookVo() {
		this.title = "java";
		this.author = "ȫ�浿";
		this.isbn = "1234";
		this.price = 100;
	}

	// Method
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	


}
