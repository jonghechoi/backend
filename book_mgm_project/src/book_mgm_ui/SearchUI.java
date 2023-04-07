package book_mgm_ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import book_db.BookDao;
import book_db.BookVo;


public class SearchUI implements ActionListener{
	//Field
	//도서 관리 시스템 정의
	//도서정보를 저장하는 데이터 객체 정의
//	BookMgmSystem bms;
	BookDao dao;
	BookMgmUI ui;	
	JTextField isbn_tf;
	JButton btn_search, btn_update, btn_delete;
	JPanel jp;
	String[] colNames = {"번호","ISBN","도서명","저자명","가격"};
	DefaultTableModel model = new DefaultTableModel(colNames, 0);
	JTable table = new JTable(model);
	Object[] row = new Object[6];
	BookVo book; // 검색결과, 수정하기, 삭제하기 버튼 사용
	ArrayList<BookVo> bookList;
	int selectRow;
	String[] itemList = {"ISBN","TITLE","AUTHOR"};
	JComboBox comboList;
	
	//Constructor
	public SearchUI() {}
	public SearchUI(BookMgmUI ui) {
		this.ui = ui;
//		this.bms = ui.bms;
		this.dao = ui.dao;
		//도서관리 시스템 전역변수에 로컬변수 set
		init();		
	}
	public SearchUI(HashMap param) {
		this.ui = (BookMgmUI)param.get("ui");
		this.dao = this.ui.dao;
		
		init((String)param.get("item"), (String)param.get("data"));
	}
	
	//Method
	public void init() {
		ui.switch_panel(BookMgmUI.SEARCH);
		ui.search_panel.setLayout(new BorderLayout());
		
		JPanel search_panel = new JPanel(); //학생명라벨, 학생이름입력, 검색 버튼
//		JLabel name_label = new JLabel("ISBN");
		comboList = new JComboBox(itemList);
		isbn_tf = new JTextField(20);
		btn_search = new JButton("search");
		search_panel.add(comboList);
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
		
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectRow = table.getSelectedRow();	
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseReleased(MouseEvent e) {}
		});
	}
	
	public void init(String item, String data) {
		ui.switch_panel(BookMgmUI.SEARCH);
		ui.search_panel.setLayout(new BorderLayout());
		
		JPanel search_panel = new JPanel(); //학생명라벨, 학생이름입력, 검색 버튼
//		JLabel name_label = new JLabel("ISBN");
		comboList = new JComboBox(itemList);
		isbn_tf = new JTextField(20);
		btn_search = new JButton("search");
		search_panel.add(comboList);
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
		search_proc(item, data);
		
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectRow = table.getSelectedRow();	
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseReleased(MouseEvent e) {}
		});
	}
	
	/**
	 * (Search -> Update -> 되돌리기)에서 돌아온 후 해당값 다시 넣어주기 
	 */
	public void search_proc(String item, String data) {
		
		// UpdateUI로부터 받은 item, data를 SearchUI의 ComboBox와 isbn_tf에 다시 씌워주기
		for(int i=0; i<itemList.length; i++) {
			if( itemList[i] == item ) {
				comboList.setSelectedIndex(i);
				isbn_tf.setText(data);
			}
		}
		
      	bookList = dao.search(item, data);
		int no = 1;
		if(bookList.size() != 0) {
			jp.setVisible(true);
			
			DefaultTableModel model = new DefaultTableModel(colNames, 0);
			for(BookVo book : bookList) {
				row[0] = book.getRno();
				row[1] = book.getIsbn();
				row[2] = book.getTitle();
				row[3] = book.getAuthor();
				row[4] = book.getSprice();
				model.addRow(row);	
			}
			model.fireTableDataChanged();
			table.setModel(model);
		}else {
			DefaultTableModel model = new DefaultTableModel(colNames, 0);				
			table.setModel(model);
			JOptionPane.showMessageDialog(null,"검색한 데이터가 존재하지 않습니다");
		}
	}
	
	
	/**
	 * 내용 : 입력한 학생명을 검색하여 결과 출력하는 기능
	 */
	public void search_proc() {
		if(validationCheck()) {
			/* ISBN으로 검색하여 도서가 존재하면 도서데이터객체를 반환 */
			// 와일드카드 문자를 활용하여 도서 검색 - 검색 결과에 따라 여러권 출력 가능하도록!!
			String item = (String)comboList.getSelectedItem(); // 명시적형변환
			bookList = dao.search(item, isbn_tf.getText().toUpperCase());
			int no = 1;
			if(bookList.size() != 0) {
				jp.setVisible(true);
				
				DefaultTableModel model = new DefaultTableModel(colNames, 0);
				for(BookVo book : bookList) {
					row[0] = book.getRno();
					row[1] = book.getIsbn();
					row[2] = book.getTitle();
					row[3] = book.getAuthor();
					row[4] = book.getSprice();
					model.addRow(row);	
				}
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
			HashMap param = new HashMap();
			param.put("ui", ui);
			System.out.println("1 --> " + bookList.get(selectRow).getIsbn());
			param.put("isbn", bookList.get(selectRow).getIsbn());
			param.put("item", (String)comboList.getSelectedItem());
			param.put("data", isbn_tf.getText().toUpperCase());
			
			System.out.println("item --> "+param.get("item")+"data -->"+param.get("data"));
//			new UpdateUI(ui, bookList.get(selectRow).getIsbn());
			new UpdateUI(param);
		}else if(obj == btn_delete) {
			new DeleteUI(ui, bookList.get(selectRow).getIsbn());
		}
	}
	
}