package java_code.java_20day;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventObject2 {
	// Field
	JFrame jf;
	JPanel jp;
	JTextField tf;
	JButton button1, button2;
	Font font;
	
	// Constructor
	public EventObject2() {
		jf = new JFrame("EventObject~");
		jp = new JPanel();
		button1 = new JButton("  ���  ");
		button2 = new JButton("  ���  ");
		tf = new JTextField();
		
		font = new Font("���� ���", Font.BOLD, 12);
		button1.setFont(font);;
		button2.setFont(font);;
		tf.setFont(new Font("���� ���", Font.PLAIN, 12));
		
		jp.add(button1);
		jp.add(button2);
		jf.add(tf, BorderLayout.NORTH);
		jf.add(jp, BorderLayout.CENTER);
		
		jf.setSize(300, 300);
		jf.setVisible(true);
		
		EventObject2Proc eventProc = new EventObject2Proc(this);
		button1.addActionListener(eventProc); // 2.�ٸ� Ŭ�������� ó�� 
		button2.addActionListener(eventProc);
		jf.addWindowListener(eventProc);
	}
}

// �̺�Ʈ ó�� Ŭ����
/*
 * �ڹ� ���� �ϳ��� Ŭ������ ������ ���� ���� ��� ����
 * ������!!! 10���� Ŭ������ public�� �ٴ� �ִ� �� 1�����߸� ��. �ٷ� ������ �̸��� ������ �ִ� Ŭ����
 */
class EventObject2Proc extends WindowAdapter implements ActionListener {
	EventObject2 eo2;
	
	
	public EventObject2Proc(EventObject2 eo2) {
		this.eo2 = eo2;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand()+" ��ư Ŭ��");
		
		// public Object getSource() 
		// API ���� �θ�Ŭ�����κ����� �޼ҵ���. ��, �ڽ� ��ü+�θ� ��ü�� �Բ� �����Ǵµ� �θ� ��ü�� ����ϴ� ����
		Object tmpE = e.getSource(); 
		if(e.getSource() == eo2.button1) {
			String str = eo2.tf.getText();
			//validation check(��ȿ�� üũ)
			if(str.length() != 0) {
				System.out.println("str --> " +  str);
			}else {
				System.out.println("���� �Է����ּ���.");
				JOptionPane.showMessageDialog(null, "���� �Է����ּ���");
			}
		}else {
			eo2.tf.setText("");
		}
	}
	
	public void windowClosing(WindowEvent e) {
		System.out.println("--- ���α׷� ���� ---");
		System.exit(0);
	}
	
}











