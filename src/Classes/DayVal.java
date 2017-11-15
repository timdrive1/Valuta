package Classes;

public class DayVal {
    String val;
    String date;
    double cost;
    int nom;

    public DayVal(String val, String date, double cost, int nom) {
        this.val = val;
        this.date = date;
        this.cost = cost;
        this.nom = nom;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setNom(int nom) {
        this.nom = nom;
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
