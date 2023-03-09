package java_code.java_16day;
import java.util.ArrayList;
import java.util.List;

import java_code.java_15day.Animal;
import java_code.java_15day.Dog;
import java_code.java_15day.Hospital;


public class ArrayListCastingTest {

	public static void main(String[] args) {
		List<Dog> dList = new ArrayList<Dog>(); 
		
		Dog dog1 = new Dog();
		Dog dog2 = new Dog();
		Dog dog3 = new Dog();
		
		dList.add(dog1);
		dList.add(dog2);
		dList.add(dog3);
		
		Object obj = dList.get(0); // 타입을 안 줬는데도 묵시적 형변환이 일어남 왜?? dog1에 Object 타입이 있기 때문
		Animal ani = dList.get(1); // dog2에도 Animal 타입이 있음
		Hospital hos = dList.get(2);
		
		Dog d1 = (Dog)obj;
		Dog d2 = (Dog)ani;
		Dog d3 = (Dog)hos;
 	}

}
