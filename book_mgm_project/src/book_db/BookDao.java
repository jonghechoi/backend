package book_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

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
	// 1. ����̹� �ε� & ����̹��Ŵ��� ��ü ����
	public BookDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	// 2. Statement ����
	public void getStatement() {
		try {
			stmt = conn.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 3. PreparedStatement ���� - �Ű������� sql �ʿ�
	public void getPreparedStatement(String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 4. CRUD Method ����
	public boolean insert(BookVo book) {
		boolean result = false;
		
		try {
			String sql = "insert into book values (?,?,?,?,sysdate)"; 
			getPreparedStatement(sql);
			pstmt.setString(1, book.getIsbn()); // ù��° �ڸ�, ������
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
	
	// ��ü ���� ��ȸ
	public ArrayList<BookVo> select() {
		ArrayList<BookVo> list = new  ArrayList<BookVo>();
		// TO_CHAR�� ���� PRICE�� Int->String���� ����
		// BookVo���� �ٲ���� ��
		// �̶� BookVo �Ѱ��� ����ؾ� �� ���� Vo�� ���α׷����� ���ϰ� �ϱ� ���� �����̹Ƿ� �� �ٸ� �ʵ�
		// �߰��ص���. -> sprice �ϳ� �� ���� ���⿡ ���������Ϳʹ� �ٸ� ��¿� �ʵ� �ϳ� �� ���������!
		String sql = "  SELECT ROWNUM RNO, ISBN, TITLE, AUTHOR, PRICE, " +
				"  to_char(PRICE, 'L999,999') SPRICE, " +
				"  to_char(BDATE, 'YY-MM-DD')" + 
				"  FROM (SELECT ISBN, TITLE, AUTHOR, PRICE, BDATE" + 
				"          FROM  BOOK" + 
				"          ORDER BY BDATE DESC)";
		// StringBuffer Ȱ��
		StringBuffer sb = new StringBuffer(300);
		sb.append("  SELECT ROWNUM RNO, ISBN, TITLE, AUTHOR, PRICE, ");
		sb.append("  to_char(PRICE, 'L999,999') SPRICE, ");
		sb.append("  to_char(BDATE, 'YY-MM-DD')");
		sb.append("  FROM (SELECT ISBN, TITLE, AUTHOR, PRICE, BDATE");
		sb.append("          FROM  BOOK");
		sb.append("          ORDER BY BDATE DESC)");
		System.out.println(sb.toString());
		try {
			getPreparedStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookVo book = new BookVo();
				book.setRno(rs.getInt(1));
				book.setIsbn(rs.getString(2));
				book.setTitle(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setSprice(rs.getString(6));
				book.setBdate(rs.getString(7));
				list.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public int getCheckResult(String isbn) {
		int result = 0;
		StringBuffer sb = new StringBuffer(100);
		sb.append("SELECT COUNT(ISBN) FROM BOOK WHERE ISBN = '" + isbn + "'");
		
		try {
			getPreparedStatement(sb.toString());
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<BookVo> search(String item,String data) {
//		System.out.println("item --------------->  " + item + ", isbn -----> " + isbn);
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		StringBuffer sql = new StringBuffer(100);
		sql.append("SELECT ROWNUM RNO, ISBN, TITLE, AUTHOR, PRICE, SPRICE, BDATE");
		sql.append(" FROM (SELECT ISBN, TITLE, AUTHOR, PRICE, TO_CHAR(PRICE, 'L999,999') SPRICE, BDATE FROM BOOK");
//		sql.append(" WHERE ISBN LIKE '%" + data + "%' ORDER BY BDATE DESC)");

		if(item.equals("ISBN")) {
			sql.append(" WHERE ISBN LIKE '%" + data + "%' ORDER BY BDATE DESC)");
		}else if(item.equals("TITLE")) {
			sql.append(" WHERE TITLE LIKE '%" + data + "%' ORDER BY BDATE DESC)");
		}else if(item.equals("AUTHOR")) {
			sql.append(" WHERE AUTHOR LIKE '%" + data + "%' ORDER BY BDATE DESC)");
		}
		
		try {
			getPreparedStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookVo book = new BookVo();
				book.setRno(rs.getInt(1));
				book.setIsbn(rs.getString(2));
				book.setTitle(rs.getString(3));
				book.setAuthor(rs.getString(4));
				book.setSprice(rs.getString(6));
				book.setBdate(rs.getString(7));
				list.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public BookVo search(String isbn) {
		BookVo book = null;
		StringBuffer sql = new StringBuffer(100);
		sql.append("SELECT ISBN, TITLE, AUTHOR, PRICE FROM BOOK ");
		sql.append(" where isbn = ?");
		try {
			getPreparedStatement(sql.toString());
			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				book = new BookVo();
				book.setIsbn(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setSprice(rs.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public int update(BookVo book) {
		int result = 0;
		StringBuffer sql = new StringBuffer(200);
		sql.append(" update book set title=?, author=?, price=?");
		sql.append(" where  isbn=?");
		try {
			getPreparedStatement(sql.toString());
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getIsbn());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean delete(BookVo book) {
		boolean result = false;
		
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM BOOK WHERE ISBN=?");
		
		try {
			getPreparedStatement(sql.toString());
			pstmt.setString(1, book.getIsbn());
			if(pstmt.executeUpdate()==1) result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
			System.out.println("---------------------> Dao ����");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
