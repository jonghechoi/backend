package book_mgm_ui;

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

import book_mgm_ui_system.BookMgmSystem;
import book_mgm_ui_system.BookVo;


public class UpdateUI implements ActionListener{
	//Field
	//���� ���� �ý��� ����
	BookMgmSystem bms;
	BookMgmUI ui;
	JTextField isbn_tf;
	JButton btn_search, btn_update, btn_reset;
	ArrayList<JTextField> tf_list;
	
	//Constructor
	public UpdateUI() {}
	public UpdateUI(BookMgmUI ui) {
		this.ui = ui;
		//�������� �ý��� ���������� ���ú��� set
		this.bms = ui.bms;
		init();
	}
	
	public UpdateUI(BookMgmUI ui, BookVo book) {
		this.ui = ui;
		this.bms = ui.bms;
		init(book);
	}
	
	public void init() {
		ui.switch_panel(BookMgmUI.UPDATE);
		ui.update_panel.setLayout(new BorderLayout());
		
		JPanel top_panel = new JPanel();
		JLabel label = new JLabel("������ ISBN");
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
		JLabel label = new JLabel("������ ISBN");
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
	 * ���� : ���� �� ȭ�� ����
	 */
	public JPanel update_form() {
		tf_list = new ArrayList<JTextField>();
		JPanel up_panel = new JPanel(new BorderLayout());
		JPanel label_panel = new JPanel(new GridLayout(4,1));
		JPanel tf_panel = new JPanel(new GridLayout(4,1));
		JPanel btn_panel = new JPanel();
		
		String[] namelist = {"ISBN","������","���ڸ�","����"};
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
		
		btn_update = new JButton("�����Ϸ�");
		btn_reset = new JButton("�ٽþ���");
		btn_panel.add(btn_update);
		btn_panel.add(btn_reset);
		
		up_panel.add(label_panel, BorderLayout.WEST);
		up_panel.add(tf_panel, BorderLayout.CENTER);
		up_panel.add(btn_panel, BorderLayout.SOUTH);
		
		btn_update.addActionListener(this);
		btn_reset.addActionListener(this);
		
		return up_panel;		
	}
	
	/**
	 * ���� : ������ �л����� �˻��ϴ� ���
	 */
	public void search_proc() {
		if(validationCheck()) {
			/* ISBN���� �˻��Ͽ� ������ �����ϸ� ���������Ͱ�ü�� ��ȯ �޾� �������� set */
			BookVo book = bms.search(isbn_tf.getText());
			if(book != null) {
				tf_list.get(0).setText(book.getIsbn());
				tf_list.get(0).setEditable(false);
				tf_list.get(1).setText(book.getTitle());
				tf_list.get(2).setText(book.getAuthor());
				tf_list.get(3).setText(String.valueOf(book.getPrice()));
				
			}else {
				JOptionPane.showMessageDialog(null, "������ �����Ͱ� �������� �ʽ��ϴ�");
			}
		}
	}
	
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
	 * ���� : �����Ϸ� ���
	 */
	public void update_proc() {
		/* ������ ������ �����ϸ� ���� ���� ������ �Է� ���� �������� �ý��ۿ��� update ����*/
		BookVo ubook = new BookVo();
		ubook.setIsbn(tf_list.get(0).getText());
		ubook.setTitle(tf_list.get(1).getText());
		ubook.setAuthor(tf_list.get(2).getText());
		ubook.setPrice(Integer.parseInt(tf_list.get(3).getText()));

		boolean result = bms.update(ubook);
		if(result) {
			JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�");
			new SelectUI(ui);
		}
	}
	
	/**
	 * �׼� �̺�Ʈ ó��
	 */  
	@Override   //Annotation(������̼�)
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_search || obj == isbn_tf) {
			search_proc();
		}else if(obj == btn_update) {
			update_proc();
		}else if(obj == btn_reset) {
			isbn_tf.setText("");
			for(JTextField tf : tf_list) {
				tf.setText("");
			}
			isbn_tf.requestFocus();
		}
	}
	
}
















