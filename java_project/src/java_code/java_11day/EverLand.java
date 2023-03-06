//EverLand.java

package java_code.java_11day;
import java.util.Scanner;

public class EverLand {

	static RoutineVo[] routineList = new RoutineVo[3];

	public static void main(String[] args) {
		// 1. ���� Ŭ����(�̸�, �Ϸ絿�� �԰�/�ڰ�/��� �� ���ϴ��� �������), setter/getter Ŭ����
		// 2. ��Ű�۰� �Ϸ絿�� �������� �ϰ��� �ۼ�
		// 3. ����� ��ü �����ϰ� ����
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

		// �������� �Ϸ� �ϰ� ����
		keeper.insertBehavior();
		
		while(true) {
			keeper.compareBehavior();			
		}
		
	}

}