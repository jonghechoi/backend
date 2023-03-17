package java_code.java_19day;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Panel;

public class FrameTest {

	public static void main(String[] args) {
//		FrameChild fc = new FrameChild();
		
		Frame f = new Frame("Frame Test");
		
		Panel f_panel = new Panel();
		Panel btn_panel = new Panel();
		Panel chk_panel = new Panel();
		Panel choice_panel = new Panel();
		
		Button button1 = new Button("Button1");
		Button button2 = new Button("Button2");
		Checkbox chk1 = new Checkbox("1. ", true);
		Checkbox chk2 = new Checkbox("2. ", true);
		Checkbox chk3 = new Checkbox("3. ", true);
		Choice choice = new Choice();
		
		choice.add("1번 메뉴");
		choice.add("2번 메뉴");
		choice.add("3번 메뉴");
		
		btn_panel.add(button1);
		btn_panel.add(button2);
		chk_panel.add(chk1);
		chk_panel.add(chk2);
		chk_panel.add(chk3);
		choice_panel.add(choice);
		
		f_panel.add(btn_panel);
		f_panel.add(chk_panel);
		f_panel.add(choice_panel);
		f.add(f_panel);
		
		f.setVisible(true); 
		f.setSize(799, 799);
	}

}
