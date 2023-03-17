package java_code.java_19day;
import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JFrame;

public class BorderLayoutTest {

	public static void main(String[] args) {
		JFrame jf = new JFrame("BorderLayout test");
		System.out.println(jf.getLayout());
		
		// 레이아웃 매니저 FlowLayout 으로 변경 가능
//		jf.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		Button east = new Button("East");
		Button west = new Button("West");
		Button south = new Button("South");
		Button north = new Button("North");
		Button center = new Button("Center");
		
		jf.add(east, BorderLayout.EAST);
		jf.add(west, BorderLayout.WEST);
		jf.add(south, BorderLayout.SOUTH);
		jf.add(north, BorderLayout.NORTH);
		jf.add(center, BorderLayout.CENTER);
		
		jf.setSize(300, 300);
		jf.setVisible(true); 
	}

}