package java_code.java_04day;
import java.util.Scanner;

public class Gugudan_03 {

	public static void main(String[] args) {
		// 임의의 시작과 끝단을 입력받아  출력
		
		Scanner scan = new Scanner(System.in);
		
		boolean flag = true;
		while(flag) {
			System.out.print("시작하려는 숫자를 입력하세요 >  ");
			int startNum = scan.nextInt();
			System.out.print("종료하려는 숫자를 입력하세요 >  ");
			int endNum = scan.nextInt();
			
			// startNum, endNum 값이 모두 0이 아닌 경우에만 실행
			if(startNum!=0 && endNum!=0) {
				// startNum 보다 endNum이 더 큰 경우
				if(startNum<endNum) {
					for(int i=1; i<=9; i++) {
						for(int j=startNum; j<=endNum; j++) {
							System.out.printf("%d*%d=%d  ",j,i,j*i);
						}
						System.out.println();
					}
				} else {	// startNum 보다 endNum이 크지 않을 경우
					for(int i=1; i<=9; i++) {
						for(int j=startNum; j>=endNum; j--) {
							System.out.printf("%d*%d=%d  ",j,i,j*i);
						}
						System.out.println();
					}	
				}
				
				// startNum 보다 endNum이 크지 않을 경우
				
				
			}else {
				System.out.println("0은 입력할 수 없습니다");
			}
			
			boolean flag2 = true;
			while(flag2) {
				System.out.print("계속 하시겠습니까?(y/n) ");
				String yn = scan.next();
				
				if(yn.equals("y")) {
					flag2 = false;
				}else if(yn.equals("n")) {
					System.out.println("\n====== 프로그램 종료 ======\n");
					flag2 = flag = false;
				}else {
					System.out.println("잘못 입력했습니다. 다시 입력해주세요");
					flag2 = true;
				}
			}
		
		}
	}

}
