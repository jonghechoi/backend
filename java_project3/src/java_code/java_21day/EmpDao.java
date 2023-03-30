package java_code.java_21day;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpDao {
	// Field
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521"; // 이 형식은 외워야 함
	String user = "scott";
	String password = "tiger";
	
	// Constructor
	public EmpDao() {
		try {
			Class.forName(this.driver);
			System.out.println("-------------->> 1단계 성공");
			conn = DriverManager.getConnection(this.url, this.user, this.password);
			System.out.println("-------------->> 2단계 Connection 객체 생성");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method
	// Statement는 종류가 많기 때문에 생성자가 아닌 메소드로 빠짐
	public void getStatement() {
		try {
			stmt = conn.createStatement();
			System.out.println("-------------->> 3단계 Statement 객체 생성");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] getResultColName() {
		String[] colList = null;
		
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			colList = new String[rsmd.getColumnCount()];
			for(int i=0; i<colList.length; i++) {
				colList[i] = rsmd.getColumnName(i+1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return colList;
	}
	
	public ArrayList<EmpVo> getResult() {
		ArrayList<EmpVo> list = new ArrayList<EmpVo>();
		
		String sql = "select rownum rno, empno, ename, "
				+ " 		 job,to_char(hiredate, 'yyyy/mm/dd') hiredate, deptno "
				+ "   	from (select empno, ename, job,hiredate, deptno "
				+ "			  	from emp "
				+ "				order by deptno) ";
		
		getStatement();
		try {
			rs = stmt.executeQuery(sql);

			System.out.println("----------------------------------------------------------");
			while(rs.next()) { // next메소드를 통해 커서를 다음 행으로 옮김고 boolean값 반환
				EmpVo employee = new EmpVo();
				employee.setRno(rs.getInt(1));
				employee.setEmpno(rs.getInt(2));
				employee.setEname(rs.getString(3));
				employee.setJob(rs.getString(4));
				employee.setHiredate(rs.getString(5));
				employee.setDeptno(rs.getInt(6));
				list.add(employee);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) rs.close();
			if(conn != null) rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
