package java_code.java_17day;

import java.util.ArrayList;

public class ExceptionTest3 {
	public static void main(String[] args) throws Exception {
		
		try {
			int x = 0;
			int y = 100/x;
			
			System.out.println(y);
		}catch(Exception e) {
			System.out.println("���� ó�� �Ϸ�");
		}finally {
			// ���� ���� ���� ������� ���� �ǹ������� ���� �ڵ带 ���� ����
			System.out.println("���ܿ� ������� ������ ����");
			System.out.println("Integer �������� ���� ���ڿ��̸�, �ݵ�� ���ڷ� �Է����ּ���.");
			System.out.println("UseAge : new Integer(���ڿ� ����)");
		}
	}
}
