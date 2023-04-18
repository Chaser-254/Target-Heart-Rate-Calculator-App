package com.example.thrapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TargetHeartRateCalculator extends Application {

    public static int calculateMaxHeartRate(int age) {
        return 220 - age;
    }

    public static String calculateTargetHeartRateRange(int maxHeartRate) {
        int minTargetHeartRate = (int) (maxHeartRate * 0.5);
        int maxTargetHeartRate = (int) (maxHeartRate * 0.85);
        return minTargetHeartRate + " - " + maxTargetHeartRate + " bpm ";
    }

    @Override
    public void start(Stage primaryStage) {

        Label ageLabel = new Label("Age:");
        TextField ageTextField = new TextField();
        Button calculateButton = new Button("Calculate");
        Label maxHeartRateLabel = new Label();
        Label targetHeartRateRangeLabel = new Label();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(ageLabel,0,0);
        gridPane.add(ageTextField,1,0);
        gridPane.add(calculateButton,1,1);
        gridPane.add(maxHeartRateLabel,0,2);
        gridPane.add(targetHeartRateRangeLabel,1,2);

        calculateButton.setOnAction(e -> {
            try{
                int age =  Integer.parseInt(ageTextField.getText());
                int maxHeartRate = calculateMaxHeartRate(age);
                String targetHeartRateRange = calculateTargetHeartRateRange(maxHeartRate);
                maxHeartRateLabel.setText("Max Heart Rate: " + maxHeartRate + " bpm ");
                targetHeartRateRangeLabel.setText("Target Heart Rate Range: " + targetHeartRateRange);
            }catch (NumberFormatException ex){
                maxHeartRateLabel.setText("");
                targetHeartRateRangeLabel.setText("");
            }
        });

        Scene scene = new Scene(gridPane,400,200);
        primaryStage.setTitle("Target Heart Rate Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}