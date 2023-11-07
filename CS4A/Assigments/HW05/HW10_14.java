/*
    Design a class named MyDate. The class contains:
■ The data fields year, month, and day that represent a date. month is 0-based, i.e., 0 is for January.
■ A no-arg constructor that creates a MyDate object for the current date.
■ A constructor that constructs a MyDate object with a specified elapsed time since midnight, January 1, 1970, in milliseconds.
■ A constructor that constructs a MyDate object with the specified year, month, and day.
■ Three getter methods for the data fields year, month, and day, respectively.
■ A method named setDate(long  elapsedTime) that sets a new date for the object using the elapsed time.
*/
import java.util.Calendar;
import java.util.GregorianCalendar;

public class HW10_14 {
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        MyDate date1 = new MyDate();
        MyDate date2 = new MyDate(34355555133101L);

        System.out.println("Date1 - Month: " + date1.getMonth() +
                " Day: " + date1.getDay() + " Year: " + date1.getYear());
        System.out.println("Date2 - Month: " + date2.getMonth() +
                " Day: " + date2.getDay() + " Year: " + date2.getYear());
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate() {
        GregorianCalendar cal = new GregorianCalendar();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
    }

    public MyDate(long elapsedTime) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(elapsedTime);
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setDate(long elapsedTime) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTimeInMillis(elapsedTime);
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
    }
}