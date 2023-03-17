package java_code.java_20day;

import java.util.ArrayList;

public class LambdaTest {

	public static void main(String[] args) {
		// ArrayList
		ArrayList<String> list = new ArrayList<String>();
		
		// 데이터 입력
		for(int i=0; i<5; i++) {
			list.add((i+1) + ". Hello Java");
		}
		// 데이터 출력
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
		for(String i : list) {
			System.out.println(i);
		}
		System.out.println();
		// forEach
		list.forEach((String str) -> {System.out.println(str);});
		list.forEach(str -> {System.out.println(str);});
	}

}
