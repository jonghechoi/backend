package java_code.java_13day;

public class StringBufferClassTest {

	public static void main(String[] args) {
		String name = "홍길동"; // 맨처음에 "홍길동"이 들어가고
		name = name + ", 김고은"; // 추가가 되면 새롭게 저장공간이 만들어지고 거기에 들어감
		name = name + ", 김철수"; // 세번째가 들어가면 또 새로 만들어짐
		name = name + ", 이영희"; 
		name = name + ", 박보검"; // 총 5개의 저장공간이 생기게 됨. 이전 4개의 변수는 GC가 해결
								// 굉장히 비효율적
		System.out.println("name = " + name);
		
		// StringBuffer
		StringBuffer sb = new StringBuffer(30);
		System.out.println("capacity ==> " + sb.capacity());
		
		sb.append("홍길동");
		sb.append("김고은");
		sb.append("김철수");
		System.out.println("capacity ==> " + sb.capacity());
		System.out.println("length ==> " + sb.length());
		
		System.out.println(sb.toString()); // StringBuffer의 부모는 java.lang.Object
										   // 때문에 object의 모든 메소드를 상속 받으므로 java.lang.String의 메소드도 가져올 수 있음
		System.out.println(sb);
		
		sb.append("전도연");
		System.out.println(sb);
		
		sb.insert(3, "이순신");
		System.out.println(sb);
	}

}
