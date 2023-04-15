package coding_test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class 폰켓몬 {

	public static void main(String[] args) {
        /**
        * 1. 총개수/2 
        * 2. HashMap 이용하여 각 번호의 갯수 저장
        * 3. key 사이즈가 N/2보다 크면 N/2 리턴
        * 4. 아니면, key 사이즈 리턴
        */
		int[] nums = {3,2,2,4,4,1,1,1,1,5};
        int answer = 0;
        int pickNum = nums.length/2;
        
        // 중복을 피하기 위해 HashMap 사용 
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
        	hmap.put(nums[i], 0);
        	  // 각 숫자의 갯수는 여기서 필요없음. 중복되지 않는 수가 몇개 있느냐를 사용하니까!
//            if(hmap.containsKey(nums[i])) {
//                hmap.put(nums[i], 1);    
//            }else {
//                hmap.put(nums[i], hmap.get(nums[i]+1));
//            }
        }    
        
        // 삼항연산자 깔끔!
        System.out.println(hmap.size() > pickNum ? pickNum : hmap.size()); // 5
        /*
         * ****************************************************************************************************************************
         * 스트림으로 처리...ㄷㄷ
         */
        int answer2= Arrays.stream(nums)
        					.boxed() // 반환값이 Stream<Integer> 이기 때문에 기본 타입을 래퍼 클래스로 변환. 또 제네릭으로 선언된 컬렉션에는 기본 타입의 요소를 저장할 수 없음 
        					.collect(Collectors.collectingAndThen(Collectors.toSet(),
        							phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
        System.out.println(answer2); // 5
        
        Set<Integer> answer3= Arrays.stream(nums)
						    		 .boxed()  
						    		 .collect(Collectors.toSet());
        System.out.println(answer3); // [1, 2, 3, 4, 5]
	}
}
