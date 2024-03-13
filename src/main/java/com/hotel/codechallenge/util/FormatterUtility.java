package com.hotel.codechallenge.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatterUtility {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static String getDatetime() {
        return LocalDateTime.now().format(formatter);
    }
}