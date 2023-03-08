package java_code.java_14day;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetClassTest {
	public static void main(String[] args) {
		HashSet<UserVo> hset = new HashSet<UserVo>(); // generic�� �̿��Ͽ� ��Ȯ�� ������ Ÿ�� ����. (UserVo ������ Ÿ�Ը� �Է°���)
		hset.add(new UserVo()); // ��ü�� ���� �ٷ� hset�� ����
		hset.add(new UserVo("�׽�Ʈ","�λ��",30));
		hset.add(new UserVo("�����","��õ��",35));
		hset.add(new UserVo("�ں���","��⵵",36));
		
		
		System.out.println("size ==> "+hset.size());
		
		Iterator<UserVo> it = hset.iterator(); // generic ���� ������! // iterator() �޼ҵ� ����ؼ� it��� Iterator �������̽� ����
		while(it.hasNext()) {
//			System.out.print(it.next().getName()+"\t"); // �̷��� ������ ������ java.util.NoSuchElementException
//			System.out.print(it.next().getAddress()+"\t");
//			System.out.print(it.next().getAge()+"\n");

			UserVo user = it.next(); // 1. HashSet�� �� �ִ� UserVo ��ü. 
									 // 2. �̰��� UserVo(generic���� ��õǾ� ����) ��ü ���·� it ���ͷ����� �������̽��� ������
									 // 3. Iterator �������̽��� it. it�� �ڽ��� ������ ��ü�� next() �޼ҵ� �̿��� �ٽ� UserVo�� ��ȯ 
			if(user.getName().equals("�׽�Ʈ")) {
				it.remove();
			}
//			System.out.print(user.getName()+"\t");
//			System.out.print(user.getAddress()+"\t");
//			System.out.print(user.getAge()+"\n");
			
		}
		System.out.println("size ==> "+hset.size());
		
	}
}
