
public class Graffiti {

	public static void main(String[] args) {
		// 총 3개의 String객체가 생성된다. 사용하는건 마지막 s 하나뿐일텐데 --> GC 대상 --> StringBuffer을 사용하자
		String s = new String("s");
		s = s.concat(" 붙이기");
//		System.out.println("1 ---> " + s);
		s = s + " 붙이기";
//		System.out.println("2 ---> " + s);
		
		
		String a = "012345";
		
		System.out.println(a.substring(0, 6));
		System.out.println(a.substring(2, 4));
		System.out.println(a.substring(4, 6));

	}

}
