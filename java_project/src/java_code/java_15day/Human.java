package java_code.java_15day;

public class Human implements Animal, Hospital { // �������̽��� implement�ϸ� ������ ��� �߻� �޼ҵ带 �������̵� �ؾ���
	// Field											// �߻� �޼ҵ尡 10���� �ִ�? 10�� �� �ؾ���
	String name, address;
	int age;

	@Override // ��ø��ϱ� ����
	public void checkUp() {
		System.out.println("human : �ǰ������ϴ�");
	}
	
	@Override
	public void eat() {
		System.out.println("Human : �Դ�");
	}
	
	@Override
	public void sleep() {
		System.out.println("Human : �ڴ�");
	}
}
