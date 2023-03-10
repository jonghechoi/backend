package java_code.java_17day;

import java.util.ArrayList;

public class ExceptionTest1 {
	public static void main(String[] args) throws Exception {
		// 1차원 배열 5개 생성 후 '1. 홍길동' 형식으로
		String[] nameList = new String[5];
		
		// 입출력
		try {
			for(int i=0; i<6; i++) { 
				nameList[i] = i+1+". 홍길동";
				System.out.println(nameList[i]);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
