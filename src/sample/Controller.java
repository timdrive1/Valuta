package sample;

import Classes.DayVal;
import Classes.MonthOperation;
import Classes.MonthValParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Controller {
    ObservableList observableList;
    MonthOperation mo = new MonthOperation();
    @FXML
    Button buttonId = new Button();
    @FXML
    ChoiceBox choiceBox = new ChoiceBox(FXCollections.observableArrayList(mo.getVal()));
    @FXML
    TableView tableView = new TableView();
    @FXML
    TableColumn dateColumn = new TableColumn();
    @FXML
    TableColumn rateColumn = new TableColumn();
    @FXML
    TableColumn denColumn = new TableColumn();

    public Controller() throws IOException {
    }

    @FXML
    public void initialize(){

        List<String> list = new ArrayList<String>();
        list = mo.getVal();
        ObservableList obList = FXCollections.observableList(list);
       // observableList = obList;
        choiceBox.getItems().clear();
        choiceBox.setItems(obList);
        List<DayVal> dvlist = new ArrayList<>();
        /*dvlist = mo.getArrmo();
        ObservableList<DayVal> obList1 = FXCollections.observableList(dvlist);*/
//        tableView.getColumns().addAll(dateColumn, rateColumn, denColumn);
        dateColumn.setCellValueFactory(new PropertyValueFactory<DayVal, String>("sdate"));
        rateColumn.setCellValueFactory(new PropertyValueFactory<DayVal, Double>("scost"));
        denColumn.setCellValueFactory(new PropertyValueFactory<DayVal, Integer>("snom"));
        tableView.setItems(observableList);
      //  tableView.setItems(obList1);


        /*MonthOperation mo = new MonthOperation();
        ObservableList<String> aL = FXCollections.observableArrayList(mo.getVal());
        choiceBox.setItems(aL);
        System.out.println(aL.get(1));*/

    }

    @FXML
    public void onClick() throws IOException {
        ArrayList<DayVal> xmlDayVal = mo.getXmlDayVal();
        String s = choiceBox.getSelectionModel().getSelectedItem().toString();
        ArrayList<DayVal> dayVals = mo.getArrmo();

        observableList = FXCollections.observableList(mo.getCursetmp(searchVal(s,xmlDayVal)));/*searchVal(s, xmlDayVal)*/
        tableView.setItems(observableList);

        }



    public String searchVal(String s, ArrayList<DayVal> tmp){
    String stmp = null;
        for (int i = 0; i <tmp.size() ; i++) {
            if(tmp.get(i).getNameVal().equals(s)){
                stmp = tmp.get(i).getVal();
            }
        }
        return stmp;

    }
}


