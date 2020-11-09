package commonclass.timecalendar;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getClass());
		
		//getTime() ：日历类 --> Date
		Date date = calendar.getTime();
		System.out.println(date);
		
		//setTime() ：Date --> 日历类
		Date date1 = new Date();
		calendar.setTime(date1);
		int day = calendar.get(Calendar.DAY_OF_YEAR); //年中的第几天
		System.out.println(day);
		//这样day 可以加减，即先sdf 格式成一个 util.Date
		//再setTime 设置calendar 的时间，获取day
		
		System.out.println(new Date(2020,9,8));
//		Fri Oct 08 00:00:00 CST 3920
	}
}
