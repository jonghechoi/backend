package java_code.java_13day;
import java.util.ArrayList;

public class ScoreTest {

	public static void main(String[] args) {
		
		ScoreVo[] scoreList1 = new ScoreVo[2]; // scoreList1�� ScoreVo�� ��� ����Ʈ��°� ���������� Ȯ�� ����
		ScoreVo hong = new ScoreVo("ȫ�浿", 10, 10, 10);
		ScoreVo lee = new ScoreVo("�̼���");
		ScoreVo test = new ScoreVo("�׽�Ʈ");
		
		scoreList1[0] = hong;
		scoreList1[1] = lee;
//		scoreList1[2] = test; // array�� ����ϸ� �ε��� ���� ���
		System.out.println("-------------------------------------------");
		
//		ArrayList scoreList3 = new ArrayList(2); // ���� scoreList2 ����Ʈ�� ������ �𸣱� ������ generic�� ���� ���� ������ ���������� ���δ�
		ArrayList<ScoreVo> scoreList2 = new ArrayList<ScoreVo>(2);

		scoreList2.add(hong);
		scoreList2.add(lee);
		scoreList2.add(test);
		scoreList2.add(2, new ScoreVo("mong",20,20,100));
		scoreList2.set(1, new ScoreVo("��浿",30,30,30));
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
