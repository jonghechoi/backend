package coding_test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class Babbling {

	public static void main(String[] args) {
        int answer = 0;
        String[] saying = {"aya", "ye", "woo", "ma"};
        String[] result1 = {};
        String[] result2 = {};
        String[] result0 = {"ayayewooma"};
        
        // 2°³ ÇÕ¼º
        int count = 0;
        for(int i=0; i<saying.length; i++) {
            for(int j=0; j<saying.length; j++) {
                result1[count] = saying[i].concat(saying[j]);
                count++;
            }
        }
		
        answer = result1.length;
        
        System.out.println(answer);
	}

}
