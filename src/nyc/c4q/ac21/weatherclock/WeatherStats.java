package nyc.c4q.ac21.weatherclock;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.net.URL;
import java.util.HashMap;

/**
 * Created by alvin2 on 4/9/15.
 * Alvin Kuang
 * C4Q Access Code 2.1
 */
public class WeatherStats
{
/*
    public static String getConditions() {
        URL url = HTTP.stringToURL("http://api.openweathermap.org/data/2.5/weather?q=New%20York,NY");
        String doc = HTTP.get(url);
        JSONObject obj = (JSONObject) JSONValue.parse(doc);

        JSONObject sys = (JSONObject) obj.get("weather");
        String conditions = "" + sys.get("description");

        if (conditions.contains("rain"))
            return "Grab Your Poncho!";
        else if (conditions.contains("clear sky"))
            return "Oh Sunny Day!";
        else if (conditions.contains("thunder"))
            return "Hide Yo Kids Hide Yo Wife there's a thunderstorm tonight!";
        else if (conditions.contains("snow"))
            return "It's Snowing!";
        else if (conditions.contains("clouds"))
            return "The Sun is hiding!";
        else if (conditions.contains("mist"))
            return "A little Misty, no Staryu";
        else return null;
    }
*/
}
