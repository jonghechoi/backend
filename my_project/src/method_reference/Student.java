package method_reference;

public class Student {
	String name, major;
	
	Student(String name, String major) {
		this.name = name;
		this.major = major;
		
		printMethod();
	}
	
	public void printMethod() {
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + major);
	}
}
