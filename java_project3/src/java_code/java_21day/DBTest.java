package java_code.java_21day;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) {
		// 0. ����̹� �غ� - �ش� ������Ʈ ojdbc�� �����ϴ� ����̹� path ����
		try {
			// 1. ����̹� �ε� - Class.forName("����̹�");
			Class.forName("oracle.jdbc.driver.OracleDriver"); // OracleDriver.class ������ �ε�
			System.out.println("-------------->> 1�ܰ� ����");
			
			// 2. Connection ���� - �������̽��̹Ƿ� �����δ� ��ü ���� �ȵ�
			String url = "jdbc:oracle:thin:@localhost:1521"; // �� ������ �ܿ��� ��
			String user = "scott";
			String password = "tiger";
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("-------------->> 2�ܰ� Connection ��ü ����");
			
			// 3. Statement ���� - conn ��ü�� ���ؼ� Statement�� ������
			Statement stmt = conn.createStatement();
			System.out.println("-------------->> 3�ܰ� Statement ��ü ����");
			
			// 4. ResultSet ���� - executeQuery : select ������ ��� // executeUpdate�� insert,update,delete�� ���
			// �μ���ȣ �������� ����, ���ȣ ���
			String sql = "select rownum RN, empno, ename, "
					+ " 		 job,to_char(hiredate, 'yyyy/mm/dd') hiredate, deptno "
					+ "   	from (select empno, ename, job,hiredate, deptno "
					+ "			  	from emp "
					+ "				order by deptno) ";
			
			ResultSet rs = stmt.executeQuery(sql); // ���⼭���� db �����Ͱ� jvm���� �� ��
			
			// 5. ResultSet ������ ó�� - �ܼ� â�� ���
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.print(rsmd.getColumnName(1)+"\t");
			System.out.print(rsmd.getColumnName(2)+"\t");
			System.out.print(rsmd.getColumnName(3)+"\t");
			System.out.print(rsmd.getColumnName(4)+"\t\t");
			System.out.print(rsmd.getColumnName(5)+"\t");
			System.out.print(rsmd.getColumnName(6)+"\n");
			System.out.println("----------------------------------------------------------");
			while(rs.next()) { // next�޼ҵ带 ���� Ŀ���� ���� ������ �ű�� boolean�� ��ȯ
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getInt(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\t\t");
				System.out.print(rs.getString(5) + "\t"); // yyyy/mm/dd�� ��ȯ
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
