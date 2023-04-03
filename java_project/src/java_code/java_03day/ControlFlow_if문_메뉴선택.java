package java_code.java_03day;
import java.util.Scanner;

public class ControlFlow_if문_메뉴선택 {
	/*
	 * 점심 메뉴 선택
	 * 1: 된장찌개, 2: 김치찌개, 3: 돈까스, 4: 짜장면
	 */
	public static void main(String[] args) {
		// 1. 메뉴판 출력
		System.out.println("-------- 점심 메뉴 리스트 -------");
		System.out.println("1. 된장찌개");
		System.out.println("2. 김치찌개");
		System.out.println("3. 돈까스");
		System.out.println("4. 짜장면");
		System.out.println("** 메뉴선택은 숫자로 해주세요 **");
		System.out.println("---------------------------");
		
		//2. 메뉴 입력을 위한 Scanner 객체 생성
		Scanner scan = new Scanner(System.in);
		System.out.print("메뉴선택(숫자)> ");
		int menu = scan.nextInt();
		
		if(menu==1) {
			System.out.println("된장찌개를 선택했습니다");
		} else if(menu==2) {
			System.out.println("김치찌개를 선택했습니다");
		} else if(menu==3) {
			System.out.println("돈까스를 선택했습니다");
		} else if(menu==4) {
			System.out.println("짜장면 선택했습니다");
		} else {
			System.out.println("없는 메뉴입니다. 다시 선택해주세요");
		}
		
		scan.close(); // 굳이 안해도 main 메소드가 끝나면 이 객체도 사라짐.
		
	}

}
