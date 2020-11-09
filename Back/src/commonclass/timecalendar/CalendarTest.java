package commonclass.timecalendar;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getClass());
		
		//getTime() �������� --> Date
		Date date = calendar.getTime();
		System.out.println(date);
		
		//setTime() ��Date --> ������
		Date date1 = new Date();
		calendar.setTime(date1);
		int day = calendar.get(Calendar.DAY_OF_YEAR); //���еĵڼ���
		System.out.println(day);
		//����day ���ԼӼ�������sdf ��ʽ��һ�� util.Date
		//��setTime ����calendar ��ʱ�䣬��ȡday
		
		System.out.println(new Date(2020,9,8));
//		Fri Oct 08 00:00:00 CST 3920
	}
}
