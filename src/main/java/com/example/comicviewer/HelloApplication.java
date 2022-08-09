package com.example.comicviewer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Properties;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));


        Properties prop = ComicViewerUtil.getProperty("config.properties");
        String windowWidth = prop.getProperty("windowWidth");
        String windowHeight = prop.getProperty("windowHeight");
        int width = Integer.parseInt(windowWidth);
        int height = Integer.parseInt(windowHeight);

        Scene scene = new Scene(fxmlLoader.load(), width, height);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        HelloController helloController = fxmlLoader.getController();
//        stage.widthProperty().addListener((observableValue, oldVal, newVal) -> {
//            helloController.image1.setFitWidth((double)newVal/2);
//            helloController.image2.setFitWidth((double)newVal/2);
//        });
        stage.heightProperty().addListener((observableValue, oldVal, newVal) -> {

            double menuheight = helloController.menubar.getHeight();
            helloController.image1.setFitHeight(((double)newVal-menuheight));
            helloController.image2.setFitHeight(((double)newVal-menuheight));
        });

//        HelloController helloController = fxmlLoader.getController();
        scene.setOnKeyPressed(e -> helloController.hotkeyPress(e));



    }

    public static void main(String[] args) {
        launch();
    }
}