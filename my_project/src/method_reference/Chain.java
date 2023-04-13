package method_reference;

public class Chain {
	public static void staticChain(String s1, String s2) {
		System.out.println(s1 + ", " + s2);
	}
	
	public void instanceChain(String s1, String s2) {
		System.out.println(s1 + ", " + s2);
	}
}
