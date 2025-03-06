module org.example.cardgame24 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.scripting;


    opens org.example.cardgame24 to javafx.fxml;
    exports org.example.cardgame24;
}