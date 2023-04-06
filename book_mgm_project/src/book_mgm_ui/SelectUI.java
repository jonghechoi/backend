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
	//���� ���� �ý��� ����
//	BookMgmSystem bms;
	BookDao dao;
	BookMgmUI ui;	
	String[] colNames = {"��ȣ","ISBN","������","���ڸ�","����", "��¥"};
	DefaultTableModel model = new DefaultTableModel(colNames, 0);
	JTable table = new JTable(model);
	Object[] row = new Object[colNames.length]; 
	
	//Constructor
	public SelectUI() {}
	public SelectUI(BookMgmUI ui) {
		this.ui = ui;
		//�������� �ý��� ���������� ���ú��� set
//		this.bms = ui.bms;
		this.dao = ui.dao;
		init();
	}
	
	//Method
	public void init() {		
		ui.switch_panel(BookMgmUI.SELECT);
		
		//table�� ������ �ֱ�
		createJTableData(); // Dao ��ü�� ���� DB�� �����Ͽ� �����͸� ������ �� model ���� �۾�
		table.setModel(model);		
		
		
		JScrollPane pane = new JScrollPane(table);
		pane.setPreferredSize(new Dimension(500,250));
		ui.select_panel.add(pane);
		
		ui.content_panel.add(ui.select_panel);
		ui.repaint();
		ui.setVisible(true);	
	}
	
	//JTable ������ ����
	public void createJTableData() {
//		int no = 1;
		model.setRowCount(0);
		/*
		 * �������� �ý��ۿ��� select�� ����� row�� �ε����� ���� �ֱ�
		 */
		// 1. bms���� ������ ��������
		// ����ϴ� 1�� ���� --> BookVo
		// ����ϴ� ������ ���� --> ArrayList<BookVo>
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











