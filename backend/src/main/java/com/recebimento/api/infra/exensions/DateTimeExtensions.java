package com.recebimento.api.infra.exensions;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateTimeExtensions {

    public static LocalDateTime BrazilTimeZone() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        return LocalDateTime.from(LocalDateTime.parse(formattedDateTime, formatter).atOffset(ZoneOffset.of("-03:00")));
    }
}
