package java_code.java_15day;

public class ShapeTest {

	public static void main(String[] args) {
		Circle 빨강색원 = new Circle("빨강색");
		Circle 파랑색원 = new Circle("빨강색");
		
		Square 노랑색사각형 = new Square("노랑색");
		Square 보라색사각형 = new Square("보라색");
		
		Triangle 초록색삼각형 = new Triangle("초록색");
		
		빨강색원.draw();
		파랑색원.draw();
		노랑색사각형.draw();
		보라색사각형.draw();
		초록색삼각형.draw();
		
	}

}

