package java_code.java_04day;
import java.util.Scanner;

public class Gugudan_03 {

	public static void main(String[] args) {
		// ������ ���۰� ������ �Է¹޾�  ���
		
		Scanner scan = new Scanner(System.in);
		
		boolean flag = true;
		while(flag) {
			System.out.print("�����Ϸ��� ���ڸ� �Է��ϼ��� >  ");
			int startNum = scan.nextInt();
			System.out.print("�����Ϸ��� ���ڸ� �Է��ϼ��� >  ");
			int endNum = scan.nextInt();
			
			// startNum, endNum ���� ��� 0�� �ƴ� ��쿡�� ����
			if(startNum!=0 && endNum!=0) {
				// startNum ���� endNum�� �� ū ���
				if(startNum<endNum) {
					for(int i=1; i<=9; i++) {
						for(int j=startNum; j<=endNum; j++) {
							System.out.printf("%d*%d=%d  ",j,i,j*i);
						}
						System.out.println();
					}
				} else {	// startNum ���� endNum�� ũ�� ���� ���
					for(int i=1; i<=9; i++) {
						for(int j=startNum; j>=endNum; j--) {
							System.out.printf("%d*%d=%d  ",j,i,j*i);
						}
						System.out.println();
					}	
				}
				
				// startNum ���� endNum�� ũ�� ���� ���
				
				
			}else {
				System.out.println("0�� �Է��� �� �����ϴ�");
			}
			
			boolean flag2 = true;
			while(flag2) {
				System.out.print("��� �Ͻðڽ��ϱ�?(y/n) ");
				String yn = scan.next();
				
				if(yn.equals("y")) {
					flag2 = false;
				}else if(yn.equals("n")) {
					System.out.println("\n====== ���α׷� ���� ======\n");
					flag2 = flag = false;
				}else {
					System.out.println("�߸� �Է��߽��ϴ�. �ٽ� �Է����ּ���");
					flag2 = true;
				}
			}
		
		}
	}

}
