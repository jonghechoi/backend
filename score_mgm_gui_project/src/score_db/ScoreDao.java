package score_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import score_mgm_oop_arrayList.ScoreVo;

public class ScoreDao {
	// Field        
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521"; 
	String user = "scott";
	String password = "tiger";
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	ResultSetMetaData rsmd;
	
	// Constructor
	public ScoreDao() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Statement ����
	public void getStatement() {
		try {
			stmt = conn.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method : CRUD
	/*
	 * ���� ���
	 */
	public boolean insert(ScoreVo score) {
		boolean result = false;
		
		try {
			getStatement();		// Statement ��ü ����
			String sql = " insert into score "
					+ " values('s_'||to_char(sequ_score_sid.nextval, '000'),"
					+ " '"+ score.getName() +"', "
					+ score.getKor() + ", "
					+ score.getEng() + ", "
					+ score.getMath() + ", "
					+ " sysdate) ";
			System.out.println("sql --> " + sql);
			// Statement.executeQuery --> Select �϶� ��� : ResultSet ��ȯ��(�����͸� �޾ƿ��� ��ü)
			// Statement.executeUpdate --> Insert, Update, Delete �϶� ��� : int ��ȯ�� 
			int val = stmt.executeUpdate(sql);
			if(val == 1) result = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/*
	 * ���� ��ü ����Ʈ ��ȸ
	 */
	public ArrayList<ScoreVo> select() {
		ArrayList<ScoreVo> list = new ArrayList<ScoreVo>();
		
		try {
			getStatement();
			String sql = "SELECT ROWNUM RNO, SID, NAME, KOR, ENG, MATH, TOT, AVG, SDATE\r\n" + 
					"     	FROM(SELECT SID, NAME, KOR, ENG, MATH, KOR+ENG+MATH TOT, TO_CHAR((KOR+ENG+MATH)/3.0, '999') AVG, SDATE\r\n" + 
					"  			   FROM SCORE\r\n" + 
					"              ORDER BY SDATE DESC)";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				ScoreVo score = new ScoreVo();
				score.setRno(rs.getInt(1));
				score.setSid(rs.getString(2));
				score.setName(rs.getString(3));
				score.setKor(rs.getInt(4));
				score.setEng(rs.getInt(5));
				score.setMath(rs.getInt(6));
				score.setTot(rs.getInt(7));
				score.setAvg(rs.getInt(8));
				score.setSdate(rs.getString(9));
				list.add(score);
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*
	 * ����, �������� �й� �˻� ���
	 */
	public ScoreVo search(String sid, String fname) {
		ScoreVo score = null; // ���ú����� jvm�� �˾Ƽ� �ʱ�ȭ������ �ʱ� ������ ��������� �ʱ�ȭ �ʿ�
		
		try {
			getStatement();
			String sql = "SELECT SID, NAME, KOR, ENG, MATH, SDATE" + 
					"  FROM SCORE" + 
					"  WHERE SID='" + sid + "'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				score = new ScoreVo();
				score.setSid(rs.getString(1));
				score.setName(rs.getString(2));
				score.setKor(rs.getInt(3));
				score.setEng(rs.getInt(4));
				score.setMath(rs.getInt(5));
				score.setSdate(rs.getString(6));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return score;
	}
	
	public ArrayList<ScoreVo> search(String name) {
		ArrayList<ScoreVo> list = new ArrayList<ScoreVo>();
		
		try {
			getStatement();
			String sql = "SELECT SID, NAME, KOR, ENG, MATH, KOR+ENG+MATH TOT,"
					+ " (KOR+ENG+MATH)/3.0 AVG, SDATE " + 
					"  FROM SCORE " + 
					"  WHERE NAME LIKE '%" + name + "%'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				ScoreVo score = new ScoreVo();
				score.setSid(rs.getString(1));
				score.setName(rs.getString(2));
				score.setKor(rs.getInt(3));
				score.setEng(rs.getInt(4));
				score.setMath(rs.getInt(5));
				score.setTot(rs.getDouble(6));
				score.setAvg(rs.getDouble(7));
				score.setSdate(rs.getString(8));
				list.add(score);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean update(ScoreVo score) {
		boolean result = false;
		
		try {
			getStatement();
			String sql = " update score set kor="+score.getKor()
						+" , eng="+score.getEng()
						+" , math="+score.getMath()
						+" where sid='"+ score.getSid()+"'";
			int val = stmt.executeUpdate(sql);
			if(val == 1) result = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean delete(ScoreVo score) {
		boolean result = false;
		
		try {
			getStatement();
			String sql = "DELETE FROM SCORE WHERE SID= '"+score.getSid()+"'";
			System.out.println("sql -------->" +sql);
			int val = stmt.executeUpdate(sql);
			if(val == 1) result = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// close
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
