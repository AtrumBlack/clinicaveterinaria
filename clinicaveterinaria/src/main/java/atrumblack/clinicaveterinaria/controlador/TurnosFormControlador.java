package atrumblack.clinicaveterinaria.controlador;

//import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;

@Component
public class TurnosFormControlador extends FormularioControlador{
    @FXML
    private AnchorPane turnos_form;
    @FXML
    private Button turnos_btn_10;

    @FXML
    private Button turnos_btn_1030;

    @FXML
    private Button turnos_btn_11;

    @FXML
    private Button turnos_btn_1130;

    @FXML
    private Button turnos_btn_12;

    @FXML
    private Button turnos_btn_1230;

    @FXML
    private Button turnos_btn_13;

    @FXML
    private Button turnos_btn_1330;

    @FXML
    private Button turnos_btn_14;

    @FXML
    private Button turnos_btn_1430;

    @FXML
    private Button turnos_btn_15;

    @FXML
    private Button turnos_btn_1530;

    @FXML
    private Button turnos_btn_16;

    @FXML
    private Button turnos_btn_8;

    @FXML
    private Button turnos_btn_830;

    @FXML
    private Button turnos_btn_9;

    @FXML
    private Button turnos_btn_930;

    @FXML
    private Button turnos_btn_agregar;

    @FXML
    private Button turnos_btn_eliminar;

    @FXML
    private Button turnos_btn_limpiar;

    @FXML
    private Button turnos_btn_modificar;

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
