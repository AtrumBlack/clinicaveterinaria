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
public class MascotaFormControlador extends FormularioControlador{

    @FXML
    private AnchorPane mascota_form;

    @FXML
    private TableView<?> mascota_tabla;

    @FXML
    private TextField mascota_text_alias;

    @FXML
    private TextField mascota_text_buscar_alias;

    @FXML
    private TextField mascota_text_color_de_pelo;

    @FXML
    private TextField mascota_text_especie;

    @FXML
    private DatePicker mascota_text_fecha_nacimiento;

    @FXML
    private TextField mascota_text_peso_actual;

    @FXML
    private TextField mascota_text_peso_promedio;

    @FXML
    private TextField mascota_text_sexo;

    @FXML
    private JFXButton mascota_btn_eliminar;

    @FXML
    private JFXButton mascota_btn_limpiar;

    @FXML
    private JFXButton mascota_btn_modificar;

    @FXML
    private TableColumn<?, ?> mascota_col_alias;

    @FXML
    private TableColumn<?, ?> mascota_col_cliente;

    @FXML
    private TableColumn<?, ?> mascota_col_color_de_pelo;

    @FXML
    private TableColumn<?, ?> mascota_col_especie;

    @FXML
    private TableColumn<?, ?> mascota_col_fecha_nacimiento;

    @FXML
    private TableColumn<?, ?> mascota_col_id;

    @FXML
    private TableColumn<?, ?> mascota_col_peso_actual;

    @FXML
    private TableColumn<?, ?> mascota_col_peso_promedio;

    @FXML
    private TableColumn<?, ?> mascota_col_sexo;

}
