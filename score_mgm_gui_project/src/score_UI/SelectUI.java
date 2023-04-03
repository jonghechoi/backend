package score_UI;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import score_db.ScoreDao;
import score_mgm_oop_arrayList.ScoreVo;

public class SelectUI {
	//Field
//	ScoreMgmSystem sms; //성적관리 시스템
	ScoreDao dao;
	ScoremgmUI ui;	
	String[] colNames = {"번호","이름","국어","영어","수학","총점","평균"};
	DefaultTableModel model = new DefaultTableModel(colNames, 0);
	JTable table = new JTable(model);
	Object[] row = new Object[7]; 
	
	//Constructor
	public SelectUI() {}
	public SelectUI(ScoremgmUI ui) {
		this.ui = ui;
//		this.sms = ui.sms;
		dao = ui.dao;
		init();
	}
	
	//Method
	public void init() {		
		ui.switch_panel(ScoremgmUI.SELECT);
		
		//table에 데이터 넣기
		createJTableData();
		table.setModel(model);		
		
		
		JScrollPane pane = new JScrollPane(table);
		pane.setPreferredSize(new Dimension(500,250));
		ui.select_panel.add(pane);
		
		ui.content_panel.add(ui.select_panel);
		ui.repaint();
		ui.setVisible(true);	
	}
	
	//JTable 데이터 생성
	public void createJTableData() {
//		int no = 1;
		model.setRowCount(0);
//		for(ScoreVo score : sms.select()) {
		for(ScoreVo score : dao.select()) {
			row[0] = score.getRno();
			row[1] = score.getName();
			row[2] = score.getKor();
			row[3] = score.getEng();
			row[4] = score.getMath();
			row[5] = score.getTot();
			row[6] = score.getAvg();
			
			model.addRow(row);
//			no++;
		}
		
		model.fireTableDataChanged();		
	}
	
}











