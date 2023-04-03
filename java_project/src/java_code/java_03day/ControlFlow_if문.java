package java_code.java_03day;

public class ControlFlow_if문 {

	public static void main(String[] args) {
		
		int x = 200;
		int y = 200;
		
//		System.out.println("x>y = " + (x>y)); // x가 작다
//		System.out.println("x<y = " + (x<y)); // y가 크다

//		if(x>y) System.out.println("x가 y보다 크다");
	
//		if(x>y) {
//			System.out.println("실행문1");
//			System.out.println("x가 y보다 크다");
//		}else {
//			System.out.println("y가 x보다 크다");
//		}
		
		if(x>y) {
			System.out.println("x가 y보다 크다"); // x>y 조건식이 true인 경우 실행
		}else if(x<y) {
			System.out.println("y가 x보다 크다"); // x<y 조건식이 true인 경우 실행
		}else {
			System.out.println("x와 y가 같다"); // 위의 if 조건식이 모두 false인 경우 실행
		}
		
		
	}

}
