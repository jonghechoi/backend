package java_code.java_15day;

public class Human implements Animal, Hospital { // 인터페이스를 implement하면 내부의 모든 추상 메소드를 오버라이딩 해야함
	// Field											// 추상 메소드가 10개가 있다? 10개 다 해야함
	String name, address;
	int age;

	@Override // 명시만하기 위함
	public void checkUp() {
		System.out.println("human : 건강검진하다");
	}
	
	@Override
	public void eat() {
		System.out.println("Human : 먹다");
	}
	
	@Override
	public void sleep() {
		System.out.println("Human : 자다");
	}
}
