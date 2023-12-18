package atrumblack.clinicaveterinaria.controlador;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;

@Component
public class TratamientoFormControlador extends FormularioControlador {
    @FXML
    private AnchorPane tratamiento_form;
    @FXML
    private JFXButton tratamiento_btn_agregar;

    @FXML
    private JFXButton tratamiento_btn_eliminar;

    @FXML
    private JFXButton tratamiento_btn_limpiar;

    @FXML
    private JFXButton tratamiento_btn_modificar;

    @FXML
    private TableColumn<?, ?> tratamiento_col_descripcion;

    @FXML
    private TableColumn<?, ?> tratamiento_col_id;

    @FXML
    private TableColumn<?, ?> tratamiento_col_importe;

    @FXML
    private TableColumn<?, ?> tratamiento_col_tipo;

    @FXML
    private TextField tratamiento_tex_descripcion;

    @FXML
    private TextField tratamiento_tex_importe;

    @FXML
    private TextField tratamiento_text_tipo;

    @FXML
    private TextField tratamiento_txt_buscar;
}
