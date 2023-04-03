package functional_interface_lambda;

import java.util.function.Function;

public class FunctionalInterfaceLambda {

	public static void main(String[] args) {
		/*
		 *  함수형 인터페이스 & 람다 연습
		 */
//		Function<String, Integer> stringToInt = new Function<>() {
//			@Override
//			public Integer apply(String s) {
//				return Integer.parseInt(s);
//			}
//		};
//		System.out.println(stringToInt.apply("10").getClass());
//		
		
		Function<String, String> stringToInt2 = (String sss) -> sss+"haha";		
		
		String result = stringToInt2.apply("dadaaa");
		
		System.out.println(result);
		
		
		Function<String, Integer> stringToInt3 = (String sss) -> Integer.parseInt(sss);		
		
		int result2 = stringToInt3.apply("222222");
		
		System.out.println(result2);

	}

}
