package method_reference;

import java.util.function.BiFunction;

public class StudentTest {

	public static void main(String[] args) {
		BiFunction<String, String, Student> constructor;
		
//		constructor = (name, major) -> new Student(name, major);
		constructor = Student::new;
		
		constructor.apply("Ǫ����124", "��ġ�ܱ�");
		
	}

}
