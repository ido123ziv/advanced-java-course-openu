package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.HashMap;

public class Controller {

    @FXML
    private ComboBox<Integer> cbDay;

    @FXML
    private ComboBox<Integer> cbMonth;

    @FXML
    private ComboBox<Integer> cbYear;

    @FXML
    private TextField tf;

    private HashMap<Date, String> map;

    @FXML
    void setReminder(ActionEvent event) {
        if (tf.getText().isBlank()) {
            tf.setText((map.get(new Date(cbDay.getValue(), cbMonth.getValue(), cbYear.getValue()))));
        } else {
            map.put((new Date(cbDay.getValue(), cbMonth.getValue(), cbYear.getValue())),tf.getText());
        }
    }

    @FXML
    void show(ActionEvent event) {
        if (cbDay.getValue() != null && cbMonth.getValue() != null && cbYear.getValue() != null) {
            Date d = new Date(cbDay.getValue(), cbMonth.getValue(), cbYear.getValue());
            if (map.containsKey(d)) {
                tf.setText((map.get(d)));
            } else {
                tf.setText("");
            }
        }
    }

    public void initialize() {
        map = new HashMap<Date,String>();
        setComboBoxes();
    }

    public void setComboBoxes() {
        for (int i = 0; i < 51; i++) {
            cbYear.getItems().add(1999 + i);
        }

        for (int i = 1; i < 13; i++) {
            cbMonth.getItems().add(i);
        }

        for (int i = 1; i < 32; i++) {
            cbDay.getItems().add(i);
        }
    }
}
