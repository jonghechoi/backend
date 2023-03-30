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
	String url = "jdbc:oracle:thin:@localhost:1521"; // 이 형식은 외워야 함
	String user = "scott";
	String password = "tiger";
	
	
	// 1~2 단계
	public SqlDao() {
		try {
			Class.forName(driver);
			System.out.println("-------------->> 1단계 성공");
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("-------------->> 2단계 Connection 객체 생성");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 3단계
	public void getStatement() {
		try {
			stmt = conn.createStatement();
			System.out.println("-------------->> 3단계 Statement 객체 생성");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	// 컬럼리스트 리턴 메소드
	public String[] getColList() { // 호출시 getResult 메소드 호출 다음에 호출!!
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
	
	// 4~5 단계
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
