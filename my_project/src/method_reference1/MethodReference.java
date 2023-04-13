package method_reference1;

public class MethodReference {
	// 정적 메소드 참조
	public static void staticChain(String s1, String s2) {
		System.out.println(s1 + "," + s2);
	}
	
	// 인스턴스 메소드 참조
	public void instanceChain(String s1, String s2) {
		System.out.println(s1 + "," + s2);
	}
		
	
}
