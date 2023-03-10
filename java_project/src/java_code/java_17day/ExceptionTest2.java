package java_code.java_17day;

import java.util.ArrayList;

public class ExceptionTest2 {
	public static void main(String[] args) throws Exception {
		String[] nameList = new String[5];
		try {
			Integer in = new Integer("abc");
			int x = 0;
			int val = in.intValue()/x;
			
			for(int i=0; i<6; i++) { 
				nameList[i] = i+1+". ȫ�浿";
				System.out.println(nameList[i]);
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
