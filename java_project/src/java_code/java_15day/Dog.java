package java_code.java_15day;

public class Dog implements Animal, Hospital {
	// Field
	String name, address;
	int age;
	
	@Override
	public void checkUp() {
		System.out.println("dog : �ǰ������ϴ�");
	}
	
	@Override
	public void eat() {
		System.out.println("dog : �Դ�");
	}
	
	@Override
	public void sleep() {
		System.out.println("dog : �ڴ�");
	}
}
