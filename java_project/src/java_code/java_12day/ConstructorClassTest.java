package java_code.java_12day;

public class ConstructorClassTest {

	public static void main(String[] args) {
		BookVo book = new BookVo();
		BookVo python1 = new BookVo("python");
		BookVo python2 = new BookVo("python","park");
		BookVo python3 = new BookVo("python","park","7231");
		BookVo python4 = new BookVo("python","park","7231",500);
		
		BookVo java = new BookVo();
		System.out.println(java.title);
		System.out.println(java.author);
		System.out.println(java.isbn);
		System.out.println(java.price);
		
		BookVo oracle = new BookVo("oracle", "song", "7894", 200);
		System.out.println(oracle.title);
		System.out.println(oracle.author);
		System.out.println(oracle.isbn);
		System.out.println(oracle.price);
		
		
		ConstructorClass cc = new ConstructorClass(); // 해당 클래스 내에 생성자가 없으면 JVM이 컴파일시 생성
		System.out.println(cc.name);
		System.out.println(cc.address);
		System.out.println(cc.age);
	}

}
