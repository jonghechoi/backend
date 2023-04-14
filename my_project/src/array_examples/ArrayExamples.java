package array_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayExamples {

	public static void main(String[] args) {
		// List
		List<String> list = List.of("A", "AB", "ABC");
//		System.out.println(list);
		
		/*
		 * ArrayList 객체를 List타입으로 받는 이유는??
		 * 유연성, 확장성, 가독성, 힙메모리 효율을 위해서임... 왜?
		 * 1. 유연성, 확장성
		 * 		유지 보수 중 ArrayList를 LinkedList를 바꿔야 한다면 ArrayList를 사용한 모든 코드를 수정해야함
		 * 		하지만 List를 사용한다면 변수타입만 수정해주면 됨 -> List<String> dataList = new LinkedList<>()
		 * 2. 힙메모리 효율
		 * 		ArrayList 객체가 잡는 힙메모리를 모두 사용하는 것이 아니라 ArrayList 객체에게 할당된 힙메모리 중 List타입만
		 * 		잡고 있으므로 힙메모리 효율이 증가!
		 */		
		List<String> aList = new ArrayList<>();
        aList.add("A");
        aList.add("AB");
        aList.add("ABC");
//        System.out.println(aList.getClass());
        
        // Arrays.toString(str)
        String[] str = {"A", "B", "C"}; 
        System.out.println(str);
//        System.out.println(Arrays.toString(str));
        
        // 
		List<String> words = Arrays.asList("apple", "banana", "orange", "pear", "watermelon");

		List<String> longWords = words.stream()
		                              .filter(string -> string.length() >= 5)
		                              .collect(Collectors.toList());
//		System.out.println(longWords);
		
		// 배열에서 특정 문자열 변경
		List<String> strList = new ArrayList<String>();
		String[] city = {"서울", "전주", "제주"};
		strList.addAll(Arrays.asList(city));
		System.out.println(strList);
		
		// Arrays.asList()로 반환된 객체는 ArrayList가 아닌 Arrays$ArrayList 클래스의 인스턴스이기 때문에
		// 요소를 추가/삭제 할 수 없다
		// 따라서 ArrayList로 변환해야 한다
//		List<String> aaa = Arrays.asList("1", "2", "3", "4", "5");
		List<String> bbb = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));
		String[] ccc = {"6", "7", "8"};
		bbb.addAll(Arrays.asList(ccc));
//		System.out.println(bbb);
		
		List<String> ddd = bbb.stream()
							  .filter(i -> Integer.valueOf(i) >= 5)
							  .collect(Collectors.toList());
		System.out.println("ddd --> " + ddd);
		
		System.out.println(Math.max(15, 10));
		System.out.println(Integer.compare(10, 20));
		System.out.println(Integer.compare(20, 10));
		System.out.println(Integer.compare(30, 30));
		
		System.out.println("maxInt : " + "-".repeat(30));
		
		List<String> listTest = new ArrayList<String>(Arrays.asList("A", "AB", "ABC,"));
		Object[] objTest = listTest.toArray();
		
		List<Object> listTest2 = Arrays.asList(objTest);
		
		System.out.println(listTest2);

	}
}