package java_code.java_17day;
import java.io.File;

public class ExceptionTest4 {
	public static void main(String[] args) throws Exception {
		
		// ���� ����
		File file = new File("text.txt");
		try {
//			boolean result1 = file.createNewFile();
//			if(result1) {
//				System.out.println("���� ���� �Ϸ�");
//			}else {
//				System.out.println("���� ���� ����");
//			}

			boolean result2 = file.delete();
			if(result2) {
				System.out.println("���� ���� �Ϸ�");
			}else {
				System.out.println("���� ���� ����");
			}
		}catch (Exception e) {
			System.out.println("== ���� ó�� �Ϸ� ==");
		}
		
	}
}
