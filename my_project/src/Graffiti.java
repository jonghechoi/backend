
public class Graffiti {

	public static void main(String[] args) {
		// �� 3���� String��ü�� �����ȴ�. ����ϴ°� ������ s �ϳ������ٵ� --> GC ��� --> StringBuffer�� �������
		String s = new String("s");
		s = s.concat(" ���̱�");
//		System.out.println("1 ---> " + s);
		s = s + " ���̱�";
//		System.out.println("2 ---> " + s);
		
		
		String a = "012345";
		
		System.out.println(a.substring(0, 6));
		System.out.println(a.substring(2, 4));
		System.out.println(a.substring(4, 6));

	}

}
