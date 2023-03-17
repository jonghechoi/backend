package java_code.java_19day;
import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowLayoutTest {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		System.out.println(jp.getLayout()); // java.awt.FlowLayout - ������Ʈ ���� ������ ����, ���ʺ��� ���ʷ� ����
		
		Button button1 = new Button("Button1");
		Button button2 = new Button("Button2");
		Button button3 = new Button("Button3");
		Button button4 = new Button("Button4");
		Button button5 = new Button("Button5");

		jp.add(button1);
		jp.add(button2);
		jp.add(button3);
		jp.add(button4);
		jp.add(button5);

		jf.add(jp);
		
		jf.setSize(300, 300);
		jf.setVisible(true);
		
	}

}
