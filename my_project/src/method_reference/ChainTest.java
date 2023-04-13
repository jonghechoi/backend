package method_reference;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class ChainTest {

	public static void main(String[] args) {
		/**
		 *  ����(static) �޼ҵ� ����
		 */
		BiConsumer<String, String> consumer;
		
		// ���ٽ�
		consumer = (s1, s2) -> Chain.staticChain(s1, s2);
		consumer.accept("hi", "ji");
		// �޼ҵ� ���� 
		consumer = Chain::staticChain;
		consumer.accept("hi~~~", "ji~~~");
		
		/**
		 * 	�ν��Ͻ� �޼ҵ� ����
		 */
		Chain chain = new Chain();
		
		consumer = (s1, s2) -> chain.instanceChain(s1, s2);
		consumer.accept("ho", "jo");
		
		consumer = chain::instanceChain;
		consumer.accept("ho~~~", "jo~~~");
	}
}