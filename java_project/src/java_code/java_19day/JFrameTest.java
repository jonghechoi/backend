package java_code.java_19day;
import java.awt.Color;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/*
 * javax.swing 사용
 */
public class JFrameTest {

	public static void main(String[] args) {
		Frame f = new Frame("Frame Test");
		f.setSize(800, 800);
		
		JPanel f_panel = new JPanel();
		JPanel btn_panel = new JPanel();
		JPanel chk_panel = new JPanel();
		JPanel choice_panel = new JPanel();
		
		JButton button1 = new JButton("Button1");
		JButton button2 = new JButton("Button2");
		btn_panel.add(button1);
		btn_panel.add(button2);
		btn_panel.setBounds(200, 300, 100, 100);


		JCheckBox chk1 = new JCheckBox("1. ", true);
		JCheckBox chk2 = new JCheckBox("2. ", true);
		JCheckBox chk3 = new JCheckBox("3. ", true);
		chk_panel.add(chk1);
		chk_panel.add(chk2);
		chk_panel.add(chk3);
		chk_panel.setBounds(500, 500, 100, 100);

		
		String[] fList = {"1번 메뉴", "2번 메뉴", "3번 메뉴"};
		JComboBox comboBox = new JComboBox(fList);
		choice_panel.add(comboBox);
		choice_panel.setBounds(500, 500, 200, 200);

		
		f.add(chk_panel);
		f.add(choice_panel);
		f.add(btn_panel);
		
		f.setVisible(true); 
		
	}

}
