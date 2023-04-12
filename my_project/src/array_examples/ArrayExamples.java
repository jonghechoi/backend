package array_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayExamples {

	public static void main(String[] args) {
		// List
		List<String> list = List.of("A", "AB", "ABC");
		System.out.println(list);
		
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
        System.out.println(aList);
        
        // Arrays.toString(str)
        String[] str = {"A", "B", "C"}; 
        System.out.println(Arrays.toString(str));
        
        // 
		List<String> words = Arrays.asList("apple", "banana", "orange", "pear", "watermelon");

		List<String> longWords = words.stream()
		                              .filter(string -> string.length() >= 5)
		                              .collect(Collectors.toList());
		System.out.println(longWords);

	}

}
