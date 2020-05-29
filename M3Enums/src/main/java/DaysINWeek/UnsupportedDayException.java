package DaysINWeek;

public class UnsupportedDayException extends Exception {

    public UnsupportedDayException() {
        super("Not a valid day of the week");
    }
}
