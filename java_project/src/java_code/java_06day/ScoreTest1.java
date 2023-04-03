package java_code.java_06day;
import java.util.Scanner;

public class ScoreTest1 {

	public static void main(String[] args) {
		// 한 학생의 정보(학생명, 국어점수, 영어점수, 수학점수)를 입력받아 배열에 저장하고, 출력
		
		// 변수 정의 및 생성
		String name = "";
		String[] subjectList = {"국어", "영어", "수학", "컴퓨터", "음악"};
		int[] scoreList = new int[subjectList.length]; 
		
		Scanner scan = new Scanner(System.in);
		System.out.print("학생명>");
		name = scan.next();

		for(int i=0;i<subjectList.length;i++) {
			System.out.print(subjectList[i] + "점수>");
			scoreList[i] = scan.nextInt();
		}
				
		// 출력
		System.out.println("학생명 = " + name);
		for(int i=0;i<scoreList.length;i++) {
			System.out.println(subjectList[i] + " = " + scoreList[i]);
		}
				
		System.out.println("========== 프로그램 종료 ==========");
		
	}

}
