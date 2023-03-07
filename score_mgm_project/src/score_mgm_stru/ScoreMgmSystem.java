package score_mgm_stru;

import java.util.Scanner;

public class ScoreMgmSystem {

	public static void main(String[] args) {
		//1. 메뉴 출력
		System.out.println("==============================");
		System.out.println("\t성적 관리 시스템");
		System.out.println("------------------------------");
		System.out.println("  1. 성적 등록");
		System.out.println("  2. 성적 조회(전체)");
		System.out.println("  3. 성적 검색");
		System.out.println("  4. 성적 수정");
		System.out.println("  5. 성적 삭제");
		System.out.println("  0. 프로그램 종료");
		System.out.println("==============================");
		
		//2. 메뉴 선택
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.print("메뉴선택(숫자)> ");
			int menu = scan.nextInt();
			
			switch(menu) {
				case 1 : //등록
					System.out.println("등록");
					break;
				case 2: //조회(전체)
					System.out.println("조회");
					break;
				case 3: //검색
					System.out.println("검색");
					break;
				case 4: //수정
					System.out.println("수정");
					break;
				case 5: //삭제
					System.out.println("삭제");
					break;
				case 0: //프로그램 종료
					System.out.println("프로그램을 종료합니다.");
					flag = false;
					//System.exit(0);
					break;
				default: //메뉴 이외의 다른 숫자 입력 시
					System.out.println("다른 메뉴를 선택해주세요");
			}//switch
		}//while
		
		System.out.println("-- 프로세스 종료 --");
	}//main

}//class










