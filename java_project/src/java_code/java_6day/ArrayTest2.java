package java_code.java_6day;

public class ArrayTest2 {

	public static void main(String[] args) {
		// String 문자열을 배열에 저장 후 출력
		String[] strList = new String[3];
		strList[0] = "JAVA";
		strList[1] = new String("Oracle");
		strList[2] = "HTML";
		
		// strList의 값을 출력(확장 for)
		for(String i:strList) {
			System.out.println(i);
		}

	}

}
