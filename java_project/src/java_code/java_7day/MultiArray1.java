package java_code.java_7day;

public class MultiArray1 {

	public static void main(String[] args) {
		// �������� ������ 2�� 4���� 2���� �迭 ����
		int[][] numList = new int[2][4];
		int number = 1;
		
		// ������ �Է� & ���
		for(int i=0; i<numList.length; i++) {
			for(int j=0; j<numList[i].length; j++) {
				
				
				numList[i][j] = number;
				
				System.out.println("numList["+i+"]["+j+"] = "+numList[i][j]);
				number++;
			}//��
		}//��
		System.out.println(numList[1][1]);
	}

}
