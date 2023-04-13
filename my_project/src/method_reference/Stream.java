package method_reference;

import java.util.List;


public class Stream {

	public static void main(String[] args) {
		List<String> list = List.of("A", "AB", "ABC");
		
		// 람다식
		list.stream()
				.map(str -> str.length())
				.forEach(str -> System.out.println(str));
		
		// 메소드 참조
		list.stream()
				.map(String::length)
				.forEach(System.out::println);
	}
}