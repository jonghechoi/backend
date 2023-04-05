package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Babbling {
	

	public static void main(String[] args) {
        /*
            1. saying 에서 만들 수 있는 모든 조건 만들어서 saying2에 넣고
            2. babbling과 비교
        */        
        int answer = 0;
        String[] babbling = {"aya", "ye", "woo", "ma"};

 

        for(int i =0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replace("aya", "1");
            babbling[i] = babbling[i].replace("woo", "1");
            babbling[i] = babbling[i].replace("ye", "1");
            babbling[i] = babbling[i].replace("ma", "1");
            babbling[i] = babbling[i].replace("1", "");
            if(babbling[i].isEmpty()) {
                answer = answer + 1;
            }
        }

        ["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]
        
        wyeoo
        

        
//        result.forEach(s -> System.out.println(s));

	}


}



