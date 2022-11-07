module com.calingaertgrafico.calingaertlegalegrafico {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;

    opens com.calingaertgrafico.calingaertlegalegrafico to javafx.fxml;
    exports com.calingaertgrafico.calingaertlegalegrafico;
}