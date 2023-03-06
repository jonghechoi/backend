// ZooKeeper.java

package java_code.java_11day;
import java.util.Scanner;

public class ZooKeeper {
	int size = 3;
	AnimalVo[] animals;
	Scanner scan = new Scanner(System.in);

	public void insertBehavior() {
		System.out.println("== 동물들 하루 일과 정리 in EverLand ==");
		
		// 동물들 하루 정보 저장
		AnimalVo[] animals = new AnimalVo[size];
		
		System.out.println("=== 동물들의 하루 일과표를 작성하세요. ===");
		for(int i=0; i<size; i++) {
			AnimalVo animalVo = new AnimalVo();
			System.out.print((i+1) +"번째 동물의 이름을 입력하세요. >> ");
			animalVo.setName(scan.next());
			
			System.out.print(animalVo.getName() +"의 오늘 하루 식사 횟수를 입력하세요. >> ");
			animalVo.setDayEat(scan.nextInt());
			System.out.print(animalVo.getName() +"의 오늘 하루 수면 횟수를 입력하세요. >> ");
			animalVo.setDaySleep(scan.nextInt());
			System.out.print(animalVo.getName() +"의 오늘 하루 놀이 횟수를 입력하세요. >> ");
			animalVo.setDayPlay(scan.nextInt());
			
			animals[i] = animalVo;
		}
		this.animals = animals;
	}

	public void compareBehavior() {
		System.out.print("알아보고자 하는 동물의 이름을 입력하세요. >> ");
		String name = scan.next();
		
		int search_idx = -1;
		for(int i=0; i<size; i++) {
			if(EverLand.routineList[i].getRoutineName().equals(name)) {
				search_idx = i;
			}
		}

		System.out.println("================ " + name + "의 루틴 변경사항 ==================");
		System.out.println("식사 횟수 차이 (매일 루틴 - 금일 식사 횟수) : " 
				+ (EverLand.routineList[search_idx].getRoutineEat() - animals[search_idx].getDayEat()));
		System.out.println("수면 횟수 차이 (매일 루틴 - 금일 수면 횟수) : " 
				+ (EverLand.routineList[search_idx].getRoutineSleep() - animals[search_idx].getDaySleep()));
		System.out.println("놀이 횟수 차이 (매일 루틴 - 금일 놀이 횟수) : " 
				+ (EverLand.routineList[search_idx].getRoutinePlay() - animals[search_idx].getDayPlay()));
	}
		

}