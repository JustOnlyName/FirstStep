package commonclass.timecalendar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalTimeTest {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		System.out.println(localDate);
		System.out.println(localTime);
		System.out.println(localDateTime);
//		2020-09-24
//		23:21:04.292
//		2020-09-24T23:21:04.292
		
		//of()  方法没有偏移量
		LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 1, 20, 30);
		System.out.println(localDateTime1);
//		2020-10-01T20:30
		
		//体现localDate 的不可变性
		LocalDate localDate1 = localDate.withDayOfMonth(22);
		System.out.println(localDate); //2020-09-25
		System.out.println(localDate1); //2020-09-22
	}
}
