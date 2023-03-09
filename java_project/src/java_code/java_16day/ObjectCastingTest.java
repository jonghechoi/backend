package java_code.java_16day;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ObjectCastingTest {

	public static void main(String[] args) {
		// ArrayList를 통해 List 객체를 생성
		List<String> strList = new ArrayList<String>(); // interface는 객체 생성안되지만 자식 통해서는 객체 생성 가능!!!
		Set<String> strSet = new HashSet<String>();
		Map<String, String> strMap = new HashMap<String, String>();
		
		ArrayList<String> strList2 = (ArrayList<String>)strList;
		HashSet<String> strSet2 = (HashSet<String>)strSet;
		HashMap<String, String> strMap2 = (HashMap<String, String>)strMap;
	}

}
