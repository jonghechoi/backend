package java_code.java_15day;

public class Dog implements Animal, Hospital {
	// Field
	String name, address;
	int age;
	
	@Override
	public void checkUp() {
		System.out.println("dog : 건강검진하다");
	}
	
	@Override
	public void eat() {
		System.out.println("dog : 먹다");
	}
	
	@Override
	public void sleep() {
		System.out.println("dog : 자다");
	}
}
