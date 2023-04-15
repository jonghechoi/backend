package coding_test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class ���ϸ� {

	public static void main(String[] args) {
        /**
        * 1. �Ѱ���/2 
        * 2. HashMap �̿��Ͽ� �� ��ȣ�� ���� ����
        * 3. key ����� N/2���� ũ�� N/2 ����
        * 4. �ƴϸ�, key ������ ����
        */
		int[] nums = {3,2,2,4,4,1,1,1,1,5};
        int answer = 0;
        int pickNum = nums.length/2;
        
        // �ߺ��� ���ϱ� ���� HashMap ��� 
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
        	hmap.put(nums[i], 0);
        	  // �� ������ ������ ���⼭ �ʿ����. �ߺ����� �ʴ� ���� � �ִ��ĸ� ����ϴϱ�!
//            if(hmap.containsKey(nums[i])) {
//                hmap.put(nums[i], 1);    
//            }else {
//                hmap.put(nums[i], hmap.get(nums[i]+1));
//            }
        }    
        
        // ���׿����� ���!
        System.out.println(hmap.size() > pickNum ? pickNum : hmap.size()); // 5
        /*
         * ****************************************************************************************************************************
         * ��Ʈ������ ó��...����
         */
        int answer2= Arrays.stream(nums)
        					.boxed() // ��ȯ���� Stream<Integer> �̱� ������ �⺻ Ÿ���� ���� Ŭ������ ��ȯ. �� ���׸����� ����� �÷��ǿ��� �⺻ Ÿ���� ��Ҹ� ������ �� ���� 
        					.collect(Collectors.collectingAndThen(Collectors.toSet(),
        							phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
        System.out.println(answer2); // 5
        
        Set<Integer> answer3= Arrays.stream(nums)
						    		 .boxed()  
						    		 .collect(Collectors.toSet());
        System.out.println(answer3); // [1, 2, 3, 4, 5]
	}
}
