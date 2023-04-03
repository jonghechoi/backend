package java_code.java_4day;

public class ControlFlow_while문2 {

	public static void main(String[] args) {
		// 1에서 10까지 합계 출력
		int i = 1;
		while(i<11) {
			System.out.println(i);
			i++;
		}
		
		int j = 1;
		int sum = 0;
		while(j<11) {
			sum += j;
			j++;
		}
		System.out.println(sum);
		
		
	}
}
