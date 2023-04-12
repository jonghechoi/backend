package method_reference;

import java.util.function.BiFunction;

public class 매개변수메소드참조 {

	public static void main(String[] args) {
		/**
		 * 	매개 변수의 메소드 참조
		 */
		BiFunction<String, String, Boolean> function;
		
		// 람다식
		function = (s1, s2) -> s1.equals(s2);
		// 메소드 참조
		function = String::equals;
		
		Boolean equal = function.apply("이거", "맞아?");
		System.out.println("equal --> " + equal);
	}
}