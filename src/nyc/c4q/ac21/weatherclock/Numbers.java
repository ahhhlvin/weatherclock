package nyc.c4q.ac21.weatherclock;
/**
 * Created by alvin2 on 4/9/15.
 * Alvin Kuang
 * C4Q Access Code 2.1
 */
import java.util.ArrayList;
import java.util.Calendar;

public class Numbers
{
        public static ArrayList<String> DrawTime(){
            Calendar cal=Calendar.getInstance();
            String time = "0";
            time+=DateTime.formatTime(cal, true);
            if(cal.get(Calendar.HOUR_OF_DAY)>9&&cal.get(Calendar.HOUR_OF_DAY)<13){
                time.replace("0","");
            }
            if(cal.get(Calendar.HOUR_OF_DAY)>21&&cal.get(Calendar.HOUR_OF_DAY)<=23){
                time.replace("0","");
            }
            if (cal.get(Calendar.HOUR_OF_DAY) >= 12)
            {
                time += " PM";
            }else
            {
                time += " AM";
            }
            ArrayList<ArrayList<String>>list=new ArrayList<ArrayList<String>>();
            ArrayList<String>lines=new ArrayList<String>();
            lines.add("     \n");
            for(int i=0;i<time.length();i++){

                if(time.charAt(i)=='1'){
                    lines.add(" 00  \n");
                    lines.add("  0  \n");
                    lines.add("  0  \n");
                    lines.add("  0  \n");
                    lines.add("00000\n");

                }else if(time.charAt(i)=='2'){
                    lines.add("00000\n");
                    lines.add("    0\n");
                    lines.add("00000\n");
                    lines.add("0    \n");
                    lines.add("00000\n");

                } else if(time.charAt(i)=='3'){
                    lines.add("00000\n");
                    lines.add("    0\n");
                    lines.add("00000\n");
                    lines.add("    0\n");
                    lines.add("00000\n");

                } else if(time.charAt(i)=='4'){
                    lines.add("0   0\n");
                    lines.add("0   0\n");
                    lines.add("00000\n");
                    lines.add("    0\n");
                    lines.add("    0\n");

                } else if(time.charAt(i)=='5'){
                    lines.add("00000\n");
                    lines.add("0    \n");
                    lines.add("00000\n");
                    lines.add("    0\n");
                    lines.add("00000\n");

                } else if(time.charAt(i)=='6'){
                    lines.add("00000\n");
                    lines.add("0    \n");
                    lines.add("00000\n");
                    lines.add("0   0\n");
                    lines.add("00000\n");

                } else if(time.charAt(i)=='7'){
                    lines.add("00000\n");
                    lines.add("    0\n");
                    lines.add("    0\n");
                    lines.add("    0\n");
                    lines.add("    0\n");

                } else if(time.charAt(i)=='8'){
                    lines.add("00000\n");
                    lines.add("0   0\n");
                    lines.add("00000\n");
                    lines.add("0   0\n");
                    lines.add("00000\n");

                } else if(time.charAt(i)=='9'){
                    lines.add("00000\n");
                    lines.add("0   0\n");
                    lines.add("00000\n");
                    lines.add("    0\n");
                    lines.add("    0\n");

                }else if(time.charAt(i)=='0'){
                    lines.add("00000\n");
                    lines.add("0   0\n");
                    lines.add("0   0\n");
                    lines.add("0   0\n");
                    lines.add("00000\n");

                }else if(time.charAt(i)==':'){
                    lines.add("     \n");
                    lines.add("  0  \n");
                    lines.add("     \n");
                    lines.add("  0  \n");
                    lines.add("     \n");

                }else if(time.charAt(i)=='M'){
                    lines.add("00000\n");
                    lines.add("0 0 0\n");
                    lines.add("0 0 0\n");
                    lines.add("0 0 0\n");
                    lines.add("0 0 0\n");

                }else if(time.charAt(i)=='P'){
                    lines.add("00000\n");
                    lines.add("0   0\n");
                    lines.add("00000\n");
                    lines.add("0    \n");
                    lines.add("0    \n");

                }else if(time.charAt(i)=='A'){
                    lines.add(" 000 \n");
                    lines.add("0   0\n");
                    lines.add("00000\n");
                    lines.add("0   0\n");
                    lines.add("0   0\n");
                }else{
                    lines.add(" \n");
                    lines.add(" \n");
                    lines.add(" \n");
                    lines.add(" \n");
                    lines.add(" \n");
                    lines.add(" \n");
                }

            }
            return lines;
        }
    }

