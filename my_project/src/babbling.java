<<<<<<< HEAD:my_project/coding_test/coding_test/babbling.java
<<<<<<< HEAD
package coding_test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class babbling {

	public static void main(String[] args) {
        int answer = 0;
        String[] saying = {"aya", "ye", "woo", "ma"};
        String[] result1 = {};
        String[] result2 = {};
        String[] result0 = {"ayayewooma"};
        
        // 2개 합성
        int count = 0;
        for(int i=0; i<saying.length; i++) {
            for(int j=0; j<saying.length; j++) {
                result1[count] = saying[i].concat(saying[j]);
                count++;
            }
        }
		
        answer = result1.length;
        
        System.out.println(answer);
		
        1	2	3	4
        1	2	3	4
        
        12 13 14 21 23 24 31 32 34 41 42 43
        
	}

}
=======
package coding_test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class babbling {

	public static void main(String[] args) {
        int answer = 0;
        String[] saying = {"aya", "ye", "woo", "ma"};
        String[] result1 = {};
        String[] result2 = {};
        String[] result0 = {"ayayewooma"};
        
        // 2개 합성
        int count = 0;
        for(int i=0; i<saying.length; i++) {
            for(int j=0; j<saying.length; j++) {
                result1[count] = saying[i].concat(saying[j]);
                count++;
            }
        }
		
        answer = result1.length;
        
        System.out.println(answer);
		
        1	2	3	4
        1	2	3	4
        
        12 13 14 21 23 24 31 32 34 41 42 43
        
	}

}
>>>>>>> refs/remotes/origin/main
=======
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;

public class babbling {

	public static void main(String[] args) {
        int answer = 0;
        String[] saying = {"aya", "ye", "woo", "ma"};
        String[] result1 = {};
        String[] result2 = {};
        String[] result0 = {"ayayewooma"};
        
        // 2개 합성
        int count = 0;
        for(int i=0; i<saying.length; i++) {
            for(int j=0; j<saying.length; j++) {
                result1[count] = saying[i].concat(saying[j]);
                count++;
            }
        }
		
        answer = result1.length;
        
        System.out.println(answer);
		
        1	2	3	4
        1	2	3	4
        
        12 13 14 21 23 24 31 32 34 41 42 43
        
	}

}
>>>>>>> parent of f2dfb86 (20230404):my_project/src/babbling.java
