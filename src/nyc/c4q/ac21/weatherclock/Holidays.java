package nyc.c4q.ac21.weatherclock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Holidays {

    /**
     * Loads holidays from a file.
     *
     * //@param holidayType
     *   The type of holiday.  Use "National holiday" for U.S. federal holidays.
     * @return
     *   A map from date to holiday name for holidays.
     */
    public static String getHolidays(String date) {
        String holidays="";
        ArrayList<String> lines = FileTools.readLinesFromFile("holidays.csv");
        HashMap<String, String> map=new HashMap<String, String>();
        int comma1 = lines.get(1).indexOf(',');
        ArrayList<String> dates=new ArrayList<String>();
        //line.substring(0, comma1);
        ArrayList<String> name = new ArrayList<String>();

        for(int i=0; i<lines.size();i++){
            dates.add(lines.get(i).substring(0,comma1));
        }
        for(int i=0; i<lines.size();i++){
            name.add(lines.get(i).substring(comma1 + 1));
        }

        //line.substring(comma1 + 1, comma2);
        for(int i=0; i<dates.size();i++)
        {
            int comma2 = lines.get(i).indexOf(',');
            map.put(dates.get(i), name.get(i));
        }


        if(map.containsKey(date)){
            holidays="Today is " +map.get(date);
        }else{
            holidays+="Today is NOT a holiday! :(";
        }
        return holidays;
    }

}


