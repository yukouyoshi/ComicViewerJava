package com.example.comicviewer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected ImageView image1;
    @FXML
    protected ImageView image2;

    @FXML
    protected MenuBar menubar;

    @FXML
    protected void quit() {

        System.exit(0);

    }

    @FXML
    protected void openFile() {
        try {
            openDialog();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private void openDialog() throws MalformedURLException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File f = fileChooser.showOpenDialog(null);

        String extention = f.getName().split("\\.")[f.getName().split("\\.").length-1].toLowerCase();
        System.out.println(f.toURI().toURL());
        if (extention.equals("zip")) {

            System.out.println();
        } else if (extention.equals("jpg") || extention.equals("png") || extention.equals("gif")) {
            File[] files = new File(f.getParent()).listFiles((File pathname) -> multiEndWith(new String[]{"jpg", "png", "gif"}, pathname.getName()));

            Image pic1 = new Image(f.toURI().toURL().toString());
            image1.setImage(pic1);

            Image pic2 = new Image(f.getAbsolutePath());
            image2.setImage(pic2);
        }

    }

    public void hotkeyPress(KeyEvent event) {
        if (event.getCode().equals(KeyCode.DIGIT1)) {
            image2.setVisible(false);
        } else if (event.getCode().equals(KeyCode.DIGIT2)) {
            image2.setVisible(true);
        }
    }


    private boolean multiEndWith(String[] endstrs, String target) {
        for (String endstr : endstrs) {
            if (target.endsWith(endstr)) return true;
        }
        return false;
    }

}