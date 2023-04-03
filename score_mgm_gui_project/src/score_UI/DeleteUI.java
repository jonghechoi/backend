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

import score_mgm_oop_arrayList.ScoreMgmSystem;
import score_mgm_oop_arrayList.ScoreVo;

public class DeleteUI implements ActionListener{
	//Field
	ScoreMgmSystem sms;
	ScoremgmUI ui;
	JTextField name_tf;
	JButton btn_search, btn_delete, btn_reset;
	ArrayList<JTextField> tf_list;
	
	//Constructor
	public DeleteUI() {}
	public DeleteUI(ScoremgmUI ui) {
		this.ui = ui;
		this.sms = ui.sms;
		init();
		
	}

	public void init() {
		tf_list = new ArrayList<JTextField>();
		ui.switch_panel(ScoremgmUI.DELETE);
		ui.delete_panel.setLayout(new BorderLayout());
		
		JPanel top_panel = new JPanel();
		JLabel label = new JLabel("삭제할 학생명");
		name_tf = new JTextField(20);
		btn_search = new JButton("search");
		top_panel.add(label);
		top_panel.add(name_tf);
		top_panel.add(btn_search);
				
		ui.delete_panel.add(top_panel, BorderLayout.NORTH);
		ui.delete_panel.add(delete_form(), BorderLayout.CENTER);		
		ui.content_panel.add(ui.delete_panel);
		ui.repaint();
		ui.setVisible(true);
		
		btn_search.addActionListener(this);
		name_tf.addActionListener(this);
	}//init
	
	/**
	 * 내용 : 수정 폼 화면 구성
	 */
	public JPanel delete_form() {
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
			tf.setEditable(false);
			tf_list.add(tf);
		}
		
		btn_delete = new JButton("삭제완료");
		btn_reset = new JButton("취소하기");
		btn_panel.add(btn_delete);
		btn_panel.add(btn_reset);
		
		up_panel.add(label_panel, BorderLayout.WEST);
		up_panel.add(tf_panel, BorderLayout.CENTER);
		up_panel.add(btn_panel, BorderLayout.SOUTH);
		
		btn_delete.addActionListener(this);
		btn_reset.addActionListener(this);
		
		return up_panel;		
	}
	
	/**
	 * 내용 : 삭제할 학생명을 검색하는 기능
	 */
	public void search_proc() {
		if(validationCheck()) {
			ScoreVo score = sms.search(name_tf.getText());
			if(score != null) {
				tf_list.get(0).setText(score.getName());
				tf_list.get(1).setText(String.valueOf(score.getKor()));
				tf_list.get(2).setText(String.valueOf(score.getEng()));
				tf_list.get(3).setText(String.valueOf(score.getMath()));
				
			}else {
				JOptionPane.showMessageDialog(null, "삭제할 데이터가 존재하지 않습니다");
			}
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
	 * 내용 : 삭제완료 기능
	 */
	public void delete_proc() {
		
		int choice = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?");
		if(choice == 0) {
			boolean result = sms.delete(name_tf.getText());
			if(result) {
				JOptionPane.showMessageDialog(null,"삭제가 완료되었습니다");
				new SelectUI(ui);
			}
		}
	}
	
	/**
	 * 액션 이벤트 처리
	 */  
	@Override   //Annotation(어노테이션)
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==btn_search || obj ==name_tf) {
			search_proc();
		}else if(obj == btn_delete) {
			delete_proc();
		}else if(obj == btn_reset) {
			name_tf.setText("");
			for(JTextField tf : tf_list) {
				tf.setText("");
			}
			name_tf.requestFocus();
		}
	}
	
	
	
}






