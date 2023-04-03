package score_UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ScoremgmEvent extends WindowAdapter implements ActionListener{
	//Field
	ScoremgmUI ui;
	
	//Constructor
	public ScoremgmEvent() {}
	public ScoremgmEvent(ScoremgmUI ui) {
		this.ui = ui;
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
			new UpdateUI(ui);
		}else if(obj == ui.button_list.get(4)) {
			new DeleteUI(ui);
		}else if(obj == ui.button_list.get(5)) {
			int result = JOptionPane.showConfirmDialog(null, "������ �����Ͻðڽ��ϱ�?");
			if(result==0)  {
				// Dao ��ü ����
				ui.dao.close();
				System.exit(0);
			}
			
		}
		
	}
	
	public void	windowClosing(WindowEvent e) {
		//System.out.println("------- ���α׷� ���� ----------");
		// Dao ��ü ����
		ui.dao.close();
		System.exit(0);
	}
	
}//class








