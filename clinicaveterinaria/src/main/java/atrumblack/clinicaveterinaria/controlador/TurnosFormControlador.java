package atrumblack.clinicaveterinaria.controlador;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;

@Component
public class TurnosFormControlador extends FormularioControlador{
    @FXML
    private AnchorPane turnos_form;
    @FXML
    private JFXButton turnos_btn_10;

    @FXML
    private JFXButton turnos_btn_1030;

    @FXML
    private JFXButton turnos_btn_11;

    @FXML
    private JFXButton turnos_btn_1130;

    @FXML
    private JFXButton turnos_btn_12;

    @FXML
    private JFXButton turnos_btn_1230;

    @FXML
    private JFXButton turnos_btn_13;

    @FXML
    private JFXButton turnos_btn_1330;

    @FXML
    private JFXButton turnos_btn_14;

    @FXML
    private JFXButton turnos_btn_1430;

    @FXML
    private JFXButton turnos_btn_15;

    @FXML
    private JFXButton turnos_btn_1530;

    @FXML
    private JFXButton turnos_btn_16;

    @FXML
    private JFXButton turnos_btn_8;

    @FXML
    private JFXButton turnos_btn_830;

    @FXML
    private JFXButton turnos_btn_9;

    @FXML
    private JFXButton turnos_btn_930;

    @FXML
    private JFXButton turnos_btn_agregar;

    @FXML
    private JFXButton turnos_btn_eliminar;

    @FXML
    private JFXButton turnos_btn_limpiar;

    @FXML
    private JFXButton turnos_btn_modificar;

    @FXML
    private TableColumn<?, ?> turnos_col_alias;

    @FXML
    private TableColumn<?, ?> turnos_col_cliente;

    @FXML
    private TableColumn<?, ?> turnos_col_id;

    @FXML
    private DatePicker turnos_date_fecha_reserva;



    @FXML
    private TableView<?> turnos_tabla_mascota;

    @FXML
    private TextField turnos_text_buscar_alias;

    @FXML
    private TextField turnos_text_cliente;
}
