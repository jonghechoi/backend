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
	//���� ���� �ý��� ����
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
		//�������� �ý��� ���������� ���ú��� set
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
		
		JLabel title = new JLabel("------ ���� ��� ȭ�� ------");
		title_panel.add(title);
		btn_insert = new JButton("��ϿϷ�");
		btn_cancel = new JButton("�ٽþ���");
		isbn_check = new JButton("�ߺ�üũ");
		btn_panel.add(btn_insert);
		btn_panel.add(btn_cancel);
				
		String[] namelist = {"ISBN","������","���ڸ�","����"};
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
	 * ���� : �Է��� ���� �����͸� ����ҿ� ����ϴ� �۾�
	 */
	public void insert_proc() {
		if(validationCheck()) {
			/* 
			 * isbn, ������, ���ڸ�, ���� -> BookMgmSystem���� ������ �� (2���� ��� ����)
			 * 1. �Ķ����(����)�� ���� 
			 * 2. ��ü�� ����  
			 * �޽����� ȣ���ϴ� ����� ���Ǵ�� ���ֱ� ���� 2���� �޼ҵ带 �����ε� �� �� ����  
			 */
			
			BookVo book = new BookVo();
			book.setIsbn(tf_list.get(0).getText());
			book.setTitle(tf_list.get(1).getText());
			book.setAuthor(tf_list.get(2).getText());
			book.setPrice(Integer.parseInt(tf_list.get(3).getText()));
			
//			boolean result = bms.insert(book);
			boolean result = dao.insert(book);
			
			if(result) {
				JOptionPane.showMessageDialog(null,"��ϼ���~");
				tf_list.forEach(tf -> { tf.setText(""); });
			}else {
				JOptionPane.showMessageDialog(null,"��Ͻ���~");
			}
		}//if
	}
	
	/**
	 * ���� : ��ϿϷ� ó���� �����ϱ� �� ��üũ(��ȿ�� üũ)
	 */
	public boolean validationCheck() {
		boolean result = false;
		String[] msglist = {"ISBN","������","���ڸ�","����"};
		
		for(int i=0;i<msglist.length;i++) {
			JTextField tf = tf_list.get(i);
			if(tf.getText().equals("") || tf.getText().trim().length() == 0) {
				JOptionPane.showMessageDialog(null,msglist[i]+"��(��) �Է����ּ���");
				tf.requestFocus();
				i = msglist.length;
			}else if(i == (msglist.length-1)) {
				result = true;
			}
		}		
		
		return result;
	}
	
	/** 
	 * ���� : ���, ��� ��ư �̺�Ʈ ó�� 
	 */
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn_insert || obj == tf_list.get(3)) {
			insert_proc();			
			new InsertUI(ui);
		}else if(obj == btn_cancel) {			
			tf_list.forEach(tf -> {tf.setText("");});	//���ٽ� ǥ��
		}else if(obj == isbn_check) {
			/**
			 * �ߺ�üũ ��ư �������� validation check ���� �޼ҵ�
			 * 1. ������ �ִ� isbn�� ���ؼ� (db�� group�Լ��� count �̿��ؼ� int�� ����غ���)
			 * 	-> ���ٸ� joptionpanel �޽���â �߸鼭 �״�� �����Ұ��� ����� 
			 * 	-> ������(count�� 1�̸�) �޽���â �߸鼭 �ٽ��Ұ��� �����
			 * 		-> �ٽ� �Ѵٸ� createIsbn() �޼ҵ� �����ؼ� �ٽ� �� �ֱ�
			 */
			int result = dao.getCheckResult(tf_list.get(0).getText());
			if(result == 0) {
				JOptionPane.showConfirmDialog(null, "��밡���մϴ�. ��������ұ��?", "Ȯ�θ޽���â", 0);
			}else {
				int check = JOptionPane.showConfirmDialog(null, "�̹� ������� ISBN�Դϴ�. �ٽ� �����Ͻðڽ��ϱ�?", "Ȯ�θ޽���â", 0);
				if(check==0) init();
			}		
		}
	}

}









