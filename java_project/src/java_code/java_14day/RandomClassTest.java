package java_code.java_14day;
import java.util.Random;

public class RandomClassTest {

	public static void main(String[] args) {
		System.out.println((int)Math.floor(Math.random()*100));
		
		// Random Ŭ���� ���� �� ���� �߻�
		Random rd = new Random();
		System.out.println(rd.nextInt()); // ���, ���� ����
		System.out.println(rd.nextInt(100)); // 2�ڸ� ���� ������ ����ϱ�
		System.out.println(rd.nextDouble());
		
	}

}
