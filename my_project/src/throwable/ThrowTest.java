package throwable;

public class ThrowTest {

	public static void main(String[] args) {
		int a,b;
		
		a = 10;
		b = 0;
		
		try {
			throwTest(a, b);
		}catch(ArithmeticException e) {
			// throw는 Exception을 던질 때 예외 내용을 던져주지 않음
			// 따라서 개발자가 직접 메시지를 던져줘야 함 -> Exception 재정의 필요
			System.out.println("Call '하'는 메소드 : " + e.getMessage());
		}
	}
	
	public static void throwTest(int numA, int numB) throws ArithmeticException{
		try {
			System.out.println("numA/numB --> " + numA/numB);
		}catch(ArithmeticException e) {
			System.out.println("Call '되'는 메소드 --> " + e.getMessage());
			throw new ArithmeticException();
		}
	}
}
