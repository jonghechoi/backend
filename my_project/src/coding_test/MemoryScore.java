package coding_test;

import java.util.Arrays;

public class MemoryScore {

	public static void main(String[] args) {
		String[] name = {"may", "kein", "kain", "radi"};	
		int[] yearning = {5, 10, 1, 3};
		String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
		
        int[] answer = new int[photo.length];
        
        int num = 0;
        for(String[] p1 : photo) {
            int score = 0;
            for(String p2 : p1) {
                for(int n=0; n<name.length; n++) {
                    if(name[n].equals(p2)) score += yearning[n];
                }
            }
            answer[num] = score;
            num++;
        }
        
        Arrays.stream(answer).forEach( (s) -> System.out.println(s) );
	}

}
