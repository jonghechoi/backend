package score_mgm_oop_arrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreMgmSystem {
	//Field - 메뉴에 대한 상수값 정의
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
	/** 인덱스 검색 메소드 **/
	public int findIndex(String name) {
		int index = -1;
		
		//매개변수의 name이 scoreList에 저장되어 있는지 검색하고 결과를 index에 저장
		int count = 0;
		for(ScoreVo score : scoreList) {
			if(score.getName().equals(name)) {
				index = count;
			}			
			count++;
		}

		return index;
	}
	
	
	/** 검색 : R(read) - select **/
	public ScoreVo search(String name) {
		ScoreVo score = null; 		
		int idx = findIndex(name);			
		if(idx != -1) {
			score = scoreList.get(idx);						
		}		
		
		return score;
	}
	
	
	/** 삭제 : D(delete) - delete **/
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
	
	/** 수정 : U(update) - update **/
	public boolean update(ScoreVo update_score) {
		boolean result = false;
		int idx = findIndex(update_score.getName());
		
		if(idx != -1) {				
			scoreList.set(idx, update_score);	
			result = true;
		}					
		return result;
	}
	
	
	/** 조회 : R(read) - select **/
	public ArrayList<ScoreVo> select() {
		return scoreList;
	}
	
	/** 등록 : C(create) - insert **/
	public boolean insert(ScoreVo score) {
		boolean result = false;
		
		if(scoreList.add(score)) {
			result = true;
		}
		return result;		
	}
		
}//class









