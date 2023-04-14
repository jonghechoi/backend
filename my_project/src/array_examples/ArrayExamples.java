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
		
		// Arrays.asList()�� ��ȯ�� ��ü�� ArrayList�� �ƴ� Arrays$ArrayList Ŭ������ �ν��Ͻ��̱� ������
		// ��Ҹ� �߰�/���� �� �� ����
		// ���� ArrayList�� ��ȯ�ؾ� �Ѵ�
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