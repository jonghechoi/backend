package java_code.java_4day;
import java.util.Scanner;

public class ControlFlow_while��3 {

	public static void main(String[] args) {
		// �޴��� �ݺ������� �����ϴ� ���� ���� -> ���α׷� ���ῡ �ʿ��� flag ���� ���!!
		
		
		// �޴� ���
		System.out.println("-------------");
		System.out.println("1. ���");
		System.out.println("2. ���");
		System.out.println("0. ����");
		System.out.println("-------------");
		
		// �޴� ����
		Scanner scan = new Scanner(System.in);
		
		boolean flag = true;
		while(flag) {
			System.out.print("�޴�(����) > ");
			int menu = scan.nextInt();
			
			switch(menu) {
				case 1:
					System.out.println("��� \n");
					break;
				case 2:
					System.out.println("��� \n");
					break;
				case 0:
					// ���� ���� Ȯ��
					System.out.print("������ �����Ͻðڽ��ϱ�?(y/n) > ");
					String con = scan.next();
					if(con.equals("y")) {
						System.out.println("-- while ���� --");
						 flag = false;
//						System.exit(0); 
					}else if(con.equals("n")) {
						System.out.println("n ����");
					}else {
						System.out.println("�ٸ� �޴��� �����ϼ̽��ϴ�");
					}
					
					break;				
				default: 
					System.out.println("�޴� �غ����Դϴ� \n");
			}
		}
		System.out.println("-- main ���� --");
	}
}
