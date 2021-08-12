package com.chalkboard.demo.domain.type;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DateTime {
    private final LocalDateTime value;
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ISO_DATE_TIME;

    public static DateTime from(LocalDateTime dateTime) {
        return new DateTime(dateTime);
    }

    // エラーログでこのオブジェクトが表示されるときや、thymeleafで使用されるときは
    // ObjectクラスのtoString()が使用され、オブジェクトの単なる文字列表現が返される
    // なのでオーバーライドしておく
    @Override
    public String toString() {
        return value.format(formatter);
    }
}