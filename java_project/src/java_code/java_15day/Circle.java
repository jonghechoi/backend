package java_code.java_15day;

public class Circle extends Shape {
//	String color;
	
	Circle(String color) {
		super("�ڽ�: Circle");
		this.color = color;
		System.out.println("Circle : ������ ȣ��");
	}
	
	@Override
	public void draw() {
		System.out.println(color+"���� �׸���");
	}
}
