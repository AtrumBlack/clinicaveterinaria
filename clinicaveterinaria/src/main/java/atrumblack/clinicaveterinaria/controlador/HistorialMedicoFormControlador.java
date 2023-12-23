package atrumblack.clinicaveterinaria.controlador;

//import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;

@Component
public class HistorialMedicoFormControlador extends FormularioControlador{
    @FXML
    private AnchorPane historia_clinica_form;
    @FXML
    private TableColumn<?, ?> historia_clinica_col_alias;

    @FXML
    private TableColumn<?, ?> historia_clinica_col_alias_mascota;

    @FXML
    private TableColumn<?, ?> historia_clinica_col_cliente;

    @FXML
    private TableColumn<?, ?> historia_clinica_col_cliente_mascota;

    @FXML
    private TableColumn<?, ?> historia_clinica_col_id;

    @FXML
    private TableColumn<?, ?> historia_clinica_col_id_mascota;

//    @FXML
//    private JFXComboBox<?> historia_clinica_combo_informacion_general;
//
//    @FXML
//    private JFXComboBox<?> historia_clinica_combo_tratamiento;
//
//    @FXML
//    private JFXComboBox<?> historia_clinica_combo_vacuna;
//
//    @FXML
//    private JFXComboBox<?> historia_clinica_combo_vistas;

    @FXML
    private TableView<?> historia_clinica_tabla;

    @FXML
    private TableView<?> historia_clinica_tabla_mascota;

    @FXML
    private TextField historia_clinica_text_buscar_alias;
}
