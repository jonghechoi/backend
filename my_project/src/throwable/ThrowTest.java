package throwable;

public class ThrowTest {

	public static void main(String[] args) {
		int a,b;
		
		a = 10;
		b = 0;
		
		try {
			throwTest(a, b);
		}catch(ArithmeticException e) {
			// throw�� Exception�� ���� �� ���� ������ �������� ����
			// ���� �����ڰ� ���� �޽����� ������� �� -> Exception ������ �ʿ�
			System.out.println("Call '��'�� �޼ҵ� : " + e.getMessage());
		}
	}
	
	public static void throwTest(int numA, int numB) throws ArithmeticException{
		try {
			System.out.println("numA/numB --> " + numA/numB);
		}catch(ArithmeticException e) {
			System.out.println("Call '��'�� �޼ҵ� --> " + e.getMessage());
			throw new ArithmeticException();
		}
	}
}
