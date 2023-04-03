package java_code.java_21day;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) {
		// 0. 드라이버 준비 - 해당 프로젝트 ojdbc로 시작하는 드라이버 path 설정
		try {
			// 1. 드라이버 로딩 - Class.forName("드라이버");
			Class.forName("oracle.jdbc.driver.OracleDriver"); // OracleDriver.class 파일을 로딩
			System.out.println("-------------->> 1단계 성공");
			
			// 2. Connection 생성 - 인터페이스이므로 스스로는 객체 생성 안됨
			String url = "jdbc:oracle:thin:@localhost:1521"; // 이 형식은 외워야 함
			String user = "scott";
			String password = "tiger";
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("-------------->> 2단계 Connection 객체 생성");
			
			// 3. Statement 생성 - conn 객체를 통해서 Statement가 생성됨
			Statement stmt = conn.createStatement();
			System.out.println("-------------->> 3단계 Statement 객체 생성");
			
			// 4. ResultSet 생성 - executeQuery : select 쿼리만 사용 // executeUpdate은 insert,update,delete에 사용
			// 부서번호 오름차순 정렬, 행번호 출력
			String sql = "select rownum RN, empno, ename, "
					+ " 		 job,to_char(hiredate, 'yyyy/mm/dd') hiredate, deptno "
					+ "   	from (select empno, ename, job,hiredate, deptno "
					+ "			  	from emp "
					+ "				order by deptno) ";
			
			ResultSet rs = stmt.executeQuery(sql); // 여기서부터 db 데이터가 jvm으로 온 것
			
			// 5. ResultSet 데이터 처리 - 콘솔 창에 출력
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.print(rsmd.getColumnName(1)+"\t");
			System.out.print(rsmd.getColumnName(2)+"\t");
			System.out.print(rsmd.getColumnName(3)+"\t");
			System.out.print(rsmd.getColumnName(4)+"\t\t");
			System.out.print(rsmd.getColumnName(5)+"\t");
			System.out.print(rsmd.getColumnName(6)+"\n");
			System.out.println("----------------------------------------------------------");
			while(rs.next()) { // next메소드를 통해 커서를 다음 행으로 옮김고 boolean값 반환
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getInt(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\t\t");
				System.out.print(rs.getString(5) + "\t"); // yyyy/mm/dd로 변환
				System.out.print(rs.getInt(6) + "\n");
			}
			
			// 6. close
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
