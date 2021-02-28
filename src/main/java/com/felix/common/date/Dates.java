package com.felix.common.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.LongFunction;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.util.Objects.requireNonNull;

/**
 * Class that contains methods for working with {@link Date}.
 */
public class Dates {

    /**
     * Create a {@link Date} object by arguments.
     * @param year year.
     * @param month month.
     * @param day day.
     * @return instance of {@link Date}.
     */
    public static Date of(int year, int month, int day) {
        return toDate(LocalDate.of(year, month, day));
    }

    /**
     * Create a {@link Date} object by arguments.
     * @param year year.
     * @param month month.
     * @param day day.
     * @param hour hour.
     * @param minute minute.
     * @param second second.
     * @return instance of {@link Date}.
     */
    public static Date of(int year, int month, int day, int hour, int minute, int second) {
        return toDate(LocalDateTime.of(year, month, day, hour, minute, second));
    }

    /**
     * Create a {@link Date} object by arguments.
     * @param year year.
     * @param month month.
     * @param day day.
     * @param hour hour.
     * @param minute minute.
     * @return instance of {@link Date}.
     */
    public static Date of(int year, int month, int day, int hour, int minute) {
        return toDate(LocalDateTime.of(year, month, day, hour, minute, 0));
    }

    /**
     * Convert a {@link LocalDate} to {@link Date}.
     * @param localDate {@link LocalDate} to conversion.
     * @return instance of {@link Date}.
     */
    public static Date toDate(LocalDate localDate) {
        requireNonNull(localDate, "localDate is null.");
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Convert a {@link LocalDate} to {@link Date}.
     * @param localDateTime {@link LocalDateTime} to conversion.
     * @return instance of {@link Date}.
     */
    public static Date toDate(LocalDateTime localDateTime) {
        requireNonNull(localDateTime, "localDateTime is null.");
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Returns a day of month by date.
     * @param date date.
     * @return day of month.
     */
    public static int getDayOfMonth(Date date) {
        requireNonNull(date, "Date is null.");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Returns a month by date.
     * @param date date.
     * @return month value, start of 1.
     */
    public static int getMonth(Date date) {
        requireNonNull(date, "Date is null.");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * Returns a year by date.
     * @param date date.
     * @return year value.
     */
    public static int getYear(Date date) {
        requireNonNull(date, "Date is null.");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * Convert a {@link Date} to {@link LocalDate}.
     * @param date date to conversion.
     * @return instance of {@link LocalDate}.
     */
    public static LocalDate toLocalDate(Date date) {
        requireNonNull(date, "Date is null.");
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Convert a {@link Date} to {@link LocalDateTime}.
     * @param date date to conversion.
     * @return instance of {@link LocalDateTime}.
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        requireNonNull(date, "Date is null.");
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * Format a {@link Date}.
     * @param date date to format.
     * @param format format.
     * @return String with formatted date.
     */
    public static String format(Date date, String format) {
        requireNonNull(date, "Date is null.");
        requireNonNull(format, "Format is null.");
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * Format a {@link LocalDate}.
     * @param date date to format.
     * @param format format.
     * @return String with formatted date.
     */
    public static String format(LocalDate date, String format) {
        requireNonNull(date, "Date is null.");
        requireNonNull(format, "Format is null.");
        return date.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * Format a {@link LocalDateTime}.
     * @param date date to format.
     * @param format format.
     * @return String with formatted date.
     */
    public static String format(LocalDateTime date, String format) {
        requireNonNull(date, "Date is null.");
        requireNonNull(format, "Format is null.");
        return date.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * Returns instance of {@link Date} from a {@link String} with formatted date.
     * @param date formatted date.
     * @param format format.
     * @return instance of {@link Date}.
     */
    public static Date parseDate(String date, String format) {
        requireNonNull(date, "Date is null.");
        requireNonNull(format, "Format is null.");
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid format.");
        }
    }

    /**
     * Returns a list of {@link LocalDate} between start and end date.
     * @param start start date.
     * @param end end date.
     * @param chrono type of interval(Days, Months, Years).
     * @return a list of {@link LocalDate} by interval.
     */
    public static List<LocalDate> getInterval(LocalDate start, LocalDate end, ChronoUnit chrono) {
        requireNonNull(start, "Start date is null.");
        requireNonNull(end, "End date is null.");
        requireNonNull(chrono, "ChronoUnit is null.");

        if (start.isAfter(end))
            throw new IllegalArgumentException("Start date is after end date.");

        LongFunction<LocalDate> incrementDate = i -> {
            switch (chrono) {
                case DAYS: return start.plusDays(i);
                case MONTHS: return start.plusMonths(i);
                case YEARS: return start.plusYears(i);
                default: return null;
            }
        };

        return LongStream.range(0, chrono.between(start, end) + 1)
                .mapToObj(incrementDate)
                .collect(Collectors.toList());
    }

    /**
     * Returns a list of {@link LocalDateTime} between start and end date.
     * @param start start date.
     * @param end end date.
     * @param chrono type of interval(Days, Months, Years, Hours, Minutes, Seconds).
     * @return a list of {@link LocalDateTime} by interval.
     */
    public static List<LocalDateTime> getInterval(LocalDateTime start, LocalDateTime end, ChronoUnit chrono) {
        requireNonNull(start, "Start date is null.");
        requireNonNull(end, "End date is null.");
        requireNonNull(chrono, "ChronoUnit is null.");

        if (start.isAfter(end))
            throw new IllegalArgumentException("Start date is after end date.");

        LongFunction<LocalDateTime> incrementDate = i -> {
            switch (chrono) {
                case DAYS: return start.plusDays(i);
                case MONTHS: return start.plusMonths(i);
                case YEARS: return start.plusYears(i);
                case HOURS: return start.plusHours(i);
                case MINUTES: return start.plusMinutes(i);
                case SECONDS: return start.plusSeconds(i);
                default: return null;
            }
        };

        return LongStream.range(0, chrono.between(start, end) + 1)
                .mapToObj(incrementDate)
                .collect(Collectors.toList());
    }
}
