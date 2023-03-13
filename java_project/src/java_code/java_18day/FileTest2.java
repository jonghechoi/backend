package java_code.java_18day;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileTest2 {

	public static void main(String[] args) {
		try {
			// 1. JVM�� ���� ���� - test2.txt
			File file = new File("test2.txt");
			
			if(!file.exists()) {
				System.out.println("���� ���� �ȵ�");
			}else {
				file.createNewFile();
				System.out.println("���� ���� ��");
			}
			
			// 2. FileWriter ��ü ����
			FileWriter fw = new FileWriter(file, true);
//			Scanner scan = new Scanner(System.in);
//			String str = scan.next();
//			fw.write(str+"\n");
			
			// 2-1. FileReader ��ü ����
			FileReader fi = new FileReader("test2.txt");
			int i = 0;
			char[] cbuf = new char[500]; // ĳ���͹��۸� ���� ��ü ����
//			String str2 = "";
			while((i = fi.read(cbuf)) != -1) {
//				str2 += (char)i;
			}
//			System.out.println(str2);
			System.out.println(cbuf);
			
			// 3. close()
			fw.close();
			fi.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
