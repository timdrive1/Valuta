package Classes;

import javafx.beans.property.*;

public class DayVal {
    String val;
    String date;
    double cost;
    int nom;
    StringProperty sval;
    StringProperty sdate;
    DoubleProperty scost;
    IntegerProperty snom;

    public DayVal(String val, String date, double cost, int nom) {
        sval = new SimpleStringProperty(val);
        sdate = new SimpleStringProperty(date);
        scost = new SimpleDoubleProperty(cost);
        snom = new SimpleIntegerProperty(nom);
        this.val = val;
        this.date = date;
        this.cost = cost;
        this.nom = nom;
    }

    public void setVal(String val) {
        this.val = val;
        sval = new SimpleStringProperty(val);

    }

    public void setDate(String date) {
        this.date = date;
        sdate = new SimpleStringProperty(date);

    }

    public void setCost(double cost) {
        this.cost = cost;
        scost = new SimpleDoubleProperty(cost);
    }

    public void setNom(int nom) {
        this.nom = nom;
        snom = new SimpleIntegerProperty(nom);
    }

    public String getVal() {
        return val;
    }

    public String getDate() {
        return date;
    }

    public double getCost() {
        return cost;
    }

    public int getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return val+" "+ " "+date +" "+ cost + " " +  nom;
    }
}
