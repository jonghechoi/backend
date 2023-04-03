package java_code.java_09day;
import java.util.Scanner;

public class 강남고등학교 {

	public static void main(String[] args) {
		// 성적관리 시스템 생성
		Scanner scan = new Scanner(System.in);
		SMOSystem gsmo = new SMOSystem();
		
		// 이렇게 만들면 SMSystem 클래스에도 main이 있기 때문에 안됨 (정확히 main이 뭐지?)
		// SMSystem gsmo = new SMSystem();
		
		gsmo.showMenu("강남 고등학교");
//		System.out.println("몇 명의 학생을 입력 하시겠습니까?");
//		int size = scan.nextInt();
		boolean result = true;
		while(result) {
			result = gsmo.choiceMenu();
		}
	}

}
