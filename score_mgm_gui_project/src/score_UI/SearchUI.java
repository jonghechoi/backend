package score_UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import score_mgm_oop_arrayList.ScoreMgmSystem;
import score_mgm_oop_arrayList.ScoreVo;

public class SearchUI implements ActionListener{
	//Field
	ScoreMgmSystem sms;
	ScoremgmUI ui;	
	JTextField name_tf;
	JButton btn_search, btn_update, btn_delete;
	JPanel jp;
	ScoreVo score;
	String[] colNames = {"�̸�","����","����","����","����","���"};
	DefaultTableModel model = new DefaultTableModel(colNames, 0);
	JTable table = new JTable(model);
	Object[] row = new Object[6];
	
	//Constructor
	public SearchUI() {}
	public SearchUI(ScoremgmUI ui) {
		this.ui = ui;
		this.sms = ui.sms;
		init();		
	}
	
	//Method
	public void init() {
		ui.switch_panel(ScoremgmUI.SEARCH);
		ui.search_panel.setLayout(new BorderLayout());
		
		JPanel search_panel = new JPanel(); //�л����, �л��̸��Է�, �˻� ��ư
		JLabel name_label = new JLabel("�л���");
		name_tf = new JTextField(20);
		btn_search = new JButton("search");
		search_panel.add(name_label);
		search_panel.add(name_tf);
		search_panel.add(btn_search);	
		
		//search_result = new JTextArea(10,50);
		
		jp = new JPanel();
		btn_update = new JButton("�����ϱ�");
		btn_delete = new JButton("�����ϱ�");
		jp.add(btn_update);			jp.add(btn_delete);		

		JScrollPane pane = new JScrollPane(table);
		pane.setPreferredSize(new Dimension(500,150));
		
		ui.search_panel.add(search_panel, BorderLayout.NORTH);
		ui.search_panel.add(pane, BorderLayout.CENTER);
		ui.search_panel.add(jp, BorderLayout.SOUTH);
		jp.setVisible(false);
		ui.content_panel.add(ui.search_panel);
		ui.repaint();
		ui.setVisible(true);	
		
		btn_search.addActionListener(this);
		name_tf.addActionListener(this);
		btn_update.addActionListener(this);
		btn_delete.addActionListener(this);
	}
	
	
	/**
	 * ���� : �Է��� �л����� �˻��Ͽ� ��� ����ϴ� ���
	 */
	public void search_proc() {
		if(validationCheck()) {
			score = sms.search(name_tf.getText());
			if(score != null) {
				jp.setVisible(true);
				
				DefaultTableModel model = new DefaultTableModel(colNames, 0);				
				row[0] = score.getName();
				row[1] = score.getKor();
				row[2] = score.getEng();
				row[3] = score.getMath();
				row[4] = score.getTot();
				row[5] = score.getAvg();
				
				model.addRow(row);
				model.fireTableDataChanged();
				
				table.setModel(model);
			}else {
				DefaultTableModel model = new DefaultTableModel(colNames, 0);				
				table.setModel(model);
				
				JOptionPane.showMessageDialog(null,"�˻��� �����Ͱ� �������� �ʽ��ϴ�");
			}
				
		}
	}
	
	/**
	 * ���� : �л��� �Է¿��� üũ
	 */
	public boolean validationCheck() {
		boolean result = false;
		
		if(name_tf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "�л����� �Է����ּ���");
			name_tf.requestFocus();
		}else {
			result = true;
		}
		
		return result;
	}
	
	
	/**
	 * ���� : �˻���ư�� �̺�Ʈ ó��
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btn_search || obj == name_tf) {
			search_proc();
		}else if(obj == btn_update) {
//			new UpdateUI(ui, score);
		}else if(obj == btn_delete) {
//			new DeleteUI(ui, score);
		}
	}
	
}











