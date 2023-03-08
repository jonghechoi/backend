package java_code.java_15day;

public class Square extends Shape {
	String color;
	
	public Square(String color) {
		this.color = color;
	}
	
	public void draw() {
		System.out.println(color+"사각형을 그린다");
	}
}
