package coding_test;

import java.util.ArrayList;
import java.util.Arrays;

public class �������ڴ½Ⱦ� {

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
        		        .mapToInt(i-> i) // mapToInt() �޼���� IntStream ��ü ��ȯ 
        	            .toArray();      // IntStream ��ü�� toArray() �޼��带 ���� int[] �迭�� ��ȯ ����
        
        Arrays.stream(answer)
              .forEach(System.out::println);
	}

}
