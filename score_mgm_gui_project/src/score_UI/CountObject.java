//package score_UI;
//
//import score_ArrayList.Scoremgm;
//
//public class CountObject extends Thread{
//	//Field
//	ScoremgmUI ui;
//	Scoremgm system;
//	
//	//Constructor
//	public CountObject() {}
//	public CountObject(ScoremgmUI ui, Scoremgm system) {
//		this.ui = ui;
//		this.system = system;
//	}
//		
//	public void run() {
//		while(true) {
//			//system.scorelist의 길이가져오기
//			int count = system.scorelist.size();			
//			//ui.tf_count 등록인원 값 넣기
//			ui.tf_count.setText(String.valueOf(count));
////			System.out.println("count------------>>" + count);
//			
//			try {
//				Thread.sleep(10000);				
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
//	}
//}
//
//
//
//
//
//
//
