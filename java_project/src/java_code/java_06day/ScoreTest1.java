package java_code.java_06day;
import java.util.Scanner;

public class ScoreTest1 {

	public static void main(String[] args) {
		// �� �л��� ����(�л���, ��������, ��������, ��������)�� �Է¹޾� �迭�� �����ϰ�, ���
		
		// ���� ���� �� ����
		String name = "";
		String[] subjectList = {"����", "����", "����", "��ǻ��", "����"};
		int[] scoreList = new int[subjectList.length]; 
		
		Scanner scan = new Scanner(System.in);
		System.out.print("�л���>");
		name = scan.next();

		for(int i=0;i<subjectList.length;i++) {
			System.out.print(subjectList[i] + "����>");
			scoreList[i] = scan.nextInt();
		}
				
		// ���
		System.out.println("�л��� = " + name);
		for(int i=0;i<scoreList.length;i++) {
			System.out.println(subjectList[i] + " = " + scoreList[i]);
		}
				
		System.out.println("========== ���α׷� ���� ==========");
		
	}

}
