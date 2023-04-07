package book_mgm_ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import book_db.BookDao;
import book_db.BookVo;

public class DeleteUI implements ActionListener{
	//Field
	//도서 관리 시스템 정의
//	BookMgmSystem bms;
	BookDao dao;
	BookMgmUI ui;
	JTextField isbn_tf;
	JButton btn_search, btn_delete, btn_reset, btn_prev;
	ArrayList<JTextField> tf_list;
	String item, data;
	
	//Constructor
	public DeleteUI() {}
	public DeleteUI(BookMgmUI ui) {
		this.ui = ui;
		this.dao = ui.dao;
//		this.bms = ui.bms;
		//도서관리 시스템 전역변수에 로컬변수 set
		init();
	}
	public DeleteUI(HashMap param) {
		this.ui = (BookMgmUI)param.get("ui");
		this.dao = ui.dao;
		this.item = (String)param.get("item");
		this.data = (String)param.get("data");
		init(dao.search((String)param.get("isbn")));		
	}
	
	public DeleteUI(BookMgmUI ui, String isbn) {
		this.ui = ui;
		this.dao = ui.dao;
//		this.bms = ui.bms;
		//도서관리 시스템 전역변수에 로컬변수 set
		BookVo book = dao.search(isbn);
		init(book);
	}
	

	public void init() {
		tf_list = new ArrayList<JTextField>();
		ui.switch_panel(BookMgmUI.DELETE);
		ui.delete_panel.setLayout(new BorderLayout());
		
		JPanel top_panel = new JPanel();
		JLabel label = new JLabel("삭제할 도서의 IBSN");
		isbn_tf = new JTextField(20);
		btn_search = new JButton("search");
		top_panel.add(label);
		top_panel.add(isbn_tf);
		top_panel.add(btn_search);
				
		ui.delete_panel.add(top_panel, BorderLayout.NORTH);
		ui.delete_panel.add(delete_form(), BorderLayout.CENTER);		
		ui.content_panel.add(ui.delete_panel);
		ui.repaint();
		ui.setVisible(true);
		
		btn_search.addActionListener(this);
		isbn_tf.addActionListener(this);
	}//init
	
	public void init(BookVo book) {
		tf_list = new ArrayList<JTextField>();
		ui.switch_panel(BookMgmUI.DELETE);
		ui.delete_panel.setLayout(new BorderLayout());
		
		JPanel top_panel = new JPanel();
		JLabel label = new JLabel("삭제할 도서의 IBSN");
		isbn_tf = new JTextField(20);
		btn_search = new JButton("search");
		top_panel.add(label);
		top_panel.add(isbn_tf);
		top_panel.add(btn_search);
		
		ui.delete_panel.add(top_panel, BorderLayout.NORTH);
		ui.delete_panel.add(delete_form(), BorderLayout.CENTER);		
		ui.content_panel.add(ui.delete_panel);
		ui.repaint();
		ui.setVisible(true);
		
		isbn_tf.setText(book.getIsbn());
		tf_list.get(0).setText(book.getIsbn());
		tf_list.get(0).setEditable(false);
		tf_list.get(1).setText(book.getTitle());
		tf_list.get(2).setText(book.getAuthor());
		tf_list.get(3).setText(String.valueOf(book.getPrice()));
		
		btn_search.addActionListener(this);
		isbn_tf.addActionListener(this);
		if(item==null) btn_prev.setVisible(false);
	}//init
	
	/**
	 * 내용 : 수정 폼 화면 구성
	 */
	public JPanel delete_form() {
		JPanel up_panel = new JPanel(new BorderLayout());
		JPanel label_panel = new JPanel(new GridLayout(4,1));
		JPanel tf_panel = new JPanel(new GridLayout(4,1));
		JPanel btn_panel = new JPanel();
		
		String[] namelist = {"ISBN","도서명","저자명","가격"};
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
		btn_prev = new JButton("이전페이지");
		btn_panel.add(btn_delete);
		btn_panel.add(btn_reset);
		btn_panel.add(btn_prev);
		
		up_panel.add(label_panel, BorderLayout.WEST);
		up_panel.add(tf_panel, BorderLayout.CENTER);
		up_panel.add(btn_panel, BorderLayout.SOUTH);
		
		btn_delete.addActionListener(this);
		btn_reset.addActionListener(this);
		btn_prev.addActionListener(this);
		
		return up_panel;		
	}
	
	/**
	 * 내용 : 삭제할 학생명을 검색하는 기능
	 */
	public void search_proc() {
		if(validationCheck()) {
			/* ISBN으로 검색하여 도서가 존재하면 도서데이터객체를 반환 받아 삭제폼에 set */
			BookVo book = dao.search(isbn_tf.getText().trim().toUpperCase());
			if(book != null) {
				tf_list.get(0).setText(book.getIsbn());
				tf_list.get(1).setText(book.getTitle());
				tf_list.get(2).setText(book.getAuthor());
				tf_list.get(3).setText(String.valueOf(book.getPrice()));
			}else {
				JOptionPane.showMessageDialog(null, "삭제할 데이터가 존재하지 않습니다");
			}
		}
	}
	
	public boolean validationCheck() {
		boolean result = false;
		
		if(isbn_tf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "isbn을 입력해주세요");
			isbn_tf.requestFocus();
		}else {
			result = true;
		}
		
		return result;
	}
	
	/**
	 * 내용 : 삭제완료 기능
	 */
	public void delete_proc() {
		/* 삭제할 도서가 존재하면 '확인' 버튼을 클릭하여 도서관리 시스템에서 delete 진행*/
		int choice = JOptionPane.showConfirmDialog(null, "정말로 삭제하시겠습니까?");
		if(choice == 0) {
			BookVo book = dao.search(isbn_tf.getText());
			boolean result = dao.delete(book);
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
		if(obj==btn_search || obj ==isbn_tf) {
			search_proc();
		}else if(obj == btn_delete) {
			delete_proc();
		}else if(obj == btn_reset) {
			isbn_tf.setText("");			
			tf_list.forEach(tf -> {tf.setText("");});
			isbn_tf.requestFocus();
		}else if(obj == btn_prev) {
			HashMap param = new HashMap();
			param.put("ui", ui);
			param.put("item", item);
			param.put("data", data);
			new SearchUI(param);
		}
	}
	
	
	
}






