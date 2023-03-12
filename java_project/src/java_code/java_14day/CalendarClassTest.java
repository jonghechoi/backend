package java_code.java_14day;
import java.util.Calendar;

public class CalendarClassTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // ���� �ð������� ������ ��ü �����ϰ� cal�� ����
		System.out.println(cal.YEAR); // ��� ��� --> 1
		System.out.println(cal.MONTH);// ��� ��� --> 2
		System.out.println("year - " + cal.get(Calendar.YEAR)); // calendar.YEAR=1 ���
		System.out.println("year - " + cal.get(cal.YEAR)); // calendar.YEAR=1 ���
		System.out.println("month - " + (cal.get(Calendar.MONTH)+1)); 
		System.out.println("date - " + cal.get(Calendar.DATE)); 
		System.out.println(cal.getTime());
	}

}
