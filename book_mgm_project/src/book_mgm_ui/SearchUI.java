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
	//���� ���� �ý��� ����
	//���������� �����ϴ� ������ ��ü ����
	BookMgmSystem bms;
	BookMgmUI ui;	
	JTextField isbn_tf;
	JButton btn_search, btn_update, btn_delete;
	JPanel jp;
	String[] colNames = {"��ȣ","ISBN","������","���ڸ�","����"};
	DefaultTableModel model = new DefaultTableModel(colNames, 0);
	JTable table = new JTable(model);
	Object[] row = new Object[6];
	BookVo book; // �˻����, �����ϱ�, �����ϱ� ��ư ���
	
	//Constructor
	public SearchUI() {}
	public SearchUI(BookMgmUI ui) {
		this.ui = ui;
		this.bms = ui.bms;
		//�������� �ý��� ���������� ���ú��� set
		init();		
	}
	
	//Method
	public void init() {
		ui.switch_panel(BookMgmUI.SEARCH);
		ui.search_panel.setLayout(new BorderLayout());
		
		JPanel search_panel = new JPanel(); //�л����, �л��̸��Է�, �˻� ��ư
		JLabel name_label = new JLabel("ISBN");
		isbn_tf = new JTextField(20);
		btn_search = new JButton("search");
		search_panel.add(name_label);
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
	}
	
	
	/**
	 * ���� : �Է��� �л����� �˻��Ͽ� ��� ����ϴ� ���
	 */
	public void search_proc() {
		if(validationCheck()) {
			/* ISBN���� �˻��Ͽ� ������ �����ϸ� ���������Ͱ�ü�� ��ȯ */
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
//			BookMgmEvent.updateui.init();
			new UpdateUI(ui, book);
		}else if(obj == btn_delete) {
			new DeleteUI(ui, book);
		}
	}
	
}











