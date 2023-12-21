package atrumblack.clinicaveterinaria.controlador;

import atrumblack.clinicaveterinaria.modelo.Cliente;
import atrumblack.clinicaveterinaria.modelo.ClienteTableCell;
import atrumblack.clinicaveterinaria.modelo.Mascota;
import atrumblack.clinicaveterinaria.servicio.MascotaServicio;
import com.jfoenix.controls.JFXButton;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MascotaFormControlador extends FormularioControlador{

    private static final Logger logger =
            LoggerFactory.getLogger(MascotaFormControlador.class);
    private Integer idMascotaInterno;
    @Autowired
    private MascotaServicio mascotaServicio;

    @FXML
    private AnchorPane mascota_form;

    @FXML
    private TableView<Mascota> mascota_tabla;

    @FXML
    private TextField mascota_text_alias;

    @FXML
    private TextField mascota_text_buscar_alias;

    @FXML
    private TextField mascota_text_color_de_pelo;
    @FXML
    private TextField mascota_text_raza;


    @FXML
    private TextField mascota_text_especie;

    @FXML
    private DatePicker mascota_text_fecha_nacimiento;

    @FXML
    private TextField mascota_text_peso_actual;

    @FXML
    private TextField mascota_text_peso_promedio;


    @FXML
    private ComboBox<Mascota.Sexo> mascota_combo_sexo;

    @FXML
    private JFXButton mascota_btn_eliminar;

    @FXML
    private JFXButton mascota_btn_limpiar;

    @FXML
    private JFXButton mascota_btn_modificar;

    //Tabla Mascota

    @FXML
    private TableColumn<Mascota, String> mascota_col_alias;

    @FXML
    private TableColumn<Mascota, Cliente> mascota_col_cliente;

    @FXML
    private TableColumn<Mascota, String> mascota_col_color_de_pelo;

    @FXML
    private TableColumn<Mascota, String> mascota_col_especie;

    @FXML
    private TableColumn<Mascota, Date> mascota_col_fecha_nacimiento;

    @FXML
    private TableColumn<Mascota, Integer> mascota_col_id;

    @FXML
    private TableColumn<Mascota, Double> mascota_col_peso_actual;

    @FXML
    private TableColumn<Mascota, Double> mascota_col_peso_promedio;

    @FXML
    private TableColumn<Mascota, Mascota.Sexo> mascota_col_sexo;
    @FXML
    private TableColumn<Mascota, String> mascota_col_raza;
    private final ObservableList<Mascota> mascotaList =
            FXCollections.observableArrayList();

    private static ObservableValue<String> call(TableColumn.CellDataFeatures<Mascota, String> cellData) {
        Cliente cliente = cellData.getValue().getCliente();
        if (cliente != null) {
            return new SimpleStringProperty(cliente.getNombreCompleto()); // Cambia "getNombreCompleto()" por el método adecuado de tu clase Cliente
        } else {
            return new SimpleStringProperty("");
        }
    }

    private void configurarColumnasMascota() {

        mascota_col_id.setCellValueFactory(new PropertyValueFactory<>("idMascota"));
        mascota_col_alias.setCellValueFactory(new PropertyValueFactory<>("alias"));
        mascota_col_especie.setCellValueFactory(new PropertyValueFactory<>("especie"));

        mascota_col_color_de_pelo.setCellValueFactory(new PropertyValueFactory<>("colorDePelo"));
        mascota_col_fecha_nacimiento.setCellValueFactory(new PropertyValueFactory<>("fechaNacimiento"));
        mascota_col_peso_actual.setCellValueFactory(new PropertyValueFactory<>("pesoActual"));

//       mascota_col_cliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
//        mascota_col_cliente.setCellFactory(column -> new ClienteTableCell());
        
        mascota_col_cliente.setCellValueFactory(MascotaFormControlador::call);
        mascota_col_peso_promedio.setCellValueFactory(new PropertyValueFactory<>("pesoPromedio"));
        mascota_col_sexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        mascota_col_raza.setCellValueFactory(new PropertyValueFactory<>("raza"));

    }
    @FXML
    public void initialize() {
        mascota_tabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        configurarColumnasMascota();
        configurarListeners();
        listarMoscota();

        // Configurar el ComboBox para el campo de Sexo
        mascota_combo_sexo.getItems().setAll(Mascota.Sexo.values());

//        // Agregar un ChangeListener para manejar la selección de la tabla en tiempo real
//        mascota_tabla.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue != null) {
//                idMascotaInterno = newValue.getIdMascota();
//
//                cargarMascotaFormulario();
//            }
//        });
    }
    private void listarMoscota() {
        logger.info("Ejecutando listado de mascota por cliente");
        mascotaList.clear();
        mascotaList.addAll(mascotaServicio.listarMascota());
        mascota_tabla.setItems(mascotaList);
    }
    private void configurarListeners() {
        // Configurar el Listener para la búsqueda en tiempo real mientras se escribe
        mascota_text_buscar_alias.textProperty().addListener((observable, oldValue, newValue) -> filtrarMascotaPorAlias(newValue));
    }

    private void filtrarMascotaPorAlias(String alias) {
        List<Mascota> mascotasFiltrados = mascotaList.stream()
                .filter(mascota -> mascota.getAlias().toLowerCase().startsWith(alias.toLowerCase()))
                .collect(Collectors.toList());

        mascota_tabla.setItems(FXCollections.observableArrayList(mascotasFiltrados));
    }
//    public void cargarMascotaFormulario() {
//        var mascota = mascota_tabla.getSelectionModel().getSelectedItem();
//        if (mascota != null) {
//            idMascotaInterno = mascota.getIdMascota();
//            mascota_text_especie.setText(mascota.getEspecie());
//            mascota_text_color_de_pelo.setText(mascota.getColorDePelo());
//            mascota_combo_sexo.setValue(mascota.getSexo());
//           // mascota_combo_sexo.setText(mascota.getSexo().name());
//            mascota_text_peso_actual.setText(mascota.getPesoActual() != null ? mascota.getPesoActual().toString() : "");
//            mascota_text_peso_promedio.setText(mascota.getPesoPromedio() != null ? mascota.getPesoPromedio().toString() : "");
//
//            // Establecer la fecha de nacimiento en el DatePicker
//            mascota_text_fecha_nacimiento.setValue(mascota.getFechaNacimiento());
//
//            mascota_text_raza.setText(mascota.getRaza());
//        }
//    }
}
