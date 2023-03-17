package java_code.java_19day;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GridLayoutTest {

	public static void main(String[] args) {
		JFrame jf = new JFrame("GridLayout Test!!");
		JPanel jp = new JPanel(new GridLayout(4,2,5,5));
		String[] labelList = {"�̸�", "��������", "��������", "��������"};

		
		for(String label : labelList) {
			jp.add(new JLabel(label));
			jp.add(new JTextField(5));
		}
		
		JPanel but_panel = new JPanel(new GridLayout(1,2,5,5));
		but_panel.add(new JButton("���"));
		but_panel.add(new JButton("���"));
		
		jf.add(jp, BorderLayout.CENTER);
		jf.add(but_panel, BorderLayout.SOUTH);
		jf.setSize(400, 400);
		jf.setVisible(true);
		
	}

}
