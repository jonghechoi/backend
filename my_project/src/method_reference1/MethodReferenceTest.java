package method_reference1;

import java.util.function.BiConsumer;

public class MethodReferenceTest {

	public static void main(String[] args) {
		BiConsumer<String, String> consumer;
		consumer = (s1, s2) -> MethodReference.staticChain(s1, s2);
//		consumer = MethodReference::staticChain;
		consumer.accept("static", "method");
		
		MethodReference chain = new MethodReference();
		consumer = (s1,s2) -> chain.instanceChain(s1,s2); // ���ٽ� 
		consumer = chain::instanceChain; //�޼ҵ� ���� 
		consumer.accept("instance", "method");
	}

}
