package java_code.java_19day;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActionEventTest implements ActionListener {

	
	public static void main(String[] args) {
		JFrame jf = new JFrame("Action Event");
		JPanel jp = new JPanel();
		JButton button1 = new JButton("버튼1");
		JButton button2 = new JButton("버튼2");
		
		Font font = new Font("맑은 고딕", Font.BOLD, 30);
		button1.setFont(font);
		button2.setFont(font);
		
		jp.add(button1);
		jp.add(button2);
		jf.add(jp);
		
		jf.setSize(300, 300);
		jf.setVisible(true);
		
		// button1의 액션이벤트 처리
		// 액션이벤트의 처리는 클래스 자기 자신이 될 수도 있고 위임할 수도 있다. 다만 중요한것은 ActionListener을 반드시 상속받아야 한다는것!!
		ActionEventProc eventProc = new ActionEventProc();
		button1.addActionListener(eventProc);
		button2.addActionListener(eventProc);
		
		// jf 종료 이벤트 처리
		jf.addWindowListener(eventProc);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 눌림");
		
	}
}

// 이벤트 처리 클래스
class ActionEventProc extends WindowAdapter implements ActionListener {
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("종료종료");
		System.exit(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String btnName = e.getActionCommand();
		if(btnName.equals("버튼1")) {
			System.out.println("버튼 111");
		}else if(btnName.equals("버튼2")) {
			System.out.println("버튼 222");
		}
	}
	

}









