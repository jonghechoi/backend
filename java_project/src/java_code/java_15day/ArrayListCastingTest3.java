package java_code.java_15day;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCastingTest3 {

	public static void main(String[] args) {
		
//		List<Integer> valList = new ArrayList<Integer>(); // premitive Ÿ���� <>�� �����Ƿ� wrapperŬ���� �̿�
//		valList.add(100); // Ÿ���� Integer �̹Ƿ� JVM�� ���������� �ٲ�
//		valList.add(new Integer(100)); 
	
//		valList.remove(new Integer(100)); // API �������� .remove(Object o)�̹Ƿ� Integer ��ü�� 100�� ��������
//		System.out.println(valList.get(0));
//		System.out.println(valList.get(1));
		
		List<Object> strList = new ArrayList<Object>();
		for(int i=0;i<5;i++) {
			strList.add(i+". ȫ�浿");
			System.out.println(strList.get(i));
		}
		
//		ArrayList<String> subList = (ArrayList<String>)strList.subList(0, 3);
		List<Object> subList = strList.subList(0, 3);
		for(int i=0;i<subList.size();i++) {
			String str = (String)subList.get(i);
			System.out.println("=====> " + str);
		}
		
//		for(String str : subList) { // Ȯ�� for���� ����� ����ȯ �Ұ�
//			System.out.println("sublist : " + str);
//		}
	}

}
