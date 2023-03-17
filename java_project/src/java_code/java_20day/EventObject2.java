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
		button1 = new JButton("  등록  ");
		button2 = new JButton("  취소  ");
		tf = new JTextField();
		
		font = new Font("맑은 고딕", Font.BOLD, 12);
		button1.setFont(font);;
		button2.setFont(font);;
		tf.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		jp.add(button1);
		jp.add(button2);
		jf.add(tf, BorderLayout.NORTH);
		jf.add(jp, BorderLayout.CENTER);
		
		jf.setSize(300, 300);
		jf.setVisible(true);
		
		EventObject2Proc eventProc = new EventObject2Proc(this);
		button1.addActionListener(eventProc); // 2.다른 클래스에서 처리 
		button2.addActionListener(eventProc);
		jf.addWindowListener(eventProc);
	}
}

// 이벤트 처리 클래스
/*
 * 자바 파일 하나에 클래스가 여러개 들어가는 것은 상관 없음
 * 하지만!!! 10개의 클레스에 public이 붙는 애는 딱 1개여야만 함. 바로 파일의 이름을 가지고 있는 클래스
 */
class EventObject2Proc extends WindowAdapter implements ActionListener {
	EventObject2 eo2;
	
	
	public EventObject2Proc(EventObject2 eo2) {
		this.eo2 = eo2;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand()+" 버튼 클릭");
		
		// public Object getSource() 
		// API 보면 부모클래스로부터의 메소드임. 즉, 자식 객체+부모 객체가 함께 생성되는데 부모 객체를 사용하는 것임
		Object tmpE = e.getSource(); 
		if(e.getSource() == eo2.button1) {
			String str = eo2.tf.getText();
			//validation check(유효성 체크)
			if(str.length() != 0) {
				System.out.println("str --> " +  str);
			}else {
				System.out.println("값을 입력해주세요.");
				JOptionPane.showMessageDialog(null, "값을 입력해주세요");
			}
		}else {
			eo2.tf.setText("");
		}
	}
	
	public void windowClosing(WindowEvent e) {
		System.out.println("--- 프로그램 종료 ---");
		System.exit(0);
	}
	
}











