package java_code.java_13day;
import java.util.ArrayList;

public class ArrayListClassTest {

	public static void main(String[] args) {
		ArrayList alist = new ArrayList(); // 기본 저장공간 10개 생성
		System.out.println(alist.size()); // 실제 들어간 사이즈
		
		alist.add(new String("홍길동"));
		alist.add("최치열");
		alist.add(124); // 객체 형태로만 들어가야 하는데 int, double, String도 가능하다??
		alist.add(123.13135); // wrapper 클래스가 자동으로 형변환을 하여 [new 123],[new "최치열"] 등으로 객체로 넣음
		System.out.println(alist.size());
		
		// 확장 for문을 쓰려면 데이터 타입이 같아야 하는데 위의 경우는 데이터 타입이 다르므로 쓸 수 없음
		for (int i=0; i<alist.size(); i++) {
			System.out.println(alist.get(i));
		}
	}

}
