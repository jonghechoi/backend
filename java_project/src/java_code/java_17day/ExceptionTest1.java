package java_code.java_17day;

import java.util.ArrayList;

public class ExceptionTest1 {
	public static void main(String[] args) throws Exception {
		// 1���� �迭 5�� ���� �� '1. ȫ�浿' ��������
		String[] nameList = new String[5];
		
		// �����
		try {
			for(int i=0; i<6; i++) { 
				nameList[i] = i+1+". ȫ�浿";
				System.out.println(nameList[i]);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
