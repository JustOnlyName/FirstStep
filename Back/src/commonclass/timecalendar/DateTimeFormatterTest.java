package commonclass.timecalendar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;

public class DateTimeFormatterTest {
	public static void main(String[] args) {
		//������ SimpleDateFormat
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		
		//��ʽ��������-->�ַ���
		LocalDateTime localDateTime = LocalDateTime.now();
		String str = formatter.format(localDateTime);
		System.out.println(localDateTime); //2020-09-26T16:01:13.292
		System.out.println(str); //2020-09-26T16:01:13.292

		//�������ַ���-->����
		TemporalAccessor parse = formatter.parse("2020-09-26T16:01:13.292");
		System.out.println(parse); //{},ISO resolved to 2020-09-26T16:01:13.292
		
		//�ص㣬�Զ��巽ʽ
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss E");
		//��ʽ��
		String str1 = formatter1.format(LocalDateTime.now());
		System.out.println(str1); //2020-09-26 04:46:45 ������
		
		//����
		TemporalAccessor parse1 = formatter1.parse("2020-09-26 04:46:45 ������");
		System.out.println(parse1); //{SecondOfMinute=45, NanoOfSecond=0, HourOfAmPm=4, MicroOfSecond=0, MilliOfSecond=0, MinuteOfHour=46},ISO resolved to 2020-09-26

		
	}
}
