
public class Graffiti {

	public static void main(String[] args) {
		// �� 3���� String��ü�� �����ȴ�. ����ϴ°� ������ s �ϳ������ٵ� --> GC ��� --> StringBuffer�� �������
		String s = new String("s");
		s = s.concat(" ���̱�");
		System.out.println("1 ---> " + s);
		s = s + " ���̱�";
		System.out.println("2 ---> " + s);
		

	}

}
