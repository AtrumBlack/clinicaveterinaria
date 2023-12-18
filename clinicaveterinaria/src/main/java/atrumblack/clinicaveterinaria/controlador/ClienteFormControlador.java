package atrumblack.clinicaveterinaria.controlador;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;

@Component
public class ClienteFormControlador extends FormularioControlador{
    @FXML
    private AnchorPane cliente_form;
    @FXML
    private TableView<?> cliente_tabla;

    @FXML
    private TableView<?> cliente_tabla_Mascota;

    @FXML
    private TextField cliente_text_alias_mascota;

    @FXML
    private TextField cliente_text_apellido;

    @FXML
    private TextField cliente_text_buscar_alias;

    @FXML
    private TextField cliente_text_contacto;

    @FXML
    private TextField cliente_text_direccion;

    @FXML
    private TextField cliente_text_documento;

    @FXML
    private TextField cliente_text_email;

    @FXML
    private TextField cliente_text_especie_mascota;

    @FXML
    private TextField cliente_text_nombre;

    @FXML
    private TextField cliente_text_telefono;

    @FXML
    private JFXButton cliente_btn_agregar;

    @FXML
    private JFXButton cliente_btn_agregar_mascota;

    @FXML
    private JFXButton cliente_btn_eliminar;

    @FXML
    private JFXButton cliente_btn_limpiar;

    @FXML
    private JFXButton cliente_btn_modificar;

    @FXML
    private TableColumn<?, ?> cliente_col_alias_mascota;

    @FXML
    private TableColumn<?, ?> cliente_col_apellido;

    @FXML
    private TableColumn<?, ?> cliente_col_contacto;

    @FXML
    private TableColumn<?, ?> cliente_col_direccion;

    @FXML
    private TableColumn<?, ?> cliente_col_documento;

    @FXML
    private TableColumn<?, ?> cliente_col_email;

    @FXML
    private TableColumn<?, ?> cliente_col_especie_mascota;

    @FXML
    private TableColumn<?, ?> cliente_col_id;

    @FXML
    private TableColumn<?, ?> cliente_col_id_mascota;

    @FXML
    private TableColumn<?, ?> cliente_col_nombre;

    @FXML
    private TableColumn<?, ?> cliente_col_telefono;

}
