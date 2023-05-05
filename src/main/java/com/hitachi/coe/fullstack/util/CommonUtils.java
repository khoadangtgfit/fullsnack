package com.hitachi.coe.fullstack.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.util.CollectionUtils;

public class CommonUtils {
    private CommonUtils(){}

    /**
     * Partition list sets of N item
     * 
     * @param objects List<T> List input of data
     * @param number int number of item
     * @return new list with N item in each list
     * @param <T> generic type
     */
    public static <T> List<List<T>> nItemPartition(List<T> objects, final int number) {
    	if (CollectionUtils.isEmpty(objects)) {
    		return Collections.emptyList();
    	}
        return new ArrayList<>(IntStream.range(0, objects.size()).boxed()
                .collect(Collectors.groupingBy(e -> e / number, Collectors.mapping(objects::get, Collectors.toList())))
                .values());
    }

    /**
     * Format value for bid decimal number.
     * EX: 0.1 to .1
     * @param sdi BigDecimal
     * @return String
     */
    public static String formatValue(BigDecimal sdi) {
        if(sdi == null){
            return "--";
        }
        String formatSdi = sdi.toString();

        if (sdi.compareTo(BigDecimal.valueOf(0)) >= 0) {
            String subSDI = sdi.toString().substring(0, 1);
            String format = sdi.toString().substring(1);
            if (subSDI.equalsIgnoreCase("0")) {
                formatSdi = format;
            }
        } else {
            String subSDI = sdi.toString().substring(1, 2);
            String format = sdi.toString().substring(2);
            if (subSDI.equalsIgnoreCase("0")) {
                if (sdi.compareTo(BigDecimal.valueOf(0)) < 0) {
                    formatSdi = "-" + format;
                } else {
                    formatSdi = format;
                }
            }
        }
        return formatSdi;
    }

    /**
     * Format number of rounding and remove zero first
     * @param bigDecimal {@link BigDecimal}
     * @param format {@link String}
     * @return String of converted Big decimal
     */
    public static String formatBigDecimal(BigDecimal bigDecimal, String format){
        if(bigDecimal == null){
            return "--";
        }
        String formatTypeString = checkFormatType(format);
        DecimalFormat df = new DecimalFormat(formatTypeString);
        return df.format(bigDecimal);
    }

    /**
     * Check type of big decimal format
     * @param format input Format {@link String}
     * @return new regex to convert
     */
    public static String checkFormatType(String format){
        if(format == null){
            return "#.00";
        }
        if (format.startsWith(".")){
            return "#" + format;
        }
        if (format.startsWith("0")){
            return format;
        }
        return "#.00";
    }

    /**
     * Change format a double to new pattern #.###
     *
     * @param data Double
     * @return Double
     */
    public static double doubleFormatter(Double data) {
        DecimalFormat df = new DecimalFormat("#.####");
        return Double.parseDouble(df.format(data));
    }

    /**
     * Convert date pattern from database (replace D to d, replace Y to y)
     *
     * @param s String
     * @return String
     */
    public static String convertDateYearPattern(String s) {
        s = s.replace("D", "d");
        s = s.replace("Y", "y");
        return s;
    }

}
