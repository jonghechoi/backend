package java_code.java_06day;
import java.util.Scanner;

public class ScoreTest2 {

	public static void main(String[] args) {
		// �л� ����(�л���, ����, ����, ��������)�� �Է� �޾� ����Ͻÿ�
		// �л� ���� ���� �� ���Ƿ� �Է¹޾� ����
//		hong,10,20,30,kim,10,10,10,park,20,20,20
//		hong,kim,park // �л���
//		10,20,30      // ����
//		10,10,10      // ����       
//		100,90,80     // ����
	
		Scanner scan = new Scanner(System.in);
		System.out.print("�л��� �Է�(����)> ");
		int size = scan.nextInt();
		String contCon = "";
		
		// �迭 ����
		String[] nameList = new String[size];
		double[] korList = new double[size];
		double[] engList = new double[size];
		double[] mathList = new double[size];
		double[] totList = new double[size];
		double[] avgList = new double[size];
		
		int count = 0; // ��ϵ� �л� ��
		
		boolean flag = true;
		while(flag) {
			// ������ �Է� : ����Ǵ� �ε��� ������
			for(int i=count;i<nameList.length;i++) {
				System.out.print("�л� �̸��� �Է����ּ��� > ");
				nameList[i] = scan.next();
				
				System.out.print("���� >> ");
				korList[i] = scan.nextDouble();
				
				System.out.print("���� >> ");
				engList[i] = scan.nextDouble();
				
				System.out.print("���� >> ");
				mathList[i] = scan.nextDouble();
				
				totList[i] = korList[i] + engList[i] + mathList[i];
				avgList[i] = totList[i]/3.0;
				
				count++;
				
				System.out.print("��� �Է��Ͻ÷��� �ƹ� Ű�� �����ð� ���߽ð����� n�� �������� >> ");
				contCon = scan.next();
				if(contCon.equals("n")) {
					i = nameList.length-1;
				}
			}
			
			System.out.println("===========================================================");
			System.out.println("�л���\t����\t����\t����\t����\t���");
			System.out.println("===========================================================");
			for(int i=0; i<count; i++) {		
				System.out.print(nameList[i]+"\t"+korList[i]+"\t"+engList[i]+"\t"+engList[i]+"\t"+mathList[i]+"\t"+totList[i]+"\t"+avgList[i]+"\t"+"\n");
				
			}
			
			// �߰� ��� ���� Ȯ�� : ��üũ�� > ��ϵ� �л� ��
			if(size>count) {
				System.out.print("�� ��� �Ͻðڽ��ϱ�? \n(y:�߰� ���, n:���α׷� ����)");
				String con = scan.next();
				
				if(con.equals("n")) {
					// ���α׷� ����
					flag = false;
				}
			}else {
				// ���α׷� ����
				flag = false;
			}
		
		}//while
	}

}
