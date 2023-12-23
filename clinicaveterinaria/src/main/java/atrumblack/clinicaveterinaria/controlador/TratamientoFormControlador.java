package atrumblack.clinicaveterinaria.controlador;

import atrumblack.clinicaveterinaria.modelo.Cliente;
import atrumblack.clinicaveterinaria.modelo.Mascota;
import atrumblack.clinicaveterinaria.modelo.Tratamiento;
import atrumblack.clinicaveterinaria.servicio.ClienteServicio;
import atrumblack.clinicaveterinaria.servicio.TratamientoServicio;
//import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TratamientoFormControlador extends FormularioControlador {

    private static final Logger logger =
            LoggerFactory.getLogger(TratamientoFormControlador.class);
    @Autowired
    private TratamientoServicio tratamientoServicio;
    private Integer idTratamientoInterno;
    @FXML
    private AnchorPane tratamiento_form;
    //@FXML
//    private JFXButton tratamiento_btn_agregar;
//
//    @FXML
//    private JFXButton tratamiento_btn_eliminar;
//
//    @FXML
//    private JFXButton tratamiento_btn_limpiar;
//
//    @FXML
//    private JFXButton tratamiento_btn_modificar;

    @FXML
    private TableView<Tratamiento> tratamiento_tabla;

    @FXML
    private TableColumn<Tratamiento, String> tratamiento_col_descripcion;

    @FXML
    private TableColumn<Tratamiento, Integer> tratamiento_col_id;

    @FXML
    private TableColumn<Tratamiento, Double> tratamiento_col_importe;

    @FXML
    private TableColumn<Tratamiento, String> tratamiento_col_tipo;

    @FXML
    private TextField tratamiento_tex_descripcion;

    @FXML
    private TextField tratamiento_tex_importe;

    @FXML
    private TextField tratamiento_text_tipo;

    @FXML
    private TextField tratamiento_txt_buscar;
    private final ObservableList<Tratamiento> tratamientoList =
            FXCollections.observableArrayList();
    private void configurarColumnasTratamiento() {
        tratamiento_col_id.setCellValueFactory(new PropertyValueFactory<>("idTratamiento"));
        tratamiento_col_tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tratamiento_col_descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        tratamiento_col_importe.setCellValueFactory(new PropertyValueFactory<>("importe"));
        // Establecer la tabla de Mascota como no editable
        tratamiento_tabla.setEditable(false);

        // Establecer el modelo de selección como nulo para hacer que la tabla no sea seleccionable
        tratamiento_tabla.setSelectionModel(null);
    }
    private void listarTratamiento() {
        logger.info("Ejecutando listado de tratamiento");
        tratamientoList.clear();
        tratamientoList.addAll(tratamientoServicio.listarTratamientos());
        tratamiento_tabla.setItems(tratamientoList);
    }
    @FXML
    public void initialize() {
        tratamiento_tabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        configurarColumnasTratamiento();
        configurarListeners();
        listarTratamiento();

//        // Agregar un ChangeListener para manejar la selección de la tabla en tiempo real
//        tratamiento_tabla.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue != null) {
//                idTratamientoInterno = newValue.getIdTratamiento();
//
//                cargarTratamientoFormulario();
//            }
//        });
    }


    private void configurarListeners() {
        // Configurar el Listener para la búsqueda en tiempo real mientras se escribe
        tratamiento_txt_buscar.textProperty().addListener((observable, oldValue, newValue) -> filtrarTratamientoPorTipo(newValue));
    }

    private void filtrarTratamientoPorTipo(String tipo) {
        List<Tratamiento> tratamientoFiltrados = tratamientoList.stream()
                .filter(tratamiento -> tratamiento.getTipo().toLowerCase().startsWith(tipo.toLowerCase()))
                .collect(Collectors.toList());

        tratamiento_tabla.setItems(FXCollections.observableArrayList(tratamientoFiltrados));
    }
//    public void cargarTratamientoFormulario() {
//        var tratamiento = tratamiento_tabla.getSelectionModel().getSelectedItem();
//        if (tratamiento != null) {
//            idTratamientoInterno = tratamiento.getIdTratamiento();
//            tratamiento_text_tipo.setText(tratamiento.getTipo());
//            tratamiento_tex_descripcion.setText(tratamiento.getDescripcion());
//            tratamiento_tex_importe.setText(tratamiento.getImporteTratamiento() != null ? tratamiento.getImporteTratamiento().toString() : "");
//        }
//    }
}
