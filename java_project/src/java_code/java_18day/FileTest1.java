package java_code.java_18day;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class FileTest1 {

	public static void main(String[] args) {
		// 1. File 객체 생성
		File file = new File("text.txt");
		System.out.println(file.getAbsolutePath());
		try {
			if(!file.exists()) {
				System.out.println("이미 생성된 파일");
			}else {
				file.createNewFile();
				System.out.println("파일이 생성됨");
			}
			
			// 2. FileInputStream / FileOutputStream 생성
			// JVM ---> File(test.txt)
			FileOutputStream fos = new FileOutputStream(file, true);
			String str = "hello";
			byte[] str2 = str.getBytes();
			fos.write(str2);
			System.out.println("--- 파일 쓰기 완료 ---");
			fos.close();
			
			// 2-2.JVM <-- (데이터 입력) -- File(test.txt) : FileInputStream
			FileInputStream fi = new FileInputStream("test2.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fi));
			// FileInputStream.read() 은 인풋스트림으로부터 1바이트씩 읽어옴. 
//			int i = 0;
//			while( (i = fi.read()) != -1 ) { // read()를 통해 읽어온 데이터가 i에 저장, byte=>int로 묵시적 형변환
//				System.out.println((char)i);
//			}
		
//			byte[] buf = new byte[500];
//			fi.read(buf);
//			
//			String str3 = new String(buf);
//			System.out.println(str3);
			
			// 3. close
			fi.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		

		
		

	}

}
