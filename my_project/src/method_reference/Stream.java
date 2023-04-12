package method_reference;

import java.util.List;


public class Stream {

	public static void main(String[] args) {
		List<String> list = List.of("A", "AB", "ABC");
		
		// ���ٽ�
		list.stream()
				.map(str -> str.length())
				.forEach(str -> System.out.println(str));
		
		// �޼ҵ� ����
		list.stream()
				.map(String::length)
				.forEach(System.out::println);
	}
}