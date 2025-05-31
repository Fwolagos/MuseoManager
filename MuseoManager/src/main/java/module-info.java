module com.mycompany.museomanager {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.museomanager to javafx.fxml;
    exports com.mycompany.museomanager;
}
