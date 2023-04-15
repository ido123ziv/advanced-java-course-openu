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
    private ComboBox<Integer> cbItem;

    @FXML
    private CheckBox control;
    @FXML
    protected void orderPressed() {
        System.out.println("Hello");
    }

    public void initialize() {
        Menu menu = new Menu(FilesHandler.getMenu());
        HashMap<mealCourse, ArrayList<Item>> menuItems = menu.getMenu();
        ArrayList<mealCourse> keys = new ArrayList<>(menuItems.keySet());
        types = new TextField[keys.size()];
        double textSize = grid.getPrefWidth();
        double textHeight = grid.getPrefHeight() / (keys.size() * keys.size());

        for (int i =0; i < keys.size(); i ++){
            types[i] = new TextField(keys.get(i).name());
            types[i].setPrefHeight(textHeight);
            types[i].setPrefWidth(textSize);
            types[i].setId(keys.get(i).name());
//            grid.add(types[i], );
        }
    }
}