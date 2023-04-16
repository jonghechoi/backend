package coding_test;

import java.util.Arrays;
import java.util.HashSet;

public class 소수찾기 {
    static HashSet<Integer> set = new HashSet<>(); // 중복값 제거 위한 set
    static char[] arr; // 종이조각
    static boolean[] visited; // 사용여부
    
	public static void main(String[] args) {
        int answer = 0;
        String numbers = "17";
        
        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        
        for(int i=0; i<numbers.length(); i++){
            arr[i] = numbers.charAt(i); 
        }
                
        recursion("",0); // 재귀함수
        
        answer = set.size();
//        return answer;
	}

    // dfs 재귀로 구현. 가능한 숫자 조합 찾고 소수면 set에 추가
    public static void recursion(String str, int idx){
        
        int num;
        if(str!=""){
            num = Integer.parseInt(str);
            if(isPrime(num)) set.add(num); // 소수판별
        }
        if(idx==arr.length) {
        	System.out.println();
        	System.out.println();
        	System.out.println("----------- 리턴 시작 -----------");
        	System.out.println();
        	System.out.println();
        	return; // 끝까지 다했을 때 
        }
        
        for(int i=0;i<arr.length;i++){
            if(visited[i]) continue; // 방문한 노드면 넘어감
            visited[i] = true; // 방문
            System.out.println("idx : " + idx + " ---> for문 i:"+i+", str:"+str+arr[i]);
            recursion(str+arr[i], idx+1); // 방문 했을 시 재귀
            System.out.println("idx : " + idx + " ---> for문2 i:"+i+", str:"+str);
            visited[i] = false; // 백트래킹
        }
    }//recursion
    
    // 소수 판별
    public static boolean isPrime(int num){
        if(num==0||num==1) return false;
        for(int i=2; i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }

}
