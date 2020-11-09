package commonclass.timecalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExer {
	public static void main(String[] args) {
		String birth = "2020-01-21";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = sdf.parse(birth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		java.sql.Date birthDate = new java.sql.Date(date.getTime());
		System.out.println(birthDate);
	}
}
