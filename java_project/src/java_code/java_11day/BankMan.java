package java_code.java_11day;

/*
 * 은행직원 클래스
 */
public class BankMan {
	// Field
	AccountPaperVo paper;
//	AccountVo[] accountList;
	
	// Constructor
	
	// Method
	// 직원도 고객정보리스트를 가지고 있어야 함  
	public void setAccountList() {
//		this.accountList = accountList;
		
		System.out.print("고객명\t계좌번호\t패스워드\t잔액\n");
		for(AccountVo member : KBBankTest.accountList) {
			System.out.print(member.getName()+"\t");
			System.out.print(member.getAccountNumber()+"\t");
			System.out.print(member.getPassword()+"\t");
			System.out.print(member.getBalance()+"\n");
		}
	}
	
	public void setPaper(AccountPaperVo paper) {
		System.out.println("3. 직원이 출금용지를 받는다.");
		System.out.println(paper.getName());
		System.out.println(paper.getAccountNumber());
		System.out.println(paper.getPassword());
		System.out.println(paper.getMoney());
		
		this.paper = paper;
	}
	
	public int checkPaper(AccountPaperVo paper) {
		this.paper = paper;
		
		// KBBankTest.accountList의 데이터와 paper의 데이터를 비교
		System.out.println("4. 출금용지를 체크한다");
		// 체크 결과의 이름(X):1, 계좌번호(X) 2, 비밀번호(X)3, 금액(X)=4
		int result =0;
		
		// 유효성 체크(데이터의 유무 확인)                                                                                                                                                                                                        
		// member에 있는 정보와 paper에 있는 정보를 비교한다
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
			System.out.println("4. 직원 : 처리중 입니다");
		}
		return result;
 
	}
	
	public int checkPaper() {
		// KBBankTest.accountList의 데이터와 paper의 데이터를 비교
		System.out.println("4. 출금용지를 체크한다");
		// 체크 결과의 이름(X):1, 계좌번호(X) 2, 비밀번호(X)3, 금액(X)=4
		int result =0;
		
		// 유효성 체크(데이터의 유무 확인)                                                                                                                                                                                                        
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
//			System.out.println("4. 직원 : 처리중 입니다");
			result = 0;
			changeProcess(result); // accountList에 paper 출금액 적용
		}
		return result;
	}
	
	public void askAccount(int result) {
		System.out.println("5. 체크한 결과를 알려준다");
		switch(result) {
			case 1: 
				System.out.println("--> 이름을 알려주세요");
				break;
			case 2: 
				System.out.println("--> 계좌번호를 알려주세요");
				break;
			case 3: 
				System.out.println("--> 패스워드를 알려주세요");
				break;
			case 4: 
				System.out.println("--> 금액을 알려주세요");
				break;
			default:
		}//switch
//		System.out.println("6. 직원이 금액을 확인한다.");
//		this.paper.setMoney(money);
	}
	
	public void changeProcess(int result) {
		// 고객 정보 변경 --> 출금 처리
		// accountList에 paper 출금액 적용
		int member_idx = -1;
		
//		int i = 0;
//		for(AccountVo member : KBBankTest.accountList) {
//			if(member.getName().equals(paper.getName())) {
//				if(member.getAccountNumber().equals(paper.getAccountNumber())) {
//					if(member.getPassword().equals(paper.getPassword())) {
//						member_idx = i;
//						i = account_length; // for문 끝내기용
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
						i = account_length; // for문 끝내기용
					}
				}
			}
		}
		
		int balance = KBBankTest.accountList[member_idx].getBalance() - paper.getMoney(); // (계좌에 있던 금액 - 출금액)
		KBBankTest.accountList[member_idx].setBalance(balance);
		
		System.out.println("직원 : "+ paper.getMoney() + "만원이 출금되었습니다");
		System.out.println("직원 : 잔액은 "
		       + KBBankTest.accountList[member_idx].getBalance() + "만원입니다");
		
	}
}
