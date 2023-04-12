package method_reference;

import java.util.function.BiFunction;

public class �Ű������޼ҵ����� {

	public static void main(String[] args) {
		/**
		 * 	�Ű� ������ �޼ҵ� ����
		 */
		BiFunction<String, String, Boolean> function;
		
		// ���ٽ�
		function = (s1, s2) -> s1.equals(s2);
		// �޼ҵ� ����
		function = String::equals;
		
		Boolean equal = function.apply("�̰�", "�¾�?");
		System.out.println("equal --> " + equal);
	}
}