import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeAndCalendar {
    public static void main(String[] args) {
        // Display the current time
        displayCurrentTime();

        // Display the calendar for the current month
        displayCurrentMonthCalendar();
    }

    private static void displayCurrentTime() {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        
        // Define the format for displaying the time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        // Format the current time
        String formattedTime = now.format(formatter);
        
        // Display the current time
        System.out.println("Current Time: " + formattedTime);
    }

    private static void displayCurrentMonthCalendar() {
        // Get the current year and month
        Calendar now = new GregorianCalendar();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH); // January is 0, December is 11
        
        // Print the month and year
        System.out.println("\nCalendar for " + (month + 1) + "/" + year + ":");
        
        // Print the day headers
        System.out.println("Su Mo Tu We Th Fr Sa");
        
        // Create a calendar instance for the first day of the month
        Calendar calendar = new GregorianCalendar(year, month, 1);
        
        // Find the day of the week for the first day of the month
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);
        
        // Adjust start day to match with our header
        int offset = (startDay == Calendar.SUNDAY) ? 0 : (startDay - Calendar.SUNDAY + 7) % 7;
        
        // Print leading spaces for the first week
        for (int i = 0; i < offset; i++) {
            System.out.print("   ");
        }
        
        // Print the days of the month
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%2d ", day);
            if ((day + offset) % 7 == 0) {
                System.out.println(); // Start a new line for each week
            }
        }
        
        System.out.println(); // Print a newline after the calendar
    }
}
