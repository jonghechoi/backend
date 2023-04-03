package java_code.java_21day;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlDao {
	// Field
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521"; // �� ������ �ܿ��� ��
	String user = "scott";
	String password = "tiger";
	
	
	// 1~2 �ܰ�
	public SqlDao() {
		try {
			Class.forName(driver);
			System.out.println("-------------->> 1�ܰ� ����");
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("-------------->> 2�ܰ� Connection ��ü ����");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 3�ܰ�
	public void getStatement() {
		try {
			stmt = conn.createStatement();
			System.out.println("-------------->> 3�ܰ� Statement ��ü ����");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	// �÷�����Ʈ ���� �޼ҵ�
	public String[] getColList() { // ȣ��� getResult �޼ҵ� ȣ�� ������ ȣ��!!
		String[] colList = null;
		
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			colList = new String[rsmd.getColumnCount()];
			for(int i=0; i<colList.length; i++) {
				colList[i] = rsmd.getColumnName(i+1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return colList;
	}
	
	// 4~5 �ܰ�
	public ArrayList<Object[]> getResult(String sql) {
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		getStatement();
		
		try {
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while(rs.next()) {
				Object[] objList = new Object[rsmd.getColumnCount()];
				
				for(int i=0; i<objList.length; i++) {
					objList[i] = rs.getObject(i+1);
				}
				list.add(objList);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return list;
	}
	
	//close
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
