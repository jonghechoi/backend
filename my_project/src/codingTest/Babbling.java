package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Babbling {
	

	public static void main(String[] args) {
        /*
            1. saying ���� ���� �� �ִ� ��� ���� ���� saying2�� �ְ�
            2. babbling�� ��
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



