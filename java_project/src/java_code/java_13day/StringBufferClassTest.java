package java_code.java_13day;

public class StringBufferClassTest {

	public static void main(String[] args) {
		String name = "ȫ�浿"; // ��ó���� "ȫ�浿"�� ����
		name = name + ", �����"; // �߰��� �Ǹ� ���Ӱ� ��������� ��������� �ű⿡ ��
		name = name + ", ��ö��"; // ����°�� ���� �� ���� �������
		name = name + ", �̿���"; 
		name = name + ", �ں���"; // �� 5���� ��������� ����� ��. ���� 4���� ������ GC�� �ذ�
								// ������ ��ȿ����
		System.out.println("name = " + name);
		
		// StringBuffer
		StringBuffer sb = new StringBuffer(30);
		System.out.println("capacity ==> " + sb.capacity());
		
		sb.append("ȫ�浿");
		sb.append("�����");
		sb.append("��ö��");
		System.out.println("capacity ==> " + sb.capacity());
		System.out.println("length ==> " + sb.length());
		
		System.out.println(sb.toString()); // StringBuffer�� �θ�� java.lang.Object
										   // ������ object�� ��� �޼ҵ带 ��� �����Ƿ� java.lang.String�� �޼ҵ嵵 ������ �� ����
		System.out.println(sb);
		
		sb.append("������");
		System.out.println(sb);
		
		sb.insert(3, "�̼���");
		System.out.println(sb);
	}

}
