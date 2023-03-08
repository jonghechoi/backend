package java_code.java_14day;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapclassTest {

	public static void main(String[] args) {
		// HashMap ��ü ����
		// K - the type of keys maintained by this map
		// V - the type of mapped values
		HashMap<String,UserVo> hmap = new HashMap<String,UserVo>(); // key���� ���� String Ÿ������ ����. value���� ���� ��ü Ÿ��
		
		// UserVo Ŭ������ ���� 4���� ��ü ���� �� ����
		hmap.put("user1", new UserVo());
		hmap.put("user2", new UserVo("�׽�Ʈ","�λ��",30));
		hmap.put("user3", new UserVo("�ۼ�","��õ��",40));
		hmap.put("user4", new UserVo("����","�Ȼ��",50));

		System.out.println("size ==> " + hmap.size());

		// entrySet() �޼ҵ� �̿��ϸ� Set<Map.Entry<K,V>> �������� ���
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
		
		// iterator() ����غ��� --> hashset���� �ѹ� ���Ƽ� ����ؾ߸� ��
		// ���� Ÿ���� set�� �޼ҵ尡 entrySet(), keySet() ����. api���� �ȿ����� iterater �޼ҵ� ����!!
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
