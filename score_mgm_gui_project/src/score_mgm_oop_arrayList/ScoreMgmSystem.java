package score_mgm_oop_arrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreMgmSystem {
	//Field - �޴��� ���� ����� ����
	public static final int INSERT = 1;	
	public static final int SELECT = 2;	
	public static final int SEARCH = 3;	
	public static final int UPDATE = 4;	
	public static final int DELETE = 5;	
	public static final int EXIT = 6;	
	
	//Field
	public ArrayList<ScoreVo> scoreList;
	Scanner scan;
	
	//Constructor
	public ScoreMgmSystem(String schoolName) {
		this(10, schoolName);
	}
	
	public ScoreMgmSystem(int size, String schoolName) {
		scoreList = new ArrayList<ScoreVo>(size);
	}	
	
	//Method
	/** �ε��� �˻� �޼ҵ� **/
	public int findIndex(String name) {
		int index = -1;
		
		//�Ű������� name�� scoreList�� ����Ǿ� �ִ��� �˻��ϰ� ����� index�� ����
		int count = 0;
		for(ScoreVo score : scoreList) {
			if(score.getName().equals(name)) {
				index = count;
			}			
			count++;
		}

		return index;
	}
	
	
	/** �˻� : R(read) - select **/
	public ScoreVo search(String name) {
		ScoreVo score = null; 		
		int idx = findIndex(name);			
		if(idx != -1) {
			score = scoreList.get(idx);						
		}		
		
		return score;
	}
	
	
	/** ���� : D(delete) - delete **/
	public boolean delete(String name) {
		boolean result = false;
		int idx = findIndex(name);
		
		if(idx != -1) {
			if(scoreList.remove(scoreList.get(idx))) {
				result = true;
			}			
		}		
	
		return result;
	}
	
	/** ���� : U(update) - update **/
	public boolean update(ScoreVo update_score) {
		boolean result = false;
		int idx = findIndex(update_score.getName());
		
		if(idx != -1) {				
			scoreList.set(idx, update_score);	
			result = true;
		}					
		return result;
	}
	
	
	/** ��ȸ : R(read) - select **/
	public ArrayList<ScoreVo> select() {
		return scoreList;
	}
	
	/** ��� : C(create) - insert **/
	public boolean insert(ScoreVo score) {
		boolean result = false;
		
		if(scoreList.add(score)) {
			result = true;
		}
		return result;		
	}
		
}//class









