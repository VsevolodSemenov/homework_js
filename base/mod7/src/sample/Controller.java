package sample;

import java.math.BigDecimal;
import java.math.MathContext;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private ChoiceBox<String> choice;
    @FXML
    private Label gram;
    @FXML
    private TextField input;
    @FXML
    private Label kilo;
    @FXML
    private Label ton;

    @FXML
    void initialize() {
        Choice();
        choice.setOnAction(actionEvent -> Start());
        choice.setValue("Тонны");
    }

    void Choice() {
        ObservableList<String> lab = FXCollections.observableArrayList("Тонны", "Килограммы", "Граммы");
        choice.setItems(lab);
    }

    void Start() {
        if (choice.getValue().equals("Тонны")) {
            input.textProperty().addListener(
                    (observable, oldValue, newValue) -> ton.setText(getText(newValue, Metrics.TONN, Metrics.TONN)));
            input.textProperty().addListener(
                    (observable, oldValue, newValue) -> kilo.setText(getText(newValue, Metrics.TONN, Metrics.KILO)));
            input.textProperty().addListener(
                    (observable, oldValue, newValue) -> gram.setText(getText(newValue, Metrics.TONN, Metrics.GRAM)));
        } else if (choice.getValue().equals("Килограммы")) {
            input.textProperty().addListener(
                    (observable, oldValue, newValue) -> ton.setText(getText(newValue, Metrics.KILO, Metrics.TONN)));
            input.textProperty().addListener(
                    (observable, oldValue, newValue) -> kilo.setText(getText(newValue, Metrics.KILO, Metrics.KILO)));
            input.textProperty().addListener(
                    (observable, oldValue, newValue) -> gram.setText(getText(newValue, Metrics.KILO, Metrics.GRAM)));
        } else if (choice.getValue().equals("Граммы")) {
            input.textProperty().addListener(
                    (observable, oldValue, newValue) -> ton.setText(getText(newValue, Metrics.GRAM, Metrics.TONN)));
            input.textProperty().addListener(
                    (observable, oldValue, newValue) -> kilo.setText(getText(newValue, Metrics.GRAM, Metrics.KILO)));
            input.textProperty().addListener(
                    (observable, oldValue, newValue) -> gram.setText(getText(newValue, Metrics.GRAM, Metrics.GRAM)));
        }
    }

    private String getText(String newValue, Metrics metricsFrom, Metrics metricsTo) {
       if(newValue.length() == 0){
           return "0";
       }
       if(metricsFrom == metricsTo){
            return newValue;
       }
       double mul = (double) metricsFrom.val /metricsTo.val;
       return new BigDecimal(newValue).multiply(new BigDecimal(mul)).round(MathContext.DECIMAL32).toPlainString();
    }
    private enum Metrics{
        KILO(1000),
        GRAM(1),
        TONN(1000000);
        private final int val;
        Metrics(int val){
            this.val = val;
        }
    }
}

