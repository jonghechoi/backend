package java_code.java_14day;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapclassTest {

	public static void main(String[] args) {
		// HashMap 객체 생성
		// K - the type of keys maintained by this map
		// V - the type of mapped values
		HashMap<String,UserVo> hmap = new HashMap<String,UserVo>(); // key값은 보통 String 타입으로 지정. value값은 들어가는 객체 타입
		
		// UserVo 클래스를 통해 4개의 객체 생성 후 저장
		hmap.put("user1", new UserVo());
		hmap.put("user2", new UserVo("테스트","부산시",30));
		hmap.put("user3", new UserVo("송송","인천시",40));
		hmap.put("user4", new UserVo("퐁퐁","안산시",50));

		System.out.println("size ==> " + hmap.size());

		// entrySet() 메소드 이용하면 Set<Map.Entry<K,V>> 형식으로 출력
		for(Map.Entry<String, UserVo> entry : hmap.entrySet()) {
			System.out.print(entry.getKey()+"\t");
			System.out.print(entry.getValue().getName()+"\t");
			System.out.print(entry.getValue().getAddress()+"\t");
			System.out.print(entry.getValue().getAge()+"\n");
		}
		Set<String> keyList = hmap.keySet();
		for(String key : keyList) {
			System.out.print(hmap.get(key).getName()+"\t");
			System.out.print(hmap.get(key).getAddress()+"\t");
			System.out.print(hmap.get(key).getAge()+"\n");
		}
		
		// iterator() 사용해보기 --> hashset으로 한번 꼬아서 출력해야만 함
		// 리턴 타입이 set인 메소드가 entrySet(), keySet() 있음. api문서 안에서도 iterater 메소드 존재!!
		Iterator<Map.Entry<String,UserVo>> it = hmap.entrySet().iterator();
			
		while(it.hasNext()) {
			Map.Entry<String,UserVo> user = it.next();
			String userNum = user.getKey();
			UserVo userInfo = user.getValue();
			
			System.out.print(userNum +"\t");
			System.out.print(userInfo.getName() +"\t");
			System.out.print(userInfo.getAddress() +"\t");
			System.out.print(userInfo.getAge() +"\n");
			
			
			
		}
		
	}

}
