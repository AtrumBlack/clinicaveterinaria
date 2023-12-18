package atrumblack.clinicaveterinaria.controlador;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;

@Component
public class VisitaFormControlador extends FormularioControlador{
    @FXML
    private AnchorPane visitas_form;
    @FXML
    private JFXButton visitas_btn_agregar;

    @FXML
    private JFXButton visitas_btn_agregar_tratamiento;

    @FXML
    private JFXButton visitas_btn_eliminar;

    @FXML
    private JFXButton visitas_btn_eliminar_tratamiento;

    @FXML
    private JFXButton visitas_btn_limpiar;

    @FXML
    private JFXButton visitas_btn_modificar;

    @FXML
    private TableColumn<?, ?> visitas_col_alias;

    @FXML
    private TableColumn<?, ?> visitas_col_cliente;

    @FXML
    private TableColumn<?, ?> visitas_col_descripcion;

    @FXML
    private TableColumn<?, ?> visitas_col_especie;

    @FXML
    private TableColumn<?, ?> visitas_col_id_mascota;

    @FXML
    private TableColumn<?, ?> visitas_col_id_tratamiento;

    @FXML
    private TableColumn<?, ?> visitas_col_tipo;



    @FXML
    private TableView<?> visitas_tabla_mascota;

    @FXML
    private TableView<?> visitas_tabla_tratamiento;

    @FXML
    private TextField visitas_text_alias;

    @FXML
    private TextField visitas_text_buscar_alias;

    @FXML
    private TextField visitas_text_cliente;

    @FXML
    private TextField visitas_text_destalles_sintomas;

    @FXML
    private TextField visitas_text_importe;

    @FXML
    private TextField visitas_text_peso_actual;
}
