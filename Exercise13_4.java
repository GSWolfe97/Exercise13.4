/*
 *  Program:    Exercise 13.4
 *  Date:       1/24/18
 *  Developer:  Garrett Wolfe
 *  Purpose:    Rewrite the PrintCalendar class in Listing 6.12 to display a calendar 
                for a specified month using the Calendar and GregorianCalendar classes.
 */
package exercise13_4;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Exercise13_4 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.exit(1);
	}
        Calendar calendar = new GregorianCalendar(Integer.valueOf(args[1]), Integer.valueOf(args[0]) - 1, 1);
        
        printHeader(calendar); 
        
        for (int i = 1; i < calendar.get(Calendar.DAY_OF_WEEK); i++) 
            System.out.print("    ");
        while (calendar.get(Calendar.DATE) <
            calendar.getActualMaximum(Calendar.DATE)) {
            if (calendar.get(Calendar.DAY_OF_WEEK) == 7)
		System.out.printf("%4d\n", calendar.get(Calendar.DATE));
            else
		System.out.printf("%4d", calendar.get(Calendar.DATE));
                calendar.add(Calendar.DATE, 1);
            }
            System.out.printf("%4d\n", calendar.get(Calendar.DATE));
            String[] months = getMonths();
            System.out.println(months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.YEAR) + " contains " + calendar.getActualMaximum(Calendar.DAY_OF_MONTH) + " days.");
    }

    public static String[] getMonths() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return months;
    }

    public static void printHeader(Calendar calendar) {
        String[] months = getMonths();

        int length = 29 / 2 - (months[calendar.get(Calendar.MONTH)].length() / 2 + 3);
        System.out.println();
        for (int i = 0; i < length; i++)
        System.out.print(" ");
        System.out.println(months[calendar.get(Calendar.MONTH)] + ", " + calendar.get(Calendar.YEAR));
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }
}
