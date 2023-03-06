package java_code.java_4day;
import java.util.Scanner;

public class Gugudan_03_test {

	public static void main(String[] args) {
		/*
		 * ������ ���۰� ������ �Է¹޾� �ܱ��� ������ּ���.
		 * 1. ���۴��� ������ start, ������ ������ end�� �����Ѵ�.
		 * 2. start, end ������ ��� 0�� �ƴ� ��쿡�� ��µǵ��� �Ѵ�.
		 * 		����, start,end ������ �ϳ��� 0�� �ԷµǸ� ���α׷��� ����ȴ�.
		 * 3. start�� end���� ���� ��� ������ �������� ���
		 * 		����, start�� end���� ū ��� ������ �������� ���� ���ҽ��� ���
		 * 4. ���������� ���α׷��� �� ���۵Ǹ�, �ݺ������� �۵���Ų��.
		 */
		
		Scanner scan = new Scanner(System.in);
		
		boolean flag = true;
		while(flag) {
			System.out.print("���۰��� �Է��ϼ��� > ");
			int start = scan.nextInt();
			System.out.print("������ �Է��ϼ��� > ");
			int end = scan.nextInt();
			
			if( start!=0 && end!=0) {
				System.out.println("====== ���α׷� ���� ======");
				
				if(start<=end) {
					// ����ٰ� ������ ��ø for�� �ۼ�
					for(int i=1; i<=9; i++) {
						for(int j=start; j<=end; j++) {
							System.out.printf("%d*%d=%d   ",j,i,j*i);
						}
						System.out.println();
					}
				}else {
					// ���� ������ ��ø for�� �ۼ�
					for(int i=1; i<=9; i++) {
						for(int j=start; j>=end; j--) {
							System.out.printf("%d*%d=%d   ",j,i,j*i);
						}
						System.out.println();
					}
				}
				
			}else {
				System.out.println("====== ���α׷� ���� ======");
				System.exit(0);
			}
			
			boolean flag2 = true;
			while(flag2) {
				System.out.print("��� �����Ͻðڽ��ϱ�?(y/n���� ����)");
				String yn = scan.next();
				if(yn.equals("y")) {
					System.out.println("\n====== ���α׷��� ��� ����˴ϴ� ======\n");
					flag2 = false;
				}else if(yn.equals("n")) {
					System.out.println("\n====== ���α׷��� ����˴ϴ� ======\n");
					flag2 = flag = false;
				}else {
					System.out.println("\n====== �ٽ� �Է��Ͻʽÿ� ======\n");
					flag2 = true;
				}
			}
		}
	}

}
