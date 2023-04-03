package java_code.java_7day;
import java.util.Scanner;

public class MultiArrayScoreTest {

	public static void main(String[] args) {
		// 
		Scanner scan = new Scanner(System.in);
		System.out.print("�л��� �Է� (����)> ");
		int size = scan.nextInt();
		
		String[] subjectList = {"����", "����", "����"};
		String[] nameList = new String[size];
		int[][] scoreList = new int[size][subjectList.length+2];

		for(int i=0; i<scoreList.length; i++) {
			System.out.print("�л����� �Է��ϼ��� >> ");
			nameList[i] = scan.next();
			
			int slength = subjectList.length;
			// �Է� ���� �л��� ����
			for(int j=0; j<size; j++) {
				System.out.print(subjectList[j]+" >> ");
				scoreList[i][j] = scan.nextInt();
				//����
				scoreList[i][slength] += scoreList[i][j]; 
				//���
				scoreList[i][slength+1] = scoreList[i][slength]/3;
			}
		}
		
		// ���
		System.out.println("===================================================");
		System.out.print("�л���\t����\t����\t����\t����\t���\n");
		System.out.println("===================================================");
		
		for(int i=0; i<scoreList.length; i++) {
			System.out.print(nameList[i]+"\t");
			for(int j=0; j<scoreList[i].length; j++) {
				System.out.print(scoreList[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

}
