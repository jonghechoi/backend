package java_code.java_05day;
import java.util.Scanner;

public class ModulerTest {

	public static void main(String[] args) {
		// 100�̶�� �������� Ȧ������ ¦������ ���
		Scanner scan = new Scanner(System.in);
		
		boolean flag = true;
		while(flag) {
			try {
				System.out.print("���� �Է��ϼ��� >> ");
				int val = scan.nextInt();
				if(val != 0) {
					if(val%2 == 0 ) {
						// ¦��
						System.out.println("¦��");
					}else {
						// Ȧ��
						System.out.println("Ȧ��");
					}
					
					boolean flag2 = true;
					while(flag2) {
						System.out.print("��� �����Ͻðڽ��ϱ�?(y/n) ");
						String yesno = scan.next();
						if(yesno.equals("y")) {
							flag2 = false;
						}else if(yesno.equals("n")) {
							flag = flag2 = false;
						}else {
							System.out.println("�߸��� ���� �Է��߽��ϴ�. �ٽ� �Է��ϼ���");
						}
					}
					
				}else {
					// val ���� 0
					System.out.println("0�� �Է��Ͽ����ϴ�. \n ====== ���α׷� ���� ======");
					flag = false;
				}
			}catch(Exception e) {
				System.out.println("�߸��� ���� �Է��߽��ϴ�. �ٽ� �Է��ϼ���");
				scan = new Scanner(System.in);
			}
			
		}

	}

}
