package java_code.java_2day;

public class DataTypeTest2 {

	public static void main(String[] args) {
		// ����(����,���) ���� ����
		// 4����Ʈ ������ ����  num�� 100�� ����
		int num = 100;
		// 8����Ʈ �Ǽ��� ���� fnum�� 3.14�� ����
		double fnum = 3.14;
		// 1����Ʈ ������ ���� s1�� 'ȫ'�� ����
		char s1 = 'ȫ';
		// �⺻ ������ ������ s2�� "ȫ�浿"�� ����
		String s2 = "ȫ�浿";
		// ��ü Ÿ�� ������ ���� s3�� "ȫ�浿"�� ����
		String s3 = new String("ȫ�浿");

		//���
		System.out.println("num = " + num);
		System.out.println("fnum = " + fnum);
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		System.out.println("s3 = " + s3);
		System.out.println("s2==s3 --> " + (s2==s3));
		// �� false ������?? ���ÿ� �ִ� s3�� ���� "ȫ�浿"�� �ּҰ�
		System.out.println(s3.hashCode());
		// ���� ���ڵ����� �񱳴� equals�� ���. equals �޼ҵ�� ���� �ִ� �����ͱ��� ������
		System.out.println("s2.equals(s3) -- > " + (s2.equals(s3)));
	}

}
