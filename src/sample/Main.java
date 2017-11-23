package sample;

import Classes.DayVal;
import Classes.MonthValParser;
import javafx.application.Application;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MonthValParser monthOperation = new MonthValParser();
        ArrayList<DayVal> vals = monthOperation.run();
        ObservableList<DayVal> aL = FXCollections.observableArrayList(vals);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Rate");
        primaryStage.setScene(new Scene(root, 1000, 1000));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
