package java_code.java_13day;

public class MathClassTest {

	public static void main(String[] args) {
		double randomNum = Math.random()*10000;
		int number = (int)Math.floor(randomNum); // ����� ����ȯ. double Ÿ���� int �� �ٲ�� �ϴϱ�

		System.out.println("randomNum = " + randomNum);
		System.out.println("number = " + number);
	}

}
