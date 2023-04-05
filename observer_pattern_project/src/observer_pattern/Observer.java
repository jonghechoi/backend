package observer_pattern;

public class Observer {
	private Duck duck;
	private int studyHours;
	private int observerNum = 0;
	
	public Observer(Duck duck) {
		this.duck = duck;
		observerNum++;
		duck.registerObserver(this);
	}
	
	public void update() {
		studyHours = duck.getStudyHours();
		display();
	}
	
	public void display() {
		System.out.println("Observer"+observerNum+"�� �ٶ� ���� Duck���� ���� �ð� : " + studyHours);
	}
}
