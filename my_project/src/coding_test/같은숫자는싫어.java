package coding_test;

import java.util.ArrayList;
import java.util.Arrays;

public class 같은숫자는싫어 {

	public static void main(String[] args) {
		int[] arr = {1,1,3,3,0,1,1};
		int[] answer = {};
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
        for(int i=0; i<arr.length; i++) {
        	if(i == 0) {
        		arrList.add(arr[i]);
        		continue;
        	}
        	if(arr[i] != arr[i-1]) {
        		arrList.add(arr[i]);
        	}
        }
        
        
        answer = arrList.stream()
        		        .mapToInt(i-> i) // mapToInt() 메서드는 IntStream 객체 반환 
        	            .toArray();      // IntStream 객체는 toArray() 메서드를 통해 int[] 배열로 변환 가능
        
        Arrays.stream(answer)
              .forEach(System.out::println);
	}

}
