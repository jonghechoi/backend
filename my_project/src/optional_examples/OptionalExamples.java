package optional_examples;

import java.util.Optional;

public class OptionalExamples {

	public static void main(String[] args) {
		Optional<String> optional = Optional.of("this is optional describing");
		// 객체가 존재하는지 확인
		if(optional.isPresent()) {
			System.out.println(optional.get());
		}
		
		// 객체가 존재하지 않는 경우 기본값 출력
		System.out.println(optional.orElse(null));
		
		// 객체가 존재하지 않는 경우 기본값 생성하여 출력
		Optional<String> optional2 = Optional.ofNullable(null);
		System.out.println(optional2.orElseGet(() -> "orElseGet practice"));
	}

}
