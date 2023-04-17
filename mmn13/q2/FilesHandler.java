Label
import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FilesHandler {

    /**
     * reads from file, get menu in a list form
     * @return a list of items for menu
     */
    public static ArrayList<Item> getMenu(){
        ArrayList<Item> menuList = new ArrayList<>();
        try {
            File file = new File("q2\\menu.txt");
            Scanner scanner = new Scanner(file);
            String [] strings = new String[3];
            int counter = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.compareTo("---") != 0){
                    strings[counter] = line;
                    counter ++;
                }
                else {
                    counter = 0;
                    menuList.add(new Item(strings[0],strings[1], Double.parseDouble(strings[2]) ));
                    strings = new String[3];
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return menuList;
    }

    /**
     * this method write a string to a file
     * @param name -> file name
     * @param Content -> file content
     */
    public static void saveToFile(String name, String Content){
        try {
            File myObj = new File(name);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                FileWriter myWriter = new FileWriter(name);
                myWriter.write(Content);
                myWriter.close();
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
