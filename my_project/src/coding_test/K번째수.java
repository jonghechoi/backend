package coding_test;

import java.util.Arrays;

public class K¹øÂ°¼ö {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] answer = new int[commands.length];
		
		int idx = 0;
        for(int[] command : commands) {
        	int[] arr1 = Arrays.copyOfRange(array, command[0]-1, command[1]);
        	Arrays.sort(arr1);
        	int num = arr1[command[2]-1];
        	answer[idx] = num;
        	idx++;
        }
        
        Arrays.stream(answer)
        	   .forEach(System.out::println);
	}
}
