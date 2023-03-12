package java_code.java_14day;
import java.util.Calendar;

public class CalendarClassTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // 현재 시간정보를 가져와 객체 생성하고 cal에 담음
		System.out.println(cal.YEAR); // 상수 출력 --> 1
		System.out.println(cal.MONTH);// 상수 출력 --> 2
		System.out.println("year - " + cal.get(Calendar.YEAR)); // calendar.YEAR=1 출력
		System.out.println("year - " + cal.get(cal.YEAR)); // calendar.YEAR=1 출력
		System.out.println("month - " + (cal.get(Calendar.MONTH)+1)); 
		System.out.println("date - " + cal.get(Calendar.DATE)); 
		System.out.println(cal.getTime());
	}

}
