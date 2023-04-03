package score_UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import score_db.ScoreDao;
import score_mgm_oop_arrayList.ScoreMgmSystem;


public class ScoremgmUI extends JFrame{
	//Field
	ScoreDao dao;
	ScoreMgmSystem sms; //성적관리 시스템
	ScoremgmEvent event_object;	//이벤트 처리 클래스
	
	String[] menulist = {"등록","조회","검색","수정","삭제","종료"};
	JPanel menu_panel, title_panel, content_panel, insert_panel, select_panel
				, search_panel, update_panel, delete_panel, count_panel; 
	ArrayList<JButton> button_list = new ArrayList<JButton>(menulist.length);
	JTextField tf_count;
	
	public static final int INSERT = 1;
	public static final int SELECT = 2;
	public static final int SEARCH = 3;
	public static final int UPDATE = 4;
	public static final int DELETE = 5;
	
	
	//Constructor
	public ScoremgmUI() {
		init();	//초기 화면 생성 메소드
		dao = new ScoreDao();
	}
	
	//Method
	public void init() {
		setTitle("성적관리시스템");
		sms = new ScoreMgmSystem("강남 고등학교");
		event_object = new ScoremgmEvent(this);
		
		title_panel = new JPanel(new BorderLayout());
		menu_panel = new JPanel(new GridLayout(6,1));
		content_panel = new JPanel();
		insert_panel = new JPanel();
		select_panel = new JPanel();
		search_panel = new JPanel();
		update_panel = new JPanel();
		delete_panel = new JPanel();
		count_panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		tf_count = new JTextField("0");
		tf_count.setEditable(false);
		count_panel.add(new JLabel("등록인원 : "));
		count_panel.add(tf_count);
		count_panel.add(new JLabel("    "));
		
		
		JLabel t1 = new JLabel("*************************************",JLabel.CENTER);
		JLabel t2 = new JLabel("성적관리 시스템",JLabel.CENTER);
		JLabel t3 = new JLabel("*************************************",JLabel.CENTER);
		title_panel.add(t1, BorderLayout.NORTH);
		title_panel.add(t2, BorderLayout.CENTER);
		title_panel.add(t3, BorderLayout.SOUTH);		
		
		for(String menu : menulist) {
			JButton btn_menu = new JButton("          "+menu+"          ");
			menu_panel.add(btn_menu);
			btn_menu.addActionListener(event_object);
			button_list.add(btn_menu);
		}
		
		//----
		ImageIcon img = new ImageIcon("images/score_duke.jpg");
		JLabel img_label = new JLabel(img);
		
		//----
		content_panel.add(img_label);
		add(menu_panel, BorderLayout.WEST);
		add(title_panel, BorderLayout.NORTH);
		add(content_panel, BorderLayout.CENTER);
		add(count_panel, BorderLayout.SOUTH);
		
		addWindowListener(event_object);
		
		setSize(750,400);
		setVisible(true);
		
		//등록인원수를 가져오는 쓰레드 생성 및 실행
//		new CountObject(this, system).start();
		
	}
	
	/**
	 * 설명 : 각 메뉴가 호출될 때마다 패널을 스위칭 하는 메소드 구현
	 */
	public void switch_panel(int menu) {
		content_panel.removeAll();
		insert_panel.setVisible(false);
		select_panel.setVisible(false);
		search_panel.setVisible(false);
		update_panel.setVisible(false);
		delete_panel.setVisible(false);
		
		switch(menu){
			case INSERT : //등록
				insert_panel.removeAll();
				insert_panel.setVisible(true);
				break;
			case SELECT : //조회
				select_panel.removeAll();
				select_panel.setVisible(true);
				break;
			case SEARCH : //검색
				search_panel.removeAll();
				search_panel.setVisible(true);
				break;
			case UPDATE : //수정
				update_panel.removeAll();
				update_panel.setVisible(true);
				break;
			case DELETE : //삭제
				delete_panel.removeAll();
				delete_panel.setVisible(true);
				break;
		}
	}
	
	
}//class









