package vn.codegym.zingmp3.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter implements Formatter<Date> {
    private final SimpleDateFormat formatter;

    public DateFormatter(String pattern) {
        this.formatter = new SimpleDateFormat(pattern);
    }

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        return formatter.parse(text);
    }

    @Override
    public String print(Date object, Locale locale) {
        return formatter.format(object);
    }
}
