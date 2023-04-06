package book_mgm_ui;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import book_db.BookDao;
//import book_mgm_ui_system.BookVo;
import book_db.BookVo;

public class SelectUI {
	//Field
	//도서 관리 시스템 정의
//	BookMgmSystem bms;
	BookDao dao;
	BookMgmUI ui;	
	String[] colNames = {"번호","ISBN","도서명","저자명","가격", "날짜"};
	DefaultTableModel model = new DefaultTableModel(colNames, 0);
	JTable table = new JTable(model);
	Object[] row = new Object[colNames.length]; 
	
	//Constructor
	public SelectUI() {}
	public SelectUI(BookMgmUI ui) {
		this.ui = ui;
		//도서관리 시스템 전역변수에 로컬변수 set
//		this.bms = ui.bms;
		this.dao = ui.dao;
		init();
	}
	
	//Method
	public void init() {		
		ui.switch_panel(BookMgmUI.SELECT);
		
		//table에 데이터 넣기
		createJTableData(); // Dao 객체를 통해 DB를 연동하여 데이터를 가져온 후 model 구성 작업
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
		/*
		 * 도서관리 시스템에서 select한 결과를 row의 인덱스에 맞춰 넣기
		 */
		// 1. bms에서 데이터 가져오기
		// 출력하는 1개 고정 --> BookVo
		// 출력하는 여러개 고정 --> ArrayList<BookVo>
//		List<BookVo> blist = bms.select();
		
		for(BookVo score : dao.select()) {
			row[0] = score.getRno();
			row[1] = score.getIsbn();
			row[2] = score.getTitle();
			row[3] = score.getAuthor();
			row[4] = score.getSprice();
			row[5] = score.getBdate();
			
			model.addRow(row);
//			no++;
		}
		
		model.fireTableDataChanged();		
	}
	
}











