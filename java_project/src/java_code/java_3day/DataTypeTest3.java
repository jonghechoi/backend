package java_code.java_3day;

public class DataTypeTest3 {

	public static void main(String[] args) {
		// ������ ����ȯ
		short s = 10; // 2byte
		int i = s; // 4byte
		double d1 = i; // 8byte
		double d2 = s; // 8byte
		
		// ����� ����ȯ
		int i2 = 1000; // 4byte
		short s2 = (short)i2; // 2byte
		
	}

}
