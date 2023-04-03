package java_code.java_4day;

public class Gugudan_02 {

	public static void main(String[] args) {
		/*
		 * 2*1 = 2   3*1 = 3 ~~ 9*1 = 9
		 * 2*2 = 4   3*2 = 6
		 * ...       ...
		 * 2*9 = 18  3*9 = 27   9*9 = 81
		 */
		
		for(int i=1; i<=9; i++) {
			for(int j=2; j<=5; j++) {
				int length = (int)(Math.log10(i*j)+1);
				if(length==1) {
					System.out.printf("%d*%d=%d    ",j,i,j*i);
				}else if(length==2) {
					System.out.printf("%d*%d=%d   ",j,i,j*i);
				}else {
					System.out.println("너무 길다...");
				}
				
			}
			System.out.println();
		}
		
		
	}

}
