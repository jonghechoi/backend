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
		 * ArrayList ��ü�� ListŸ������ �޴� ������??
		 * ������, Ȯ�强, ������, ���޸� ȿ���� ���ؼ���... ��?
		 * 1. ������, Ȯ�强
		 * 		���� ���� �� ArrayList�� LinkedList�� �ٲ�� �Ѵٸ� ArrayList�� ����� ��� �ڵ带 �����ؾ���
		 * 		������ List�� ����Ѵٸ� ����Ÿ�Ը� �������ָ� �� -> List<String> dataList = new LinkedList<>()
		 * 2. ���޸� ȿ��
		 * 		ArrayList ��ü�� ��� ���޸𸮸� ��� ����ϴ� ���� �ƴ϶� ArrayList ��ü���� �Ҵ�� ���޸� �� ListŸ�Ը�
		 * 		��� �����Ƿ� ���޸� ȿ���� ����!
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
		
		// �迭���� Ư�� ���ڿ� ����
		List<String> strList = new ArrayList<String>();
		String[] city = {"����", "����", "����"};
		strList.addAll(Arrays.asList(city));
		System.out.println(strList);

	}
}