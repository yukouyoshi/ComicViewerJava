module com.example.comicviewer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.comicviewer to javafx.fxml;
    exports com.example.comicviewer;
}