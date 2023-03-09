package java_code.java_15day;

public class ShapeTest {

	public static void main(String[] args) {
//		Circle 빨강색원 = new Circle("빨강색");
//		Circle 파랑색원 = new Circle("빨강색");
		
//		Square 노랑색사각형 = new Square("노랑색");
//		Square 보라색사각형 = new Square("보라색");
//		
//		Triangle 초록색삼각형 = new Triangle("초록색");
		
//		빨강색원.draw();
//		파랑색원.draw();
//		노랑색사각형.draw();
//		보라색사각형.draw();
//		초록색삼각형.draw();
		
		// 명시적 형변환 - 상속관계가 있는 상태에서 자식의 모습으로 부모가 생성되어진 경우
		Shape S1 = new Circle("아무");
		Circle C1 = (Circle)S1;
		
		S1.draw(); // 자식클래스 메소드도 사용하므로 아래와 같은 결과 나옴
		C1.draw(); // 
		
	}

}

