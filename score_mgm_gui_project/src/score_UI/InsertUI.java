package score_UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import score_db.ScoreDao;
import score_mgm_oop_arrayList.ScoreVo;

public class InsertUI implements ActionListener{
	//Field
	ScoremgmUI ui;
//	ScoreMgmSystem sms;
	ScoreDao dao;
	JButton btn_insert, btn_cancel;
	ArrayList<JTextField> tf_list;
	
	//Constructor
	public InsertUI() {}
	public InsertUI(ScoremgmUI ui) {
		this.ui = ui;
//		this.sms = ui.sms;
		this.dao = ui.dao;
		init();		
	}
	
	//Method
	public void init() {
		ui.switch_panel(ScoremgmUI.INSERT);
		
		tf_list = new ArrayList<JTextField>();
		ui.insert_panel.setLayout(new BorderLayout());
		Panel title_panel = new Panel(new FlowLayout(FlowLayout.CENTER));
		Panel label_panel = new Panel(new GridLayout(4,1));
		Panel tf_panel = new Panel(new GridLayout(4,1));
		Panel btn_panel = new Panel();
		
		JLabel title = new JLabel("------ ���� ��� ȭ�� ------");
		title_panel.add(title);
		btn_insert = new JButton("��ϿϷ�");
		btn_cancel = new JButton("�ٽþ���");
		btn_panel.add(btn_insert);
		btn_panel.add(btn_cancel);
				
		String[] namelist = {"�̸�","����","����","����"};
		for(String name : namelist) {
			Panel name_panel = new Panel();
			Panel t_panel = new Panel();
			JLabel label = new JLabel(name);
			JTextField tf = new JTextField(15);
			name_panel.add(label);
			t_panel.add(tf);
			label_panel.add(name_panel);
			tf_panel.add(t_panel);	
			tf_list.add(tf);
		}
		
		ui.insert_panel.add(title_panel,BorderLayout.NORTH);
		ui.insert_panel.add(label_panel, BorderLayout.WEST);
		ui.insert_panel.add(tf_panel, BorderLayout.CENTER);
		ui.insert_panel.add(btn_panel, BorderLayout.SOUTH);		

		ui.content_panel.add(ui.insert_panel);	
		ui.repaint();
		ui.setVisible(true);	
		
		
		btn_insert.addActionListener(this);
		btn_cancel.addActionListener(this);
		tf_list.get(3).addActionListener(this);
	}//init
	
	/**
	 * ���� : �Է��� ���� �����͸� ����ҿ� ����ϴ� �۾�
	 */
	public void insert_proc() {
		if(validationCheck()) {
			ScoreVo score = new ScoreVo();
			score.setName(tf_list.get(0).getText());
			score.setKor(Integer.parseInt(tf_list.get(1).getText()));
			score.setEng(Integer.parseInt(tf_list.get(2).getText()));
			score.setMath(Integer.parseInt(tf_list.get(3).getText()));		
			
			boolean result = dao.insert(score);
			if(result) {
				JOptionPane.showMessageDialog(null,"��ϼ���~");
				for(JTextField tf:tf_list) tf.setText("");
			}else {
				JOptionPane.showMessageDialog(null,"��Ͻ���~");
			}
		}//if
	}
	
	/**
	 * ���� : ��ϿϷ� ó���� �����ϱ� �� ��üũ(��ȿ�� üũ)
	 */
	public boolean validationCheck() {
		boolean result = false;
		String[] msglist = {"�̸�","����","����","����"};
		
		for(int i=0;i<msglist.length;i++) {
			JTextField tf = tf_list.get(i);
			if(tf.getText().equals("") || tf.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null,msglist[i]+"��(��) �Է����ּ���");
				tf.requestFocus();
				i = msglist.length;
			}else if(i == (msglist.length-1)) {
				result = true;
			}
		}		
		
		return result;
	}
	
		
	/** 
	 * ���� : ���, ��� ��ư �̺�Ʈ ó�� 
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_insert || obj == tf_list.get(3)) {
			insert_proc();			
		}else if(obj == btn_cancel) {			
			tf_list.forEach(tf -> {tf.setText("");});	//���ٽ� ǥ��
		}
	}

}









