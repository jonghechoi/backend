package book_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class BookDao {
	// Field
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521";
	String user = "scott";
	String password = "tiger";
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	ResultSetMetaData rsmd;

	// Constructor
	// 1. 드라이버 로딩 & 드라이버매니저 객체 생성
	public BookDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	// 2. Statement 생성
	public void getStatement() {
		try {
			stmt = conn.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 3. PreparedStatement 생성 - 매개변수로 sql 필요
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 4. CRUD Method 생성
	public boolean insert(BookVo book) {
		boolean result = false;
		
		try {
			String sql = "insert into book values (?,?,?,?,sysdate)"; 
			getPreparedStatement(sql);
			pstmt.setString(1, book.getIsbn()); // 첫번째 자리, 데이터
			pstmt.setString(2,  book.getTitle().toUpperCase());
			pstmt.setString(3,  book.getAuthor());
			pstmt.setInt(4,  book.getPrice());
			
			int val = pstmt.executeUpdate();
			
//			getStatement();
//			String sql = "INSERT INTO BOOK " 
//					+ "  VALUES('" + book.getIsbn() + "',"
//					+ " '" + book.getTitle() + "',"
//					+ " '" + book.getAuthor() + "',"
//					+ book.getPrice() + ", SYSDATE)";
//			System.out.println("sql ------------->" + sql);
			
//			int val = stmt.executeUpdate(sql);
			
			if(val==1) result = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public void select() {}
	public void search() {}
	public void update() {}
	public void delete() {}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
			System.out.println("---------------------> Dao 종료");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
