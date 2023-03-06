package java_code.java_7day;
import java.util.Scanner;

public class MultiArrayScoreTest {

	public static void main(String[] args) {
		// 
		Scanner scan = new Scanner(System.in);
		System.out.print("학생수 입력 (정수)> ");
		int size = scan.nextInt();
		
		String[] subjectList = {"국어", "영어", "수학"};
		String[] nameList = new String[size];
		int[][] scoreList = new int[size][subjectList.length+2];

		for(int i=0; i<scoreList.length; i++) {
			System.out.print("학생명을 입력하세요 >> ");
			nameList[i] = scan.next();
			
			int slength = subjectList.length;
			// 입력 받은 학생의 점수
			for(int j=0; j<size; j++) {
				System.out.print(subjectList[j]+" >> ");
				scoreList[i][j] = scan.nextInt();
				//총점
				scoreList[i][slength] += scoreList[i][j]; 
				//평균
				scoreList[i][slength+1] = scoreList[i][slength]/3;
			}
		}
		
		// 출력
		System.out.println("===================================================");
		System.out.print("학생명\t국어\t영어\t수학\t총점\t평균\n");
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
