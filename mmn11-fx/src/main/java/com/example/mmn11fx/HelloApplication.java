package com.example.mmn11fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        // TODO Auto-generated method stub
        //Defining string to label XAxis
        String Euro = "Euro";
        String Pound = "British Pound";
        String A_Dollar = "Austrelian Dollar";
        String frenc= "Swis Franc";

        //Configuring category and NumberAxis
        CategoryAxis xaxis= new CategoryAxis();
        NumberAxis yaxis = new NumberAxis(0.1,2,0.1);
        xaxis.setLabel("Currency");
        yaxis.setLabel("Dollar price");

        //Configuring BarChart
        BarChart<String,Float> bar = new BarChart(xaxis,yaxis);
        bar.setTitle("Dollar Conversion chart");

        //Configuring Series for XY chart
        XYChart.Series<String,Float> series = new XYChart.Series<>();
//        series.getData().add(new XYChart.Data(Euro,0.83));
//        series.getData().add(new XYChart.Data(Pound,0.73));
//        series.getData().add(new XYChart.Data(frenc,1.00));
//        series.getData().add(new XYChart.Data(A_Dollar,1.32));
        Optional<String> key = data.avgTemp.keySet().stream().findFirst();
        for (int i = 0; i < data.avgTemp.get(key).size(); i++){
            series.getData().add(new XYChart.Data<>("a", (float) data.avgTemp.get(key).get(i)));
        }
//        for (Map.Entry<String, List<Integer>> e: data.avgTemp.entrySet()){
//            series.getData().add(new XYChart.Data());
//        }
        //Adding series to the barchart
        bar.getData().add(series);

        // configuring group and scene
        Group root = new Group();
        root.getChildren().add(bar);
        Scene scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.setTitle("BarChart Example");
        stage.show();
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}