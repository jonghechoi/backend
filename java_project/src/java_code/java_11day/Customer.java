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
		System.out.println("1. ���� ��������� ���´�.");
		
		System.out.print("���� >> ");
		paper.setName(scan.next());
		System.out.print("���¹�ȣ >> ");
		paper.setAccountNumber(scan.next());
		System.out.print("��й�ȣ >> ");
		paper.setPassword(scan.next());
		System.out.print("�ܾ� >> ");
		paper.setMoney(scan.nextInt());
		
		this.paper = paper;
	}
	
	public AccountPaperVo getPaper() {
		System.out.println("2. ���� ��ݿ����� �����Ѵ�.");
		return paper;
	}
	
	public AccountPaperVo answerAccount(int checkResult) {
		System.out.println("5. ���� ���������� �˷��ش�.");
	
		switch(checkResult) {
			case 1:
				System.out.print("���� >> ");
				paper.setName(scan.next());
				break;
			case 2:
				System.out.print("���¹�ȣ >> ");
				paper.setAccountNumber(scan.next());
				break;
			case 3:
				System.out.print("��й�ȣ >> ");
				paper.setPassword(scan.next());
				break;
			case 4:
				System.out.print("�ݾ� >> ");
				paper.setMoney(scan.nextInt());
				break;
			default:
		}
		return paper;
	}
	
	public void confirmBalance() {
		System.out.println("=== �ܾ� Ȯ�� ===");
	}
	
}
