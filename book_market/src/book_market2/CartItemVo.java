package book_market2;

/*
 * 중복되는 도서가 있으면 수량을 늘려야 한다.
 */
public class CartItemVo {
	String isbn;
	int qty, totalPrice;
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
