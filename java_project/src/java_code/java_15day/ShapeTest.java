package java_code.java_15day;

public class ShapeTest {

	public static void main(String[] args) {
//		Circle �������� = new Circle("������");
//		Circle �Ķ����� = new Circle("������");
		
//		Square ������簢�� = new Square("�����");
//		Square ������簢�� = new Square("�����");
//		
//		Triangle �ʷϻ��ﰢ�� = new Triangle("�ʷϻ�");
		
//		��������.draw();
//		�Ķ�����.draw();
//		������簢��.draw();
//		������簢��.draw();
//		�ʷϻ��ﰢ��.draw();
		
		// ����� ����ȯ - ��Ӱ��谡 �ִ� ���¿��� �ڽ��� ������� �θ� �����Ǿ��� ���
		Shape S1 = new Circle("�ƹ�");
		Circle C1 = (Circle)S1;
		
		S1.draw(); // �ڽ�Ŭ���� �޼ҵ嵵 ����ϹǷ� �Ʒ��� ���� ��� ����
		C1.draw(); // 
		
	}

}

