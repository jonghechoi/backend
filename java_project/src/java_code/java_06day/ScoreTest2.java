package java_code.java_06day;
import java.util.Scanner;

public class ScoreTest2 {

	public static void main(String[] args) {
		// 학생 정보(학생명, 국어, 영어, 수학점수)를 입력 받아 출력하시오
		// 학생 수는 실행 시 임의로 입력받아 진행
//		hong,10,20,30,kim,10,10,10,park,20,20,20
//		hong,kim,park // 학생명
//		10,20,30      // 국어
//		10,10,10      // 영어       
//		100,90,80     // 수학
	
		Scanner scan = new Scanner(System.in);
		System.out.print("학생수 입력(정수)> ");
		int size = scan.nextInt();
		String contCon = "";
		
		// 배열 선언
		String[] nameList = new String[size];
		double[] korList = new double[size];
		double[] engList = new double[size];
		double[] mathList = new double[size];
		double[] totList = new double[size];
		double[] avgList = new double[size];
		
		int count = 0; // 등록된 학생 수
		
		boolean flag = true;
		while(flag) {
			// 데이터 입력 : 저장되는 인덱스 맞춰줌
			for(int i=count;i<nameList.length;i++) {
				System.out.print("학생 이름을 입력해주세요 > ");
				nameList[i] = scan.next();
				
				System.out.print("국어 >> ");
				korList[i] = scan.nextDouble();
				
				System.out.print("영어 >> ");
				engList[i] = scan.nextDouble();
				
				System.out.print("수학 >> ");
				mathList[i] = scan.nextDouble();
				
				totList[i] = korList[i] + engList[i] + mathList[i];
				avgList[i] = totList[i]/3.0;
				
				count++;
				
				System.out.print("계속 입력하시려면 아무 키나 누르시고 멈추시겠으면 n을 누르세요 >> ");
				contCon = scan.next();
				if(contCon.equals("n")) {
					i = nameList.length-1;
				}
			}
			
			System.out.println("===========================================================");
			System.out.println("학생명\t국어\t영어\t수학\t총점\t평균");
			System.out.println("===========================================================");
			for(int i=0; i<count; i++) {		
				System.out.print(nameList[i]+"\t"+korList[i]+"\t"+engList[i]+"\t"+engList[i]+"\t"+mathList[i]+"\t"+totList[i]+"\t"+avgList[i]+"\t"+"\n");
				
			}
			
			// 추가 등록 여부 확인 : 전체크기 > 등록된 학생 수
			if(size>count) {
				System.out.print("더 등록 하시겠습니까? \n(y:추가 등록, n:프로그램 종료)");
				String con = scan.next();
				
				if(con.equals("n")) {
					// 프로그램 종료
					flag = false;
				}
			}else {
				// 프로그램 종료
				flag = false;
			}
		
		}//while
	}

}
