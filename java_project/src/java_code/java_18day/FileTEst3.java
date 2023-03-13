package java_code.java_18day;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

/*
 * BufferedReader를 활용한 데이터 읽기
 */
public class FileTEst3 {

	public static void main(String[] args) {
		try {
			File file = new File("test.txt");
			
			if(file.exists()) {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				
				String str = null;
				while((str=br.readLine()) != null) {
					System.out.println(str);
				
				fr.close();
				br.close();
				} 
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
