package coding_test;

import java.util.ArrayList;
import java.util.Arrays;

public class ����ū�� {

	public static void main(String[] args) {
//		int[] numbers = {3, 30, 34, 5, 9};
//		int[] numbers = {5, 9, 3, 30, 34};
//		int[] numbers = {333, 30, 34, 5, 9};
//		int[] numbers = {313, 30, 34, 5, 9};
//		int[] numbers = {900, 30, 50, 510, 9};
//		int[] numbers = {0, 30, 34, 5, 9};
//		int[] numbers = {0, 10, 34, 5, 9};
//		int[] numbers = {707, 77, 34, 5, 9};
//		int[] numbers = {777, 30, 77, 5, 9};
//		int[] numbers = {6, 10, 2};
//		int[] numbers = {0, 10, 2};
		int[] numbers = {00, 0, 0, 0};
//		int[] numbers = {0, 0, 12};
//		int[] numbers = {34, 3444, 32, 3222};
		
		String[] strNumbers = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
		
		ArrayList<String> answerArray = new ArrayList<>();

		boolean except = true;
		for(int i=0; i<strNumbers.length; i++) { // ���ο� ��
			if(!strNumbers[i].equals("0")) except = false;
			
			if(answerArray.isEmpty()) {
				answerArray.add(strNumbers[i]);
			}else {
				int count = 0;
				for(int j=0; j<answerArray.size(); j++) { // ������ ��� �ִ� ��
					int compareNum = (strNumbers[i]+answerArray.get(j)).compareTo(answerArray.get(j)+strNumbers[i]);

					if(compareNum < 0) {
						count = j+1;
					}else if(compareNum >= 0) {
						count = j;
						j = answerArray.size(); // nextPrev�� ũ�� ���ڸ��� Ȯ�� �ʿ� ���� �� �ڸ��� ����
					}
				}
				answerArray.add(count, strNumbers[i]);
			}
		}
		
		String answer = ""; 
		System.out.println(except);
		if(!except) {
			for(String num : answerArray) answer += String.valueOf(num);
		}else {
			answer = "0";
		}
		
		System.out.println(answer);
	}

}
