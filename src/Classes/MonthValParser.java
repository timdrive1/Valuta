package Classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;

public class MonthValParser {

    static ArrayList<DayVal> monthVals = new ArrayList<>();




    public static ArrayList<DayVal> run() {
        String[] val;
        String csvFile = "UR.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";


        try {
            int x = 0;
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                if(x!=0) {
                    val = line.split(cvsSplitBy);
                    monthVals.add(new DayVal(val[0], val[1], parseDouble(val[5]), Integer.parseInt(val[8])));

                }
                x++;
            }





        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return monthVals;
    }

}
