package sample;

import Classes.DayVal;
import Classes.MonthOperation;
import Classes.MonthValParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    MonthOperation mo = new MonthOperation();
    @FXML
    ChoiceBox choiceBox = new ChoiceBox(FXCollections.observableArrayList(mo.getVal()));
    @FXML
    public void initialize(){
        List<String> list = new ArrayList<String>();
        list = mo.getVal();

        ObservableList obList = FXCollections.observableList(list);
        choiceBox.getItems().clear();
        choiceBox.setItems(obList);

        /*MonthOperation mo = new MonthOperation();
        ObservableList<String> aL = FXCollections.observableArrayList(mo.getVal());
        choiceBox.setItems(aL);
        System.out.println(aL.get(1));*/

    }
}
