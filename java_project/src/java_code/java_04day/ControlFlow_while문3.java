package java_code.java_4day;
import java.util.Scanner;

public class ControlFlow_while문3 {

	public static void main(String[] args) {
		// 메뉴를 반복적으로 선택하는 로직 구현 -> 프로그램 종료에 필요한 flag 변수 상요!!
		
		
		// 메뉴 출력
		System.out.println("-------------");
		System.out.println("1. 등록");
		System.out.println("2. 출력");
		System.out.println("0. 종료");
		System.out.println("-------------");
		
		// 메뉴 선택
		Scanner scan = new Scanner(System.in);
		
		boolean flag = true;
		while(flag) {
			System.out.print("메뉴(숫자) > ");
			int menu = scan.nextInt();
			
			switch(menu) {
				case 1:
					System.out.println("등록 \n");
					break;
				case 2:
					System.out.println("출력 \n");
					break;
				case 0:
					// 종료 여부 확인
					System.out.print("정말로 종료하시겠습니까?(y/n) > ");
					String con = scan.next();
					if(con.equals("y")) {
						System.out.println("-- while 종료 --");
						 flag = false;
//						System.exit(0); 
					}else if(con.equals("n")) {
						System.out.println("n 선택");
					}else {
						System.out.println("다른 메뉴를 선택하셨습니다");
					}
					
					break;				
				default: 
					System.out.println("메뉴 준비중입니다 \n");
			}
		}
		System.out.println("-- main 종료 --");
	}
}
