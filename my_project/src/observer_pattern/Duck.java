package observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class Duck {
	private List<Observer> observers;
	private int studyHours;
	
	// 생성자
	public Duck() {
		// 객체 생성시 observers 객체 생성
		observers = new ArrayList<>();
	}
	
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}
	
	/* 
	 * 여기까지가 Duck, Observer 클래스 생성 단계 
	 */
	
	public void notifyObservers() {
		for(Observer observer : observers) {
			observer.update();
		}
	}
	
	public void setStudyHours(int studyHours) {
		this.studyHours = studyHours;
		startStudy();
	}
	
	public void startStudy() {
		notifyObservers();
	}
	
	public int getStudyHours() {
		return studyHours;
	}
}
