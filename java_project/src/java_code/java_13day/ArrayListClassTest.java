package java_code.java_13day;
import java.util.ArrayList;

public class ArrayListClassTest {

	public static void main(String[] args) {
		ArrayList alist = new ArrayList(); // �⺻ ������� 10�� ����
		System.out.println(alist.size()); // ���� �� ������
		
		alist.add(new String("ȫ�浿"));
		alist.add("��ġ��");
		alist.add(124); // ��ü ���·θ� ���� �ϴµ� int, double, String�� �����ϴ�??
		alist.add(123.13135); // wrapper Ŭ������ �ڵ����� ����ȯ�� �Ͽ� [new 123],[new "��ġ��"] ������ ��ü�� ����
		System.out.println(alist.size());
		
		// Ȯ�� for���� ������ ������ Ÿ���� ���ƾ� �ϴµ� ���� ���� ������ Ÿ���� �ٸ��Ƿ� �� �� ����
		for (int i=0; i<alist.size(); i++) {
			System.out.println(alist.get(i));
		}
	}

}
