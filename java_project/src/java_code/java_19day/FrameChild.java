package java_code.java_19day;
import java.awt.Frame;

public class FrameChild extends Frame {
	// �����ڰ� ȣ��Ǹ� JVM�� �⺻������ �������
	// �̶� Frame�� ��� ������ FrameChild�� �⺻ �����ڰ� �ڽ��� ��ü ����� ���� Frame ��ü�� ���� ����
//	FrameChild fc = new FrameChild();
	
	public FrameChild() {
		super("Frame Test2");
		setSize(400,400);
		setVisible(true);
//		setTitle("Frame Test2");
	}
	
	
	
}
