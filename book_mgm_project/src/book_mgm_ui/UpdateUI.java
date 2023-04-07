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


public class UpdateUI implements ActionListener{
	//Field
	//도서 관리 시스템 정의
//	BookMgmSystem bms;
	BookDao dao;
	BookMgmUI ui;
	JTextField isbn_tf;
	JButton btn_search, btn_update, btn_reset, btn_prev;
	ArrayList<JTextField> tf_list;
	String item, data; // 이전 페이지 버튼 호출시 사용할 매개변수
	
	//Constructor
	public UpdateUI() {}
	
	public UpdateUI(BookMgmUI ui) {
		this.ui = ui;
		//도서관리 시스템 전역변수에 로컬변수 set
//		this.bms = ui.bms;
		this.dao = ui.dao;
		init();
	}
	
	public UpdateUI(BookMgmUI ui, String isbn) {
		this.ui = ui;
//		this.bms = ui.bms;
		this.dao = ui.dao;
		BookVo book = dao.search(isbn);
		init(book);
	}
	
	public UpdateUI(HashMap param) {
		// hashmap에 넣을때 모두 object 타입으로 넣었음
		// 꺼낼 때는 다시 자식 클래스로 명시적 형변환이 필요
		BookMgmUI ui = (BookMgmUI)param.get("ui"); 
		this.ui = ui;
		this.dao = ui.dao;
		this.item = (String)param.get("item");
		System.out.println("2 --> "+this.item);
		this.data = (String)param.get("data");
		System.out.println("3 --> "+this.data);
		init(dao.search((String)param.get("isbn")));
	}
	
	public void init() {
		ui.switch_panel(BookMgmUI.UPDATE);
		ui.update_panel.setLayout(new BorderLayout());
		
		JPanel top_panel = new JPanel();
		JLabel label = new JLabel("수정할 ISBN");
		isbn_tf = new JTextField(20);
		btn_search = new JButton("search");
		top_panel.add(label);
		top_panel.add(isbn_tf);
		top_panel.add(btn_search);
				
		ui.update_panel.add(top_panel, BorderLayout.NORTH);
		ui.update_panel.add(update_form(), BorderLayout.CENTER);		
		ui.content_panel.add(ui.update_panel);
		ui.repaint();
		ui.setVisible(true);
		
		btn_search.addActionListener(this);
		isbn_tf.addActionListener(this);
	}
	
	public void init(BookVo book) {
		ui.switch_panel(BookMgmUI.UPDATE);
		ui.update_panel.setLayout(new BorderLayout());
		
		JPanel top_panel = new JPanel();
		JLabel label = new JLabel("수정할 ISBN");
		isbn_tf = new JTextField(20);
		btn_search = new JButton("search");
		top_panel.add(label);
		top_panel.add(isbn_tf);
		top_panel.add(btn_search);
		
		ui.update_panel.add(top_panel, BorderLayout.NORTH);
		ui.update_panel.add(update_form(), BorderLayout.CENTER);		
		ui.content_panel.add(ui.update_panel);
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
			tf_list.add(tf);
		}
		
		btn_update = new JButton("수정완료");
		btn_reset = new JButton("다시쓰기");
		btn_prev = new JButton("이전으로");
		btn_panel.add(btn_update);
		btn_panel.add(btn_reset);
		btn_panel.add(btn_prev);
		
		up_panel.add(label_panel, BorderLayout.WEST);
		up_panel.add(tf_panel, BorderLayout.CENTER);
		up_panel.add(btn_panel, BorderLayout.SOUTH);
		
		btn_update.addActionListener(this);
		btn_reset.addActionListener(this);
		btn_prev.addActionListener(this);
		
		return up_panel;		
	}
	
	/**
	 * 내용 : 수정할 학생명을 검색하는 기능
	 */
	public void search_proc() {
		if(validationCheck()) {
			/* ISBN으로 검색하여 도서가 존재하면 도서데이터객체를 반환 받아 수정폼에 set */
			BookVo book = dao.search(isbn_tf.getText().trim().toUpperCase());
			if(book != null) {
				tf_list.get(0).setText(book.getIsbn());
				tf_list.get(0).setEditable(false);
				tf_list.get(1).setText(book.getTitle());
				tf_list.get(2).setText(book.getAuthor());
				tf_list.get(3).setText(String.valueOf(book.getPrice()));
				
			}else {
				JOptionPane.showMessageDialog(null, "수정할 데이터가 존재하지 않습니다");
			}
		}
	}
	
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
	 * 내용 : 수정완료 기능
	 */
	public void update_proc() {
		/* 수정할 도서가 존재하면 수정 도서 정보를 입력 한후 도서관리 시스템에서 update 진행*/
		BookVo book = new BookVo();
		book.setIsbn(tf_list.get(0).getText());
		book.setTitle(tf_list.get(1).getText());
		book.setAuthor(tf_list.get(2).getText());
		book.setPrice(Integer.parseInt(tf_list.get(3).getText()));

		int result = dao.update(book);
		if(result == 1) {
			JOptionPane.showMessageDialog(null, "수정이 완료되었습니다");
			new SelectUI(ui);
		}else {
			JOptionPane.showMessageDialog(null, "수정이 실패했습니다");
		}
	}
	
	/**
	 * 액션 이벤트 처리
	 */  
	@Override   //Annotation(어노테이션)
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_search || obj == isbn_tf) {
			search_proc();
		}else if(obj == btn_update) {
			update_proc();
		}else if(obj == btn_reset) {
			isbn_tf.setText("");
			for(JTextField tf : tf_list) tf.setText("");			
			isbn_tf.requestFocus();
		}else if(obj == btn_prev) {
			// 매개변수가 많으면 객체로 묶어서 보내기
			HashMap param = new HashMap();
			param.put("ui", ui);
			param.put("item", item);
			param.put("data", data);
			System.out.println("UpdateUI의 item --> "+ item +" data --> "+data);
			new SearchUI(param);
		}
	}
	
}