package java_code.java_5day;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		// ȫ�浿�� ������ �Է¹޾�, ������ ����� ���
		// �Է��� �л���, ����, ����, ���� ������ �Է¹޾� ó��
		Scanner scan = new Scanner(System.in);
		double tot = 0.0;
		double avg = 0.0;
		System.out.print("�л��� >> ");
		String name = scan.next();
		System.out.print("���� ���� >> ");
		int kor = scan.nextInt();
		System.out.print("���� ������ �Է��ϼ��� >> ");
		int eng = scan.nextInt();
		System.out.print("���� ������ �Է��ϼ��� >> ");
		int math = scan.nextInt();
		
		tot = kor + eng + math;
		avg = tot/3.0;
		
		// �л��� ����   ����   ����    ����      ���
		// ȫ�浿 100 100 100 300.0 100.0
		System.out.print("�л���\t����\t����\t����\t����\t���\n");
		System.out.println("--------------------------------------");
		System.out.println(name+"\t");
		System.out.println(kor+"\t");
		System.out.println(eng+"\t");
		System.out.println(math+"\t");
		System.out.println(tot+"\t");
		System.out.println(avg);
	}

}
