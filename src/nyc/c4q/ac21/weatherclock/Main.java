package nyc.c4q.ac21.weatherclock;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;

public class Main {

    /**
     * SAMPLE CODE: Returns sunset time for the current day.
     */
    public static Calendar getSunset() {


        URL url = HTTP.stringToURL("http://api.openweathermap.org/data/2.5/weather?q=New%20York,NY");
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

        URL url = HTTP.stringToURL("http://api.openweathermap.org/data/2.5/weather?q=New%20York,NY");
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

        JSONParser parser = new JSONParser();
        JSONObject weather_json_obj = (JSONObject)parser.parse(new FileReader("/Users/alvin2/Desktop/accesscode/weatherclock/json-files/weather.json"));

        // FIXME: get way to pull API data from URL!!
        URL webUrl = HTTP.stringToURL(
                "http://api.openweathermap.org/data/2.5/weather?q=New%20York,NY");


        // Find out the size of the terminal currently.
        final int numCols = TerminalSize.getNumColumns();
        final int numRows = TerminalSize.getNumLines();

        // Create the terminal.
        final AnsiTerminal terminal = new AnsiTerminal();

        // When the program shuts down, reset the terminal to its original state.
        // This code makes sure the terminal is reset even if you kill your
        // program by pressing Control-C.
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                terminal.showCursor();
                terminal.reset();
                terminal.scroll(1);
                terminal.moveTo(numRows, 0);
            }
        });

        // Clear the screen to black.
        terminal.setBackgroundColor(AnsiTerminal.Color.BLACK);
        terminal.clear();
        // Don't show the cursor.
        terminal.hideCursor();

        // Get sunset time for the current day.
        Calendar sunset = getSunset();


        // Get sunrise time for the current day.
        Calendar sunrise = getSunrise();


        int xPosition = 1 + numCols / 2 - 5;
        while (true) {
            // Get the current date and time.
            Calendar cal = Calendar.getInstance();

            // Write the time, including seconds, in white.
            String time = DateTime.formatTime(cal, true);
            if (cal.get(Calendar.HOUR_OF_DAY) >= 12)
                time += " PM";
            else
                time += " AM";
            terminal.setTextColor(AnsiTerminal.Color.WHITE);
            terminal.moveTo(3, xPosition);
            terminal.write(time);

            // Write the date in gray.
            String date = DateTime.formatDate(cal);
            terminal.setTextColor(AnsiTerminal.Color.WHITE, false);
            terminal.moveTo(5, xPosition);
            terminal.write(date);

            // Write the day of the week in green on a blue background.
            String dayOfWeek = DateTime.getDayOfWeekNames().get(cal.get(Calendar.DAY_OF_WEEK));
            terminal.setTextColor(AnsiTerminal.Color.GREEN);
            terminal.setBackgroundColor(AnsiTerminal.Color.BLUE);
            terminal.moveTo(7, xPosition);
            terminal.write("  " + dayOfWeek + "  ");

            // Set the background color back to black.
            terminal.setBackgroundColor(AnsiTerminal.Color.BLACK);

            // Write sunset time in dark yellow.
            String sunsetTime = DateTime.formatTime(sunset, false) + " PM";
            terminal.setTextColor(AnsiTerminal.Color.YELLOW, false);
            terminal.moveTo(9, xPosition - 2);
            terminal.write("Sunset Time: " + sunsetTime);

            //
            //
            //
            // Write sunrise time in dark yellow.
            String sunriseTime = DateTime.formatTime(sunrise, false) + " AM";
            terminal.setTextColor(AnsiTerminal.Color.YELLOW, false);
            terminal.moveTo(10, xPosition - 2);
            terminal.write("Sunrise Time: " + sunriseTime);
            //
            //
            //
            //


            // Pause for one second, and do it again.

            // FIXME: this changes the delay in displaying whatever comes after it!
            //DateTime.pause(1.0);


            int y = 12;
            for (int i = 0; i < CalendarPrinter.printMonthCalendar(cal).size(); i++) {
                terminal.moveTo(y,xPosition);
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


            JSONObject tempObj = (JSONObject) weather_json_obj.get("main");
            JSONArray weatherArray = (JSONArray) weather_json_obj.get("weather");
            JSONObject weatherHash = (JSONObject) weatherArray.get(0);




            terminal.moveTo(19, xPosition);
            terminal.setTextColor(AnsiTerminal.Color.WHITE, true);
            terminal.write("---- CURRENT WEATHER INFO ----");

            Double temperature = (Double)tempObj.get("temp");
            temperature = ((temperature  - 273.15) * 1.8000 + 32);
            terminal.moveTo(21, xPosition);
            terminal.write("Temperature is currently: " + temperature + " °F");

            Double pressure = (Double) tempObj.get("pressure");
            pressure = pressure * 0.02952998751;
            terminal.moveTo(23 ,xPosition);
            terminal.write("Air Pressure is currently: " + pressure + " inHG");

            Long humidity = (Long) tempObj.get("humidity");
            terminal.moveTo(25 ,xPosition);
            terminal.write("Humidity is currently: " + humidity + " %");


            // ASCII ART FOR WEATHER SHOULD GO HERE...

            String weather = (String) weatherHash.get("main");
            terminal.moveTo(277 ,xPosition);
            terminal.write("Current weather: " + weather);

            String weatherDescrip = (String) weatherHash.get("description");
            terminal.moveTo(31 ,xPosition);
            terminal.write("Sky description: " + weatherDescrip);




        }
    }
}
