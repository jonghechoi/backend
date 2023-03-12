package order;
import java.util.ArrayList;

import book_market.*;

public class OrderVo {
	String address;
	UserVo userInfo;
	ArrayList<CartItemVo> cartItem;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public UserVo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserVo userInfo) {
		this.userInfo = userInfo;
	}
	public ArrayList<CartItemVo> getCartItem() {
		return cartItem;
	}
	public void setCartItem(ArrayList<CartItemVo> cartItem) {
		this.cartItem = cartItem;
	}
	



	
}
