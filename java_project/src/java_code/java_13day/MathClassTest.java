package java_code.java_13day;

public class MathClassTest {

	public static void main(String[] args) {
		double randomNum = Math.random()*10000;
		int number = (int)Math.floor(randomNum); // 명시적 형변환. double 타입을 int 로 바꿔야 하니까

		System.out.println("randomNum = " + randomNum);
		System.out.println("number = " + number);
	}

}
