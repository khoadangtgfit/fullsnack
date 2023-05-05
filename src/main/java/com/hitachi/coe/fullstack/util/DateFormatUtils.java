package com.hitachi.coe.fullstack.util;

import lombok.SneakyThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static com.hitachi.coe.fullstack.constant.Constants.DATE_FORMAT;
import static com.hitachi.coe.fullstack.constant.Constants.UTC_TIME_ZONE;

public class DateFormatUtils {
     private DateFormatUtils(){}

    /**
     * Convert Date at site time zone to Date at UTC 0
     * @param date input date - site time zone
     * @param siteTimeZone site time zone
     * @return output date - UTC
     * @throws ParseException 
     */
    @SneakyThrows
    public static Date convertDateFromSiteTimeZoneToGMT(Date date, String siteTimeZone) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        String timeStringInSite =  sdf.format(date);

        SimpleDateFormat dateFormatSite = new SimpleDateFormat(DATE_FORMAT);
        SimpleDateFormat dateFormatUTC = new SimpleDateFormat(DATE_FORMAT);
        dateFormatSite.setTimeZone(TimeZone.getTimeZone(siteTimeZone));
        dateFormatUTC.setTimeZone(TimeZone.getTimeZone(UTC_TIME_ZONE));

        Date dateInSite = dateFormatSite.parse(timeStringInSite);

        return sdf.parse(dateFormatUTC.format(dateInSite));
    }

}
