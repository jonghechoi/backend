package observer_pattern;

public class Test {

	public static void main(String[] args) {
		Duck duck = new Duck();
		Observer observer = new Observer(duck);
		Observer observer2 = new Observer(duck);
		Observer observer3 = new Observer(duck);
		
		duck.setStudyHours(7);

	}

}
