package coding_test;

import java.util.ArrayList;
import java.util.Collections;

public class ����ū�� {

	public static void main(String[] args) {
//		int[] numbers = {3, 30, 34, 5, 9};
//		int[] numbers = {5, 9, 3, 30, 34};
//		int[] numbers = {333, 30, 34, 5, 9};
//		int[] numbers = {313, 30, 34, 5, 9};
//		int[] numbers = {900, 30, 34, 5, 9};
//		int[] numbers = {0, 30, 34, 5, 9};
//		int[] numbers = {0, 10, 34, 5, 9};
//		int[] numbers = {707, 77, 34, 5, 9};
		int[] numbers = {777, 30, 77, 5, 9};
//		int[] numbers = {6, 10, 2};
//		int[] numbers = {0, 10, 2};
//		int[] numbers = {0, 0};
		ArrayList<Integer> answerArray = new ArrayList<>();

		boolean except = true;
		for(int i=0; i<numbers.length; i++) { // ���ο� ��
			if(numbers[i] != 0) except = false;
			
			if(answerArray.isEmpty()) {
				answerArray.add(numbers[i]);
			}else {
				int count = 0;
				String nextStr = String.valueOf(numbers[i]);
				for(int j=0; j<answerArray.size(); j++) { // ������ ��� �ִ� ��
					String prevStr =  String.valueOf(answerArray.get(j));
					
					int prevNext = Integer.valueOf( prevStr + nextStr ); 
					int nextPrev = Integer.valueOf( nextStr + prevStr );
					
					if(prevNext < nextPrev) {
						count = j;
						j = answerArray.size(); // nextPrev�� ũ�� ���ڸ��� Ȯ�� �ʿ� ���� �� �ڸ��� ����
					}else {
						count = j+1;
					}
				}
				answerArray.add(count, numbers[i]);
			}
		}
		
		System.out.println(answerArray);
		
		String answer = ""; 
		if(except) {
			answer = "0";
		}else {
			for(int num : answerArray ) answer += String.valueOf(num);
		}
		
		
		System.out.println(answer);
	}

}
