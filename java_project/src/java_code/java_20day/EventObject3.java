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

public class EventObject3 {
	// Field
	JFrame jf;
	JPanel jp;
	JTextField tf;
	JButton button1, button2;
	Font font;
	
	// Constructor
	public EventObject3() {
		jf = new JFrame("EventObject~");
		jp = new JPanel();
		button1 = new JButton("  ���  ");
		button2 = new JButton("  ���  ");
		tf = new JTextField();
		
		font = new Font("���� ���", Font.BOLD, 12);
		button1.setFont(font);;
		button2.setFont(font);;
		tf.setFont(new Font("���� ���", Font.PLAIN, 12));
		
		jp.add(button1);
		jp.add(button2);
		jf.add(tf, BorderLayout.NORTH);
		jf.add(jp, BorderLayout.CENTER);
		
		jf.setSize(300, 300);
		jf.setVisible(true);
		
//		EventObject2Proc eventProc = new EventObject2Proc(this);
		button1.addActionListener(new ActionListener() { //  3.����� Ŭ���� ó��
									@Override
									public void actionPerformed(ActionEvent e) {
										String str = tf.getText();
										if(str.length() != 0) {
											System.out.println("str --> " + str);
										}
									 }
								  }); 
		button2.addActionListener(new ActionListener() {
								  	@Override
								  	public void actionPerformed(ActionEvent e) {
								  		tf.setText("");
								  	}
								  });
		jf.addWindowListener(new WindowAdapter() {
						     	@Override
						     	public void windowClosing(WindowEvent e) {
						     		System.out.println("--- ���α׷� ���� ---");
						     		System.exit(0);
						     	}
						  	 });
	}
}










