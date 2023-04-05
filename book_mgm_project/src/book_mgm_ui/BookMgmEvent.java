package book_mgm_ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import book_db.BookDao;

public class BookMgmEvent extends WindowAdapter implements ActionListener{
	//Field
	BookMgmUI ui;
//	BookMgmSystem bms;
	BookDao dao;
	
//	public static UpdateUI updateui;
//	DeleteUI deleteui;
	
	//Constructor
	public BookMgmEvent() {}
	public BookMgmEvent(BookMgmUI ui) {
		this.ui = ui;
		// �̱��� �������� ���Ŷ� ���ο� ��ü ���� ���ϰ� ui ��ü���� ������
//		this.bms = ui.bms;
		this.dao = ui.dao;
	}
	
	//Method
	public void	actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == ui.button_list.get(0)) {
			new InsertUI(ui);		
		}else if(obj == ui.button_list.get(1)) {
			new SelectUI(ui);
		}else if(obj == ui.button_list.get(2)) {
			new SearchUI(ui);
		}else if(obj == ui.button_list.get(3)) {
//			updateui = new UpdateUI(ui);
			new UpdateUI(ui);
		}else if(obj == ui.button_list.get(4)) {
			new DeleteUI(ui);
		}else if(obj == ui.button_list.get(5)) {
			int result = JOptionPane.showConfirmDialog(null, "������ �����Ͻðڽ��ϱ�?");
			if(result==0) {
				ui.dao.close();
				System.exit(0);
			}
		}
		
	}
	
	public void	windowClosing(WindowEvent e) {
		//System.out.println("------- ���α׷� ���� ----------");
		ui.dao.close();
		System.exit(0);
	}
	
}//class








