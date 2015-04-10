package nyc.c4q.ac21.weatherclock;

import java.util.ArrayList;

/**
 * Created by shadowslimmedia on 4/9/15.
 */
public class WeatherDrawings {

    public static ArrayList<String> printCloud() {

        ArrayList<String> cloudDrawing = new ArrayList<String>();

        cloudDrawing.add("        _ __");
        cloudDrawing.add("     __( =  =- _");
        cloudDrawing.add("    (-       -  )__- -_");
        cloudDrawing.add("   (  -=  - )   -     _)");
        cloudDrawing.add("  (_-= _(    =-    _=-");
        cloudDrawing.add("   -(     -    -  _)");
        cloudDrawing.add("     -=__(__  _-)-");
        cloudDrawing.add("           -=-");

        return cloudDrawing;
    }

    public static ArrayList<String> printMoon() {

        ArrayList<String> moonDrawing = new ArrayList<String>();

        moonDrawing.add("                              *          ");//1
        moonDrawing.add("             *     ,MMM8&&&.            *");//2
        moonDrawing.add("                  MMMM88&&&&&    .       ");//3
        moonDrawing.add("                 MMMM88&&&&&&&           ");//4
        moonDrawing.add("     *           MMM88&&&&&&&&           ");//5
        moonDrawing.add("                 MMM88&&&&&&&&           ");//6
        moonDrawing.add("                 'MMM88&&&&&&'           ");//7
        moonDrawing.add("                   'MMM8&&&'      *      ");//8
        moonDrawing.add("                                         ");//9
        moonDrawing.add("             NIGHT                       ");//10


        return moonDrawing;
    }

    public static ArrayList<String> printSun() {

        ArrayList<String> sunDrawing = new ArrayList<String>();

        sunDrawing.add("                .               ");
        sunDrawing.add("                .               ");
        sunDrawing.add("                |               ");
        sunDrawing.add("          '.  _..._  .'         ");
        sunDrawing.add("            .'     '.           ");
        sunDrawing.add("       '-. /         \\ .-'     ");
        sunDrawing.add("      _ _  ;S U N N Y;  _ _     ");
        sunDrawing.add("           \\         /         ");
        sunDrawing.add("        .-' '._   _.' '-.       ");
        sunDrawing.add("           .   ```   .          ");
        sunDrawing.add("          '     |     '         ");
        sunDrawing.add("                '               ");
        sunDrawing.add("                '               ");

        return sunDrawing;
    }

    public static ArrayList<String> printRain() {
        ArrayList<String> rainDrawing = new ArrayList<String>();

        rainDrawing.add("    ooooooo ");
        rainDrawing.add("  ooooooooooo ");
        rainDrawing.add("   ooooooooo   ");
        rainDrawing.add("   \\\\ \\ \\ \\\\ ");
        rainDrawing.add("    \\   \\ \\\\");

        return rainDrawing;
    }

    public static ArrayList<String> titleProject () {
        ArrayList<String> titleDrawing = new ArrayList<String>();


        titleDrawing.add(" __    __    ___   ____  ______  __ __    ___  ____        _____ ______   ____  ______  ____  ___   ____  ");
        titleDrawing.add("|  |__|  |  /  _] /    ||      ||  |  |  /  _]|    \\      / ___/|      | /    ||      ||    |/   \\ |    \\");
        titleDrawing.add("|  |  |  | /  [_ |  o  ||      ||  |  | /  [_ |  D  )    (   \\_ |      ||  o  ||      | |  ||     ||  _  |");
        titleDrawing.add("|  |  |  ||    _]|     ||_|  |_||  _  ||    _]|    /      \\__  ||_|  |_||     ||_|  |_| |  ||  O  ||  |  |");
        titleDrawing.add("|  `  '  ||   [_ |  _  |  |  |  |  |  ||   [_ |    \\      /  \\ |  |  |  |  _  |  |  |   |  ||     ||  |  |");
        titleDrawing.add(" \\      / |     ||  |  |  |  |  |  |  ||     ||  .  \\     \\    |  |  |  |  |  |  |  |   |  ||     ||  |  |");
        titleDrawing.add("  \\_/\\_/  |_____||__|__|  |__|  |__|__||_____||__|\\_|      \\___|  |__|  |__|__|  |__|  |____|\\___/ |__|__|");
        titleDrawing.add("                                                                                                          ");

        return titleDrawing;
    }


}

