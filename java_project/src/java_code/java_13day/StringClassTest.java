package java_code.java_13day;

public class StringClassTest {

	public static void main(String[] args) {
		String name1 = "ȫ�浿";
		String name2 = new String("ȫ�浿");
		String strList = "�ڹ�,����Ŭ,Spring,HTML";
		String[] strArray = strList.split(",");
		
		for(String str : strArray) {
			System.out.print(str+"\t");
		}
		System.out.println();
		
		System.out.println(String.valueOf(100));
		System.out.println(String.valueOf(100.23452));
		
		String[] slist = {"ȫ�浿","�̼���","�����","�ں���"};
		String slist2 = String.join("/",slist);
		System.out.println("slist2 ===> " + slist2);
		
		System.out.println("ȫ�浿".length());
		
		
		if(name1 == name2) { // == �����ڴ� �ּҰ��� ���ϱ� ������ �����ٰ� ��µ�
			System.out.println("����");
		}else {
			System.out.println("�ٸ���");
		}
		
		if(name1.equals(name2)) { // String Ŭ������ ������ equals �޼ҵ�� ���� ��
			System.out.println("����");
		}else {
			System.out.println("�ٸ���");
		}

	}

}
