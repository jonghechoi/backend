package java_code.java_13day;

public class StringClassTest {

	public static void main(String[] args) {
		String name1 = "홍길동";
		String name2 = new String("홍길동");
		String strList = "자바,오라클,Spring,HTML";
		String[] strArray = strList.split(",");
		
		for(String str : strArray) {
			System.out.print(str+"\t");
		}
		System.out.println();
		
		System.out.println(String.valueOf(100));
		System.out.println(String.valueOf(100.23452));
		
		String[] slist = {"홍길동","이순신","김고은","박보검"};
		String slist2 = String.join("/",slist);
		System.out.println("slist2 ===> " + slist2);
		
		System.out.println("홍길동".length());
		
		
		if(name1 == name2) { // == 연산자는 주소값을 비교하기 때문에 따르다가 출력됨
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		if(name1.equals(name2)) { // String 클래스가 가지는 equals 메소드는 값을 비교
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}

	}

}
