package java_code.java_15day;

public class Cat implements Animal, Hospital {
	// Field
	String name, address;
	int age;

	@Override
	public void checkUp() {
		System.out.println("cat : 건강검진하다");
	}
	
	@Override
	public void eat() {
		System.out.println("cat : 먹다");
	}
	
	@Override
	public void sleep() {
		System.out.println("cat : 자다");
	}
}
