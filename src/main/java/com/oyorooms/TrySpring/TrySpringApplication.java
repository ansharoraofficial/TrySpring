package com.oyorooms.TrySpring;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class TrySpringApplication {

	public static void main(String[] args) {
		String dateTime = "2011-12-03T02:15:30+03:00";
		LocalDateTime localDateTime = CustomDateTimeUtil.zonedStringToUTCLocalDateTime(dateTime);
		StringBuilder cronBuilder = new StringBuilder();
		cronBuilder.append(localDateTime.getSecond());
		cronBuilder.append(" ");
		cronBuilder.append(localDateTime.getMinute());
		cronBuilder.append(" ");
		cronBuilder.append(localDateTime.getHour());
		cronBuilder.append(" ? * * *");
		String cron = cronBuilder.toString();
	}

}
