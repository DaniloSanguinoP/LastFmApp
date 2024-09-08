package com.example.lastfmapp.utils;

import java.text.DecimalFormat;

public class FormatUtil {

    public static String FormatNumber(String number) {
        try {
            double numberDouble = Double.parseDouble(number);
            DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
            String formattedNumber = decimalFormat.format(numberDouble);

            return String.format("%s", formattedNumber);
        } catch (NumberFormatException e) {
            return "0";
        }
    }
}
