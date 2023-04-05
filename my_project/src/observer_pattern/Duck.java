package observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class Duck {
	private List<Observer> observers;
	private int studyHours;
	
	// ������
	public Duck() {
		// ��ü ������ observers ��ü ����
		observers = new ArrayList<>();
	}
	
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}
	
	/* 
	 * ��������� Duck, Observer Ŭ���� ���� �ܰ� 
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
