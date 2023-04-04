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
		JLabel label = new JLabel("수정할 학번");
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
	 * 내용 : 수정 폼 화면 구성
	 */
	public JPanel update_form() {
		tf_list = new ArrayList<JTextField>();
		JPanel up_panel = new JPanel(new BorderLayout());
		JPanel label_panel = new JPanel(new GridLayout(4,1));
		JPanel tf_panel = new JPanel(new GridLayout(4,1));
		JPanel btn_panel = new JPanel();
		
		String[] namelist = {"이름","국어","영어","수학"};
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
		
		btn_update = new JButton("수정완료");
		btn_reset = new JButton("다시쓰기");
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
	 * 내용 : 수정할 학생명을 검색하는 기능
	 */
	public void search_proc() {
		if(validationCheck()) {
			ScoreVo score = dao.search(name_tf.getText().trim().toLowerCase(), "update");
			// 기존 dao.search()에서는 ScoreVo 객체를 new로 생성해서 값만 안 들어갔지 null은 아니게 됨
			// 따라서 null로 초기화하고, score에 값이 들어갈 때 객체 할당해야 함
			// 중요해!!!!!!!!!!
			if(score != null) {  
				tf_list.get(0).setText(score.getName());
				tf_list.get(0).setEditable(false);
				tf_list.get(1).setText(String.valueOf(score.getKor()));
				tf_list.get(2).setText(String.valueOf(score.getEng()));
				tf_list.get(3).setText(String.valueOf(score.getMath()));
				
			}else {
				JOptionPane.showMessageDialog(null, "수정할 데이터가 존재하지 않습니다");
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
			JOptionPane.showMessageDialog(null, "수정할 데이터가 존재하지 않습니다");
		}
	}
	
	public boolean validationCheck() {
		boolean result = false;
		
		if(name_tf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "학생명을 입력해주세요");
			name_tf.requestFocus();
		}else {
			result = true;
		}
		
		return result;
	}
	
	/**
	 * 내용 : 수정완료 기능
	 */
	public void update_proc() {
		ScoreVo update_score = new ScoreVo();
		update_score.setSid(name_tf.getText().trim().toLowerCase());
		update_score.setKor(Integer.parseInt(tf_list.get(1).getText()));
		update_score.setEng(Integer.parseInt(tf_list.get(2).getText()));
		update_score.setMath(Integer.parseInt(tf_list.get(3).getText()));

		boolean result = dao.update(update_score);
		if(result) {
			JOptionPane.showMessageDialog(null, "수정이 완료되었습니다");
			new SelectUI(ui);
//			name_tf.setText("");
//			for(JTextField tf : tf_list) tf.setText("");
		}
	}
	
	/**
	 * 액션 이벤트 처리
	 */  
	@Override   //Annotation(어노테이션)
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
















