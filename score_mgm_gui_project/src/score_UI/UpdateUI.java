package score_UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import score_db.ScoreDao;
import score_mgm_oop_arrayList.ScoreVo;

public class UpdateUI implements ActionListener{
	//Field
//	ScoreMgmSystem sms;
	ScoreDao dao;
	ScoremgmUI ui;
	JTextField name_tf;
	JButton btn_search, btn_update, btn_reset;
	ArrayList<JTextField> tf_list;
	
	//Constructor
	public UpdateUI() {}
	
	public UpdateUI(ScoremgmUI ui) {
		this.ui = ui;
		this.dao = ui.dao;
//		this.sms = ui.sms;
		init();
	}
	
	public UpdateUI(ScoremgmUI ui, String sid) {
		this.ui = ui;
		this.dao = ui.dao;
		init();
		search_proc(sid);
	}	
	
	
//	public UpdateUI(ScoremgmUI ui, ScoreVO score) {
//		this.ui = ui;
//		init();
//		name_tf.setText(score.getName());
//		tf_list.get(0).setText(score.getName());
//		tf_list.get(0).setEditable(false);
//		tf_list.get(1).setText(String.valueOf(score.getKor()));
//		tf_list.get(2).setText(String.valueOf(score.getEng()));
//		tf_list.get(3).setText(String.valueOf(score.getMath()));
//	}
	
	public void init() {
		ui.switch_panel(ScoremgmUI.UPDATE);
		ui.update_panel.setLayout(new BorderLayout());
		
		JPanel top_panel = new JPanel();
		JLabel label = new JLabel("������ �й�");
		name_tf = new JTextField(20);
		btn_search = new JButton("search");
		top_panel.add(label);
		top_panel.add(name_tf);
		top_panel.add(btn_search);
				
//		ui.update_panel.setBackground(Color.pink);
		ui.update_panel.add(top_panel, BorderLayout.NORTH);
		ui.update_panel.add(update_form(), BorderLayout.CENTER);		
		ui.content_panel.add(ui.update_panel);
		ui.repaint();
		ui.setVisible(true);
		
		btn_search.addActionListener(this);
		name_tf.addActionListener(this);
	}
	
	/**
	 * ���� : ���� �� ȭ�� ����
	 */
	public JPanel update_form() {
		tf_list = new ArrayList<JTextField>();
		JPanel up_panel = new JPanel(new BorderLayout());
		JPanel label_panel = new JPanel(new GridLayout(4,1));
		JPanel tf_panel = new JPanel(new GridLayout(4,1));
		JPanel btn_panel = new JPanel();
		
		String[] namelist = {"�̸�","����","����","����"};
		for(String name:namelist) {
			JPanel lpanel = new JPanel(); 
			JPanel tpanel = new JPanel();
			JLabel label = new JLabel(name);
			JTextField tf = new JTextField(15);
			lpanel.add(label);
			tpanel.add(tf);
			label_panel.add(lpanel);
			tf_panel.add(tpanel);
			tf_list.add(tf);
		}
		
		btn_update = new JButton("�����Ϸ�");
		btn_reset = new JButton("�ٽþ���");
		btn_panel.add(btn_update);
		btn_panel.add(btn_reset);
		
//		up_panel.setBackground(Color.BLUE);
		up_panel.add(label_panel, BorderLayout.WEST);
		up_panel.add(tf_panel, BorderLayout.CENTER);
		up_panel.add(btn_panel, BorderLayout.SOUTH);
		
		btn_update.addActionListener(this);
		btn_reset.addActionListener(this);
		
		return up_panel;		
	}
	
	/**
	 * ���� : ������ �л����� �˻��ϴ� ���
	 */
	public void search_proc() {
		if(validationCheck()) {
			ScoreVo score = dao.search(name_tf.getText().trim().toLowerCase(), "update");
			// ���� dao.search()������ ScoreVo ��ü�� new�� �����ؼ� ���� �� ���� null�� �ƴϰ� ��
			// ���� null�� �ʱ�ȭ�ϰ�, score�� ���� �� �� ��ü �Ҵ��ؾ� ��
			// �߿���!!!!!!!!!!
			if(score != null) {  
				tf_list.get(0).setText(score.getName());
				tf_list.get(0).setEditable(false);
				tf_list.get(1).setText(String.valueOf(score.getKor()));
				tf_list.get(2).setText(String.valueOf(score.getEng()));
				tf_list.get(3).setText(String.valueOf(score.getMath()));
				
			}else {
				JOptionPane.showMessageDialog(null, "������ �����Ͱ� �������� �ʽ��ϴ�");
			}
		}
	}
	
	public void search_proc(String sid) {
		ScoreVo score = dao.search(sid, "update");
		
		if(score != null) {  
			name_tf.setText(score.getSid());
			name_tf.setEditable(false);
			tf_list.get(0).setText(String.valueOf(score.getName()));
			tf_list.get(1).setText(String.valueOf(score.getKor()));
			tf_list.get(2).setText(String.valueOf(score.getEng()));
			tf_list.get(3).setText(String.valueOf(score.getMath()));
		}else {
			JOptionPane.showMessageDialog(null, "������ �����Ͱ� �������� �ʽ��ϴ�");
		}
	}
	
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
	 * ���� : �����Ϸ� ���
	 */
	public void update_proc() {
		ScoreVo update_score = new ScoreVo();
		update_score.setSid(name_tf.getText().trim().toLowerCase());
		update_score.setKor(Integer.parseInt(tf_list.get(1).getText()));
		update_score.setEng(Integer.parseInt(tf_list.get(2).getText()));
		update_score.setMath(Integer.parseInt(tf_list.get(3).getText()));

		boolean result = dao.update(update_score);
		if(result) {
			JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�");
			new SelectUI(ui);
//			name_tf.setText("");
//			for(JTextField tf : tf_list) tf.setText("");
		}
	}
	
	/**
	 * �׼� �̺�Ʈ ó��
	 */  
	@Override   //Annotation(������̼�)
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_search || obj == name_tf) {
			search_proc();
		}else if(obj == btn_update) {
			update_proc();
		}else if(obj == btn_reset) {
			name_tf.setText("");
			for(JTextField tf : tf_list) {
				tf.setText("");
			}
			name_tf.requestFocus();
		}
	}
	
}
















