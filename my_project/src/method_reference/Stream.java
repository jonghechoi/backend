package method_reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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