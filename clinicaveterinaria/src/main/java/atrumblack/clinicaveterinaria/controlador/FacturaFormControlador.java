package atrumblack.clinicaveterinaria.controlador;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;

@Component
public class FacturaFormControlador extends FormularioControlador {
    @FXML
    private AnchorPane factura_form;
    @FXML
    private JFXButton factura_btn_agregar;

    @FXML
    private JFXButton factura_btn_efectivo;

    @FXML
    private JFXButton factura_btn_limpiar;

    @FXML
    private JFXButton factura_btn_tarjeta;

    @FXML
    private TableColumn<?, ?> factura_col_alias;

    @FXML
    private TableColumn<?, ?> factura_col_cantidad;

    @FXML
    private TableColumn<?, ?> factura_col_cliente;

    @FXML
    private TableColumn<?, ?> factura_col_concepto;

    @FXML
    private TableColumn<?, ?> factura_col_especie;

    @FXML
    private TableColumn<?, ?> factura_col_fecha_visita;

    @FXML
    private TableColumn<?, ?> factura_col_id;

    @FXML
    private TableColumn<?, ?> factura_col_id_mascota;

    @FXML
    private TableColumn<?, ?> factura_col_importe;

    @FXML
    private TableColumn<?, ?> factura_col_precio_unitario;

    @FXML
    private TableView<?> factura_tabla;

    @FXML
    private TableView<?> factura_tabla_mascota;

    @FXML
    private TextField factura_text_buscar_alias;

    @FXML
    private TextField factura_text_cliente;

    @FXML
    private TextField factura_text_direccion;

    @FXML
    private TextField factura_text_email;

    @FXML
    private TextField factura_text_importe_total;

    @FXML
    private TextField factura_text_telefono;
}
