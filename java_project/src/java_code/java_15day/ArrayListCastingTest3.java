package java_code.java_15day;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCastingTest3 {

	public static void main(String[] args) {
		
//		List<Integer> valList = new ArrayList<Integer>(); // premitive 타입은 <>에 못들어가므로 wrapper클래서 이용
//		valList.add(100); // 타입이 Integer 이므로 JVM이 내부적으로 바꿈
//		valList.add(new Integer(100)); 
	
//		valList.remove(new Integer(100)); // API 문서보면 .remove(Object o)이므로 Integer 객체인 100도 삭제가능
//		System.out.println(valList.get(0));
//		System.out.println(valList.get(1));
		
		List<Object> strList = new ArrayList<Object>();
		for(int i=0;i<5;i++) {
			strList.add(i+". 홍길동");
			System.out.println(strList.get(i));
		}
		
//		ArrayList<String> subList = (ArrayList<String>)strList.subList(0, 3);
		List<Object> subList = strList.subList(0, 3);
		for(int i=0;i<subList.size();i++) {
			String str = (String)subList.get(i);
			System.out.println("=====> " + str);
		}
		
//		for(String str : subList) { // 확장 for문은 명시적 형변환 불가
//			System.out.println("sublist : " + str);
//		}
	}

}
