package generic;

public class Generic {
    public static void main(String []args){
        //Ÿ�� �Ķ���� ����
        People<String,Integer> p1 = new People<String,Integer>("Jack",20);
        //Ÿ�� �Ķ���� ����
        People<String,Integer> p2 = new People("Steve",30);
        //GenericMothod ȣ��
        boolean result = p1.compare(p1,p2);
        System.out.println(result);
    }
}