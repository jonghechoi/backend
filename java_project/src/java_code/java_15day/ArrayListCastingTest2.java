package java_code.java_15day;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCastingTest2 {

	public static void main(String[] args) {
		
//		List<Integer> valList = new ArrayList<Integer>(); // premitive Ÿ���� <>�� �����Ƿ� wrapperŬ���� �̿�
//		valList.add(100); // Ÿ���� Integer �̹Ƿ� JVM�� ���������� �ٲ�
//		valList.add(new Integer(100)); 
	
//		valList.remove(new Integer(100)); // API �������� .remove(Object o)�̹Ƿ� Integer ��ü�� 100�� ��������
//		System.out.println(valList.get(0));
//		System.out.println(valList.get(1));
		
		List<String> strList = new ArrayList<String>();
		for(int i=0;i<5;i++) {
			strList.add(i+". ȫ�浿");
			System.out.println(strList.get(i));
		}
		
//		ArrayList<String> subList = (ArrayList<String>)strList.subList(0, 3);
		List<String> subList = strList.subList(0, 3);
		for(String str : subList) {
			System.out.println("sublist : " + str);
		}
	}

}
