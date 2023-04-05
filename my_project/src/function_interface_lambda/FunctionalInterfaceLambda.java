package function_interface_lambda;

import java.util.Comparator;
import java.util.function.Function;

public class FunctionalInterfaceLambda {

	public static void main(String[] args) {
		
//		Function<String,Integer> stringTointeger = new Function<>() {
//			@Override
//			public Integer apply(String s) {
//				return Integer.parseInt(s);
//			}
//		};
//
//		System.out.println(stringTointeger.apply("20"));
//
//		
//		
//		Function<String,Integer> stringTointeger2 = (String s) -> Integer.parseInt(s);
//		
//		System.out.println(stringTointeger2.apply("10"));
//		
//		
//		Comparator<Integer> comp = (Integer param1, Integer param2) -> {
//			if(param1 > param2) {
//				return param1;
//			}else {
//				return param2;
//			}
//		};
//		System.out.println(comp.compare(90, 190));
		
		
		plusInterface<Integer,Integer> plus = new plusInterface<Integer,Integer>() {
			@Override
			public Integer sum(Integer x, Integer y) {
				return x + y;
			}
		};
		
		System.out.println(plus.sum(10, 23));
		
		plusInterface<Integer,Integer> plus2 = (Integer x, Integer y) -> x + y; 
		
		System.out.println(plus2.sum(111, 222));
	}
}
