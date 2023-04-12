package method_reference;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class ChainTest {

	public static void main(String[] args) {
		/**
		 *  정적(static) 메소드 참조
		 */
		BiConsumer<String, String> consumer;
		
		// 람다식
		consumer = (s1, s2) -> Chain.staticChain(s1, s2);
		consumer.accept("hi", "ji");
		// 메소드 참조 
		consumer = Chain::staticChain;
		consumer.accept("hi~~~", "ji~~~");
		
		/**
		 * 	인스턴스 메소드 참조
		 */
		Chain chain = new Chain();
		
		consumer = (s1, s2) -> chain.instanceChain(s1, s2);
		consumer.accept("ho", "jo");
		
		consumer = chain::instanceChain;
		consumer.accept("ho~~~", "jo~~~");
	}
}