package method_reference2;

import java.util.ArrayList;
import java.util.List;

public class CarTest {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(i);
			
		}
	}

}
