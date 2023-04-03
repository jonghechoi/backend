package java_code.java_21day;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class EmpPlay extends JFrame{
	// Field
	SqlDao dao;
	JTextArea ta;
	ArrayList<Object[]> list;

	// Constructor
	public EmpPlay() {
		dao = new SqlDao();
//		list = dao.getResult();
		
		setTitle("SQL 실행");
		
		JPanel sqlPanel = new JPanel(new BorderLayout());
		JPanel btnPanel = new JPanel();
		ta = new JTextArea(10,5);
		ta.setBackground(Color.LIGHT_GRAY);
		JButton btn_exec = new JButton("실 행");
		JButton btn_cancle = new JButton("다시쓰기");
		
		btnPanel.add(btn_exec);
		btnPanel.add(btn_cancle);
		sqlPanel.add(ta, BorderLayout.CENTER);
		sqlPanel.add(btnPanel, BorderLayout.SOUTH);
		
//		String[] colName = dao.getResultColName();
//		DefaultTableModel model = new DefaultTableModel(colName, 0);
//		JTable table = new JTable(model);
//		Object[] row = new Object[colName.length];
		
//		createTable(model, row); // 테이블 출력데이터 생성
		
//		table.setModel(model);
//		JScrollPane pane = new JScrollPane(table);
//		pane.setPreferredSize(new Dimension(500,250));
		
		add(sqlPanel, BorderLayout.NORTH);
//		add(pane, BorderLayout.CENTER);
		setSize(500,500);
		setVisible(true);
		
		// 버튼 이벤트 처리
		btn_exec.addActionListener( e -> {
			String sql = ta.getText().trim();
			if(sql.length() == 0) {
				JOptionPane.showMessageDialog(null, "쿼리를 입력해주세요 :)");
				ta.requestFocus();
			}else {
				createTable();
			};
		});
		
		btn_cancle.addActionListener( e -> {
			ta.setText("");
			ta.requestFocus();
		}); 
		
		// 윈도우 종료 이벤트
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	
	public void createTable() {
		list = dao.getResult(ta.getText().trim());
		String[] colName = dao.getColList();
		DefaultTableModel model = new DefaultTableModel(colName, 0);
		JTable table = new JTable(model);
//		Object[] row = new Object[colName.length];
		
		int no = 1;
		model.setRowCount(0);
//		ArrayList<EmpVo> list = dao.getResult();
		
		for(Object[] objList : list) {
			model.addRow(objList);
			no++;
		}
		model.fireTableDataChanged();
		
		table.setModel(model);
		JScrollPane pane = new JScrollPane(table);
		pane.setPreferredSize(new Dimension(500,250));
		
		add(pane, BorderLayout.CENTER);
		setVisible(true);
	}// createTable
}// class
