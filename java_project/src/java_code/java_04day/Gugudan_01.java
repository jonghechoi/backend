package java_code.java_04day;
import java.util.Scanner;

public class Gugudan_01 {

	public static void main(String[] args) {
		/* 2단 출력
		 * 2 * 1 = 2
		 * 2 * 2 = 4
		 * ...
		 */
		
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		
		while(flag) {
			System.out.print("숫자를 입력하세요. (종료를 원하면 0을 입력하세요) > ");
			int dan = scan.nextInt();
			if(dan>0) {
				System.out.printf("== %d단 출력 ==%n",dan);
				for(int i=1; i<10; i++) {
					// System.out.println("2 * " + i + " = " + (2*i));
					System.out.printf("%d * %d = %d %n",dan,i,dan*i);
				}
			}else {
				System.out.println("0단은 출력되지 않습니다");
			}//if
			
			boolean flag2 = true;
			while(flag2) {
				// 계속 진행 여부 결정
				System.out.print("계속 진행할까요?(y/n) > ");
				String yesno = scan.next();
				if(yesno.equals("n")) {
					System.out.println("프로그램을 종료합니다");
					flag = flag2 = false;
				}else if(yesno.equals("y")) {
					flag2 = false;
				}else {
					System.out.println("잘못된 값을 입력했습니다");
					flag2 = false;
				}
			}
			
		}//while
	}

}
