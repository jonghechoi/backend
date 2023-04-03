package java_code.java_4day;
import java.util.Scanner;

public class ControlFlow_for문2 {

	public static void main(String[] args) {
		// Scanner 클래스 이용하여 입력받기
		Scanner scan = new Scanner(System.in);
		System.out.print("초기값 > ");
		int startNum = scan.nextInt();
		System.out.print("최종값 > ");
		int finalNum = scan.nextInt();
		
		// 실행은 최종값이 초기값보다 큰 경우에만 실행하도록 한다!!
		if(startNum>finalNum) {
			System.out.println("최종값이 초기값보다 큼");
		} else {
			int sum = 0;		
			for(int i=startNum; i<finalNum+1; i++) {
				sum += i;
			}
			System.out.println("i의 값은 = " + sum);
		}
	}

}
