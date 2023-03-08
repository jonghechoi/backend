package java_code.java_15day;

public class Triangle extends Shape {
	String color;
	
	public Triangle(String color) {
		this.color = color;
	}
	
	public void draw() {
		System.out.println(color+"삼각형을 그린다");
	}
}
