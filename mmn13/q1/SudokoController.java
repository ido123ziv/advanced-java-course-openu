package q1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javax.swing.JOptionPane;


public class SudokoController {

    @FXML
    private GridPane grid;

    @FXML
    private Button setBtn;
    private TextField textField;
    private TextField[] textFields;
    private final int SIZE = 9;
    private boolean isWhite = false;
    private int counterRow = 9;
    private int counter = 3;
    private int row, col, block;
    private int[] rowCells, colCells, blockCells;
    // if we manage to fill 81 spots we are done, we will use an helper array to check if we change answer in a spot
    private int countToFinish;
    private boolean[] helpArr;
    private boolean isGameOn = false;

    /**
     * Function use to initialize vars on the start and also used as a listener to events (clicks, etc.)
     */
    public void initialize() {
        //Initialize arrays that will be use to check if we can enter new number
        rowCells = new int[SIZE];
        colCells = new int[SIZE];
        blockCells = new int[SIZE];
        textFields = new TextField[SIZE * SIZE];
        helpArr = new boolean[SIZE * SIZE];

        for (int i = 0; i < SIZE * SIZE; i++) {
            helpArr[i] = false;
            textFields[i] = new TextField("");
            textFields[i].setId(String.valueOf(i));
            textFields[i].setPrefSize(grid.getPrefWidth() / 9, grid.getPrefHeight() / 9);
            // Anonymous function that handle get the user input inside the textfields
            textFields[i].setOnAction(e -> {
                textField = (TextField) e.getSource();
                String text = textField.getText();
                if (text == "")
                    countToFinish--;
                if (isGameOn) {
                    String style = textField.getStyle();
                    textField.setStyle(style + "; -fx-text-inner-color: red;");
                }
                try {
                    int tmp = Integer.parseInt(text);

                    if (tmp < 1 || tmp > 9) {
                        JOptionPane.showConfirmDialog(null, "Wrong number!", "Error", JOptionPane.CLOSED_OPTION);
                        textField.clear();
                    } else {
                        if (!validateLegit(textField)) {
                            JOptionPane.showConfirmDialog(null, "You can't put this number here!", "Error", JOptionPane.CLOSED_OPTION);
                            textField.clear();
                        }
                        if (!helpArr[Integer.parseInt(textField.getId())]) {
                            if (countToFinish == 81) {
                                JOptionPane.showConfirmDialog(null, "WOW! You WON!", "Well Done!", JOptionPane.CLOSED_OPTION);
                                clearPressed(e);
                            }
                            countToFinish++;
                            helpArr[Integer.parseInt(textField.getId())] = true;
                        }
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println(textField.getText());
                    JOptionPane.showConfirmDialog(null, "You are wrong!", "Error", JOptionPane.CLOSED_OPTION);
                    textField.clear();
                }
            });
            if (i == 27)
                isWhite = !isWhite;
            if (i == 54)
                isWhite = !isWhite;
            if (isWhite)
                textFields[i].setStyle("-fx-background-color: white; -fx-border-color: grey");
            else
                textFields[i].setStyle("-fx-background-color: grey; -fx-border-color: white");
            counter--;
            counterRow--;
            if (counter == 0) {
                counter = 3;
                isWhite = !isWhite;
                if (counterRow == 0) {
                    isWhite = !isWhite;
                    counterRow = 9;
                }
            }
            grid.add(textFields[i], i % 9, i / 9);
        }
    }

    /**
     * Code used to do all the validation needed for the suduku logic
     * Row, Columns and block logic to make sure we can put the new number in this place
     *
     * @param button
     * @return
     */
    private boolean validateLegit(TextField button) {
        row = Integer.parseInt(button.getId()) / 9;
        col = Integer.parseInt(button.getId()) % 9;
        block = row / 3 * 3 + col / 3; // Will give us the block number
        // To check if the new number is already found in the specific col / row
        int cntRow = 0;
        int cntCol = 0;
        int cntBlock = 0;
        int temp = 0;

        // Fill column and row arrays
        for (int i = 0; i < SIZE; i++) {
            if (textFields[i + row * SIZE].getText() != "")
                rowCells[i] = Integer.parseInt(textFields[i + row * SIZE].getText());
            else
                rowCells[i] = 0;
            if (textFields[col + i * SIZE].getText() != "")
                colCells[i] = Integer.parseInt(textFields[col + i * SIZE].getText());
            else
                colCells[i] = 0;
        }

        // Fill Blocks array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (textFields[j + block * 3 + i * SIZE].getText() != "")
                    blockCells[temp] = Integer.parseInt(textFields[j + block * 3 + i * SIZE].getText());
                else
                    blockCells[temp] = 0;
                temp++;
            }
        }

        for (int i = 0; i < SIZE; i++) {
            if (Integer.parseInt(button.getText()) == rowCells[i])
                cntRow++;
            if (Integer.parseInt(button.getText()) == colCells[i])
                cntCol++;
            if (Integer.parseInt(button.getText()) == blockCells[i])
                cntBlock++;
        }
        if (cntRow > 1)
            return false;
        else if (cntCol > 1)
            return false;
        else if (cntBlock > 1)
            return false;
        else
            return true;
    }

    /**
     * When set button is pressed lock the table the user created and start the game
     *
     * @param event
     */
    @FXML
    void setPressed(ActionEvent event) {
        for (int i = 0; i < SIZE * SIZE; i++) {
            if (textFields[i].getText() != "")
                textFields[i].setEditable(false);
            setBtn.setDisable(true);
        }
        isGameOn = true;
    }

    /**
     * When clear pressed clean the board and reset the buttons
     *
     * @param event
     */
    @FXML
    void clearPressed(ActionEvent event) {
        for (int i = 0; i < SIZE * SIZE; i++) {
            textFields[i].setText("");
            textFields[i].setEditable(true);
            setBtn.setDisable(false);
        }
        countToFinish = 0;
        helpArr = new boolean[SIZE * SIZE];
        //initialize();
    }
}

