package java_code.java_14day;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetClassTest {
	public static void main(String[] args) {
		HashSet<UserVo> hset = new HashSet<UserVo>(); // generic을 이용하여 정확한 데이터 타입 기재. (UserVo 데이터 타입만 입력가능)
		hset.add(new UserVo()); // 객체를 만들어서 바로 hset에 담음
		hset.add(new UserVo("테스트","부산시",30));
		hset.add(new UserVo("김고은","인천시",35));
		hset.add(new UserVo("박보검","경기도",36));
		
		
		System.out.println("size ==> "+hset.size());
		
		Iterator<UserVo> it = hset.iterator(); // generic 들어가면 직관적! // iterator() 메소드 사용해서 it라는 Iterator 인터페이스 생성
		while(it.hasNext()) {
//			System.out.print(it.next().getName()+"\t"); // 이렇게 뽑으면 에러남 java.util.NoSuchElementException
//			System.out.print(it.next().getAddress()+"\t");
//			System.out.print(it.next().getAge()+"\n");

			UserVo user = it.next(); // 1. HashSet에 들어가 있는 UserVo 객체. 
									 // 2. 이것은 UserVo(generic으로 명시되어 있음) 객체 형태로 it 이터레이터 인터페이스에 존재함
									 // 3. Iterator 인터페이스인 it. it는 자신이 가지는 객체를 next() 메소드 이용해 다시 UserVo로 반환 
			if(user.getName().equals("테스트")) {
				it.remove();
			}
//			System.out.print(user.getName()+"\t");
//			System.out.print(user.getAddress()+"\t");
//			System.out.print(user.getAge()+"\n");
			
		}
		System.out.println("size ==> "+hset.size());
		
	}
}
