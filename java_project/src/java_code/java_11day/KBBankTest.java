package java_code.java_11day;

public class KBBankTest {
	// �� ���� ����
	static AccountVo[] accountList = new AccountVo[2];
	
	public static void main(String[] args) {
		// �� ���� ����
//		AccountVo[] accountList = new AccountVo[2];
		AccountVo hong = new AccountVo();
		hong.setName("ȫ�浿");
		hong.setAccountNumber("1234");
		hong.setPassword("1111");
		hong.setBalance(500);
		
		AccountVo test = new AccountVo();
		test.setName("�׽�Ʈ");
		test.setAccountNumber("7894");
		test.setPassword("2222");
		test.setBalance(100);
		
		accountList[0] = hong;
		accountList[1] = test;
		
		// ��ü ����
		AccountPaperVo ��ݿ��� = new AccountPaperVo();
		BankMan ���� = new BankMan();
		Customer ȫ�浿 = new Customer();
		
		// ������ �� ������ �˰� �־�� ��
		����.setAccountList(); // �� ���� ���
		
		// ������ �������� �˰� �־�� ��
		ȫ�浿.setPaper(��ݿ���);
		����.setPaper(ȫ�浿.getPaper());
		
		����.checkPaper(ȫ�浿.answerAccount(����.checkPaper()));
		ȫ�浿.answerAccount(����.checkPaper()); // ȫ�浿�� üũ�� ����� ���� ���ǿ� ���� ����� �Ѵ�
		
		
//		����.askMoney(ȫ�浿.answerMoney());
//		����.checkPaper();
//		����.changeProcess();
//		ȫ�浿.confirmBalance();
		
	}

}
