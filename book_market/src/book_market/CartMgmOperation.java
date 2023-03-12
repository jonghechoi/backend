package book_market;

public interface CartMgmOperation {
	public boolean insert(BookVo book);
	public void showList();
	public void clearCart();
	public boolean removeCartItem(String removeIsbn);
}
