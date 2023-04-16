package coding_test;

import java.util.Arrays;
import java.util.HashSet;

public class �Ҽ�ã�� {
    static HashSet<Integer> set = new HashSet<>(); // �ߺ��� ���� ���� set
    static char[] arr; // ��������
    static boolean[] visited; // ��뿩��
    
	public static void main(String[] args) {
        int answer = 0;
        String numbers = "17";
        
        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        
        for(int i=0; i<numbers.length(); i++){
            arr[i] = numbers.charAt(i); 
        }
                
        recursion("",0); // ����Լ�
        
        answer = set.size();
//        return answer;
	}

    // dfs ��ͷ� ����. ������ ���� ���� ã�� �Ҽ��� set�� �߰�
    public static void recursion(String str, int idx){
        
        int num;
        if(str!=""){
            num = Integer.parseInt(str);
            if(isPrime(num)) set.add(num); // �Ҽ��Ǻ�
        }
        if(idx==arr.length) {
        	System.out.println();
        	System.out.println();
        	System.out.println("----------- ���� ���� -----------");
        	System.out.println();
        	System.out.println();
        	return; // ������ ������ �� 
        }
        
        for(int i=0;i<arr.length;i++){
            if(visited[i]) continue; // �湮�� ���� �Ѿ
            visited[i] = true; // �湮
            System.out.println("idx : " + idx + " ---> for�� i:"+i+", str:"+str+arr[i]);
            recursion(str+arr[i], idx+1); // �湮 ���� �� ���
            System.out.println("idx : " + idx + " ---> for��2 i:"+i+", str:"+str);
            visited[i] = false; // ��Ʈ��ŷ
        }
    }//recursion
    
    // �Ҽ� �Ǻ�
    public static boolean isPrime(int num){
        if(num==0||num==1) return false;
        for(int i=2; i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }

}
