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
	//���� ���� �ý��� ����
	//���������� �����ϴ� ������ ��ü ����
//	BookMgmSystem bms;
	BookDao dao;
	BookMgmUI ui;	
	JTextField isbn_tf;
	JButton btn_search, btn_update, btn_delete;
	JPanel jp;
	String[] colNames = {"��ȣ","ISBN","������","���ڸ�","����"};
	DefaultTableModel model = new DefaultTableModel(colNames, 0);
	JTable table = new JTable(model);
	Object[] row = new Object[6];
	BookVo book; // �˻����, �����ϱ�, �����ϱ� ��ư ���
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
		//�������� �ý��� ���������� ���ú��� set
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
		
		JPanel search_panel = new JPanel(); //�л����, �л��̸��Է�, �˻� ��ư
//		JLabel name_label = new JLabel("ISBN");
		comboList = new JComboBox(itemList);
		isbn_tf = new JTextField(20);
		btn_search = new JButton("search");
		search_panel.add(comboList);
		search_panel.add(isbn_tf);
		search_panel.add(btn_search);	
		
		//search_result = new JTextArea(10,50);
		
		jp = new JPanel();
		btn_update = new JButton("�����ϱ�");
		btn_delete = new JButton("�����ϱ�");
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
		
		JPanel search_panel = new JPanel(); //�л����, �л��̸��Է�, �˻� ��ư
//		JLabel name_label = new JLabel("ISBN");
		comboList = new JComboBox(itemList);
		isbn_tf = new JTextField(20);
		btn_search = new JButton("search");
		search_panel.add(comboList);
		search_panel.add(isbn_tf);
		search_panel.add(btn_search);	
		
		//search_result = new JTextArea(10,50);
		
		jp = new JPanel();
		btn_update = new JButton("�����ϱ�");
		btn_delete = new JButton("�����ϱ�");
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
	 * (Search -> Update -> �ǵ�����)���� ���ƿ� �� �ش簪 �ٽ� �־��ֱ� 
	 */
	public void search_proc(String item, String data) {
		
		// UpdateUI�κ��� ���� item, data�� SearchUI�� ComboBox�� isbn_tf�� �ٽ� �����ֱ�
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
			JOptionPane.showMessageDialog(null,"�˻��� �����Ͱ� �������� �ʽ��ϴ�");
		}
	}
	
	
	/**
	 * ���� : �Է��� �л����� �˻��Ͽ� ��� ����ϴ� ���
	 */
	public void search_proc() {
		if(validationCheck()) {
			/* ISBN���� �˻��Ͽ� ������ �����ϸ� ���������Ͱ�ü�� ��ȯ */
			// ���ϵ�ī�� ���ڸ� Ȱ���Ͽ� ���� �˻� - �˻� ����� ���� ������ ��� �����ϵ���!!
			String item = (String)comboList.getSelectedItem(); // ���������ȯ
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
				JOptionPane.showMessageDialog(null,"�˻��� �����Ͱ� �������� �ʽ��ϴ�");
			}
		}
	}
	
	/**
	 * ���� : �л��� �Է¿��� üũ
	 */
	public boolean validationCheck() {
		boolean result = false;
		
		if(isbn_tf.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "ISBN�� �Է����ּ���");
			isbn_tf.requestFocus();
		}else {
			result = true;
		}
		return result;
	}
	
	
	/**
	 * ���� : �˻���ư�� �̺�Ʈ ó��
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