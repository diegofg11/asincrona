module org.diegofg11 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;
    requires java.sql;
    opens org.diegofg11.Controlador to javafx.fxml;
    opens org.diegofg11 to javafx.fxml;
    exports org.diegofg11;

    opens org.diegofg11.Modelos to javafx.base;
    exports org.diegofg11.Conexion to javafx.fxml;
    opens org.diegofg11.Conexion to javafx.fxml;

}