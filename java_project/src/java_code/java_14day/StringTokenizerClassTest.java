package java_code.java_14day;
import java.util.StringTokenizer;

public class StringTokenizerClassTest {

	public static void main(String[] args) {
		// ��ü �����ϴ� ���� ��ūȭ �ȴٰ� �����ϸ� ��
		StringTokenizer st = new StringTokenizer("java,oracle,python,html,php",",");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
	}

}
