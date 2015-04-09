package nyc.c4q.ac21.weatherclock;

import java.util.ArrayList;
import java.util.Calendar;

public class CalendarPrinter
{

    /**
     * Prints a calendar for a month.
     *
     * Prints the calendar in the traditional format with one week per line.
     * Each week starts on Sunday and shows the days of month for days in
     * that week.  The current date is marked with an asterisk.
     *
     * For example, for 2015-04-03, prints this:
     *
     *     April 2015
     *                  1   2   3*  4
     *      5   6   7   8   9  10  11
     *     12  13  14  15  16  17  18
     *     19  20  21  22  23  24  25
     *     26  27  28  29  30
     *
     * @param date
     *   The date containing the month to print.
     */
    public static ArrayList<String> printMonthCalendar(Calendar date) {
        // Extract year, month, and day for our date.
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH);
        int day = date.get(Calendar.DAY_OF_MONTH);
        ArrayList<String> lines = new ArrayList<String>();
        String list="";

        // First, show the month name and year.
        list+=(DateTime.getMonthNames().get(month) + " " + year+"\n");
        lines.add(list);
        list="";

        // Start the calendar on the first day of the month.
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, 1);

        // We may need to indent the first line, since some of the days
        // in the first week may not belong to this month.
        int indent = cal.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY;
        for (int i = 0; i < indent; ++i)
            // We use four spaces for each day, below.
            list+=("    ");

        // Now print each day of the month.  Keep going until we hit the next month.
        while (cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) == month)
        {
            // Print the day of the month.  Make sure to always print exactly
            // two characters.
            int d = cal.get(Calendar.DAY_OF_MONTH);
            if(d < 10) list += (" ");
            list += (String.valueOf(d));

            if(d == day)
                // Today!  Mark the day.
                list += ("*");
            else
                // Not today; leave some space.
                list += (" ");

            if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            {
                // Saturday: move on to the next line for the next date.
                list += "\n";
                lines.add(list);
                list="";
            }

            else
                // Other days: just leave an extra space.
                list+=(" ");

            // On to the next day.
            cal = DateTime.getNextDay(cal);
        }
        list+=("\n");
        lines.add(list);
        return lines;
    }

}
