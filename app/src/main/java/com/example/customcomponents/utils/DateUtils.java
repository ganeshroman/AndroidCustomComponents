package com.example.customcomponents.utils;

import android.text.format.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @param @nullable Temp    Explanation
 * @author Ganesh
 * <p>
 * This will be Date Utils.
 * </p>
 * Created by Ganesh Roman on 12,August,2022
 */
public class DateUtils {

    public static final String DATE_INPUT_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_OUTPUT_FORMAT = "MMM d, yyyy";

    public static int compareDate(String str1, String str2, String dateFormat) {
        SimpleDateFormat formatter1 = new SimpleDateFormat(dateFormat);
        SimpleDateFormat formatter2 = new SimpleDateFormat(dateFormat);

        Date date1 = null;
        Date date2 = null;

        try {
            date1 = formatter1.parse(str1);
            date2 = formatter2.parse(str2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date1 != null && date2 != null) {
            return date1.compareTo(date2);
        }
        return 0;
    }

    public static String formattedDateFromString(String inputFormat, String outputFormat, String inputDate) {

        if (inputFormat.equals("")) {
            inputFormat = "yyyy-MM-dd hh:mm:ss";
        }
        if (outputFormat.equals("")) {
            outputFormat = "EEEE d 'de' MMMM 'del' yyyy";
        }
        Date parsed = null;
        String outputDate = "";

        SimpleDateFormat df_input = new SimpleDateFormat(inputFormat, java.util.Locale.getDefault());
        SimpleDateFormat df_output = new SimpleDateFormat(outputFormat, java.util.Locale.getDefault());

        // You can set a different Locale, This example set a locale of Country Mexico.
        //SimpleDateFormat df_input = new SimpleDateFormat(inputFormat, new Locale("es", "MX"));
        //SimpleDateFormat df_output = new SimpleDateFormat(outputFormat, new Locale("es", "MX"));

        try {
            parsed = df_input.parse(inputDate.replace("Z", ""));
            outputDate = df_output.format(parsed);
        } catch (Exception e) {
            LogUtil.logcatE("formattedDateFromString", "Exception in formateDateFromstring(): " + e.getMessage());
            LogUtil.logcatE("Input Format", "" + inputFormat);
            LogUtil.logcatE("Output Format", "" + outputFormat);
            LogUtil.logcatE("Input Date", "" + inputDate);
        }
        if (outputDate != null && outputDate.length() > 0) {
            return outputDate;
        } else {
            return inputDate;
        }
    }


    public static String getDate(long time) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(time);
        String date = DateFormat.format(DATE_OUTPUT_FORMAT, cal).toString();
        return date;
    }


}
