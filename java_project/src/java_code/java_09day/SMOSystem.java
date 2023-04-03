
package java_code.java_9day;
import java.util.Scanner;

/*
 * 성적관리 시스템
 */
public class SMOSystem {
	// Field
	Scanner scan = new Scanner(System.in);
	StudentVo[] slist = new StudentVo[5];
	int rcount = 0;
	
	// class에 대한 객체 생성
	StudentVo hong; // 아직 heap에 저장 공간(객체)이 생성되지 않은 것. 선언만 한것. 여기에 데이터 저장 하려면 객체 생성이 먼저임
	
	// Constructor
	
	// Method
	public int findIndex(String name) {
		int result_idx = -1;
		
		for(int i=0; i<rcount; i++) {
			if(name.equals(slist[i].getName())) {
				result_idx = i;
			}
		}
		return result_idx;
	}
	
	// 등록
	public void insert() {
		if(rcount<slist.length) {
			for(int i=rcount; i<slist.length; i++) {
				StudentVo svo = new StudentVo();
				
				System.out.print("학생명 > ");
				svo.setName(scan.next());
				
				System.out.print("국어 > ");
				svo.setKor(scan.nextInt());
				
				System.out.print("영어 > ");
				svo.setEng(scan.nextInt());
		
				System.out.print("수학 > ");
				svo.setMath(scan.nextInt());
			
				slist[i] = svo;
				rcount++;
				System.out.print("계속 등록하시겠습니까?(n:종료 아무키:등록)");
				String rcon = scan.next();
				if(rcon.equals("n")) {
					i = slist.length;
					System.out.println("\n======= 등록 완료 =======\n");
				}else {
					if(rcount==slist.length) {
						System.out.println("\n== 저장공간 부족으로 추가등록이 불가능합니다. ==\n");
					}
				}
			}
		}else {
			System.out.println("\n== 저장공간 부족으로 추가등록이 불가능합니다. ==\n");
		}
	}
	public void select() {
		if(rcount!=0) {
			System.out.println("=======================");
			System.out.print("학생명\t국어\t영어\t수학\t총점\t평균\n");
			for(int i=0; i<rcount; i++) {
				System.out.printf("%s\t%d\t%d\t%d\t%d\t%f%n",slist[i].getName(),slist[i].getKor(),slist[i].getEng(),slist[i].getMath(),slist[i].getTot(),slist[i].getAvg());
			}
			System.out.println("=======================");
		}else {
			System.out.println("\n== 등록된 데이터가 없습니다. ==\n");
		}
	}
	public void search() {
		if(rcount!=0) {
			showMenu("강남 고등학교");
			System.out.println("검색할 학생의 이름을 입력하세요.");
			int search_idx = findIndex(scan.next());
			
			if(search_idx!=-1) {
				System.out.println("=======================");
				System.out.print("학생명\t국어\t영어\t수학\t총점\t평균\n");
				System.out.printf("%s \t%d\t%d\t%d\t%d\t%f%n",slist[search_idx].getName(),slist[search_idx].getKor(),slist[search_idx].getEng(),slist[search_idx].getMath(),slist[search_idx].getTot(),slist[search_idx].getAvg());
				System.out.println("=======================");
			}else {
				System.out.println("\n== 검색한 데이터가 존재하지 않습니다. ==\n");
			}
			
		}else {
			System.out.println("\n== 등록된 데이터가 없습니다. ==\n");
		}
	
	}
	public void update() {
		/*
		 * 1. 수정할 학생명
		 * 2. 학생명 체크
		 * 3. update_idx
		 * 4. 새로운 객체 만들어서 치환
		 */		
		if(rcount!=0) {
			System.out.println("수정할 학생의 이름을 입력해주세요.");
			String name = scan.next();
			int update_idx = findIndex(scan.next());

			//새로운 객체 만들어서 치환
			if(update_idx!=-1) {
				StudentVo svo = new StudentVo();
				svo.setName(name);				
				System.out.print("국어 > ");
				svo.setKor(scan.nextInt());
				System.out.print("영어 > ");
				svo.setEng(scan.nextInt());
				System.out.print("수학 > ");
				svo.setMath(scan.nextInt());
				
				slist[update_idx] = svo;
				System.out.println("\n== 수정 완료 ==\n");
			}else {
				System.out.println("\n== 등록된 데이터가 없습니다. ==\n");
			}
			
		}else {
			System.out.println("\n== 등록된 데이터가 없습니다. ==\n");
		}
	}
	public void delete() {
		/*
		 * 1. 삭제할 학생명
		 * 2. 학생명 체크
		 * 3. remove_idx
		 */

		if(rcount!=0) {
			System.out.println("삭제할 학생명을 입력해주세요.");
			int remove_idx = findIndex(scan.next());
			
			for(int i=remove_idx; i<slist.length-1; i++) {
				slist[i] = slist[i+1];
			}
			slist[slist.length-1] = null;
			rcount--;
			
		}else {
		System.out.println("\n== 등록된 데이터가 없습니다. ==\n");
		}
		
	}
	
	// 메뉴를 선택한다.
	public boolean choiceMenu() {
		System.out.print("메뉴 입력(숫자) >> ");
		int menu = scan.nextInt();
		
		boolean result = true;
		switch(menu) {
		case 1:
			insert(); // this 생략가능
			showMenu();
			break;
		case 2:
			select();
			showMenu();
			break;
		case 3:
			search();
			showMenu();
			break;
		case 4:
			update();
			showMenu();
			break;
		case 5:
			delete();
			showMenu();
			break;
		case 0:
			System.out.println("종료");
			result = false;
			break;
		default:
			System.out.println("메뉴 준비중입니다.");
		}
		return result;
	}
	
	// 메뉴를 출력한다.
	public void showMenu() {
		System.out.println("==============================");
		System.out.println("  1. 성적 등록");
		System.out.println("  2. 성적 조회(전체)");
		System.out.println("  3. 성적 검색");
		System.out.println("  4. 성적 수정");
		System.out.println("  5. 성적 삭제");
		System.out.println("  0. 프로그램 종료");
		System.out.println("==============================");
	}
	
	public void showMenu(String schoolName) {
		System.out.println("==============================");
		System.out.println(schoolName + " 성적 관리 시스템");
		System.out.println("==============================");
		System.out.println("  1. 성적 등록");
		System.out.println("  2. 성적 조회(전체)");
		System.out.println("  3. 성적 검색");
		System.out.println("  4. 성적 수정");
		System.out.println("  5. 성적 삭제");
		System.out.println("  0. 프로그램 종료");
		System.out.println("==============================");
	}
	
	
}//class
