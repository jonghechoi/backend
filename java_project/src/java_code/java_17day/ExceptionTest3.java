package java_code.java_17day;

import java.util.ArrayList;

public class ExceptionTest3 {
	public static void main(String[] args) throws Exception {
		
		try {
			int x = 0;
			int y = 100/x;
			
			System.out.println(y);
		}catch(Exception e) {
			System.out.println("예외 처리 완료");
		}finally {
			// 사용법 같은 것을 명시하지 하지 실무에서는 딱히 코드를 넣진 앖음
			System.out.println("에외와 상관없이 무조건 실행");
			System.out.println("Integer 생성자의 값은 문자열이며, 반드시 숫자로 입력해주세요.");
			System.out.println("UseAge : new Integer(문자열 숫자)");
		}
	}
}
