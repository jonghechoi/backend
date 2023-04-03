package java_code.java_05day;
import java.util.Scanner;

public class ModulerTest {

	public static void main(String[] args) {
		// 100이라는 정수값이 홀수인지 짝수인지 출력
		Scanner scan = new Scanner(System.in);
		
		boolean flag = true;
		while(flag) {
			try {
				System.out.print("값을 입력하세요 >> ");
				int val = scan.nextInt();
				if(val != 0) {
					if(val%2 == 0 ) {
						// 짝수
						System.out.println("짝수");
					}else {
						// 홀수
						System.out.println("홀수");
					}
					
					boolean flag2 = true;
					while(flag2) {
						System.out.print("계속 진행하시겠습니까?(y/n) ");
						String yesno = scan.next();
						if(yesno.equals("y")) {
							flag2 = false;
						}else if(yesno.equals("n")) {
							flag = flag2 = false;
						}else {
							System.out.println("잘못된 값을 입력했습니다. 다시 입력하세요");
						}
					}
					
				}else {
					// val 값이 0
					System.out.println("0을 입력하였습니다. \n ====== 프로그램 종료 ======");
					flag = false;
				}
			}catch(Exception e) {
				System.out.println("잘못된 값을 입력했습니다. 다시 입력하세요");
				scan = new Scanner(System.in);
			}
			
		}

	}

}
