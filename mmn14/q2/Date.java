import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    /**
     * constructor
     * @param day -> int representing the day
     * @param month -> int representing the month
     * @param year -> int representing the year
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * getter of a day
     * @return int representing the day
     */
    public int getDay() {
        return day;
    }

    /**
     * day setter
     * @param day
     */
    public void setDay(int day) {
        this.day = day;
    }
    /**
     * getter of a month
     * @return int representing the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * month setter
     * @param month
     */
    public void setMonth(int month) {
        this.month = month;
    }
    /**
     * getter of a year
     * @return int representing the year
     */
    public int getYear() {
        return year;
    }
    /**
     * year setter
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * checks if two dates are equal
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day && month == date.month && year == date.year;
    }

    /**
     * used for comparing
     * @return hash code of the date
     */
    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    /**
     * get a list of dates that are valid for each year
     * @param startYear -> start year
     * @param endYear -> end year
     * @return list of valid dates between a range
     */
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

    /**
     * validates the date
     * @return -> if the date is valid
     */
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

    /**
     * checks if this year is a leap year
     * @param year
     * @return whether the year is a leap
     */
    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else return year % 4 == 0;
    }
}

