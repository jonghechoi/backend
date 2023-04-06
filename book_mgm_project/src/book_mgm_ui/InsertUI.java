package book_mgm_ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import book_db.BookDao;
import book_db.BookVo;


public class InsertUI implements ActionListener{
	//Field
	BookMgmUI ui;
	Random rad;
	//도서 관리 시스템 정의
//	BookMgmSystem bms;
	BookDao dao;
	JButton btn_insert, btn_cancel, isbn_check;
	ArrayList<JTextField> tf_list;
	
	//Constructor
	public InsertUI() {}
	public InsertUI(BookMgmUI ui) {
		this.ui = ui;
//		this.bms = ui.bms;
		this.dao = ui.dao;
		//도서관리 시스템 전역변수에 로컬변수 set
		init();		
	}
	
	//Method
	public void init() {
		ui.switch_panel(BookMgmUI.INSERT);
		
		tf_list = new ArrayList<JTextField>();
		ui.insert_panel.setLayout(new BorderLayout());
		Panel title_panel = new Panel(new FlowLayout(FlowLayout.CENTER));
		Panel label_panel = new Panel(new GridLayout(4,1));
		Panel tf_panel = new Panel(new GridLayout(4,1));
		Panel btn_panel = new Panel();
		
		JLabel title = new JLabel("------ 도서 등록 화면 ------");
		title_panel.add(title);
		btn_insert = new JButton("등록완료");
		btn_cancel = new JButton("다시쓰기");
		isbn_check = new JButton("중복체크");
		btn_panel.add(btn_insert);
		btn_panel.add(btn_cancel);
				
		String[] namelist = {"ISBN","도서명","저자명","가격"};
		for(String name : namelist) {
			Panel name_panel = new Panel();
			Panel t_panel = new Panel();
			JLabel label = new JLabel(name);
			JTextField tf = new JTextField(15);
			name_panel.add(label);
			t_panel.add(tf);
			if(name.trim().equals("ISBN")) {
				t_panel.add(isbn_check);
			}else {
				JLabel jl = new JLabel("000000000000");
				jl.setForeground(new Color(238,238,238));
				t_panel.add(jl);
			}
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
		
		tf_list.get(0).setText(createIsbn());
		tf_list.get(0).setEditable(false);

		
		btn_insert.addActionListener(this);
		btn_cancel.addActionListener(this);
		tf_list.get(3).addActionListener(this);
		isbn_check.addActionListener(this);
	}//init
	
	public String createIsbn() {
		rad = new Random();		
		int[] intList = new int[10000-999];
		
		for(int i=1000; i<10000; i++) {
			intList[i-1000] = i;
		}
		int isbn = intList[rad.nextInt(intList.length)];
		
		return "ISBN_" + String.valueOf(isbn);
	}
	
	/**
	 * 내용 : 입력한 도서 데이터를 저장소에 등록하는 작업
	 */
	public void insert_proc() {
		if(validationCheck()) {
			/* 
			 * isbn, 도서명, 저자명, 가격 -> BookMgmSystem으로 보내야 함 (2가지 방법 존재)
			 * 1. 파라미터(낱개)로 전달 
			 * 2. 객체로 전달  
			 * 메시지를 호출하는 사람의 편의대로 해주기 위해 2가지 메소드를 오버로딩 할 수 있음  
			 */
			
			BookVo book = new BookVo();
			book.setIsbn(tf_list.get(0).getText());
			book.setTitle(tf_list.get(1).getText());
			book.setAuthor(tf_list.get(2).getText());
			book.setPrice(Integer.parseInt(tf_list.get(3).getText()));
			
//			boolean result = bms.insert(book);
			boolean result = dao.insert(book);
			
			if(result) {
				JOptionPane.showMessageDialog(null,"등록성공~");
				tf_list.forEach(tf -> { tf.setText(""); });
			}else {
				JOptionPane.showMessageDialog(null,"등록실패~");
			}
		}//if
	}
	
	/**
	 * 내용 : 등록완료 처리를 진행하기 전 폼체크(유효성 체크)
	 */
	public boolean validationCheck() {
		boolean result = false;
		String[] msglist = {"ISBN","도서명","저자명","가격"};
		
		for(int i=0;i<msglist.length;i++) {
			JTextField tf = tf_list.get(i);
			if(tf.getText().equals("") || tf.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null,msglist[i]+"을(를) 입력해주세요");
				tf.requestFocus();
				i = msglist.length;
			}else if(i == (msglist.length-1)) {
				result = true;
			}
		}		
		
		return result;
	}
	
	/** 
	 * 내용 : 등록, 취소 버튼 이벤트 처리 
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_insert || obj == tf_list.get(3)) {
			insert_proc();			
			new InsertUI(ui);
		}else if(obj == btn_cancel) {			
			tf_list.forEach(tf -> {tf.setText("");});	//람다식 표현
		}else if(obj == isbn_check) {
			/**
			 * 중복체크 버튼 눌렀을때 validation check 실행 메소드
			 * 1. 기존에 있는 isbn과 비교해서 (db에 group함수인 count 이용해서 int값 출력해보자)
			 * 	-> 없다면 joptionpanel 메시지창 뜨면서 그대로 진행할건지 물어보기 
			 * 	-> 있으면(count가 1이면) 메시지창 뜨면서 다시할건지 물어보기
			 * 		-> 다시 한다면 createIsbn() 메소드 실행해서 다시 값 넣기
			 */
			int result = dao.getCheckResult(tf_list.get(0).getText());
			if(result == 0) {
				JOptionPane.showConfirmDialog(null, "사용가능합니다. 계속진행할까요?", "확인메시지창", 0);
			}else {
				int check = JOptionPane.showConfirmDialog(null, "이미 사용중인 ISBN입니다. 다시 생성하시겠습니까?", "확인메시지창", 0);
				if(check==0) init();
			}		
		}
	}

}









