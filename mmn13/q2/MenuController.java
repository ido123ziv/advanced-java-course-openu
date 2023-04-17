Label

import javafx.event.ActionEvent;
import javax.swing.JOptionPane;
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
    private ArrayList<ComboBox<Integer>> cbItems;
    private ArrayList<Item> itemsShown;
    
    @FXML
    private ArrayList<CheckBox> checkBoxes;

    private Order order;

    /**
     * This method initialize the JavaFX Menu application!
     */
    public void initialize() {
        Menu menu = new Menu(FilesHandler.getMenu());
        order = new Order();
        HashMap<mealCourse, ArrayList<Item>> menuItems = menu.getMenu();
        ArrayList<mealCourse> keys = new ArrayList<>(menuItems.keySet());
        labels = new Label[keys.size()];
        checkBoxes = new ArrayList<>();
        cbItems = new ArrayList<>();
        itemsShown = new ArrayList<>();
        int dividerSize = keys.size() + menu.getItemsCounter();
        double textWidth = grid.getPrefWidth() / dividerSize;
        double textHeight = grid.getPrefHeight() / dividerSize;
        int lastIndex = 0, colCounter = 0;
        for (int i =0; i < keys.size(); i ++){
            labels[i] = new Label(keys.get(i).name());
            labels[i].setPrefSize(textWidth, textHeight);
            labels[i].setId(keys.get(i).name());
            labels[i].setStyle("-fx-font-weight: bold; -fx-underline: true; -fx-text-fill: gray;");
            grid.add(labels[i], colCounter, lastIndex);
            for (Item item : menuItems.get(keys.get(i))){
                itemsShown.add(item);
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
                comboBox.getSelectionModel().selectFirst();
                colCounter++;
                grid.add(comboBox, colCounter ,lastIndex);
                cbItems.add(comboBox);
                checkBoxes.add(cb);
                lastIndex++;
                colCounter = 0;
            }
        }
    }

    /**
     * This method handles clicking on the button and popping out the message window
     * @param event
     */
    @FXML
    void orderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Do you want to complete your order?");
        alert.setContentText("This action cannot be undone.");
        ButtonType confirm = new ButtonType("Confirm");
        ButtonType update = new ButtonType("Update");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(confirm, update, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == confirm){
            addItemsToOrder();
            System.out.println(order.getItems());
            TextInputDialog td = new TextInputDialog();
            td.setTitle("please enter your name and ID");
            td.setHeaderText("For example: \n\"Yossi123456789\"");
            td.setContentText("Name: ");
            Optional<String> fileNameInput = td.showAndWait();
            if (fileNameInput.isPresent()){
                String fileName = fileNameInput.get();
                if (fileName.matches("[a-zA-Z]+\\d{9}")) {
                    order.closeOrder(fileName);
                    resetMenu();
                }
                else {
                    JOptionPane.showConfirmDialog(null, "ID not in the Standards", "Error", JOptionPane.CLOSED_OPTION);
                }
            }
        } else if (result.get() == update) {
            // do something else
        } else {
            resetMenu();
        }
    }

    /**
     * add to the order current checked items
     */
    void addItemsToOrder(){
        int ls = itemsShown.size();
        for (int i =0; i< ls; i++){
            Item item = itemsShown.get(i);
            if (checkBoxes.get(i).isSelected()){
                order.addItem(new Item(item.getDescription(), item.getType().name(),  cbItems.get(i).getValue()));
            }
        }
    }

    /**
     * resets menu both visualize and logically
     */
    void resetMenu(){
        for (CheckBox cb : checkBoxes){
            cb.setSelected(false);
        }
        for (ComboBox<Integer> cb : cbItems){
            cb.getSelectionModel().selectFirst();
        }
        order = new Order();
    }
}