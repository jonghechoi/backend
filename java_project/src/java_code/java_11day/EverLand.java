//EverLand.java

package java_code.java_11day;
import java.util.Scanner;

public class EverLand {

	static RoutineVo[] routineList = new RoutineVo[3];

	public static void main(String[] args) {
		// 1. 동물 클래스(이름, 하루동안 먹고/자고/놀고 몇 번하는지 저장까지), setter/getter 클래스
		// 2. 주키퍼가 하루동안 동물들의 일과를 작성
		// 3. 여기다 객체 생성하고 구동
		int size = 3;
		int[] routineNum = {4,5,6};
		String[] animals = {"lion", "tiger", "bird"};
		
		for(int i=0; i<size; i++) {
			RoutineVo routine = new RoutineVo();
			routine.setRoutineName(animals[i]);
			routine.setRoutineEat(routineNum[i]);
			routine.setRoutineSleep(routineNum[i]);
			routine.setRoutinePlay(routineNum[i]);
			
			routineList[i] = routine;
		}

		ZooKeeper keeper = new ZooKeeper();

		// 사육사의 하루 일과 정리
		keeper.insertBehavior();
		
		while(true) {
			keeper.compareBehavior();			
		}
		
	}

}