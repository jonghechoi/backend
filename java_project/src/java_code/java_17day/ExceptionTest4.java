package java_code.java_17day;
import java.io.File;

public class ExceptionTest4 {
	public static void main(String[] args) throws Exception {
		
		// 파일 생성
		File file = new File("text.txt");
		try {
//			boolean result1 = file.createNewFile();
//			if(result1) {
//				System.out.println("파일 생성 완료");
//			}else {
//				System.out.println("파일 생성 실패");
//			}

			boolean result2 = file.delete();
			if(result2) {
				System.out.println("파일 삭제 완료");
			}else {
				System.out.println("파일 삭제 실패");
			}
		}catch (Exception e) {
			System.out.println("== 예외 처리 완료 ==");
		}
		
	}
}
