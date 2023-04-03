package java_code.java_3day;

public class ControlFlow_switch문 {

	public static void main(String[] args) {

		int value = 1;

		switch(value) {
		case 1: System.out.println("1입니다");
//			break;
		case 2: System.out.println("2입니다");
			break;
		case 3: System.out.println("3입니다");
			break;
		case 4: System.out.println("4입니다");
		default : System.out.println("기타 숫잡 이");
		}
		
		System.out.println("=== 프로그램 종료 ===");
		
	}

}
