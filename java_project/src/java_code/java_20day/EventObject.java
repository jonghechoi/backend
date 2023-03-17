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
		button = new JButton("버튼 111");
		font = new Font("맑은 고딕", Font.BOLD, 12);
		button.setFont(font);;
		
		jp.add(button);
		jf.add(jp);
		
		jf.setSize(300, 300);
		jf.setVisible(true);
		
		button.addActionListener(this); // 1.자기자신이 처리 2.다른 클래스에서 처리 3.무기명 클래스 처리
		jf.addWindowListener(this);
	}
	
	
	// Method
	
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("--- 프로그램 종료 ---");
		System.exit(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand() + " 클릭~~");
	}
}
