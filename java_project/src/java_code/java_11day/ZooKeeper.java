// ZooKeeper.java

package java_code.java_11day;
import java.util.Scanner;

public class ZooKeeper {
	int size = 3;
	AnimalVo[] animals;
	Scanner scan = new Scanner(System.in);

	public void insertBehavior() {
		System.out.println("== ������ �Ϸ� �ϰ� ���� in EverLand ==");
		
		// ������ �Ϸ� ���� ����
		AnimalVo[] animals = new AnimalVo[size];
		
		System.out.println("=== �������� �Ϸ� �ϰ�ǥ�� �ۼ��ϼ���. ===");
		for(int i=0; i<size; i++) {
			AnimalVo animalVo = new AnimalVo();
			System.out.print((i+1) +"��° ������ �̸��� �Է��ϼ���. >> ");
			animalVo.setName(scan.next());
			
			System.out.print(animalVo.getName() +"�� ���� �Ϸ� �Ļ� Ƚ���� �Է��ϼ���. >> ");
			animalVo.setDayEat(scan.nextInt());
			System.out.print(animalVo.getName() +"�� ���� �Ϸ� ���� Ƚ���� �Է��ϼ���. >> ");
			animalVo.setDaySleep(scan.nextInt());
			System.out.print(animalVo.getName() +"�� ���� �Ϸ� ���� Ƚ���� �Է��ϼ���. >> ");
			animalVo.setDayPlay(scan.nextInt());
			
			animals[i] = animalVo;
		}
		this.animals = animals;
	}

	public void compareBehavior() {
		System.out.print("�˾ƺ����� �ϴ� ������ �̸��� �Է��ϼ���. >> ");
		String name = scan.next();
		
		int search_idx = -1;
		for(int i=0; i<size; i++) {
			if(EverLand.routineList[i].getRoutineName().equals(name)) {
				search_idx = i;
			}
		}

		System.out.println("================ " + name + "�� ��ƾ ������� ==================");
		System.out.println("�Ļ� Ƚ�� ���� (���� ��ƾ - ���� �Ļ� Ƚ��) : " 
				+ (EverLand.routineList[search_idx].getRoutineEat() - animals[search_idx].getDayEat()));
		System.out.println("���� Ƚ�� ���� (���� ��ƾ - ���� ���� Ƚ��) : " 
				+ (EverLand.routineList[search_idx].getRoutineSleep() - animals[search_idx].getDaySleep()));
		System.out.println("���� Ƚ�� ���� (���� ��ƾ - ���� ���� Ƚ��) : " 
				+ (EverLand.routineList[search_idx].getRoutinePlay() - animals[search_idx].getDayPlay()));
	}
		

}