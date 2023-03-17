package book_mgm_ui;

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

import book_mgm_ui_system.BookMgmSystem;
import book_mgm_ui_system.BookVo;


public class SearchUI implements ActionListener{
	//Field
	//도서 관리 시스템 정의
	//도서정보를 저장하는 데이터 객체 정의
	BookMgmSystem bms;
	BookMgmUI ui;	
	JTextField isbn_tf;
	JButton btn_search, btn_update, btn_delete;
	JPanel jp;
	String[] colNames = {"번호","ISBN","도서명","저자명","가격"};
	DefaultTableModel model = new DefaultTableModel(colNames, 0);
	JTable table = new JTable(model);
	Object[] row = new Object[6];
	BookVo book; // 검색결과, 수정하기, 삭제하기 버튼 사용
	
	//Constructor
	public SearchUI() {}
	public SearchUI(BookMgmUI ui) {
		this.ui = ui;
		this.bms = ui.bms;
		//도서관리 시스템 전역변수에 로컬변수 set
		init();		
	}
	
	//Method
	public void init() {
		ui.switch_panel(BookMgmUI.SEARCH);
		ui.search_panel.setLayout(new BorderLayout());
		
		JPanel search_panel = new JPanel(); //학생명라벨, 학생이름입력, 검색 버튼
		JLabel name_label = new JLabel("ISBN");
		isbn_tf = new JTextField(20);
		btn_search = new JButton("search");
		search_panel.add(name_label);
		search_panel.add(isbn_tf);
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
		isbn_tf.addActionListener(this);
		btn_update.addActionListener(this);
		btn_delete.addActionListener(this);
	}
	
	
	/**
	 * 내용 : 입력한 학생명을 검색하여 결과 출력하는 기능
	 */
	public void search_proc() {
		if(validationCheck()) {
			/* ISBN으로 검색하여 도서가 존재하면 도서데이터객체를 반환 */
			book = bms.search(isbn_tf.getText());
			
			int no = 1;
			if(book != null) {
				jp.setVisible(true);
				
				DefaultTableModel model = new DefaultTableModel(colNames, 0);				
				row[0] = no;
				row[1] = book.getIsbn();
				row[2] = book.getTitle();
				row[3] = book.getAuthor();
				row[4] = book.getPrice();
				
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
		
		if(isbn_tf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "ISBN을 입력해주세요");
			isbn_tf.requestFocus();
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
		
		if(obj == btn_search || obj == isbn_tf) {
			search_proc();
		}else if(obj == btn_update) {
//			BookMgmEvent.updateui.init();
			new UpdateUI(ui, book);
		}else if(obj == btn_delete) {
			new DeleteUI(ui, book);
		}
	}
	
}











