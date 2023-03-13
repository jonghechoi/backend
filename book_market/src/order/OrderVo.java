package order;
import java.util.ArrayList;

import book_market.*;

public class OrderVo {
	String address;
	UserVo userInfo;
	Object cartItem;
	
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
	public Object getCartItem() {
		return cartItem;
	}
	public void setCartItem(Object cartItem) {
		this.cartItem = cartItem;
	}
	



	
}
