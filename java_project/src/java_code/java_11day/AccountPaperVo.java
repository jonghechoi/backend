package java_code.java_11day;

/*
 * 입출금 용지 
 */

public class AccountPaperVo {
	// Field
	String name, accountNumber, password;
	int money;
	
	// Constructor
	
	// Method
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getMoney() {
		return money;
	}
	
}//class
