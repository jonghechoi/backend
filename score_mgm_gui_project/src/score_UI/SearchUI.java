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
	String[] colNames = {"이름","국어","영어","수학","총점","평균"};
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
		
		JPanel search_panel = new JPanel(); //학생명라벨, 학생이름입력, 검색 버튼
		JLabel name_label = new JLabel("학생명");
		name_tf = new JTextField(20);
		btn_search = new JButton("search");
		search_panel.add(name_label);
		search_panel.add(name_tf);
		search_panel.add(btn_search);	
		
		//search_result = new JTextArea(10,50);
		
		jp = new JPanel();
		btn_update = new JButton("수정하기");
		btn_delete = new JButton("삭제하기");
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
	 * 내용 : 입력한 학생명을 검색하여 결과 출력하는 기능
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
				
				JOptionPane.showMessageDialog(null,"검색한 데이터가 존재하지 않습니다");
			}
				
		}
	}
	
	/**
	 * 내용 : 학생명 입력여부 체크
	 */
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
	 * 내용 : 검색버튼의 이벤트 처리
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











