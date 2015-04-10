package nyc.c4q.ac21.weatherclock;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Calendar;

public class Main {

    /**
     * SAMPLE CODE: Returns sunset time for the current day.
     */
    public static Calendar getSunset() {


        URL url = HTTP.stringToURL("http://api.openweathermap.org/data/2.5/weather?zip=94555,us");
        // URL url = HTTP.stringToURL("http://api.openweathermap.org/data/2.5/weather?q=New%20York,NY");

        String doc = HTTP.get(url);
        JSONObject obj = (JSONObject) JSONValue.parse(doc);

        JSONObject sys = (JSONObject) obj.get("sys");
        if (sys == null)
            return null;
        Long sunsetTimestamp = (Long) sys.get("sunset");
        if (sunsetTimestamp == null)
            return null;
        return (DateTime.fromTimestamp(sunsetTimestamp));
    }




    //
    //
    //
    //
    //
    public static Calendar getSunrise() {

        URL url = HTTP.stringToURL("http://api.openweathermap.org/data/2.5/weather?zip=94555,us");
        // URL url = HTTP.stringToURL("http://api.openweathermap.org/data/2.5/weather?q=New%20York,NY");

        String doc = HTTP.get(url);
        JSONObject obj = (JSONObject) JSONValue.parse(doc);

        JSONObject sys = (JSONObject) obj.get("sys");
        if (sys == null)
            return null;
        Long sunriseTimestamp = (Long) sys.get("sunrise");
        if (sunriseTimestamp == null)
            return null;
        return DateTime.fromTimestamp(sunriseTimestamp);
    }
    //
    //
    //
    //
    //


    /**
     * SAMPLE CODE: Displays a very primitive clock.
     */
    public static void main(String[] args) throws IOException, ParseException
    {


        // Find out the size of the terminal currently.
        final int numCols = TerminalSize.getNumColumns();
        final int numRows = TerminalSize.getNumLines();

        // Create the terminal.
        final AnsiTerminal terminal = new AnsiTerminal();

        // When the program shuts down, reset the terminal to its original state.
        // This code makes sure the terminal is reset even if you kill your
        // program by pressing Control-C.
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            public void run()
            {
                terminal.showCursor();
                terminal.reset();
                terminal.scroll(1);
                terminal.moveTo(numRows, 0);
            }
        });

        terminal.moveTo(1,1);
        terminal.write("weather clock");

        // Clear the screen to black.
        terminal.setBackgroundColor(AnsiTerminal.Color.BLACK);
        terminal.clear();
        // Don't show the cursor.
        terminal.hideCursor();

        // Get sunset time for the current day.
        Calendar sunset = getSunset();


        // Get sunrise time for the current day.
        Calendar sunrise = getSunrise();


        // int xPosition = 1 + numCols / 2 - 5;
        while (true) {
            // Get the current date and time.
            Calendar cal = Calendar.getInstance();

            // Write the time, including seconds, in white.

            terminal.setTextColor(AnsiTerminal.Color.BLUE);
            terminal.moveTo(5, 94);
            terminal.write("**** CURRENT TIME ****");

            terminal.moveTo(9, 94);
            terminal.write("**********************");




            String time = DateTime.formatTime(cal, true);
            if (cal.get(Calendar.HOUR_OF_DAY) >= 12)
                time += " PM";
            else
                time += " AM";
            terminal.setTextColor(AnsiTerminal.Color.RED);
            terminal.moveTo(7, 100);
            terminal.write(time);



            terminal.setTextColor(AnsiTerminal.Color.WHITE);
            terminal.moveTo(13, 86);
            terminal.write("Have a GRRRREEEAAAATTTTT day, C4Q-ers!!!");

            terminal.setTextColor(AnsiTerminal.Color.MAGENTA);
            terminal.moveTo(15, 100);
            terminal.write("^_________^");



            // Write the date in gray.
            String date = DateTime.formatDate(cal);
            // date = (cal.MONTH + "/" + cal.DAY_OF_MONTH + "/" + cal.YEAR);
            terminal.setTextColor(AnsiTerminal.Color.WHITE, false);
            terminal.moveTo(5, 4);
            terminal.write(date);

            // Write out the Holiday.
            terminal.moveTo(7, 4);
            terminal.write(Holidays.getHolidays(date));


            // Write out if DST is active
            if(DST.isDST(DateTime.parseDate(date))){
                terminal.moveTo(14, 4);
                terminal.write("DST is IN EFFECT");
            }else{
                terminal.moveTo(14, 4);
                terminal.write("DST is NOT IN EFFECT");
            }



            String dayOfWeek = DateTime.getDayOfWeekNames().get(cal.get(Calendar.DAY_OF_WEEK));
            terminal.setTextColor(AnsiTerminal.Color.WHITE);
            terminal.setBackgroundColor(AnsiTerminal.Color.BLUE);
            terminal.moveTo(5, 17);
            terminal.write("  " + dayOfWeek + "  ");

            // Set the background color back to black.
            terminal.setBackgroundColor(AnsiTerminal.Color.BLACK);


            //
            //
            //
            // Write sunrise time in dark yellow.
            String sunriseTime = DateTime.formatTime(sunrise, false) + " AM";
            terminal.setTextColor(AnsiTerminal.Color.YELLOW, false);
            terminal.moveTo(11, 4);
            terminal.write("Sunrise Time: " + sunriseTime);
            //
            //
            //
            //


            // Write sunset time in dark yellow.
            String sunsetTime = DateTime.formatTime(sunset, false) + " PM";
            terminal.setTextColor(AnsiTerminal.Color.YELLOW, false);
            terminal.moveTo(9, 4);
            terminal.write("Sunset Time: " + sunsetTime);



            int y = 20;
            for (int i = 0; i < CalendarPrinter.printMonthCalendar(cal).size(); i++) {
                terminal.setTextColor(AnsiTerminal.Color.MAGENTA, false);
                terminal.moveTo(y, 4);
                terminal.write(CalendarPrinter.printMonthCalendar(cal).get(i));
                y++;
            }

            //
            //
            //
            //
            //
            //
            //
            //
            //
            //
            //
            //
            // Alvin's part! (TEMP STUFF!!)

            URL url = HTTP.stringToURL(
                    "http://api.openweathermap.org/data/2.5/weather?zip=94555,us");
            String doc = HTTP.get(url);
            JSONObject obj = (JSONObject) JSONValue.parse(doc);

            JSONObject tempObj = (JSONObject) obj.get("main");
            JSONArray weatherArray = (JSONArray) obj.get("weather");
            JSONObject weatherHash = (JSONObject) weatherArray.get(0);


            DecimalFormat f = new DecimalFormat();
            f.setMaximumFractionDigits(1);


            terminal.moveTo(5, 40);
            terminal.setTextColor(AnsiTerminal.Color.RED, true);
            terminal.write("---- CURRENT WEATHER INFO ----");

            // temperature

            terminal.setTextColor(AnsiTerminal.Color.CYAN, true);
            Double temperature = (Double)tempObj.get("temp");
            temperature = (((temperature  - 273) * 1.8) + 32);
            terminal.moveTo(9, 40);
            terminal.write("Temperature is currently: " + f.format(temperature) + "°F");


            // pressure

            Double pressure = (Double) tempObj.get("pressure");
            pressure = pressure * 0.02952998751;
            terminal.moveTo(11, 40);
            terminal.write("Air Pressure is currently: " +  f.format(pressure) + " inHG");


            // humidity

            Long humidity = (Long) tempObj.get("humidity");
            humidity.toString();
            terminal.moveTo(13 , 40);
            terminal.write("Humidity is currently: " + humidity + " %");



            // current weather info

            String weather = (String) weatherHash.get("main");
            terminal.moveTo(15 , 40);
            terminal.write("Current weather: " + weather);

            String weatherDescrip = (String) weatherHash.get("description");
            terminal.moveTo(17 , 40);
            terminal.write("Sky description: " + weatherDescrip);


            // Print out current weather graphic
            y = 20;
            for (int i = 0; i < WeatherDrawings.printCloud().size(); i++)
            {
                terminal.setTextColor(AnsiTerminal.Color.WHITE);
                terminal.moveTo(y, 40);
                terminal.write(WeatherDrawings.printCloud().get(i));
                y++;
            }




            // Print Sun or Moon

            y = 19;
            if (cal.get(Calendar.HOUR_OF_DAY) >= 12) {
                for (int i = 0; i < WeatherDrawings.printMoon().size(); i++) {
                    terminal.moveTo(y, 80);
                    terminal.write(WeatherDrawings.printMoon().get(i));
                    y++;
                }
            } else if (cal.get(Calendar.HOUR_OF_DAY) <=12) {
                for (int i = 0; i < WeatherDrawings.printSun().size(); i++) {
                    terminal.moveTo(y, 80);
                    terminal.write(WeatherDrawings.printSun().get(i));
                    y++;
                }
            }



            // Print title
            y = 30;
            for (int i = 0; i < WeatherDrawings.titleProject().size(); i++)
            {
                terminal.setTextColor(AnsiTerminal.Color.GREEN);
                terminal.moveTo(y, 10);
                terminal.write(WeatherDrawings.titleProject().get(i));
                y++;
            }


            
        }
    }
}
