package java_code.java_11day;

import java.util.Scanner;
public class Customer {

	// Field
	int balance = 500;
	AccountPaperVo paper;
	Scanner scan = new Scanner(System.in);
	
	// Constructor
	// Method
	public void setPaper(AccountPaperVo paper) {
		System.out.println("1. 고객이 출금정보를 적는다.");
		
		System.out.print("고객명 >> ");
		paper.setName(scan.next());
		System.out.print("계좌번호 >> ");
		paper.setAccountNumber(scan.next());
		System.out.print("비밀번호 >> ");
		paper.setPassword(scan.next());
		System.out.print("잔액 >> ");
		paper.setMoney(scan.nextInt());
		
		this.paper = paper;
	}
	
	public AccountPaperVo getPaper() {
		System.out.println("2. 고객이 출금용지를 전달한다.");
		return paper;
	}
	
	public AccountPaperVo answerAccount(int checkResult) {
		System.out.println("5. 고객이 계좌정보를 알려준다.");
	
		switch(checkResult) {
			case 1:
				System.out.print("고객명 >> ");
				paper.setName(scan.next());
				break;
			case 2:
				System.out.print("계좌번호 >> ");
				paper.setAccountNumber(scan.next());
				break;
			case 3:
				System.out.print("비밀번호 >> ");
				paper.setPassword(scan.next());
				break;
			case 4:
				System.out.print("금액 >> ");
				paper.setMoney(scan.nextInt());
				break;
			default:
		}
		return paper;
	}
	
	public void confirmBalance() {
		System.out.println("=== 잔액 확인 ===");
	}
	
}
