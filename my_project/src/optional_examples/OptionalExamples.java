package optional_examples;

import java.util.Optional;

public class OptionalExamples {

	public static void main(String[] args) {
		Optional<String> optional = Optional.of("this is optional describing");
		// ��ü�� �����ϴ��� Ȯ��
		if(optional.isPresent()) {
			System.out.println(optional.get());
		}
		
		// ��ü�� �������� �ʴ� ��� �⺻�� ���
		System.out.println(optional.orElse(null));
		
		// ��ü�� �������� �ʴ� ��� �⺻�� �����Ͽ� ���
		Optional<String> optional2 = Optional.ofNullable(null);
		System.out.println(optional2.orElseGet(() -> "orElseGet practice"));
	}

}
