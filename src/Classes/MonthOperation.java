package Classes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class MonthOperation {
    XmlReaderLoopDemo xmlReaderLoopDemo = new XmlReaderLoopDemo();
    MonthValParser mo = new MonthValParser();
    ArrayList<DayVal> arrmo = mo.run();
    API api = new API();
    ArrayList<Curse> curses;

    public MonthOperation() throws IOException {
    }

    public ArrayList<DayVal> getXmlDayVal() {
        return xmlDayVal;
    }

    ArrayList<String> val = new ArrayList<>();
    ArrayList<DayVal> xmlDayVal = xmlReaderLoopDemo.xmlReader();


    public ArrayList<DayVal> getArrmo() {
        return arrmo;
    }


    public ArrayList<DayVal> getCursetmp(String val) throws IOException {
        curses = api.getcurse(val);
        ArrayList<DayVal> tmp = new ArrayList<>();
        for (int i = 0; i < curses.size()  ; i++) {

                tmp.add(new DayVal(curses.get(i).key  , curses.get(i).key, curses.get(i).curse, 1 ));

        }
        return tmp;

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
        for (int i = 0; i < xmlDayVal.size() ; i++) {
            for (int j = 0; j < val.size() ; j++) {
                if(xmlDayVal.get(i).getVal().equals(val.get(j))){
                    val.set(j, xmlDayVal.get(i).nameVal);

                }
            }

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
