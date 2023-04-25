import java.io.Serializable;
import java.util.Objects;

public class Date implements Serializable {

    private int day;
    private int month;
    private int year;

    //serial version UID
    private static final long serialVersionUID=1L;

    public Date(){

    }

    /**
     * This class contains the date of the match
     * @param day day (1-31)
     * @param month month (1-12)
     * @param year - 2021
     */
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
        if (!(o instanceof Date)) return false;
        Date date = (Date) o;
        return getDay() == date.getDay() && getMonth() == date.getMonth() && getYear() == date.getYear();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDay(), getMonth(), getYear());
    }

    @Override
    public String toString() {
        return "Date -> " +
                "\nday: " + day +
                "\nmonth: " + month +
                "\nyear: " + year;
    }
}
