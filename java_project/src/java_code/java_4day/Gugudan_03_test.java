package java_code.java_4day;
import java.util.Scanner;

public class Gugudan_03_test {

	public static void main(String[] args) {
		/*
		 * 임의의 시작과 끝단을 입력받아 단까지 출력해주세요.
		 * 1. 시작단의 변수는 start, 끝단의 변수는 end로 정의한다.
		 * 2. start, end 변수는 모두 0이 아닌 경우에만 출력되도록 한다.
		 * 		만약, start,end 변수에 하나라도 0이 입력되면 프로그램이 종료된다.
		 * 3. start가 end보다 작은 경우 구구단 형식으로 출력
		 * 		만약, start가 end보다 큰 경우 구구단 형식으로 단을 감소시켜 출력
		 * 4. 정상적으로 프로그램이 잘 동작되면, 반복적으로 작동시킨다.
		 */
		
		Scanner scan = new Scanner(System.in);
		
		boolean flag = true;
		while(flag) {
			System.out.print("시작값을 입력하세요 > ");
			int start = scan.nextInt();
			System.out.print("끝값을 입력하세요 > ");
			int end = scan.nextInt();
			
			if( start!=0 && end!=0) {
				System.out.println("====== 프로그램 실행 ======");
				
				if(start<=end) {
					// 여기다가 구구단 중첩 for문 작성
					for(int i=1; i<=9; i++) {
						for(int j=start; j<=end; j++) {
							System.out.printf("%d*%d=%d   ",j,i,j*i);
						}
						System.out.println();
					}
				}else {
					// 역순 구구단 중첩 for문 작성
					for(int i=1; i<=9; i++) {
						for(int j=start; j>=end; j--) {
							System.out.printf("%d*%d=%d   ",j,i,j*i);
						}
						System.out.println();
					}
				}
				
			}else {
				System.out.println("====== 프로그램 종료 ======");
				System.exit(0);
			}
			
			boolean flag2 = true;
			while(flag2) {
				System.out.print("계속 진행하시겠습니까?(y/n으로 선택)");
				String yn = scan.next();
				if(yn.equals("y")) {
					System.out.println("\n====== 프로그램이 계속 실행됩니다 ======\n");
					flag2 = false;
				}else if(yn.equals("n")) {
					System.out.println("\n====== 프로그램이 종료됩니다 ======\n");
					flag2 = flag = false;
				}else {
					System.out.println("\n====== 다시 입력하십시오 ======\n");
					flag2 = true;
				}
			}
		}
	}

}
