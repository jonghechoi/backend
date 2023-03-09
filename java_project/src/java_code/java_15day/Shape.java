package java_code.java_15day;

//public class Shape {
//	String color;
//	
//	public void draw() {
//		System.out.println("도형을 그린다");
//	}
//}

public abstract class Shape {
	String color;
	
	Shape() {
		System.out.println("Shape : 생성자 호출");
	}

	Shape(String childName) {
		System.out.println(childName + " ===> Shape : 생성자 호출");
	}
	
	public abstract void draw();
}
