package book_mgm_stru;
import java.util.Scanner;

public class BookMgmSystem {

	public static void main(String[] args) {
		// 1. 메뉴 선택
		System.out.println("********************");
		System.out.println("도서 관리 시스템");
		System.out.println("a. 도서 등록");
		System.out.println("b. 도서 조회(전체)");
		System.out.println("c. 도서 검색");
		System.out.println("d. 도서 수정");
		System.out.println("e. 도서 삭제");
		System.out.println("z. 프로그램 종료");
		System.out.println("********************");

		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		
		// 도서정보 저장 변수(로컬=지역=멤버 변수: 반드시 초기화 작업을 한다)
		String bookTitle = "", bookAuthor = "", bookIsbn = "";
		int bookPrice = 0, bookCount =0;
		
		while(flag) {
			System.out.print("메뉴 알바펫 입력 > ");
			String menu = scan.next();
				
			if(menu.equals("a")) {
				// 2. 메뉴 입력
				System.out.print("책 제목을 입력해주세요 >> ");
				bookTitle = scan.next();
				System.out.print("책 저자를 입력해주세요 >> ");
				bookAuthor = scan.next();
				System.out.print("책 ISBN을 입력해주세요 >> ");
				bookIsbn = scan.next();
				System.out.print("책 가격을 입력해주세요 >> ");
				bookPrice = scan.nextInt();
				System.out.println("====== 등록 완료 ======");
				bookCount++;
			} else if(menu.equals("b")) {
				System.out.println("=========== 등록 도서 정보 ===========");
				System.out.println("목록\t도서명\t저자명\t가격\tISBN");
				System.out.println("=================================");
				System.out.print("1\t");
				System.out.print(bookTitle + "\t");
				System.out.print(bookAuthor + "\t");
				System.out.print(bookPrice + "\t");
				System.out.print(bookIsbn + "\n");
				System.out.println("=================================");
				System.out.println("총  " + bookCount + "권");
				
			} else if(menu.equals("c")) {
				System.out.println("도서 검색");
			} else if(menu.equals("d")) {
				System.out.println("도서 수정");
			} else if(menu.equals("e")) {
				System.out.println("도서 삭제");
			} else if(menu.equals("z")) {
				System.out.println("\n====== 프로그램 종료 ======");
				flag = false;
				// System.exit(0);
			} else {
				System.out.println("이상한게 들어옴");
			}
		}
		
	}

}
