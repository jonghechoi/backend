package java_code.java_19day;
import java.awt.Frame;

public class FrameChild extends Frame {
	// 생성자가 호출되면 JVM이 기본생성자 만들어줌
	// 이때 Frame을 상속 받으니 FrameChild의 기본 생성자가 자신의 객체 만들기 전에 Frame 객체를 먼저 생성
//	FrameChild fc = new FrameChild();
	
	public FrameChild() {
		super("Frame Test2");
		setSize(400,400);
		setVisible(true);
//		setTitle("Frame Test2");
	}
	
	
	
}
