package com.example.mmn13;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;

import java.util.HashMap;

public class MenuController {

    @FXML
    private GridPane grid;

    @FXML
    private TextField [] types;

    @FXML
    private ComboBox<Integer> [] cbItems;

    @FXML
    private CheckBox [] checkBoxes;
    @FXML
    protected void orderPressed() {
        System.out.println("Hello");
    }

    public void initialize() {
        Menu menu = new Menu(FilesHandler.getMenu());
        HashMap<mealCourse, ArrayList<Item>> menuItems = menu.getMenu();
        ArrayList<mealCourse> keys = new ArrayList<>(menuItems.keySet());
        types = new TextField[keys.size()];
        checkBoxes = new CheckBox [keys.size()];
        cbItems = new ComboBox[keys.size()];
        double textSize = grid.getPrefWidth() / (keys.size() * keys.size());
        double textHeight = grid.getPrefHeight() / (keys.size() * keys.size());
        int lastIndex = 0, colCounter = 0;
        for (int i =0; i < keys.size(); i ++){
            types[i] = new TextField(keys.get(i).name());
            types[i].setPrefHeight(textHeight);
            types[i].setPrefWidth(textSize);
            types[i].setId(keys.get(i).name());
            grid.add(types[i], colCounter, lastIndex);
            for (Item item : menuItems.get(keys.get(i))){
//                colCounter++;
                lastIndex++;
                TextField tf = new TextField(item.getDescription());
                tf.setPrefHeight(textHeight);
                tf.setPrefWidth(textSize);
                grid.add(tf, colCounter,lastIndex);
                CheckBox cb = new CheckBox();
                colCounter++;
                grid.add(cb, colCounter ,lastIndex);
                ComboBox<Integer> comboBox = new ComboBox<>();
                colCounter++;
                grid.add(comboBox, colCounter ,lastIndex);
                lastIndex++;
            }
            colCounter = 0;
        }



    }
}