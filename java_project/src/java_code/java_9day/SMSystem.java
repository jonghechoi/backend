package java_code.java_9day;

public class SMSystem {

	public static void main(String[] args) {
		System.out.println("������ ����б��� �������� �ý���");
		
		// ȫ�浿 �л����� : test, 10, 10, 10 --> Student Ŭ������ �̿��� ��ü ����
		StudentVo hong = new StudentVo(); // �л������� Student Ŭ������ �ִµ� �� Ŭ������ ��ü�� heap�� ����Ǿ� ����
		hong.name = "hong";
		hong.kor = 10;
		hong.eng = 10;
		hong.math = 10; 
		// setter
		hong.setName(hong.name);
		hong.setKor(hong.kor);
		hong.setEng(100);
		hong.setMath(100);
		// getter
		System.out.println(hong.getName());
		System.out.println(hong.getKor());
		System.out.println(hong.getEng());
		System.out.println(hong.getMath());
		
		
		// test �л����� : test, 20, 20, 20
		StudentVo test = new StudentVo();
		test.name = "test";
		test.kor = 20;
		test.eng = 20;
		test.math = 20;

		
		// �л� ���� ���
//		System.out.println("�л���\t����\t����\t����\n");
//		System.out.println("-----------------------------------");
//		System.out.print(hong.name+"\t");
//		System.out.print(hong.kor+"\t");
//		System.out.print(hong.eng+"\t");
//		System.out.print(hong.math+"\n");
//
//		System.out.print(test.name+"\t");
//		System.out.print(test.kor+"\t");
//		System.out.print(test.eng+"\t");
//		System.out.print(test.math);
	}//main
}//lass
