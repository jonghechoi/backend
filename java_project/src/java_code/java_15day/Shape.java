package java_code.java_15day;

//public class Shape {
//	String color;
//	
//	public void draw() {
//		System.out.println("������ �׸���");
//	}
//}

public abstract class Shape {
	String color;
	
	Shape() {
		System.out.println("Shape : ������ ȣ��");
	}

	Shape(String childName) {
		System.out.println(childName + " ===> Shape : ������ ȣ��");
	}
	
	public abstract void draw();
}
