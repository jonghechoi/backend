package java_code.java_04day;
import java.util.Scanner;

public class Gugudan_01 {

	public static void main(String[] args) {
		/* 2�� ���
		 * 2 * 1 = 2
		 * 2 * 2 = 4
		 * ...
		 */
		
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		
		while(flag) {
			System.out.print("���ڸ� �Է��ϼ���. (���Ḧ ���ϸ� 0�� �Է��ϼ���) > ");
			int dan = scan.nextInt();
			if(dan>0) {
				System.out.printf("== %d�� ��� ==%n",dan);
				for(int i=1; i<10; i++) {
					// System.out.println("2 * " + i + " = " + (2*i));
					System.out.printf("%d * %d = %d %n",dan,i,dan*i);
				}
			}else {
				System.out.println("0���� ��µ��� �ʽ��ϴ�");
			}//if
			
			boolean flag2 = true;
			while(flag2) {
				// ��� ���� ���� ����
				System.out.print("��� �����ұ��?(y/n) > ");
				String yesno = scan.next();
				if(yesno.equals("n")) {
					System.out.println("���α׷��� �����մϴ�");
					flag = flag2 = false;
				}else if(yesno.equals("y")) {
					flag2 = false;
				}else {
					System.out.println("�߸��� ���� �Է��߽��ϴ�");
					flag2 = false;
				}
			}
			
		}//while
	}

}
