package com.oyorooms.TrySpring;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CustomDateTimeUtil {

  public final static String UTC_ZONE_ID = "Z";

  public final static String DATE_FORMATTER_WITH_ZONE = "yyyy-MM-dd HH:mm:ss Z";
  public final static String DD_MM_YYYY = "yyyy-MM-dd";
  public final static String DD_MMM_YYYY = "dd MMM yyyy";

  /**
   * @param date - 2018-01-10T01:02:03.456+05:30
   * @return
   */
  public static LocalDateTime zonedStringToUTCLocalDateTime(String date) {
    return convertToOtherTimeZone(ZoneId.of("UTC"),
        ZonedDateTime.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME));
  }

  /**
   * @param date - 2018-01-10T01:02:03.456+05:30
   * @return
   */
  public static String zonedStringToZoneId(String date) {
    try {
      return ZonedDateTime.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME).getZone().toString();
    } catch (Exception e) {
      return UTC_ZONE_ID;
    }
  }

  public static LocalDateTime covertFromOneTimeZoneToAnother(LocalDateTime date,
                                                             ZoneId from,
                                                             ZoneId to) {
    ZonedDateTime fromZoneDateTime = date.atZone(from);
    return convertToOtherTimeZone(to, fromZoneDateTime);
  }

  /**
   * @param to
   * @param fromZoneDateTime
   * @return
   */
  private static LocalDateTime convertToOtherTimeZone(ZoneId to, ZonedDateTime fromZoneDateTime) {
    ZonedDateTime toZoneDateTime = fromZoneDateTime.withZoneSameInstant(to);
    return toZoneDateTime.toLocalDateTime();
  }

  public static String zonedDateTimeStringFromLocalDateTimeAndZoneId(LocalDateTime date,
                                                                     String zoneId) {
    return date.atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of(zoneId))
        .format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
  }

  public static LocalDate zonedStringToLocalDate(String zonedDateTime) {
    return ZonedDateTime.parse(zonedDateTime, DateTimeFormatter.ISO_OFFSET_DATE_TIME).toLocalDate();
  }

  public static LocalDateTime zonedStringToUTCLocalDateTimeWithCustomFormatter(String date, String formatter) {
    return convertToOtherTimeZone(ZoneId.of("UTC"),
        ZonedDateTime.parse(date, DateTimeFormatter.ofPattern(formatter)));
  }

}
