package java_code.java_6day;

public class ArrayTest2 {

	public static void main(String[] args) {
		// String ���ڿ��� �迭�� ���� �� ���
		String[] strList = new String[3];
		strList[0] = "JAVA";
		strList[1] = new String("Oracle");
		strList[2] = "HTML";
		
		// strList�� ���� ���(Ȯ�� for)
		for(String i:strList) {
			System.out.println(i);
		}

	}

}
