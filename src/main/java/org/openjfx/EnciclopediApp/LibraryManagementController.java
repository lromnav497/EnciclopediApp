package org.openjfx.EnciclopediApp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;

public class LibraryManagementController {
    @FXML
    private TextField textField1, textField2, textField3, textField4, textField5, textField6, textField7;

    private ArrayList<String[]> books = new ArrayList<>();

    @FXML
    private void addBook() {
        String[] book = new String[7];
        book[0] = textField1.getText();
        book[1] = textField2.getText();
        book[2] = textField3.getText();
        book[3] = textField4.getText();
        book[4] = textField5.getText();
        book[5] = textField6.getText();
        book[6] = textField7.getText();
        books.add(book);
        clearFields();
    }

    @FXML
    private void viewBooks() {
        for (String[] book : books) {
            System.out.println(Arrays.toString(book));
        }
    }

    private void clearFields() {
        textField1.clear();
        textField2.clear();
        textField3.clear();
        textField4.clear();
        textField5.clear();
        textField6.clear();
        textField7.clear();
    }
}
