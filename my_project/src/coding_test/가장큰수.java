package coding_test;

import java.util.ArrayList;

public class ����ū�� {

	public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9};
//		int[] numbers = {5, 9, 3, 30, 34};
//		int[] numbers = {333, 30, 34, 5, 9};
//		int[] numbers = {313, 30, 34, 5, 9};
//		int[] numbers = {900, 30, 34, 5, 9};
//		int[] numbers = {707, 77, 34, 5, 9};
//		int[] numbers = {777, 30, 77, 5, 9};
//		int[] numbers = {6, 10, 2};
		ArrayList<Integer> answerArray = new ArrayList<Integer>();
		
		answerArray.add(numbers[0]);
		for(int i=0; i<numbers.length; i++) { // numbers�� ��� �� 
			
			int count = 0; // answerArray���� �� �ڸ��� ī��Ʈ
			for(int j=0; j<answerArray.size(); j++) { // ������ �ִ� ��
				if(i==j) break;
				System.out.println("i --> " + i + " j --> " + j);
				
				boolean pass = true;
				int shortNumLen = Math.min(String.valueOf(answerArray.get(j)).length(), String.valueOf(numbers[i]).length());
				for(int k=0; k<shortNumLen; k++) { // ������ �ִ� ���� ���Ӱ� ���� �� ��
					System.out.println("j--> " + j + "    .get --> " + answerArray.get(j));
					System.out.println("i--> " + i + "    numbers[i] --> " + numbers[i]);
					int nowNum = String.valueOf(answerArray.get(j)).charAt(k);
					int nextNum = String.valueOf(numbers[i]).charAt(k);

					if(nowNum < nextNum) {
						answerArray.add(j, numbers[i]);
						pass = false;
						k = shortNumLen;
						j=answerArray.size();
					}else if(nowNum > nextNum) {
						count++;
						pass = false;
						k = shortNumLen;
						if(j==answerArray.size()-1) {
							answerArray.add(count, numbers[i]);
							j=answerArray.size();
						}
					}else {
						continue;
					}
				}

				
				// ���� ��(35, 3534)�� ���ؼ� ������ �տ� ���� ����
				if(pass) {
					if(numbers[i] == answerArray.get(j)) {
						answerArray.add(j, numbers[i]);
						j=answerArray.size();
					}else if( Integer.valueOf((String.valueOf(answerArray.get(j)) + String.valueOf(numbers[i]))) > 
					         Integer.valueOf((String.valueOf(numbers[i]) + String.valueOf(answerArray.get(j)))) ) {
						answerArray.add(j+1, numbers[i]);
						j=answerArray.size();
					}else if(Integer.valueOf((String.valueOf(answerArray.get(j)) + String.valueOf(numbers[i]))) <
							 Integer.valueOf((String.valueOf(numbers[i]) + String.valueOf(answerArray.get(j)))) ) {
						answerArray.add(j, numbers[i]);
						j=answerArray.size();
					}
//					else {
//						answerArray.add(numbers[i]);
//						j=answerArray.size();
//					}
				}
				
				System.out.println(answerArray);
//				System.out.println();
				
			}
		}
		String answer = ""; 
		for(int num : answerArray ) {
			answer += String.valueOf(num);
		}
		System.out.println(answer);
	}

}
