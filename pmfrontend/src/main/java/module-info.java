module edu.secourse.patientportal.pmfrontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.net.http;
    requires tools.jackson.databind;

    opens edu.secourse.patientportal.pmfrontend to javafx.fxml;
    exports edu.secourse.patientportal.pmfrontend;

    // Allow JavaFX to access controllers via reflection
    opens edu.secourse.patientportal.pmfrontend.controller to javafx.fxml;
}