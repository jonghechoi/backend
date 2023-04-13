package coding_test;

import java.util.ArrayList;
import java.util.HashMap;

public class 신고결과받기 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int[] answer = new int[4];
		int k = 2;
		
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String name : report) {
        	ArrayList<String> list = new ArrayList<String>();
            String[] temp = name.split(" ");
            // temp[0] -> 신고자
            // temp[1] -> 용의자
            if(map.containsKey(temp[1])) {
                // 용의자의 ArrayList에 신고자가 있는지 검사
            	list = map.get(temp[1]);
                if(!list.contains(temp[0])) {
                    list.add(temp[0]);
                } 
            }else {
            	list.add(temp[0]);
            }
            map.put(temp[1], list);
        }

        for(int i=0; i<id_list.length; i++) {
        	answer[i] = 0;
            for(String key : map.keySet()) {
                if(k <= map.get(key).size()) {
                	if(map.get(key).contains(id_list[i])) answer[i] += 1;  
                }            
            }
        }
        for(int i : answer) {
        	System.out.println(i);
        	
        }
        
        
        
	}

}
