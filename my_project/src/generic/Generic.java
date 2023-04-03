package generic;

public class Generic {
    public static void main(String []args){
        //타입 파라미터 지정
        People<String,Integer> p1 = new People<String,Integer>("Jack",20);
        //타입 파라미터 추정
        People<String,Integer> p2 = new People("Steve",30);
        //GenericMothod 호출
        boolean result = p1.compare(p1,p2);
        System.out.println(result);
    }
}