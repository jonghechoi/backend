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
		JButton button1 = new JButton("��ư1");
		JButton button2 = new JButton("��ư2");
		
		Font font = new Font("���� ���", Font.BOLD, 30);
		button1.setFont(font);
		button2.setFont(font);
		
		jp.add(button1);
		jp.add(button2);
		jf.add(jp);
		
		jf.setSize(300, 300);
		jf.setVisible(true);
		
		// button1�� �׼��̺�Ʈ ó��
		// �׼��̺�Ʈ�� ó���� Ŭ���� �ڱ� �ڽ��� �� ���� �ְ� ������ ���� �ִ�. �ٸ� �߿��Ѱ��� ActionListener�� �ݵ�� ��ӹ޾ƾ� �Ѵٴ°�!!
		ActionEventProc eventProc = new ActionEventProc();
		button1.addActionListener(eventProc);
		button2.addActionListener(eventProc);
		
		// jf ���� �̺�Ʈ ó��
		jf.addWindowListener(eventProc);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("��ư ����");
		
	}
}

// �̺�Ʈ ó�� Ŭ����
class ActionEventProc extends WindowAdapter implements ActionListener {
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("��������");
		System.exit(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String btnName = e.getActionCommand();
		if(btnName.equals("��ư1")) {
			System.out.println("��ư 111");
		}else if(btnName.equals("��ư2")) {
			System.out.println("��ư 222");
		}
	}
	

}









