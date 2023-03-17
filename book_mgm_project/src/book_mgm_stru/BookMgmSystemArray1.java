package book_mgm_stru;
import java.util.Scanner;

public class BookMgmSystemArray1 {

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
//		String bookTitle = "", bookAuthor = "", bookIsbn = "";
//		int bookPrice = 0, bookCount =0;
		
		System.out.print("등록할 책의 갯수 입력 >> ");
		int size = scan.nextInt();
		
		String[] bookTitleList = new String[size];
		String[] bookAuthorList = new String[size];
		int[] bookIsbnList = new int[size];
		int[] bookPriceList = new int[size];
		
		int bookCount = 0;
		
		while(flag) {
			System.out.print("메뉴 알바펫 입력 > ");
			String menu = scan.next();
			
			// a. 도서 등록
			if(menu.equals("a")) { 
				// 2. 메뉴 입력
				if(bookCount<size) {
					boolean regflag = true;
					while(regflag) {
						for(int i=0; i<size; i++) {
							System.out.print("책 제목을 입력해주세요 >> ");
							bookTitleList[i] = scan.next();
							
							System.out.print("책 저자를 입력해주세요 >> ");
							bookAuthorList[i] = scan.next();
							
							System.out.print("책 ISBN을 입력해주세요 >> ");
							bookIsbnList[i] = scan.nextInt();
							
							System.out.print("책 가격을 입력해주세요 >> ");
							bookPriceList[i] = scan.nextInt();
							
							System.out.println("====== 등록 완료 ======");
							bookCount++;
							
							System.out.println("계속 등록하시겠습니까? (계속 등록시(y), 종료시(n) >>");
							String con = scan.next();
							if(con.equals("n")) {
								regflag = false;
								i = size;
							}
						}
					}
				}else {
					System.out.println("------- 등록 가능 공간이 없습니다 -------");
				}
				
			// b. 도서 조회
			} else if(menu.equals("b")) { 
				System.out.println("=========== 등록 도서 정보 ===========");
				System.out.println("도서명\t저자명\t가격\tISBN");
				System.out.println("=================================");
				for(int i=0; i<bookCount; i++) {
					System.out.print(bookTitleList[i]+"\t");
					System.out.print(bookAuthorList[i]+"\t");
					System.out.print(bookPriceList[i]+"\t");
					System.out.print(bookIsbnList[i]+"\t");
					System.out.println();
				}
				System.out.println("=================================");
				System.out.println("총  " + bookCount + "권");
				
				
			// c. 도서 검색
			} else if(menu.equals("c")) { 
				boolean search = true;
				while(search) {
					if(bookCount!=0) {
						System.out.print("검색할 도서명을 입력하세요 >> ");
						String searchName = scan.next();
						
						// 해당 도서가 있는지 확인
						boolean bookCheck = true;
						int bookNum = 0;
						for(int i=0; i<bookCount; i++) {
							if(searchName.equals(bookTitleList[i])) {
								bookCheck = false;
								bookNum = i;
							}
						}
						
						String research = "";
						if(!bookCheck) {
							System.out.println("선택하신 도서는 ["+ bookTitleList[bookNum] +"]입니다");
							System.out.print(bookAuthorList[bookNum]+"\t");
							System.out.print(bookPriceList[bookNum]+"\t");
							System.out.print(bookIsbnList[bookNum]+"\t");
							System.out.println();
							System.out.println("다른 도서를 검색하시겠습니까? [재검색:(y), 종료(n)]");
							research = scan.next();
						}else {
							System.out.println("입력하신 도서가 없습니다. 재검색하시겠습니까? [재검색:(y), 종료(n)]");
							research = scan.next();
						}
						
						if(research.equals("n")) {
							search = false;
						}
					}else {
						System.out.println("\n------- 도서등록을 먼저 해주세요. -------");
					}//if
				}//while
				
				
				
				
				
				
				
			// d. 도서 수정
			} else if(menu.equals("d")) {
				System.out.println("도서 수정");
				/*
				 * 1. 수정할 도서 이름 입력
				 * 2. 해당 도서에 대한 idx 추출
				 * 3. idx 사용하여 상세에 대한 수정
				 * 4. 추가 수정할 건지 확인(while)
				 */
				
				System.out.print("수정할 도서의 이름 입력 >> ");
				String modifyBook = scan.next();

				
//				for(int i=0; i<bookTitleList.length; i++) {
//					bookTitleList
//				}
//				if(modifyBook)
//				
//				
//				System.out.print("책 제목을 입력해주세요 >> ");
//				bookTitleList[i] = scan.next();
//				
//				System.out.print("책 저자를 입력해주세요 >> ");
//				bookAuthorList[i] = scan.next();
//				
//				System.out.print("책 ISBN을 입력해주세요 >> ");
//				bookIsbnList[i] = scan.nextInt();
//				
//				System.out.print("책 가격을 입력해주세요 >> ");
//				bookPriceList[i] = scan.nextInt();
//				
				
				
			// e. 도서 삭제
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
