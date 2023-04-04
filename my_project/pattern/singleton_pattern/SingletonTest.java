package singleton_pattern;

public class SingletonTest {

	public static void main(String[] args) {
		
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		
		boolean result = (instance1 == instance2);
		
		System.out.printf("result --> %b",result );
		System.out.println();
	}

}
