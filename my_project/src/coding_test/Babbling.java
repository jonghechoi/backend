package coding_test;

import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        /*
            1. saying 에서 만들 수 있는 모든 조건 만들어서 saying2에 넣고
            2. babbling과 비교
        */        
        int answer = 0;
        String[] sayingArray = {"aya", "ye", "woo", "ma"};
        ArrayList<String> result = new ArrayList<String>();
        
        ArrayList<String> sayingArrayList1 = new ArrayList<String>();
        
        for(String i : sayingArray) {
        	sayingArrayList1.add(i);
        }
        
        
        
        
        for(int i=0; i<sayingArrayList1.size(); i++) {
        	result.add(sayingArrayList1.get(i));
        	for(int j=0; j<sayingArrayList1.size(); j++) {
        		if(i!=j) {
        			result.add(sayingArrayList1.get(i).concat(sayingArrayList1.get(j)));
        			for(int x=0; x<sayingArrayList1.size(); x++) {
        				if((x!=i)&&(x!=j)) {
        					result.add(sayingArrayList1.get(i).concat(sayingArrayList1.get(j)).concat(sayingArrayList1.get(x)));
        					for(int y=0; y<sayingArrayList1.size(); y++ ) {
        						if((y!=i)&&(y!=j)&&(y!=x)) {
        							result.add(sayingArrayList1.get(i).concat(sayingArrayList1.get(j)).concat(sayingArrayList1.get(x)).concat(sayingArrayList1.get(y)));
        						}
        					}
        				}
        			}
        		}
        		
        	}
        }

        for(int i=0; i<babbling.length; i++) {
            for(int j=0; j<result.size(); j++) {
                    if(babbling[i].equals(result.get(j))) {
                        answer++;
                    }      
            }
        }
        
        
        return answer;
    }
}