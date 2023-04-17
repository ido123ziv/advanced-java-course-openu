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
    private Label [] labels;

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
        labels = new Label[keys.size()];
        checkBoxes = new CheckBox [keys.size()];
        cbItems = new ComboBox[keys.size()];
        int dividerSize = keys.size() + menu.getItemsCounter();
        double textWidth = grid.getPrefWidth() / dividerSize;
        double textHeight = grid.getPrefHeight() / dividerSize;
        int lastIndex = 0, colCounter = 0;
        for (int i =0; i < keys.size(); i ++){
            labels[i] = new Label(keys.get(i).name());
            labels[i].setPrefSize(textWidth, textHeight);
            labels[i].setId(keys.get(i).name());
            grid.add(labels[i], colCounter, lastIndex);
            for (Item item : menuItems.get(keys.get(i))){
//                colCounter++;
                lastIndex++;
                Label foodLabel = new Label(item.getDescription());
                foodLabel.setPrefHeight(textHeight);
                foodLabel.setPrefSize(textWidth, textHeight);
                grid.add(foodLabel, colCounter,lastIndex);
                colCounter++;
                Label priceLabel = new Label(Double.toString(item.getPrice()));
                priceLabel.setPrefSize(textWidth, textHeight);
                grid.add(priceLabel, colCounter,lastIndex);
                colCounter++;
                CheckBox cb = new CheckBox();
                grid.add(cb, colCounter ,lastIndex);
                ComboBox<Integer> comboBox = new ComboBox<>();
                comboBox.getItems().addAll(1,2,3,4,5,6);
                colCounter++;
                grid.add(comboBox, colCounter ,lastIndex);
                lastIndex++;
                colCounter = 0;
            }
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