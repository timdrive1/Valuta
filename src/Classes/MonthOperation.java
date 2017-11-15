package Classes;

import java.util.ArrayList;

public class MonthOperation {
    MonthValParser mo = new MonthValParser();
    ArrayList<DayVal> arrmo = mo.run();
    ArrayList<String> val = new ArrayList<>();

    public ArrayList<DayVal> getArrmo() {
        return arrmo;
    }

    public ArrayList<String> getVal(){
        for (int i = 0; i < arrmo.size() ; i++) {
            val.add(arrmo.get(i).val);
        }

        return val;
    }

    public void printDate(String date){
        for (int i = 0; i < arrmo.size() ; i++) {
            if(date.equals(arrmo.get(i).date)){
                System.out.println(arrmo.get(i).toString());
            }
        }


    }
    public void printVal(String val){
        for (int i = 0; i < arrmo.size() ; i++) {
            if(val.equals(arrmo.get(i).val)){
                System.out.println(arrmo.get(i).toString());
            }
        }
    }

}