package java_code.java_15day;

public class Cat implements Animal, Hospital {
	// Field
	String name, address;
	int age;

	@Override
	public void checkUp() {
		System.out.println("cat : �ǰ������ϴ�");
	}
	
	@Override
	public void eat() {
		System.out.println("cat : �Դ�");
	}
	
	@Override
	public void sleep() {
		System.out.println("cat : �ڴ�");
	}
}
