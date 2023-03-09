package java_code.java_15day;

public class Circle extends Shape {
//	String color;
	
	Circle(String color) {
		super("자식: Circle");
		this.color = color;
		System.out.println("Circle : 생성자 호출");
	}
	
	@Override
	public void draw() {
		System.out.println(color+"원을 그린다");
	}
}
