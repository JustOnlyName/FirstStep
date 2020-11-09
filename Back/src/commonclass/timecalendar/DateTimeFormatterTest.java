package commonclass.timecalendar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;

public class DateTimeFormatterTest {
	public static void main(String[] args) {
		//类似于 SimpleDateFormat
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		
		//格式化：日期-->字符串
		LocalDateTime localDateTime = LocalDateTime.now();
		String str = formatter.format(localDateTime);
		System.out.println(localDateTime); //2020-09-26T16:01:13.292
		System.out.println(str); //2020-09-26T16:01:13.292

		//解析：字符串-->日期
		TemporalAccessor parse = formatter.parse("2020-09-26T16:01:13.292");
		System.out.println(parse); //{},ISO resolved to 2020-09-26T16:01:13.292
		
		//重点，自定义方式
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss E");
		//格式化
		String str1 = formatter1.format(LocalDateTime.now());
		System.out.println(str1); //2020-09-26 04:46:45 星期六
		
		//解析
		TemporalAccessor parse1 = formatter1.parse("2020-09-26 04:46:45 星期六");
		System.out.println(parse1); //{SecondOfMinute=45, NanoOfSecond=0, HourOfAmPm=4, MicroOfSecond=0, MilliOfSecond=0, MinuteOfHour=46},ISO resolved to 2020-09-26

		
	}
}
