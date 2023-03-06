package java_code.java_11day;

public class KBBankTest {
	// 고객 정보 생성
	static AccountVo[] accountList = new AccountVo[2];
	
	public static void main(String[] args) {
		// 고객 정보 생성
//		AccountVo[] accountList = new AccountVo[2];
		AccountVo hong = new AccountVo();
		hong.setName("홍길동");
		hong.setAccountNumber("1234");
		hong.setPassword("1111");
		hong.setBalance(500);
		
		AccountVo test = new AccountVo();
		test.setName("테스트");
		test.setAccountNumber("7894");
		test.setPassword("2222");
		test.setBalance(100);
		
		accountList[0] = hong;
		accountList[1] = test;
		
		// 객체 생성
		AccountPaperVo 출금용지 = new AccountPaperVo();
		BankMan 직원 = new BankMan();
		Customer 홍길동 = new Customer();
		
		// 직원은 고객 정보를 알고 있어야 함
		직원.setAccountList(); // 고객 정보 출력
		
		// 직원은 고객정보를 알고 있어야 함
		홍길동.setPaper(출금용지);
		직원.setPaper(홍길동.getPaper());
		
		직원.checkPaper(홍길동.answerAccount(직원.checkPaper()));
		홍길동.answerAccount(직원.checkPaper()); // 홍길동이 체크한 결과를 통해 질의에 대한 대답을 한다
		
		
//		직원.askMoney(홍길동.answerMoney());
//		직원.checkPaper();
//		직원.changeProcess();
//		홍길동.confirmBalance();
		
	}

}
