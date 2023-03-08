package java_code.java_14day;
import java.util.Random;

public class RandomClassTest {

	public static void main(String[] args) {
		System.out.println((int)Math.floor(Math.random()*100));
		
		// Random 클래스 생성 및 난수 발생
		Random rd = new Random();
		System.out.println(rd.nextInt()); // 양수, 음수 포함
		System.out.println(rd.nextInt(100)); // 2자리 양의 정수만 출력하기
		System.out.println(rd.nextDouble());
		
	}

}
