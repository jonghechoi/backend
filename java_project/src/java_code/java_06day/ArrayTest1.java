package java_code.java_6day;
import java.util.Scanner;

public class ArrayTest1 {

	public static void main(String[] args) {
		// 배열 정의
		int[] numberList1 = new int[10]; // 배열 안의 default 값은 모두 0 
		int numberList2[] = new int[4];
		int[] numberList3 = new int[] {10,20,30}; // default: 10,20,30
		int[] numberList4 = {100,200,300};
		int[] numberList5 = null; // heap에 생성될 객체의 주소가 담길 예정이다!
		Scanner scan = null; // 나중에 생성될 Scanner 객체의 주소가 담길 예정
		
		// numberList1의 7번째 자리에 100을 입력
		numberList1[6] = 100;
		
		// numberList1 객체의 데이터 출력(인덱스 포함)
		for(int i=0;i<numberList1.length;i++) {
			System.out.println(i + " = " + numberList1[i]);
		}
		
		// numberList1 객체의 데이터 출력(인덱스 없이)
		for(int i:numberList1) {
			System.out.println(i);
		}
	}

}
