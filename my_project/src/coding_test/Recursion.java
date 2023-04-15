package coding_test;

public class Recursion {

	public static void main(String[] args) {
		
		recursion("", 1);

	}
	
	public static void recursion(String str, int idx) {
		System.out.println(str + idx);
		if(idx==2) return;
		
		for(int i=0; i<5; i++) {
			System.out.println("111 -> " + i);
			recursion(String.valueOf(idx)+"¹øÂ° recursion --> ", idx+1);
			System.out.println("222 -> " + i);
		}
	}

}
