package commonclass.timecalendar;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class InstantTest {
	public static void main(String[] args) {
		Instant instant = Instant.now();
		System.out.println(instant); //2020-09-26T03:36:33.893Z
		
		//����ʱ����ƫ����
		OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
		System.out.println(offsetDateTime); //2020-09-26T12:17:47.966+08:00
		
		//��ȡ˲ʱ��ĺ�����/ʱ���
		long milli = instant.toEpochMilli();
		System.out.println(milli); //����Date ����getTime() 
		
		Instant instant1 = Instant.ofEpochMilli(milli+100000L);
		System.out.println(instant1); //2020-09-26T04:23:42.902Z
	}
}
