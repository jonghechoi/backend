package java_code.java_7day;

public class MultiArray1 {

	public static void main(String[] args) {
		// 정수값을 저장할 2행 4열의 2차원 배열 생성
		int[][] numList = new int[2][4];
		int number = 1;
		
		// 데이터 입력 & 출력
		for(int i=0; i<numList.length; i++) {
			for(int j=0; j<numList[i].length; j++) {
				
				
				numList[i][j] = number;
				
				System.out.println("numList["+i+"]["+j+"] = "+numList[i][j]);
				number++;
			}//열
		}//행
		System.out.println(numList[1][1]);
	}

}
