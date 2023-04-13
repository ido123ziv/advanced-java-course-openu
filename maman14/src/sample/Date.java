package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day && month == date.month && year == date.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    public static List<Date> getValidDates(int startYear, int endYear) {
        List<Date> validDates = new ArrayList<>();

        for (int year = startYear; year <= endYear; year++) {
            for (int month = 1; month <= 12; month++) {
                int daysInMonth;
                switch (month) {
                    case 2:
                        daysInMonth = isLeapYear(year) ? 29 : 28;
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        daysInMonth = 30;
                        break;
                    default:
                        daysInMonth = 31;
                        break;
                }
                for (int day = 1; day <= daysInMonth; day++) {
                    Date date = new Date(year, month, day);
                    if (date.isValidDate()) {
                        validDates.add(date);
                    }
                }
            }
        }

        return validDates;
    }

    public boolean isValidDate() {
        // Check if year is valid
        if (year < 1) {
            return false;
        }

        // Check if month is valid
        if (month < 1 || month > 12) {
            return false;
        }

        // Check if day is valid
        int daysInMonth;
        switch (month) {
            case 2:
                daysInMonth = isLeapYear(year) ? 29 : 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = 30;
                break;
            default:
                daysInMonth = 31;
                break;
        }
        return day >= 1 && day <= daysInMonth;
    }

    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else return year % 4 == 0;
    }
}

