package java_code.java_11day;

/*
 * �������� Ŭ����
 */
public class BankMan {
	// Field
	AccountPaperVo paper;
//	AccountVo[] accountList;
	
	// Constructor
	
	// Method
	// ������ ����������Ʈ�� ������ �־�� ��  
	public void setAccountList() {
//		this.accountList = accountList;
		
		System.out.print("����\t���¹�ȣ\t�н�����\t�ܾ�\n");
		for(AccountVo member : KBBankTest.accountList) {
			System.out.print(member.getName()+"\t");
			System.out.print(member.getAccountNumber()+"\t");
			System.out.print(member.getPassword()+"\t");
			System.out.print(member.getBalance()+"\n");
		}
	}
	
	public void setPaper(AccountPaperVo paper) {
		System.out.println("3. ������ ��ݿ����� �޴´�.");
		System.out.println(paper.getName());
		System.out.println(paper.getAccountNumber());
		System.out.println(paper.getPassword());
		System.out.println(paper.getMoney());
		
		this.paper = paper;
	}
	
	public int checkPaper(AccountPaperVo paper) {
		this.paper = paper;
		
		// KBBankTest.accountList�� �����Ϳ� paper�� �����͸� ��
		System.out.println("4. ��ݿ����� üũ�Ѵ�");
		// üũ ����� �̸�(X):1, ���¹�ȣ(X) 2, ��й�ȣ(X)3, �ݾ�(X)=4
		int result =0;
		
		// ��ȿ�� üũ(�������� ���� Ȯ��)                                                                                                                                                                                                        
		// member�� �ִ� ������ paper�� �ִ� ������ ���Ѵ�
		if(paper.getName().equals("")) {
			result = 1;
			askAccount(1);
		}else if(paper.getAccountNumber().equals("")) {
			result = 2;
			askAccount(2);
		}else if(paper.getPassword().equals("")) {
			result = 3;
			askAccount(3);
		}else if(paper.getMoney() == 0) {
			result = 4;
			askAccount(4);
		}else {
			System.out.println("4. ���� : ó���� �Դϴ�");
		}
		return result;
 
	}
	
	public int checkPaper() {
		// KBBankTest.accountList�� �����Ϳ� paper�� �����͸� ��
		System.out.println("4. ��ݿ����� üũ�Ѵ�");
		// üũ ����� �̸�(X):1, ���¹�ȣ(X) 2, ��й�ȣ(X)3, �ݾ�(X)=4
		int result =0;
		
		// ��ȿ�� üũ(�������� ���� Ȯ��)                                                                                                                                                                                                        
		if(paper.getName().equals("")) {
			result = 1;
			askAccount(1);
		}else if(paper.getAccountNumber().equals("")) {
			result = 2;
			askAccount(2);
		}else if(paper.getPassword().equals("")) {
			result = 3;
			askAccount(3);
		}else if(paper.getMoney() == 0) {
			result = 4;
			askAccount(4);
		}else {
//			System.out.println("4. ���� : ó���� �Դϴ�");
			result = 0;
			changeProcess(result); // accountList�� paper ��ݾ� ����
		}
		return result;
	}
	
	public void askAccount(int result) {
		System.out.println("5. üũ�� ����� �˷��ش�");
		switch(result) {
			case 1: 
				System.out.println("--> �̸��� �˷��ּ���");
				break;
			case 2: 
				System.out.println("--> ���¹�ȣ�� �˷��ּ���");
				break;
			case 3: 
				System.out.println("--> �н����带 �˷��ּ���");
				break;
			case 4: 
				System.out.println("--> �ݾ��� �˷��ּ���");
				break;
			default:
		}//switch
//		System.out.println("6. ������ �ݾ��� Ȯ���Ѵ�.");
//		this.paper.setMoney(money);
	}
	
	public void changeProcess(int result) {
		// �� ���� ���� --> ��� ó��
		// accountList�� paper ��ݾ� ����
		int member_idx = -1;
		
//		int i = 0;
//		for(AccountVo member : KBBankTest.accountList) {
//			if(member.getName().equals(paper.getName())) {
//				if(member.getAccountNumber().equals(paper.getAccountNumber())) {
//					if(member.getPassword().equals(paper.getPassword())) {
//						member_idx = i;
//						i = account_length; // for�� �������
//						break;
//					}
//				}
//			}
//		}
		
		int account_length = KBBankTest.accountList.length;
		for(int i=0; i<account_length; i++) {
			AccountVo member = KBBankTest.accountList[i];
			
			if(member.getName().equals(paper.getName())) {
				if(member.getAccountNumber().equals(paper.getAccountNumber())) {
					if(member.getPassword().equals(paper.getPassword())) {
						member_idx = i;
						i = account_length; // for�� �������
					}
				}
			}
		}
		
		int balance = KBBankTest.accountList[member_idx].getBalance() - paper.getMoney(); // (���¿� �ִ� �ݾ� - ��ݾ�)
		KBBankTest.accountList[member_idx].setBalance(balance);
		
		System.out.println("���� : "+ paper.getMoney() + "������ ��ݵǾ����ϴ�");
		System.out.println("���� : �ܾ��� "
		       + KBBankTest.accountList[member_idx].getBalance() + "�����Դϴ�");
		
	}
}
