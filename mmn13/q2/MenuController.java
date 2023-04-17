package com.example.mmn13;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Optional;

public class MenuController {

    @FXML
    private GridPane grid;

    @FXML
    private TextField [] types;

    @FXML
    private ComboBox<Integer> [] cbItems;

    @FXML
    private CheckBox [] checkBoxes;

    private Order order;
    public void initialize() {
        Menu menu = new Menu(FilesHandler.getMenu());
        order = new Order();
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

    @FXML
    void orderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you sure you want to delete this item?");
        alert.setContentText("This action cannot be undone.");

        ButtonType confirm = new ButtonType("Confirm");
        ButtonType update = new ButtonType("Update");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(confirm, update, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == confirm){
            TextInputDialog td = new TextInputDialog();
            td.setTitle("please enter your name and ID");
            td.setHeaderText("For example: \n\"Yossi123456789\"");
            td.setContentText("Name: ");
            Optional<String> fileName = td.showAndWait();
            order.closeOrder(String.valueOf(fileName));
            order = new Order();

        } else if (result.get() == update) {
            // do something else
        } else {
            order = new Order();
        }
    }
}