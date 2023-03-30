package book_market2;

public interface CartMgmOperation {
	public boolean insert(BookVo book);
	public void showList();
	public boolean remove();
	public boolean remove(String isbn);
}
