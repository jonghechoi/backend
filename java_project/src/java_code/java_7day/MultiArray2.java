package java_code.java_7day;

public class MultiArray2 {

	public static void main(String[] args) {
		// �������� �Է��ϴ� ������ �迭 ����
		int[][] numList = new int[4][]; // ���� 4������ ���� ���� �������� ����
		numList[0] = new int[2];
		numList[1] = new int[3];
		numList[2] = new int[4];
		numList[3] = new int[5];

		int number = 10;
		
		// ������ �Է�/��� �ѹ���
		for(int i=0; i<numList.length; i++) {
			for(int j=0; j<numList[i].length; j++) {
				numList[i][j] = number;
				System.out.println("numList["+i+"]["+j+"] = "+numList[i][j]);
				number += 10;				
			}
			System.out.println();
		}
		
		
	}

}
