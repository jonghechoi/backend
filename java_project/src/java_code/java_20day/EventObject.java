package java_code.java_20day;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EventObject extends WindowAdapter implements ActionListener {
	// Field
	JFrame jf;
	JPanel jp;
	JButton button;
	Font font;
	
	// Constructor
	public EventObject() {
		jf = new JFrame("EventObject~");
		jp = new JPanel();
		button = new JButton("��ư 111");
		font = new Font("���� ���", Font.BOLD, 12);
		button.setFont(font);;
		
		jp.add(button);
		jf.add(jp);
		
		jf.setSize(300, 300);
		jf.setVisible(true);
		
		button.addActionListener(this); // 1.�ڱ��ڽ��� ó�� 2.�ٸ� Ŭ�������� ó�� 3.����� Ŭ���� ó��
		jf.addWindowListener(this);
	}
	
	
	// Method
	
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("--- ���α׷� ���� ---");
		System.exit(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand() + " Ŭ��~~");
	}
}
