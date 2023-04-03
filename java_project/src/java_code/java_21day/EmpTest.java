package java_code.java_21day;

import java.util.ArrayList;

public class EmpTest {

	public static void main(String[] args) {
		EmpDao dao = new EmpDao();
		ArrayList<EmpVo> list = dao.getResult();
		String[] colList = dao.getResultColName();
		
		for(String colname : colList) {
			System.out.print(colname + "\t");
		}
		System.out.println();
		for(EmpVo employee : list) {
			System.out.print(employee.getRno() + "\t");
			System.out.print(employee.getEmpno() + "\t");
			System.out.print(employee.getEname() + "\t");
			System.out.print(employee.getJob() + "\t");
			System.out.print(employee.getHiredate() + "\t");
			System.out.print(employee.getDeptno() + "\n");
		}
		
		dao.close();
	}
}
