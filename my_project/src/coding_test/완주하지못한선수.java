package coding_test;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {

	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
        Map<String, Integer> map = new HashMap<String, Integer>();
        String answer = "";
        
        for(String name : completion) {
        	if(map.get(name) == null) {
        		map.put(name, 1);
        	}else {
        		map.put(name, map.get(name) + 1);
        	}
        }
        
        System.out.println(map.keySet().iterator().next());
        
        for(String name : participant) {
        	if(map.get(name) == null) {
        		answer = name;
        	}else if(map.get(name) == 0) {
        		answer = name;
        	}else {
        		map.put(name, map.get(name) - 1);
        	}
        }
        
        System.out.println(answer);
	}

}
