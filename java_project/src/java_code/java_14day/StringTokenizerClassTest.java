package java_code.java_14day;
import java.util.StringTokenizer;

public class StringTokenizerClassTest {

	public static void main(String[] args) {
		// 객체 생성하는 순간 토큰화 된다고 생각하면 됨
		StringTokenizer st = new StringTokenizer("java,oracle,python,html,php",",");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
	}

}
