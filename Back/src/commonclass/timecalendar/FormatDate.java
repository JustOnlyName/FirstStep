package commonclass.timecalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date date = new Date();
		System.out.println(date);
		String format = sdf.format(date);
		System.out.println(format);
		try {
			Date date1 = sdf.parse(format);
			System.out.println(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String format1 = sdf1.format(date);
		System.out.println(format1);
		//½âÎö
		try {
			Date date2 = sdf1.parse("2020-02-18 11:48:22");
			System.out.println(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
}
