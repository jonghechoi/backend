package java_code.java_5day;
import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		// 홍길동의 성적을 입력받아, 총점과 평균을 출력
		// 입력은 학생명, 국어, 영어, 수학 점수를 입력받아 처리
		Scanner scan = new Scanner(System.in);
		double tot = 0.0;
		double avg = 0.0;
		System.out.print("학생명 >> ");
		String name = scan.next();
		System.out.print("국어 점수 >> ");
		int kor = scan.nextInt();
		System.out.print("영어 성적을 입력하세요 >> ");
		int eng = scan.nextInt();
		System.out.print("수학 성적을 입력하세요 >> ");
		int math = scan.nextInt();
		
		tot = kor + eng + math;
		avg = tot/3.0;
		
		// 학생명 국어   영어   수학    총점      평균
		// 홍길동 100 100 100 300.0 100.0
		System.out.print("학생명\t국어\t영어\t수학\t총점\t평균\n");
		System.out.println("--------------------------------------");
		System.out.println(name+"\t");
		System.out.println(kor+"\t");
		System.out.println(eng+"\t");
		System.out.println(math+"\t");
		System.out.println(tot+"\t");
		System.out.println(avg);
	}

}
