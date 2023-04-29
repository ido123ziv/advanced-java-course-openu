package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.*;
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
    void saveReminder(ActionEvent event) {
        Date d = new Date(cbDay.getValue(), cbMonth.getValue(), cbYear.getValue());
        if (isValid(d))
            map.put((new Date(cbDay.getValue(), cbMonth.getValue(), cbYear.getValue())), tf.getText());
        tf.setText("");
    }

    @FXML
    void saveToFile(ActionEvent event) {
        saveToFile();
    }

    @FXML
    void show(ActionEvent event) {
        Date d = new Date(cbDay.getValue(), cbMonth.getValue(), cbYear.getValue());
        if (isValid(d)) {
            if (map.containsKey(d)) {
                tf.setText((map.get(d)));
            } else {
                tf.setText("");
            }
        }
    }


    @FXML
    void load(ActionEvent event) {
        loadFile();
    }

    public void initialize() {
        map = new HashMap<Date, String>();
        setComboBoxes();
    }

    public void setComboBoxes() {
        final int MAX_DAY = 31, MAX_MONTH = 12, START_YEAR = 2023, MAX_YEAR = 2050;
        for (int i = START_YEAR; i <= MAX_YEAR; i++) {
            cbYear.getItems().add(1999 + i);
        }
        cbYear.setValue(2023);

        for (int i = 1; i <= MAX_MONTH; i++) {
            cbMonth.getItems().add(i);
        }
        cbMonth.setValue(1);

        for (int i = 1; i <= MAX_DAY; i++) {
            cbDay.getItems().add(i);
        }
        cbDay.setValue(1);
    }

    public boolean isValid(Date date) {
        int month = date.getMonth();
        if (month == 2) {
            if (date.getYear() % 100 != 0) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText(null);
                a.setContentText("February " + date.getYear() + " Has Only 28 Days");
                a.showAndWait();
                return false;
            }
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (date.getDay() == 31) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText(null);
                a.setContentText("This Month Has Only 30 Days");
                a.showAndWait();
                return false;
            }
        }
        return true;
    }

    private File getFile() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Please Choose File");
        fc.setInitialDirectory(new File("."));
        return fc.showOpenDialog(null);
    }

    private void loadFile() {
        File f = getFile();
        FileInputStream fi = null;
        ObjectInputStream in = null;
        if (f != null) {
            try {
                fi = new FileInputStream("Reminders.txt");
                in = new ObjectInputStream(fi);
                map = (HashMap<Date, String>) in.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void saveToFile() {
        File f = getFile();
        FileOutputStream fo = null;
        ObjectOutputStream out = null;
        if (f != null) {
            try {
                fo = new FileOutputStream("Reminders.txt");
                out = new ObjectOutputStream(fo);
                out.writeObject(map);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    out.close();
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
