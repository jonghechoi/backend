package java_code.java_13day;
import java.util.ArrayList;

public class ScoreTest {

	public static void main(String[] args) {
		
		ScoreVo[] scoreList1 = new ScoreVo[2]; // scoreList1은 ScoreVo만 담는 리스트라는게 직관적으로 확인 가능
		ScoreVo hong = new ScoreVo("홍길동", 10, 10, 10);
		ScoreVo lee = new ScoreVo("이순신");
		ScoreVo test = new ScoreVo("테스트");
		
		scoreList1[0] = hong;
		scoreList1[1] = lee;
//		scoreList1[2] = test; // array를 사용하면 인덱스 범위 벗어남
		System.out.println("-------------------------------------------");
		
//		ArrayList scoreList3 = new ArrayList(2); // 뭐가 scoreList2 리스트에 들어가는지 모르기 때문에 generic이 들어가서 뭐가 들어가는지 직관적으로 보인다
		ArrayList<ScoreVo> scoreList2 = new ArrayList<ScoreVo>(2);

		scoreList2.add(hong);
		scoreList2.add(lee);
		scoreList2.add(test);
		scoreList2.add(2, new ScoreVo("mong",20,20,100));
		scoreList2.set(1, new ScoreVo("김길동",30,30,30));
		scoreList2.remove(3);
		
		for(ScoreVo score : scoreList2) {
			System.out.print(score.getName()+"\t");
			System.out.print(score.getKor()+"\t");
			System.out.print(score.getEng()+"\t");
			System.out.print(score.getMath()+"\t");
			System.out.print(score.getTot()+"\t");
			System.out.print(score.getAvg()+"\n");
		}
		
	}

}
