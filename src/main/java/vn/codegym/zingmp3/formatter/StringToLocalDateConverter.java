package vn.codegym.zingmp3.formatter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringToLocalDateConverter implements Converter<String, LocalDate> {
    private final DateTimeFormatter formatter;

    public StringToLocalDateConverter(String pattern) {
        formatter = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    public LocalDate convert(String source) {
        return LocalDate.parse(source, formatter);
    }
}
