package java_code.java_03day;

public class ControlFlow_if�� {

	public static void main(String[] args) {
		
		int x = 200;
		int y = 200;
		
//		System.out.println("x>y = " + (x>y)); // x�� �۴�
//		System.out.println("x<y = " + (x<y)); // y�� ũ��

//		if(x>y) System.out.println("x�� y���� ũ��");
	
//		if(x>y) {
//			System.out.println("���๮1");
//			System.out.println("x�� y���� ũ��");
//		}else {
//			System.out.println("y�� x���� ũ��");
//		}
		
		if(x>y) {
			System.out.println("x�� y���� ũ��"); // x>y ���ǽ��� true�� ��� ����
		}else if(x<y) {
			System.out.println("y�� x���� ũ��"); // x<y ���ǽ��� true�� ��� ����
		}else {
			System.out.println("x�� y�� ����"); // ���� if ���ǽ��� ��� false�� ��� ����
		}
		
		
	}

}
