package Classes;

import java.util.ArrayList;
import java.util.HashSet;

public class MonthOperation {
    MonthValParser mo = new MonthValParser();
    ArrayList<DayVal> arrmo = mo.run();
    ArrayList<String> val = new ArrayList<>();


    public ArrayList<DayVal> getArrmo() {
        return arrmo;
    }


    public ArrayList<DayVal> getArmotmp(String name) {
        ArrayList<DayVal> tmp = new ArrayList<>();
        for (int i = 0; i < arrmo.size()  ; i++) {
            if (arrmo.get(i).getVal().equals(name)){
                tmp.add(arrmo.get(i));
            }
        }
        return tmp;
    }

    public ArrayList<String> getVal(){
        HashSet<String> hesh = new HashSet<>();
        for (int i = 0; i < arrmo.size() ; i++) {
            hesh.add(arrmo.get(i).val);
        }
        val = new ArrayList<>(hesh);
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
    public ArrayList<String> getDateforVal(String nameval){
        ArrayList<String> dates = new ArrayList<>();
        for (int i = 0; i < arrmo.size() ; i++) {
            if(arrmo.get(i).getVal().equals(nameval)){
                dates.add(arrmo.get(i).date);
            }

        }
        return dates;
    }

    public ArrayList<Double> getCostforVal(String nameval){
        ArrayList<Double> costs = new ArrayList<>();
        for (int i = 0; i < arrmo.size() ; i++) {
            if(arrmo.get(i).getVal().equals(nameval)){
                costs.add(arrmo.get(i).cost);
            }

        }
        return costs;
    }
    public ArrayList<Integer> getNomsforVal(String nameval){
        ArrayList<Integer> noms = new ArrayList<>();
        for (int i = 0; i < arrmo.size() ; i++) {
            if(arrmo.get(i).getVal().equals(nameval)){
                noms.add(arrmo.get(i).nom);
            }

        }
        return noms;
    }


}
