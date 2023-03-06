package java_code.java_6day;
import java.util.Scanner;

public class ArrayTest3 {

	public static void main(String[] args) {
		// Scanner 클래스를 3개 생성하여 배열에 저장
		Scanner[] scanList = new Scanner[3]; // heap에 Scanner 객체가 3개 만들어지는 것이 절대 아님!!! 우선은 주소(초기값 null) 들어갈 방 3개가 생성
		
//		System.out.println(scanList[0]);
//		System.out.println(scanList[1]);
//		System.out.println(scanList[2]);
		
		scanList[0] = new Scanner(System.in);
		
		for(int i=0;i<scanList.length;i++) {
			System.out.println(scanList[i]);
		}

	}

}
